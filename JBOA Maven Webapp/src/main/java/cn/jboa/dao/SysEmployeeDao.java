package cn.jboa.dao;

import cn.jboa.entity.SysEmployee;

/**
 * 员工类接口
 * 
 * @author 117
 *
 */
public interface SysEmployeeDao {
	/**
	 * 根据条件查询
	 * 
	 * @param sysEmployee
	 * @return
	 */
	SysEmployee findSysEmployee(SysEmployee sysEmployee);
}
