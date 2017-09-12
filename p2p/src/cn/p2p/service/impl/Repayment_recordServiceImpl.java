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
import cn.p2p.service.Repayment_recordService;

@Service
public class Repayment_recordServiceImpl implements Repayment_recordService {
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
	public List<Repayment_record> findPageList(Integer payer_user_id, Integer payee_user_id, String status,
			Integer from, Integer pageSize) {
		return repayment_recordMapper.findPageList(payer_user_id, payee_user_id, status, from, pageSize);
	}

	@Override
	public Integer findListCount(Integer payer_user_id, Integer payee_user_id, String status) {
		return repayment_recordMapper.findListCount(payer_user_id, payee_user_id, status);
	}

	@Override
	public Integer findTotal(Integer payer_user_id, Integer payee_user_id, String status) {
		return repayment_recordMapper.findTotal(payer_user_id, payee_user_id, status);
	}

	@Override
	public boolean add(Repayment_record repayment_record) {
		boolean falg = false;
		if (repayment_recordMapper.add(repayment_record) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public boolean update(Repayment_record repayment_record) {
		boolean falg = false;
		if (repayment_recordMapper.update(repayment_record) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public Repayment_record findById(Integer id) {
		return repayment_recordMapper.findById(id);
	}

	@Override
	public boolean doRepayment(Integer id) {
		boolean falg = true;
		Repayment_record repayment_record = repayment_recordMapper.findById(id);
		Integer b_id = repayment_record.getBorrow_id();// 标的id
		Integer payer_user_id = repayment_record.getPayer_user_id();// 借款人
		Integer payee_user_id = repayment_record.getPayee_user_id();// 投资人
		Double amount = repayment_record.getAmount();// 还款金额

		BorrowmarkDetails borrowmarkDetails = borrowmarkDetailsMapper.findByBID(b_id);
		Integer rest_period = borrowmarkDetails.getRest_period();// 剩余期数
		// 修改还款记录
		repayment_record.setStatus("YH");
		repayment_record.setActual_return_date(new Date());
		if (repayment_recordMapper.update(repayment_record) == 0) {
			falg = false;
			throw new RuntimeException("修改还款记录错误!!!");
		}

		// 修改标的
		Borrowmark borrowmark = new Borrowmark();
		borrowmark.setId(b_id);
		if (rest_period > 1) {// 如果不是最后一期
			borrowmark.setStatus(5);
		} else {
			borrowmark.setStatus(6);
		}
		if (borrowmarkMapper.update(borrowmark) == 0) {
			falg = false;
			throw new RuntimeException("修改标的错误!!!");
		}

		// 修改标的详情
		borrowmarkDetails.setRest_period(rest_period - 1);

		Calendar calendar = Calendar.getInstance();// 计算下次还款时间
		calendar.setTime(repayment_record.getShould_return_date());
		calendar.add(Calendar.DAY_OF_YEAR, 30);
		Date next_payment_day = calendar.getTime();
		borrowmarkDetails.setNext_payment_day(next_payment_day);

		if (rest_period == 1) {// 如果是最后一期
			borrowmarkDetails.setFinish_date(new Date());
		}
		if (borrowmarkDetailsMapper.update(borrowmarkDetails) == 0) {
			falg = false;
			throw new RuntimeException("修改标的详情错误!!!");
		}

		// 修改用户账户资金
		Fund_account payer_user = fund_accountMapper.findByMID(payer_user_id);// 借款人账户
		payer_user.setUpdate_date(new Date());
		Double payer_amount = payer_user.getAmount() - amount;// 借款人还款后资金
		payer_user.setAmount(payer_amount);
		if (fund_accountMapper.update(payer_user) == 0) {
			falg = false;
			throw new RuntimeException("修改用户账户资金错误!!!");
		}

		Fund_account payee_user = fund_accountMapper.findByMID(payee_user_id);// 投资人账户
		payee_user.setUpdate_date(new Date());
		Double payee_amount = payee_user.getAmount() + amount;// 投资人收到钱后资金
		payee_user.setAmount(payee_amount);
		if (fund_accountMapper.update(payee_user) == 0) {
			falg = false;
			throw new RuntimeException("修改用户账户资金错误!!!");
		}

		// 添加用户资金流水
		String payer_str = "还款，现金账户  -" + amount;
		Cash_flow payer_Cash_flow = new Cash_flow("HK", payer_user_id, 0.0, amount, payer_amount, payer_str,
				new Date());
		if (cash_flowMapper.add(payer_Cash_flow) == 0) {
			falg = false;
			throw new RuntimeException("添加用户资金流水错误!!!");
		}

		String payee_str = "收款，现金账户   +" + amount;
		Cash_flow payee_Cash_flow = new Cash_flow("SK", payee_user_id, amount, 0.0, payee_amount, payee_str,
				new Date());
		if (cash_flowMapper.add(payee_Cash_flow) == 0) {
			falg = false;
			throw new RuntimeException("添加用户资金流水错误!!!");
		}

		return falg;
	}

}
