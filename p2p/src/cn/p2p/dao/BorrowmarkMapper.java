package cn.p2p.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Borrowmark;

public interface BorrowmarkMapper {
	/**
	 * 添加
	 * 
	 * @param borrowmark
	 * @return
	 */
	Integer add(Borrowmark borrowmark);

	/**
	 * 修改
	 * 
	 * @param borrowmark
	 * @return
	 */
	Integer update(Borrowmark borrowmark);

	/**
	 * 分页查询
	 * 
	 * @param status
	 * @param from
	 * @param pageSize
	 * @return
	 */
	List<Borrowmark> findPage(@Param(value = "status") Integer status, @Param(value = "from") Integer from,
			@Param(value = "pageSize") Integer pageSize);

	/**
	 * 分页查询数量
	 * 
	 * @param status
	 * @return
	 */
	Integer findCount(Integer status);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	Borrowmark findById(Integer id);

	/**
	 * 根据会员id查询
	 * 
	 * @param m_id
	 * @return
	 */
	List<Borrowmark> findByMID(@Param(value = "m_id") Integer m_id, @Param(value = "from") Integer from,
			@Param(value = "pageSize") Integer pageSize);

	/**
	 * 根据会员id查询数量
	 * 
	 * @param m_id
	 * @return
	 */
	Integer findByMIDCount(@Param(value = "m_id") Integer m_id);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	int del(Integer id);

	/**
	 * 查询所有借款
	 * 
	 * @param from
	 * @param pageSize
	 * @return
	 */
	List<Borrowmark> findAll(@Param(value = "from") Integer from, @Param(value = "pageSize") Integer pageSize);

	/**
	 * 查询所有借款数量
	 * 
	 * @return
	 */
	Integer findAllCount();
}
