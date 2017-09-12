package cn.p2p.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Bankinformation;

public interface BankinformationService {
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
	boolean add(Bankinformation bankinformation);

	/**
	 * 修改银行信息
	 * 
	 * @param marktype
	 * @return
	 */
	boolean update(Bankinformation bankinformation);

	/**
	 * 根据id删除银行信息
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(Integer id);
	
	/**
	 * 获取所有银行信息
	 * 
	 * @return
	 */
	List<Bankinformation> findAll();
}
