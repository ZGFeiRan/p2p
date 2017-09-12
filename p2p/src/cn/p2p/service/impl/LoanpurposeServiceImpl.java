package cn.p2p.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.p2p.dao.LoanpurposeMapper;
import cn.p2p.pojo.Loanpurpose;
import cn.p2p.service.LoanpurposeService;

@Service
public class LoanpurposeServiceImpl implements LoanpurposeService {
	@Resource
	private LoanpurposeMapper loanpurposeMapper;

	@Override
	public Integer getAllCount() {
		return loanpurposeMapper.getAllCount();
	}

	@Override
	public List<Loanpurpose> findByPage(Integer from, Integer pageSize) {
		return loanpurposeMapper.findByPage(from, pageSize);
	}

	@Override
	public Loanpurpose findById(Integer id) {
		return loanpurposeMapper.findById(id);
	}

	@Override
	public boolean add(Loanpurpose loanpurpose) {
		boolean falg = false;
		if (loanpurposeMapper.add(loanpurpose) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public boolean update(Loanpurpose loanpurpose) {
		boolean falg = false;
		if (loanpurposeMapper.update(loanpurpose) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public boolean delete(Integer id) {
		boolean falg = false;
		if (loanpurposeMapper.delete(id) > 0) {
			falg = true;
		}
		return falg;
	}
}
