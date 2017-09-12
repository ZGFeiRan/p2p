package cn.p2p.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.p2p.dao.RepaymentmethodsMapper;
import cn.p2p.pojo.Repaymentmethods;
import cn.p2p.service.RepaymentmethodsService;

@Service
public class RepaymentmethodsServiceImpl implements RepaymentmethodsService {
	@Resource
	private RepaymentmethodsMapper repaymentmethodsMapper;

	@Override
	public Integer getAllCount() {
		return repaymentmethodsMapper.getAllCount();
	}

	@Override
	public List<Repaymentmethods> findByPage(Integer from, Integer pageSize) {
		return repaymentmethodsMapper.findByPage(from, pageSize);
	}

	@Override
	public Repaymentmethods findById(Integer id) {
		return repaymentmethodsMapper.findById(id);
	}

	@Override
	public boolean add(Repaymentmethods repaymentmethods) {
		boolean falg = false;
		if (repaymentmethodsMapper.add(repaymentmethods) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public boolean update(Repaymentmethods repaymentmethods) {
		boolean falg = false;
		if (repaymentmethodsMapper.update(repaymentmethods) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public boolean delete(Integer id) {
		boolean falg = false;
		if (repaymentmethodsMapper.delete(id) > 0) {
			falg = true;
		}
		return falg;
	}
}
