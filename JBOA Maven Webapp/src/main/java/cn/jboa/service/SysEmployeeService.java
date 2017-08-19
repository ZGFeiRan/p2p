package cn.jboa.service;

import cn.jboa.entity.SysEmployee;

public interface SysEmployeeService {
	/**
	 * 根据条件查询
	 * 
	 * @param sysEmployee
	 * @return
	 */
	SysEmployee findSysEmployee(SysEmployee sysEmployee);
}
