package cn.p2p.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Loanpurpose;

public interface LoanpurposeMapper {
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
	Integer add(Loanpurpose loanpurpose);

	/**
	 * 修改借款用途
	 * 
	 * @param marktype
	 * @return
	 */
	Integer update(Loanpurpose loanpurpose);

	/**
	 * 根据id删除借款用途
	 * 
	 * @param id
	 * @return
	 */
	Integer delete(Integer id);
}
