package cn.p2p.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.p2p.dao.Fund_accountMapper;
import cn.p2p.pojo.Fund_account;
import cn.p2p.service.Fund_accountService;

@Service
public class Fund_accountServiceImpl implements Fund_accountService {
	@Resource
	private Fund_accountMapper fund_accountMapper;

	@Override
	public boolean add(Fund_account fund_account) {
		boolean falg = false;
		if (fund_accountMapper.add(fund_account) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public boolean update(Fund_account fund_account) {
		boolean falg = false;
		if (fund_accountMapper.update(fund_account) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public Fund_account findByMID(Integer m_id) {
		return fund_accountMapper.findByMID(m_id);
	}

	@Override
	public Integer updateByMID(Fund_account fund_account) {
		return fund_accountMapper.updateByMID(fund_account);
	}
}
