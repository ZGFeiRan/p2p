package cn.p2p.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Repayment_record;
import cn.p2p.pojo.Tender_record;

public interface Repayment_recordMapper {
	/**
	 * 根据会员id和状态进行分页查询
	 * 
	 * @param m_id
	 * @param status
	 * @param from
	 * @param pageSize
	 * @return
	 */
	List<Repayment_record> findPageList(@Param(value = "payer_user_id") Integer payer_user_id,
			@Param(value = "payee_user_id") Integer payee_user_id, @Param(value = "status") String status,
			@Param(value = "from") Integer from, @Param(value = "pageSize") Integer pageSize);

	/**
	 * 根据会员id和状态进行分页查询
	 * 
	 * @param m_id
	 * @param status
	 * @param from
	 * @param pageSize
	 * @return
	 */
	Integer findTotal(@Param(value = "payer_user_id") Integer payer_user_id,
			@Param(value = "payee_user_id") Integer payee_user_id, @Param(value = "status") String status);

	/**
	 * 查询分页总条数
	 * 
	 * @param m_id
	 * @param status
	 * @return
	 */
	Integer findListCount(@Param(value = "payer_user_id") Integer payer_user_id,
			@Param(value = "payee_user_id") Integer payee_user_id, @Param(value = "status") String status);

	/**
	 * 添加还款记录
	 * 
	 * @param repayment_record
	 * @return
	 */
	int add(Repayment_record repayment_record);

	/**
	 * 修改还款记录
	 * 
	 * @param repayment_record
	 * @return
	 */
	int update(Repayment_record repayment_record);

	/**
	 * 根据id获取还款记录
	 * 
	 * @param id
	 * @return
	 */
	Repayment_record findById(Integer id);
}
