package cn.p2p.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Bankaccount;

public interface BankaccountMapper {
	/**
	 * 查询会员下的银行信息
	 * 
	 * @param m_id
	 * @return
	 */
	List<Bankaccount> findList(@Param(value = "m_id") Integer m_id, @Param(value = "from") Integer from,
			@Param(value = "pageSize") Integer pageSize);

	/**
	 * 分页总数
	 * 
	 * @param m_id
	 * @return
	 */
	Integer findListCount(Integer m_id);

	/**
	 * 添加用户银行信息
	 * 
	 * @param bankaccount
	 * @return
	 */
	Integer add(Bankaccount bankaccount);

	/**
	 * 删除用户银行信息
	 * 
	 * @param bankaccount
	 * @return
	 */
	Integer del(Integer id);
	
}
