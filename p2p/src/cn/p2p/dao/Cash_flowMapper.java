package cn.p2p.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Cash_flow;

public interface Cash_flowMapper {
	/**
	 * 查询资金流动列表
	 * 
	 * @param id
	 * @param financial_tran_type
	 * @return
	 */
	List<Cash_flow> findList(@Param(value = "m_id") Integer m_id,
			@Param(value = "financial_tran_type") String financial_tran_type, @Param(value = "from") Integer from,
			@Param(value = "pageSize") Integer pageSize);

	/**
	 * 查询需要分页的总数
	 * 
	 * @param m_id
	 * @param financial_tran_type
	 * @return
	 */
	Integer findCount(@Param(value = "m_id") Integer m_id,
			@Param(value = "financial_tran_type") String financial_tran_type);

	/**
	 * 添加资金流水
	 * 
	 * @param cash_flow
	 * @return
	 */
	Integer add(Cash_flow cash_flow);

	/**
	 * 查询所有资金流动列表
	 * 
	 * @param id
	 * @param financial_tran_type
	 * @return
	 */
	List<Cash_flow> findAllList(@Param(value = "financial_tran_type") String financial_tran_type,
			@Param(value = "from") Integer from, @Param(value = "pageSize") Integer pageSize);

	/**
	 * 查询所有需要分页的总数
	 * 
	 * @param m_id
	 * @param financial_tran_type
	 * @return
	 */
	Integer findAllCount(@Param(value = "financial_tran_type") String financial_tran_type);
}
