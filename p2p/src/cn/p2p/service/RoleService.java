package cn.p2p.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Role;

public interface RoleService {
	/**
	 * 查询所有角色
	 * 
	 * @return
	 */
	List<Role> findAll();

	/**
	 * 查询所有角色(分页)
	 * 
	 * @return
	 */
	List<Role> findAllPage(Integer from, Integer pageSize);

	/**
	 * 添加角色
	 * 
	 * @param role
	 * @return
	 */
	boolean add(Role role);

	/**
	 * 删除角色
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(Integer id);

	/**
	 * 根据id获取角色
	 * 
	 * @param id
	 * @return
	 */
	Role findRoleById(Integer id);

	/**
	 * 更改角色
	 * 
	 * @param role
	 * @return
	 */
	boolean update(Role role);

	/**
	 * 查询所有角色数量
	 * 
	 * @return
	 */
	Integer findAllCount();
}
