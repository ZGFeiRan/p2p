package cn.p2p.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.p2p.dao.BorrowmarkDetailsMapper;
import cn.p2p.pojo.BorrowmarkDetails;
import cn.p2p.service.BorrowmarkDetailsService;

@Service
public class BorrowmarkDetailsServiceImpl implements BorrowmarkDetailsService {
	@Resource
	private BorrowmarkDetailsMapper borrowmarkDetailsMapper;

	@Override
	public boolean add(BorrowmarkDetails borrowmarkDetails) {
		boolean falg = false;
		if (borrowmarkDetailsMapper.add(borrowmarkDetails) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public boolean update(BorrowmarkDetails borrowmarkDetails) {
		boolean falg = false;
		if (borrowmarkDetailsMapper.update(borrowmarkDetails) > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public BorrowmarkDetails findByBID(Integer borrow_id) {
		return borrowmarkDetailsMapper.findByBID(borrow_id);
	}

	@Override
	public BorrowmarkDetails findById(Integer id) {
		return borrowmarkDetailsMapper.findById(id);
	}

}
