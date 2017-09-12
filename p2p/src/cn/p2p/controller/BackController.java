package cn.p2p.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.p2p.pojo.Bankinformation;
import cn.p2p.pojo.Cash_flow;
import cn.p2p.pojo.Loanpurpose;
import cn.p2p.pojo.Member;
import cn.p2p.pojo.Repaymentmethods;
import cn.p2p.pojo.Role;
import cn.p2p.service.BankinformationService;
import cn.p2p.service.Cash_flowService;
import cn.p2p.service.LoanpurposeService;
import cn.p2p.service.MemberService;
import cn.p2p.service.RepaymentmethodsService;
import cn.p2p.service.RoleService;
import cn.p2p.util.PageSupport;
import cn.p2p.util.SecurityUtils;

@Controller
@RequestMapping("/back")
public class BackController {
	private static Logger logger = LoggerFactory.getLogger(BackController.class);
	@Resource
	private MemberService memberService;
	@Resource
	private RoleService roleService;
	@Resource
	private LoanpurposeService loanpurposeService;
	@Resource
	private RepaymentmethodsService repaymentmethodsService;
	@Resource
	private BankinformationService bankinformationService;
	@Resource
	private Cash_flowService cash_flowService;

	/**
	 * 进入后台管理员页面
	 * 
	 * @return
	 */
	@RequestMapping("/main")
	public String main() {
		return "back/main";
	}

	/**
	 * 查询管理员信息
	 * 
	 * @return
	 */
	@RequestMapping("/adminList")
	public String admin(Model model, @RequestParam(value = "currentPageNo", required = false) String _currentPageNo) {
		Integer pageSize = 5;// 页面大小

		Integer currentPageNo;// 当前页面
		if (null != _currentPageNo) {
			currentPageNo = Integer.parseInt(_currentPageNo);
		} else {
			currentPageNo = 1;
		}
		// 总条数
		Integer totalCount = memberService.findByAdminCount();
		// 分页开始的位置
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);
		Integer from = pageSupport.getFrom();
		List<Member> members = memberService.findByAdmin(from, pageSize);

