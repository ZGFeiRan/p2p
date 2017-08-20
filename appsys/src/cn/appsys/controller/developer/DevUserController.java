package cn.appsys.controller.developer;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.DevUserService;
import cn.appsys.tool.Constants;

/**
 * 开发者用户控制器
 * 
 * @author 117
 *
 */
@Controller
@RequestMapping(value = "/dev")
public class DevUserController {
	private static Logger logger = Logger.getLogger(DevUserController.class);
	@Resource
	private DevUserService devUserService;

	/**
	 * 进入开发者登录界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String loginInfo() {
		logger.info("进入登录界面!!!!!!!!!!!!!!!!!!!");
		return "devLogin";
	}

	/**
	 * 进行登录验证
	 * 
	 * @param model
	 * @param devPassword
	 * @param devCode
	 * @return
	 */
	@RequestMapping(value = "/doLogin")
	public String doLogin(Model model, @RequestParam("devPassword") String devPassword, @RequestParam String devCode,
			HttpSession session) {
		DevUser devUser = devUserService.getDevUserByCode(devCode);
		if (null != devUser) {
			if (devUser.getDevPassword().equals(devPassword)) {
				session.setAttribute(Constants.DEV_USER_SESSION, devUser);
				return "developer/main";
			} else {
				model.addAttribute("error", "密码不正确!");
			}
		} else {
			model.addAttribute("error", "帐号不存在!");
		}
		return "devLogin";
	}

	/**
	 * 进行登出操作
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/doLogout")
	public String doLogout(HttpSession session) {
		session.removeAttribute(Constants.DEV_USER_SESSION);
		return "devLogin";
	}
}
