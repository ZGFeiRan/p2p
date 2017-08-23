package cn.jboa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jboa.dao.BizClaimVoucherDao;
import cn.jboa.entity.BizClaimVoucher;
import cn.jboa.service.BizClaimVoucherService;

@Service("bizClaimVoucherService")
public class BizClaimVoucherServiceImpl implements BizClaimVoucherService {
	@Resource
	private BizClaimVoucherDao bizClaimVoucherDao;

	@Override
	public void addVoucher(BizClaimVoucher bizClaimVoucher) {
		bizClaimVoucherDao.addVoucher(bizClaimVoucher);
	}

}
