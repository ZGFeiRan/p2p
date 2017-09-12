package cn.p2p.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Cash_flow;

public interface Cash_flowService {
	/**
	 * 查询资金流动列表
	 * 
	 * @param id
	 * @param financial_tran_type
	 * @return
	 */
	List<Cash_flow> findList(Integer m_id, String financial_tran_type, Integer from, Integer pageSize);

	/**
	 * 查询需要分页的总数
	 * 
	 * @param m_id
	 * @param financial_tran_type
	 * @return
	 */
	Integer findCount(Integer m_id, String financial_tran_type);

	/**
	 * 添加资金流水
	 * 
	 * @param cash_flow
	 * @return
	 */
	boolean add(Cash_flow cash_flow);

	/**
	 * 添加充值记录
	 * 
	 * @param rechargerecord
	 * @return
	 */
	boolean recharge(Integer m_id, Double money);

	/**
	 * 添加提现记录
	 * 
	 * @param rechargerecord
	 * @return
	 */
	boolean tixian(Integer m_id, Double money);

	/**
	 * 查询所有资金流动列表
	 * 
	 * @param id
	 * @param financial_tran_type
	 * @return
	 */
	List<Cash_flow> findAllList(String financial_tran_type, Integer from, Integer pageSize);

	/**
	 * 查询所有需要分页的总数
	 * 
	 * @param m_id
	 * @param financial_tran_type
	 * @return
	 */
	Integer findAllCount(String financial_tran_type);
}
