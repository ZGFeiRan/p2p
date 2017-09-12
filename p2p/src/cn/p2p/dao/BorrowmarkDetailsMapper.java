package cn.p2p.dao;

import cn.p2p.pojo.BorrowmarkDetails;

public interface BorrowmarkDetailsMapper {
	/**
	 * 进行标的详情添加
	 * 
	 * @param borrowmarkDetails
	 * @return
	 */
	int add(BorrowmarkDetails borrowmarkDetails);

	/**
	 * 更改标的详情
	 * 
	 * @param borrowmarkDetails
	 * @return
	 */
	int update(BorrowmarkDetails borrowmarkDetails);

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
