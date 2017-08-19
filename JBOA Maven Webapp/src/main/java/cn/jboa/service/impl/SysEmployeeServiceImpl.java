package cn.jboa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jboa.dao.SysEmployeeDao;
import cn.jboa.entity.SysEmployee;
import cn.jboa.service.SysEmployeeService;

@Service("sysEmployeeService")
public class SysEmployeeServiceImpl implements SysEmployeeService {
	@Resource
	private SysEmployeeDao sysEmployeeDao;

	public SysEmployee findSysEmployee(SysEmployee sysEmployee) {
		return sysEmployeeDao.findSysEmployee(sysEmployee);
	}

}
