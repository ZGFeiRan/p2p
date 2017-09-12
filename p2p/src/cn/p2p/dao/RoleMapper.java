package cn.p2p.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.p2p.pojo.Role;

public interface RoleMapper {
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
	List<Role> findAllPage(@Param(value = "from") Integer from, @Param(value = "pageSize") Integer pageSize);

	/**
	 * 添加角色
	 * 
	 * @param role
	 * @return
	 */
	int add(Role role);

	/**
	 * 删除角色
	 * 
	 * @param id
	 * @return
	 */
	int delete(Integer id);

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
	int update(Role role);

	/**
	 * 查询所有角色数量
	 * 
	 * @return
	 */
	Integer findAllCount();
}
