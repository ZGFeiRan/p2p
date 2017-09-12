package cn.p2p.service;

import cn.p2p.pojo.Fund_account;

public interface Fund_accountService {
	/**
	 * 添加用户资金总表
	 * 
	 * @param fund_account
	 *            用户id和创建时间
	 * @return
	 */
	boolean add(Fund_account fund_account);

	/**
	 * 修改用户资金总表
	 * 
	 * @param fund_account
	 * @return
	 */
	boolean update(Fund_account fund_account);

	/**
	 * 查询会员的资金表
	 * 
	 * @param m_id
	 * @return
	 */
	Fund_account findByMID(Integer m_id);

	/**
	 * 根据会员id修改用户资金总表
	 * 
	 * @param fund_account
	 * @return
	 */
	Integer updateByMID(Fund_account fund_account);
}
