package cn.p2p.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Repaymentmethods;

public interface RepaymentmethodsMapper {
	/**
	 * 获取还款方式数量
	 * 
	 * @return
	 */
	Integer getAllCount();

	/**
	 * 获取所有还款方式
	 * 
	 * @return
	 */
	List<Repaymentmethods> findByPage(@Param(value = "from") Integer from, @Param(value = "pageSize") Integer pageSize);

	/**
	 * 根据id查找还款方式
	 * 
	 * @param id
	 * @return
	 */
	Repaymentmethods findById(Integer id);

	/**
	 * 添加还款方式
	 * 
	 * @param marktype
	 * @return
	 */
	Integer add(Repaymentmethods repaymentmethods);

	/**
	 * 修改还款方式
	 * 
	 * @param marktype
	 * @return
	 */
	Integer update(Repaymentmethods repaymentmethods);

	/**
	 * 根据id删除还款方式
	 * 
	 * @param id
	 * @return
	 */
	Integer delete(Integer id);
}
