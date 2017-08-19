package cn.jboa.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.jboa.entity.SysEmployee;
import cn.jboa.service.SysEmployeeService;
import cn.jboa.util.Constant;
import cn.jboa.util.EmptyUtils;
import cn.jboa.util.MD5Util;

@Controller
public class LoginAction extends ActionSupport {
	@Resource
	private SysEmployeeService sysEmployeeService;
	private String sn;
	private String password;

	public String login() {
		SysEmployee sysEmployee = new SysEmployee();
		sysEmployee.setSn(sn);
		sysEmployee.setPassword(MD5Util.getMD5(password));

		sysEmployee = sysEmployeeService.findSysEmployee(sysEmployee);

		if (EmptyUtils.isNotEmpty(sysEmployee)) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put(Constant.USER_SESSION, sysEmployee);
			
			return Action.SUCCESS;
		}
		return Action.LOGIN;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
