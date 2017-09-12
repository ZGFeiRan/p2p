package cn.p2p.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.p2p.pojo.Fund_account;
import cn.p2p.pojo.Member;
import cn.p2p.service.Fund_accountService;
import cn.p2p.service.MemberService;
import cn.p2p.util.Constant;
import cn.p2p.util.SecurityUtils;

@Controller
public class LoginController {

	@Resource
	private MemberService memberService;
	@Resource
	private Fund_accountService fund_accountService;

	/**
	 * 进入登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/goLogin")
	public String goFrontLogin() {
		return "front/login";
	}

	/**
	 * 进行登录
	 * 
	 * @param username
	 * @param password
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/doLogin")
	public String doBackLogin(@RequestParam String username, @RequestParam String password, Model model,
			HttpSession session) {
		String error;

		Member member = memberService.findMemberByName(username);
		if (null == member) {
			error = "用户名不存在!!!";
		} else {
			if (member.getPassword().equalsIgnoreCase(SecurityUtils.md5Hex(password))) {
				session.setAttribute(Constant.USER_SESSION, member);
				Fund_account fund = fund_accountService.findByMID(member.getId());
				if (null == fund) {
					Fund_account fund_account = new Fund_account(member.getId(), 0.0, new Date());
					fund_accountService.add(fund_account);
				}
				return "front/main";
			} else {
				error = "密码不正确!!!";
			}
		}
		model.addAttribute("error", error);
		return "front/login";
	}

	/**
	 * 登出
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/doLogout")
	public String doLogout(HttpSession session) {
		if (null != session) {
			session.removeAttribute(Constant.USER_SESSION);
		}
		return "front/main";
	}

	/**
	 * 进入首页
	 * 
	 * @return
	 */
	@RequestMapping("/main")
	public String main() {
		return "front/main";
	}

	/**
	 * 进入注册页面
	 * 
	 * @return
	 */
	@RequestMapping("/goRegister")
	public String goRegister(Member member) {
		return "front/register";
	}

	/**
	 * 验证用户名是否存在
	 * 
	 * @return
	 */
	@RequestMapping("/checkUser")
	@ResponseBody
	public String checkUser(@RequestParam String username) {
		if (null == username || username == "") {
			return "null";
		}
		Member member = memberService.findMemberByName(username);
		if (null == member) {
			return "false";
		}
		return "true";
	}

	/**
	 * 进行注册
	 * 
	 * @param member
	 * @return
	 */
	@RequestMapping("/doRegister")
	public String doRegister(Member member) {
		String password = member.getPassword();
		member.setR_id(0);// 默认权限0
		member.setRegistrationtime(new Date());// 注册时间
		member.setPassword(SecurityUtils.md5Hex(member.getPassword()));// 密码加密
		if (memberService.add(member)) {// 如果注册成功则直接登录这个帐号
			return "redirect:doLogin?username=" + member.getUsername() + "&password=" + password;
		}
		return "goRegister";
	}
}
