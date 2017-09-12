package cn.p2p.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.p2p.dao.BorrowmarkDetailsMapper;
import cn.p2p.dao.BorrowmarkMapper;
import cn.p2p.dao.Cash_flowMapper;
import cn.p2p.dao.Fund_accountMapper;
import cn.p2p.dao.Repayment_recordMapper;
import cn.p2p.dao.Tender_recordMapper;
import cn.p2p.pojo.Borrowmark;
import cn.p2p.pojo.BorrowmarkDetails;
import cn.p2p.pojo.Cash_flow;
import cn.p2p.pojo.Fund_account;
import cn.p2p.pojo.Repayment_record;
import cn.p2p.pojo.Tender_record;
import cn.p2p.service.BorrowmarkService;
import javassist.compiler.ast.NewExpr;

@Service
public class BorrowmarkServiceImpl implements BorrowmarkService {
	@Resource
	private BorrowmarkMapper borrowmarkMapper;
	@Resource
	private BorrowmarkDetailsMapper borrowmarkDetailsMapper;
	@Resource
	private Tender_recordMapper tender_recordMapper;
	@Resource
	private Repayment_recordMapper repayment_recordMapper;
	@Resource
	private Fund_accountMapper fund_accountMapper;
	@Resource
	private Cash_flowMapper cash_flowMapper;

