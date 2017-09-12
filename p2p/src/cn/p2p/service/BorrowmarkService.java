package cn.p2p.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Borrowmark;

public interface BorrowmarkService {
	/**
	 * 添加
	 * 
	 * @param borrowmark
	 * @return
	 */
	boolean add(Borrowmark borrowmark);

	/**
	 * 修改
	 * 
	 * @param borrowmark
	 * @return
	 */
	boolean update(Borrowmark borrowmark);

	/**
	 * 分页查询
	 * 
	 * @param status
	 * @param from
	 * @param pageSize
	 * @return
	 */
	List<Borrowmark> findPage(Integer status, Integer from, Integer pageSize);

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
	List<Borrowmark> findByMID(Integer m_id, Integer from, Integer pageSize);

	/**
	 * 根据会员id查询数量
	 * 
	 * @param m_id
	 * @return
	 */
	Integer findByMIDCount(Integer m_id);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	boolean del(Integer id);

	/**
	 * 查询所有借款
	 * 
	 * @param from
	 * @param pageSize
	 * @return
	 */
	List<Borrowmark> findAll(Integer from, Integer pageSize);

	/**
	 * 查询所有借款数量
	 * 
	 * @return
	 */
	Integer findAllCount();

	/**
	 * 进行标的审核
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	boolean checkBorrow(Integer id, Integer status);

	/**
	 * 进行投资
	 * 
	 * @param m_id
	 * @param b_id
	 * @return
	 */
	boolean doInvest(Integer m_id, Integer b_id);

	/**
	 * 进行放款
	 * 
	 * @param b_id
	 * @return
	 */
	boolean doMarkLoan(Integer b_id);
}
