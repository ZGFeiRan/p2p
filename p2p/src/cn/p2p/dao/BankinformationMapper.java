package cn.p2p.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Bankinformation;

public interface BankinformationMapper {
	/**
	 * 获取银行信息数量
	 * 
	 * @return
	 */
	Integer getAllCount();

	/**
	 * 获取所有银行信息
	 * 
	 * @return
	 */
	List<Bankinformation> findByPage(@Param(value = "from") Integer from, @Param(value = "pageSize") Integer pageSize);

	/**
	 * 根据id查找银行信息
	 * 
	 * @param id
	 * @return
	 */
	Bankinformation findById(Integer id);

	/**
	 * 添加银行信息
	 * 
	 * @param marktype
	 * @return
	 */
	Integer add(Bankinformation bankinformation);

	/**
	 * 修改银行信息
	 * 
	 * @param marktype
	 * @return
	 */
	Integer update(Bankinformation bankinformation);

	/**
	 * 根据id删除银行信息
	 * 
	 * @param id
	 * @return
	 */
	Integer delete(Integer id);

	/**
	 * 获取所有银行信息
	 * 
	 * @return
	 */
	List<Bankinformation> findAll();
}
