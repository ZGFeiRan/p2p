package cn.jboa.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.jboa.dao.BizClaimVoucherDao;
import cn.jboa.entity.BizClaimVoucher;

@Repository("bizClaimVoucherDao")
public class BizClaimVoucherDaoImpl extends HibernateDaoSupport implements BizClaimVoucherDao {

	@Override
	public void addVoucher(BizClaimVoucher bizClaimVoucher) {
		this.getHibernateTemplate().save(bizClaimVoucher);
	}

}
