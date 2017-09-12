package cn.p2p.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.p2p.dao.Cash_flowMapper;
import cn.p2p.dao.Fund_accountMapper;
import cn.p2p.pojo.Cash_flow;
import cn.p2p.pojo.Fund_account;
import cn.p2p.service.Cash_flowService;

@Service
public class Cash_flowServiceImpl implements Cash_flowService {
	@Resource
	private Cash_flowMapper cash_flowMapper;
	@Resource
	private Fund_accountMapper fund_accountMapper;

	@Override
	public List<Cash_flow> findList(Integer m_id, String financial_tran_type, Integer from, Integer pageSize) {
		return cash_flowMapper.findList(m_id, financial_tran_type, from, pageSize);
	}

	@Override
	public Integer findCount(Integer m_id, String financial_tran_type) {
		return cash_flowMapper.findCount(m_id, financial_tran_type);
	}

	@Override
	public boolean add(Cash_flow cash_flow) {
		boolean falg = false;
		if (cash_flowMapper.add(cash_flow) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public boolean recharge(Integer m_id, Double money) {
		boolean falg = true;
		Double oldAmount = fund_accountMapper.findByMID(m_id).getAmount();// 充值前的钱
		Double newAmount = oldAmount + money;// 充值后的钱

		if (null == fund_accountMapper.findByMID(m_id)) {// 如果用户没有资金表这儿建一个
			Fund_account fund_account = new Fund_account(m_id, money, new Date());
			fund_accountMapper.add(fund_account);
		} else {
			Fund_account fund_account = new Fund_account(m_id, new Date(), newAmount);// 如果有修改账户资金
			if (fund_accountMapper.updateByMID(fund_account) == 0) {
				falg = false;
				throw new RuntimeException("创建用户资金错误!!!");
			}
		}

		String str = "充值成功，现金账户   +" + money;
		Cash_flow cash_flow = new Cash_flow("XSCZ", m_id, money, 0.0, newAmount, str, new Date());
		if (cash_flowMapper.add(cash_flow) == 0) {// 添加流水
			falg = false;
			throw new RuntimeException("修改用户资金错误!!!");
		}
		return falg;
	}

	@Override
	public boolean tixian(Integer m_id, Double money) {
		boolean falg = true;
		Double oldAmount = fund_accountMapper.findByMID(m_id).getAmount();// 提现前的钱
		Double newAmount = oldAmount - money;// 提现后的钱

		Fund_account fund_account = new Fund_account(m_id, new Date(), newAmount);
		if (fund_accountMapper.updateByMID(fund_account) == 0) {// 修改账户资金
			falg = false;
			throw new RuntimeException("修改用户资金错误!!!");
		}

		String str = "提现成功，现金账户   -" + money;
		Cash_flow cash_flow = new Cash_flow("TX", m_id, 0.0, money, newAmount, str, new Date());
		if (cash_flowMapper.add(cash_flow) == 0) {// 添加流水
			falg = false;
			throw new RuntimeException("添加流水错误!!!");
		}

		return falg;
	}

	@Override
	public List<Cash_flow> findAllList(String financial_tran_type, Integer from, Integer pageSize) {
		return cash_flowMapper.findAllList(financial_tran_type, from, pageSize);
	}

	@Override
	public Integer findAllCount(String financial_tran_type) {
		return cash_flowMapper.findAllCount(financial_tran_type);
	}
}
