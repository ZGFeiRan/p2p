package cn.p2p.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.p2p.dao.BankaccountMapper;
import cn.p2p.pojo.Bankaccount;
import cn.p2p.service.BankaccountService;

@Service
public class BankaccountServiceImpl implements BankaccountService {
	@Resource
	private BankaccountMapper bankaccountMapper;

	@Override
	public List<Bankaccount> findList(Integer m_id, Integer from, Integer pageSize) {
		return bankaccountMapper.findList(m_id, from, pageSize);
	}

	@Override
	public Integer findListCount(Integer m_id) {
		return bankaccountMapper.findListCount(m_id);
	}

	@Override
	public boolean add(Bankaccount bankaccount) {
		boolean falg = false;
		if (bankaccountMapper.add(bankaccount) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public boolean del(Integer id) {
		boolean falg = false;
		if (bankaccountMapper.del(id) > 0) {
			falg = true;
		}
		return falg;
	}
}
