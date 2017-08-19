package cn.jboa.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.jboa.dao.SysEmployeeDao;
import cn.jboa.entity.SysEmployee;
import cn.jboa.util.EmptyUtils;

@Repository("sysEmployeeDao")
public class SysEmployeeDaoImpl extends HibernateDaoSupport implements SysEmployeeDao {
	public SysEmployee findSysEmployee(SysEmployee sysEmployee) {
		List<SysEmployee> sysEmployees = this.getHibernateTemplate().find("from SysEmployee where sn=?",
				sysEmployee.getSn());
		if (EmptyUtils.isEmpty(sysEmployees)) {
			return null;
		}
		return sysEmployees.get(0);
	}

}
