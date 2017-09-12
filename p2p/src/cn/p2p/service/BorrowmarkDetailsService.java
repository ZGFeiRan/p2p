package cn.p2p.service;

import cn.p2p.pojo.BorrowmarkDetails;

public interface BorrowmarkDetailsService {
	/**
	 * 进行标的详情添加
	 * 
	 * @param borrowmarkDetails
	 * @return
	 */
	boolean add(BorrowmarkDetails borrowmarkDetails);

	/**
	 * 更改标的详情
	 * 
	 * @param borrowmarkDetails
	 * @return
	 */
	boolean update(BorrowmarkDetails borrowmarkDetails);

	/**
	 * 查询标的详情
	 * 
	 * @param borrow_id
	 * @return
	 */
	BorrowmarkDetails findByBID(Integer borrow_id);

	/**
	 * 查询标的详情
	 * 
	 * @param borrow_id
	 * @return
	 */
	BorrowmarkDetails findById(Integer id);
}