		model.addAttribute("members", members);
		model.addAttribute("pageSupport", pageSupport);
		return "back/admin/adminList";
	}

	/**
	 * 删除会员信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteAdmin")
	@ResponseBody
	public String deleteAdmin(@RequestParam(value = "id") String id) {
		String message = "null";
		if (null != id) {
			if (memberService.deleteById(Integer.parseInt(id))) {
				message = "true";
			} else {
				message = "false";
			}
		}
		return message;
	}

	/**
	 * 修改跳转
	 * 
	 * @return
	 */
	@RequestMapping("/goAdminAlter")
	public String goAlter(@RequestParam String id, Model model, Member member_) {
		Member member = memberService.findMemberById(Integer.parseInt(id));
		List<Role> roles = roleService.findAll();
		model.addAttribute("member", member);
		model.addAttribute("roles", roles);
		return "back/admin/adminAlter";
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	@RequestMapping("/doAdminAlter")
	public String doAlter(Member member_, Model model) {
		if (null != member_) {
			// 获取数据库中的数据
			Member _member = memberService.findMemberById(member_.getId());
			if (!member_.getPassword().equalsIgnoreCase(_member.getPassword())) {// 如果密码发送改变
				member_.setPassword(SecurityUtils.md5Hex(member_.getPassword()));// 对密码进行加密
			}
			if (!member_.getPaymentpassword().equalsIgnoreCase(_member.getPaymentpassword())) {// 如果支付密码发送改变
				member_.setPaymentpassword(SecurityUtils.md5Hex(member_.getPaymentpassword()));// 对支付密码进行加密
			}
			if (memberService.alter(member_)) {
				return "redirect:adminList";// 如果更改成功则跳转到列表
			}

			model.addAttribute("member", _member);// 如果失败则跳转到修改页面
			List<Role> roles = roleService.findAll();
			model.addAttribute("roles", roles);
			return "back/admin/adminAlter";
		}
		throw new RuntimeException("修改管理员错误!!!");
	}

	/**
	 * 进入管理员添加页面
	 * 
	 * @param member
	 * @param model
	 * @return
	 */
	@RequestMapping("/goAddAdmin")
	public String goAddAdmin(Member member, Model model) {
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		return "back/admin/adminAdd";
	}

	/**
	 * 进行会员添加
	 * 
	 * @return
	 */
	@RequestMapping("/doAddAdmin")
	public String doAddAdmin(Member member) {
		member.setRegistrationtime(new Date());// 添加时间
		member.setPassword(SecurityUtils.md5Hex(member.getPassword()));// 加密
		member.setPaymentpassword(SecurityUtils.md5Hex(member.getPaymentpassword()));
		if (memberService.add(member)) {
			return "redirect:adminList";// 如果成功则跳转到列表
		}
		throw new RuntimeException("会员添加失败!!!");
	}

	/**
	 * 进入角色信息
	 * 
	 * @return
	 */
	@RequestMapping("/goRoleList")
	public String goRoleList(Model model, @RequestParam(required = false) Integer currentPageNo) {
		if (null == currentPageNo) {// 当前页
			currentPageNo = 1;
		}
		Integer pageSize = 3;// 页面大小
		Integer totalCount = roleService.findAllCount();// 总数
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);
		Integer from = pageSupport.getFrom();

		List<Role> roles = roleService.findAllPage(from, pageSize);

		model.addAttribute("roles", roles);
		model.addAttribute("pageSupport", pageSupport);
		return "back/admin/roleList";
	}

	/**
	 * 进入角色添加页面
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping("/goRoleAdd")
	public String goRoleAdd(Role role) {
		return "back/admin/roleAdd";
	}

	/**
	 * 进行角色添加操作
	 * 
	 * @return
	 */
	@RequestMapping("/doRoleAdd")
	public String doRoleAdd(Role role) {
		if (null != role) {
			if (roleService.add(role)) {
				return "redirect:goRoleList";
			}
			return "back/admin/roleAdd";
		}
		throw new RuntimeException("角色添加失败!!!");
	}

	/**
	 * 进行角色删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/doRoleDel")
	@ResponseBody
	public String doRoleDel(@RequestParam Integer id) {
		if (roleService.delete(id)) {
			return "true";
		}
		return "false";
	}

	/**
	 * 进入修改页面
	 * 
	 * @param _role
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/goRoleAlter")
	public String goRoleAlter(Role _role, Model model, @RequestParam Integer id) {
		Role role = roleService.findRoleById(id);
		model.addAttribute("role", role);
		return "back/admin/roleAlter";
	}

	/**
	 * 进行修改
	 * 
	 * @param _role
	 * @return
	 */
	@RequestMapping("/doRoleAlter")
	public String doRoleAlter(Role _role) {
		if (roleService.update(_role)) {
			return "redirect:goRoleList";// 如果成功则跳转到列表
		}
		return "redirect:goRoleAlter?id=" + _role.getId();// 如果失败跳转到修改也
	}

	/**
	 * 进入借款用途列表页面
	 * 
	 * @param currentPageNo
	 * @param model
	 * @return
	 */
	@RequestMapping("/goLoanpList")
	public String goLoanpList(@RequestParam(required = false) Integer currentPageNo, Model model) {
		if (null == currentPageNo) {// 当前页
			currentPageNo = 1;
		}
		Integer pageSize = 5;// 页面大小
		Integer totalCount = loanpurposeService.getAllCount();// 总数
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);

		Integer from = pageSupport.getFrom();
		List<Loanpurpose> loanpurposes = loanpurposeService.findByPage(from, pageSize);

		model.addAttribute("pageSupport", pageSupport);
		model.addAttribute("loanpurposes", loanpurposes);

		return "back/basic/loanpList";
	}

	/**
	 * 进入增加借款用途页面
	 * 
	 * @param loanpurpose
	 * @return
	 */
	@RequestMapping("/goLoanpAdd")
	public String goLoanpAdd(Loanpurpose loanpurpose) {
		return "back/basic/loanpAdd";
	}

	/**
	 * 进行添加借款用途
	 * 
	 * @param loanpurpose
	 * @return
	 */
	@RequestMapping("/doLoanpAdd")
	public String doLoanpAdd(Loanpurpose loanpurpose) {
		if (loanpurposeService.add(loanpurpose)) {
			return "redirect:goLoanpList";
		}
		return "redirect:goLoanpAdd";
	}

	/**
	 * 删除借款用途
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delLoanp")
	@ResponseBody
	public String delLoanp(@RequestParam Integer id) {
		if (loanpurposeService.delete(id)) {
			return "true";
		}
		return "false";
	}

	/**
	 * 进入修改借款用途
	 * 
	 * @param id
	 * @param model
	 * @param _loanpurpose
	 * @return
	 */
	@RequestMapping("/goLoanpAlter")
	public String goLoanpAlter(@RequestParam Integer id, Model model, Loanpurpose _loanpurpose) {
		Loanpurpose loanpurpose = loanpurposeService.findById(id);
		model.addAttribute("loanpurpose", loanpurpose);
		return "back/basic/loanpAlter";
	}

	/**
	 * 进行修改
	 * 
	 * @param _loanpurpose
	 * @return
	 */
	@RequestMapping("/doLoanpAlter")
	public String doLoanAlter(Loanpurpose _loanpurpose) {
		if (loanpurposeService.update(_loanpurpose)) {
			return "redirect:goLoanpList";
		}
		return "redirect:goLoanpAlter?id=" + _loanpurpose.getId();
	}

	/**
	 * 进入还款方式列表页
	 * 
	 * @param currentPageNo
	 * @param model
	 * @return
	 */
	@RequestMapping("/goRepayMList")
	public String goRepayMList(@RequestParam(required = false) Integer currentPageNo, Model model) {
		if (null == currentPageNo) {// 当前页
			currentPageNo = 1;
		}
		Integer pageSize = 5;// 页面大小
		Integer totalCount = repaymentmethodsService.getAllCount();// 总数
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);

		Integer from = pageSupport.getFrom();
		List<Repaymentmethods> repaymentmethodsList = repaymentmethodsService.findByPage(from, pageSize);

		model.addAttribute("pageSupport", pageSupport);
		model.addAttribute("repaymentmethodsList", repaymentmethodsList);

		return "back/basic/repayMList";
	}

	/**
	 * 进入还款方式添加页
	 * 
	 * @param repaymentmethods
	 * @return
	 */
	@RequestMapping("/goRepayMAdd")
	public String goRepayMAdd(Repaymentmethods repaymentmethods) {
		return "back/basic/repayMAdd";
	}

	/**
	 * 添加还款方式
	 * 
	 * @param repaymentmethods
	 * @return
	 */
	@RequestMapping("/doRepayMAdd")
	public String doRepayMAdd(Repaymentmethods repaymentmethods) {
		if (repaymentmethodsService.add(repaymentmethods)) {
			return "redirect:goRepayMList";
		}
		return "redirect:goRepayMAdd";
	}

	/**
	 * 删除还款方式
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delRepayM")
	@ResponseBody
	public String delRepayM(@RequestParam Integer id) {
		if (repaymentmethodsService.delete(id)) {
			return "true";
		}
		return "false";
	}

	/**
	 * 进入还款方式修改页面
	 * 
	 * @param _repaymentmethods
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/goRepayMAlter")
	public String goRepayMAlter(Repaymentmethods _repaymentmethods, Model model, @RequestParam Integer id) {
		Repaymentmethods repaymentmethods = repaymentmethodsService.findById(id);
		model.addAttribute("repaymentmethods", repaymentmethods);
		return "back/basic/repayMAlter";
	}

	/**
	 * 修改还款方式
	 * 
	 * @param _repaymentmethods
	 * @return
	 */
	@RequestMapping("/doRepayMAlter")
	public String doRepayMAlter(Repaymentmethods _repaymentmethods) {
		if (repaymentmethodsService.update(_repaymentmethods)) {
			return "redirect:goRepayMList";
		}
		throw new RuntimeException("修改还款方式失败!!!");
	}

	/**
	 * 进入银行信息列表
	 * 
	 * @param currentPageNo
	 * @param model
	 * @return
	 */
	@RequestMapping("/goBankInfoList")
	public String goBankInfoList(@RequestParam(required = false) Integer currentPageNo, Model model) {
		if (null == currentPageNo) {// 当前页
			currentPageNo = 1;
		}
		Integer pageSize = 5;// 页面大小
		Integer totalCount = bankinformationService.getAllCount();// 总数
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);

		Integer from = pageSupport.getFrom();
		List<Bankinformation> bankinformations = bankinformationService.findByPage(from, pageSize);

		model.addAttribute("pageSupport", pageSupport);
		model.addAttribute("bankinformations", bankinformations);

		return "back/basic/bankInfoList";
	}

	/**
	 * 进入银行信息添加页面
	 * 
	 * @param bankinformation
	 * @return
	 */
	@RequestMapping("/goBankInfoAdd")
	public String goBankInfoAdd(Bankinformation bankinformation) {
		return "back/basic/bankInfoAdd";
	}

	/**
	 * 银行信息添加
	 * 
	 * @param bankinformation
	 * @return
	 */
	@RequestMapping("/doBankInfoAdd")
	public String doBankInfoAdd(Bankinformation bankinformation) {
		if (bankinformationService.add(bankinformation)) {
			return "redirect:goBankInfoList";
		}
		throw new RuntimeException("银行信息添加失败!!!");
	}

	/**
	 * 删除银行信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delBankInfo")
	@ResponseBody
	public String delBankInfo(@RequestParam Integer id) {
		if (bankinformationService.delete(id)) {
			return "true";
		}
		return "false";
	}

	/**
	 * 进入银行信息修改
	 * 
	 * @param _bankinformation
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/goBankInfoAlter")
	public String goBankInfoAlter(Bankinformation _bankinformation, Model model, @RequestParam Integer id) {
		Bankinformation bankinformation = bankinformationService.findById(id);
		model.addAttribute("bankinformation", bankinformation);
		return "back/basic/bankInfoAlter";
	}

	/**
	 * 修改银行信息
	 * 
	 * @param _bankinformation
	 * @return
	 */
	@RequestMapping("/doBankInfoAlter")
	public String doBankInfoAlter(Bankinformation _bankinformation) {
		if (bankinformationService.update(_bankinformation)) {
			return "redirect:goBankInfoList";
		}
		throw new RuntimeException("修改银行信息失败!!!");
	}

	/**
	 * 进入充值列表
	 * 
	 * @param model
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/Recharge")
	public String goRecharge(Model model, @RequestParam(required = false) Integer currentPageNo) {
		if (null == currentPageNo) {// 当前页
			currentPageNo = 1;
		}
		Integer pageSize = 5;// 页面大小
		Integer totalCount = cash_flowService.findAllCount("XSCZ");// 总数
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);

		Integer from = pageSupport.getFrom();
		List<Cash_flow> cash_flows = cash_flowService.findAllList("XSCZ", from, pageSize);

		model.addAttribute("pageSupport", pageSupport);
		model.addAttribute("cash_flows", cash_flows);

		return "back/cashFlow/recharge";
	}

	/**
	 * 进入提现列表
	 * 
	 * @param model
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/goTixian")
	public String goTixian(Model model, @RequestParam(required = false) Integer currentPageNo) {
		if (null == currentPageNo) {// 当前页
			currentPageNo = 1;
		}
		Integer pageSize = 5;// 页面大小
		Integer totalCount = cash_flowService.findAllCount("TX");// 总数
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);

		Integer from = pageSupport.getFrom();
		List<Cash_flow> cash_flows = cash_flowService.findAllList("TX", from, pageSize);

		model.addAttribute("pageSupport", pageSupport);
		model.addAttribute("cash_flows", cash_flows);

		return "back/cashFlow/tixian";
	}

	/**
	 * 进入用户列表
	 * 
	 * @param model
	 * @param currentPageNo
	 * @param username
	 * @return
	 */
	@RequestMapping("/goMemberList")
	public String goMemberList(Model model, @RequestParam(required = false) Integer currentPageNo,
			@RequestParam(required = false) String username) {
		if (null == currentPageNo) {// 当前页
			currentPageNo = 1;
		}
		Integer pageSize = 5;// 页面大小
		Integer totalCount = memberService.findAllCount(username);
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);
		Integer from = pageSupport.getFrom();

		List<Member> members = memberService.findAll(username, from, pageSize);

		model.addAttribute("pageSupport", pageSupport);
		model.addAttribute("members", members);

		return "back/admin/memberList";
	}
}
