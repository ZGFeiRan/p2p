package cn.p2p.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Loanpurpose;

public interface LoanpurposeService {
	/**
	 * 获取借款用途数量
	 * 
	 * @return
	 */
	Integer getAllCount();

	/**
	 * 获取所有借款用途
	 * 
	 * @return
	 */
	List<Loanpurpose> findByPage(@Param(value = "from") Integer from, @Param(value = "pageSize") Integer pageSize);

	/**
	 * 根据id查找借款用途
	 * 
	 * @param id
	 * @return
	 */
	Loanpurpose findById(Integer id);

	/**
	 * 添加借款用途
	 * 
	 * @param marktype
	 * @return
	 */
	boolean add(Loanpurpose loanpurpose);

	/**
	 * 修改借款用途
	 * 
	 * @param marktype
	 * @return
	 */
	boolean update(Loanpurpose loanpurpose);

	/**
	 * 根据id删除借款用途
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(Integer id);
}