	@Override
	public boolean add(Borrowmark borrowmark) {
		boolean falg = false;
		if (borrowmarkMapper.add(borrowmark) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public boolean update(Borrowmark borrowmark) {
		boolean falg = false;
		if (borrowmarkMapper.update(borrowmark) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public List<Borrowmark> findPage(Integer status, Integer from, Integer pageSize) {
		return borrowmarkMapper.findPage(status, from, pageSize);
	}

	@Override
	public Integer findCount(Integer status) {
		return borrowmarkMapper.findCount(status);
	}

	@Override
	public Borrowmark findById(Integer id) {
		return borrowmarkMapper.findById(id);
	}

	@Override
	public List<Borrowmark> findByMID(Integer m_id, Integer from, Integer pageSize) {
		return borrowmarkMapper.findByMID(m_id, from, pageSize);
	}

	@Override
	public Integer findByMIDCount(Integer m_id) {
		return borrowmarkMapper.findByMIDCount(m_id);
	}

	@Override
	public boolean del(Integer id) {
		boolean falg = false;
		if (borrowmarkMapper.del(id) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public List<Borrowmark> findAll(Integer from, Integer pageSize) {
		return borrowmarkMapper.findAll(from, pageSize);
	}

	@Override
	public Integer findAllCount() {
		return borrowmarkMapper.findAllCount();
	}

	@Override
	public boolean checkBorrow(Integer id, Integer status) {
		boolean falg = true;
		Borrowmark borrowmark = new Borrowmark();
		borrowmark.setId(id);
		borrowmark.setStatus(status);
		if (borrowmarkMapper.update(borrowmark) == 0) {
			falg = false;
			throw new RuntimeException("修改标的失败失败!!!");
		}
		if (status == 2) {
			Borrowmark bm = borrowmarkMapper.findById(id);
			BorrowmarkDetails borrowmarkDetails = new BorrowmarkDetails();
			borrowmarkDetails.setBorrow_id(id);
			borrowmarkDetails.setApprove_date(new Date());
			borrowmarkDetails.setTotal_period(bm.getBorrowterm());
			borrowmarkDetails.setRest_period(bm.getBorrowterm());
			// 计算流标时间
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.DAY_OF_YEAR, bm.getActivetime());
			borrowmarkDetails.setLiubiao_date(calendar.getTime());

			if (borrowmarkDetailsMapper.add(borrowmarkDetails) == 0) {
				falg = false;
				throw new RuntimeException("修改标的详情失败!!!");
			}
		}
		return falg;
	}

	@Override
	public boolean doInvest(Integer m_id, Integer b_id) {
		boolean falg = true;
		Borrowmark borrowmark = borrowmarkMapper.findById(b_id);
		Double money = borrowmark.getBorrowmoney();// 标的金额
		Integer total_period = borrowmark.getBorrowterm();// 借款期限
		// 添加投标记录
		Tender_record tender_record = new Tender_record(b_id, m_id, borrowmark.getBorrowmoney(), new Date(), "N");
		if (tender_recordMapper.add(tender_record) == 0) {
			falg = false;
			throw new RuntimeException("添加投标记录失败!!!");
		}

		// 修改用户账户资金
		Fund_account fund_accoun = fund_accountMapper.findByMID(m_id);
		Double amount = fund_accoun.getAmount() - money;// 用户当前余额
		fund_accoun.setAmount(amount);
		if (fund_accountMapper.update(fund_accoun) == 0) {
			falg = false;
			throw new RuntimeException("修改用户账户资金失败!!!");
		}

		// 添加用户账户流水
		String str = "投标成功，现金账户   -" + money;
		Cash_flow cash_flow = new Cash_flow("TB", m_id, 0.0, money, amount, str, new Date());
		if (cash_flowMapper.add(cash_flow) == 0) {
			falg = false;
			throw new RuntimeException("添加用户账户流水失败!!!");
		}

		// 修改标的
		borrowmark.setStatus(4);
		if (borrowmarkMapper.update(borrowmark) == 0) {
			falg = false;
			throw new RuntimeException("修改标的失败!!!");
		}

		// 修改标的详情
		BorrowmarkDetails borrowmarkDetails = borrowmarkDetailsMapper.findByBID(b_id);
		borrowmarkDetails.setTotal_period(total_period);
		borrowmarkDetails.setRest_period(total_period);

		Calendar calendar = Calendar.getInstance();// 计算下次还款时间
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, 30);
		Date next_payment_day = calendar.getTime();
		borrowmarkDetails.setNext_payment_day(next_payment_day);

		borrowmarkDetails.setValue_date(new Date());

		calendar.clear();// 计算结束日期
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, total_period * 30);
		Date finish_date = calendar.getTime();
		borrowmarkDetails.setFinish_date(finish_date);
		if (borrowmarkDetailsMapper.update(borrowmarkDetails) == 0) {
			falg = false;
			throw new RuntimeException("修改标的详情失败!!!");
		}

		// 添加还款记录
		if (borrowmark.getRm_id() == 1) {
			// 每月还款金额=总金额*(1+年利率*期数/12)/期数
			Double amountR = money * (1 + borrowmark.getAnnualrate() * total_period / 1200) / total_period;
			Double bj = money / total_period;
			Double lx = amountR - bj;
			for (int i = 1; i <= total_period; i++) {
				calendar.clear();// 计算应还日期
				calendar.setTime(new Date());
				calendar.add(Calendar.DAY_OF_YEAR, i * 30);
				Date should_return_date = calendar.getTime();

				Repayment_record repayment_record = new Repayment_record(b_id, borrowmark.getM_id(), m_id, i, amountR,
						bj, lx, should_return_date, "WH");
				if (repayment_recordMapper.add(repayment_record) == 0) {
					falg = false;
					throw new RuntimeException("添加还款记录失败!!!");
				}
			}
		}

		return falg;
	}

	@Override
	public boolean doMarkLoan(Integer b_id) {
		boolean falg = true;
		Borrowmark borrowmark = borrowmarkMapper.findById(b_id);
		Double money = borrowmark.getBorrowmoney() * ((100 - borrowmark.getLoanfees()) / 100);// 借款会员所获得的钱

		// 修改标的
		borrowmark.setStatus(5);
		if (borrowmarkMapper.update(borrowmark) == 0) {// 修改标的
			falg = false;
			throw new RuntimeException("修改标的失败!!!");
		}

		// 修改标的详情
		BorrowmarkDetails borrowmarkDetails = borrowmarkDetailsMapper.findByBID(b_id);
		borrowmarkDetails.setLending_date(new Date());
		if (borrowmarkDetailsMapper.update(borrowmarkDetails) == 0) {
			falg = false;
			throw new RuntimeException("修改标的详情失败!!!");
		}

		// 修改会员帐户资金
		Fund_account fund_account = fund_accountMapper.findByMID(borrowmark.getM_id());
		Double newMoney = fund_account.getAmount() + money;
		fund_account.setAmount(newMoney);
		fund_account.setUpdate_date(new Date());
		if (fund_accountMapper.update(fund_account) == 0) {
			falg = false;
			throw new RuntimeException("修改会员帐户资金失败!!!");
		}

		// 修改会员流水
		String str = "放款，现金账户   +" + money;
		Cash_flow cash_flow = new Cash_flow("FK", borrowmark.getM_id(), money, 0.0, newMoney, str, new Date());
		if (cash_flowMapper.add(cash_flow) == 0) {
			falg = false;
			throw new RuntimeException("修改会员流水失败!!!");
		}

		// 修改投标记录
		Tender_record tender_record = tender_recordMapper.findByMidBid(b_id);
		tender_record.setIs_fangkuan("Y");
		if (tender_recordMapper.update(tender_record) == 0) {
			falg = false;
			throw new RuntimeException("修改投标记录失败!!!");
		}
		return falg;
	}
}
