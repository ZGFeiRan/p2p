package cn.p2p.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.p2p.pojo.Bankaccount;
import cn.p2p.pojo.Bankinformation;
import cn.p2p.pojo.Borrowmark;
import cn.p2p.pojo.Cash_flow;
import cn.p2p.pojo.Fund_account;
import cn.p2p.pojo.Member;
import cn.p2p.pojo.Repayment_record;
import cn.p2p.pojo.Tender_record;
import cn.p2p.service.BankaccountService;
import cn.p2p.service.BankinformationService;
import cn.p2p.service.BorrowmarkDetailsService;
import cn.p2p.service.BorrowmarkService;
import cn.p2p.service.Cash_flowService;
import cn.p2p.service.Fund_accountService;
import cn.p2p.service.MemberService;
import cn.p2p.service.Repayment_recordService;
import cn.p2p.service.Tender_recordService;
import cn.p2p.util.Constant;
import cn.p2p.util.EmailUtil;
import cn.p2p.util.PageSupport;
import cn.p2p.util.SecurityUtils;

@Controller
@RequestMapping("/front/member")
public class FrontMemberController {
	@Resource
	private MemberService memberService;
	@Resource
	private Cash_flowService cash_flowService;
	@Resource
	private Tender_recordService tender_recordService;
	@Resource
	private Repayment_recordService repayment_recordService;
	@Resource
	private BankaccountService bankaccountService;
	@Resource
	private BankinformationService bankinformationService;
	@Resource
	private Fund_accountService fund_accountService;
	@Resource
	private BorrowmarkService borrowmarkService;
	@Resource
	private BorrowmarkDetailsService borrowmarkDetailsService;

	/**
	 * 进入个人主页首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/main")
	public String main(Model model, HttpSession session) {
		// 当前用户id
		Integer m_id = ((Member) session.getAttribute(Constant.USER_SESSION)).getId();

		Member member = memberService.findMemberById(m_id);

		Fund_account fund_account = fund_accountService.findByMID(m_id);
		if (null == fund_account) {
			Fund_account fA = new Fund_account(m_id, 0.0, new Date());
			fund_accountService.add(fA);
			model.addAttribute("fund_account", fA);
		} else {
			model.addAttribute("fund_account", fund_account);
		}

		model.addAttribute("member", member);

		return "front/member/main";
	}

	/**
	 * 资金记录
	 * 
	 * @param financial_tran_type
	 *            类型
	 * @param model
	 * @param currentPageNo
	 *            当前页
	 * @param session
	 * @return
	 */
	@RequestMapping("/cash_flowList")
	public String cash_flowList(@RequestParam(required = false) String financial_tran_type, Model model,
			@RequestParam(required = false) Integer currentPageNo, HttpSession session) {
		if (null != financial_tran_type && financial_tran_type.equals("全部")) {
			financial_tran_type = null;
		}
		// 当前用户id
		Integer m_id = ((Member) session.getAttribute(Constant.USER_SESSION)).getId();

		if (null == currentPageNo) {// 当前页
			currentPageNo = 1;
		}
		Integer pageSize = 5;// 页容量
		// 总页数
		Integer totalCount = cash_flowService.findCount(m_id, financial_tran_type);
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);
		Integer from = pageSupport.getFrom();// limit开始值

		List<Cash_flow> cash_flows = cash_flowService.findList(m_id, financial_tran_type, from, pageSize);

		model.addAttribute("pageSupport", pageSupport);
		model.addAttribute("cash_flows", cash_flows);

		return "front/member/cash_flow";
	}

	/**
	 * 投资记录
	 * 
	 * @param model
	 * @param session
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/tender_recordList")
	public String tender_recordList(Model model, HttpSession session,
			@RequestParam(required = false) Integer currentPageNo) {
		// 当前用户id
		Integer m_id = ((Member) session.getAttribute(Constant.USER_SESSION)).getId();

		if (null == currentPageNo) {// 当前页
			currentPageNo = 1;
		}
		Integer pageSize = 5;// 页容量
		// 总页数
		Integer totalCount = tender_recordService.findByMIDCount(m_id);
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);
		Integer from = pageSupport.getFrom();// limit开始值

		List<Tender_record> tender_records = tender_recordService.findByMID(m_id, from, pageSize);

		// 计算累计投资
		List<Tender_record> tender_recordsAll = tender_recordService.findAll(m_id);
		double sum = 0;
		for (Tender_record tender_record : tender_recordsAll) {
			sum += tender_record.getTender_amount();
		}

		model.addAttribute("sum", sum);
		model.addAttribute("pageSupport", pageSupport);
		model.addAttribute("tender_records", tender_records);

		return "front/member/tender_record";
	}

	/**
	 * 还款回款
	 * 
	 * @param model
	 * @param currentPageNo
	 * @param session
	 * @return
	 */
	@RequestMapping("/repayment_record")
	public String findRepayment_recordList(Model model, @RequestParam(required = false) Integer currentPageNo,
			@RequestParam(required = false) Integer payer_user_id,
			@RequestParam(required = false) Integer payee_user_id, @RequestParam(required = false) String status) {
		if (null == currentPageNo) {// 当前页
			currentPageNo = 1;
		}
		Integer pageSize = 5;// 页容量
		// 总页数
		Integer totalCount = repayment_recordService.findListCount(payer_user_id, payee_user_id, status);
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);
		Integer from = pageSupport.getFrom();// limit开始值

		Integer sum = repayment_recordService.findTotal(payer_user_id, payee_user_id, status);

		List<Repayment_record> repayment_records = repayment_recordService.findPageList(payer_user_id, payee_user_id,
				status, from, pageSize);

		model.addAttribute("sum", sum);
		model.addAttribute("pageSupport", pageSupport);
		model.addAttribute("repayment_records", repayment_records);
		if (null == payer_user_id && status.equalsIgnoreCase("yh")) {// 回款记录
			return "front/member/huikuanjilu";
		}
		if (null == payer_user_id && status.equalsIgnoreCase("wh")) {// 回款计划
			return "front/member/huikuanjihua";
		}
		if (null == payee_user_id && status.equalsIgnoreCase("yh")) {// 还款记录
			return "front/member/huankuanjilu";
		}
		if (null == payee_user_id && status.equalsIgnoreCase("wh")) {// 还款计划
			return "front/member/huankuanjihua";
		}
		throw new RuntimeException("还款回款失败!!!");
	}

	/**
	 * 用户银行卡列表
	 * 
	 * @param model
	 * @param currentPageNo
	 * @param session
	 * @return
	 */
	@RequestMapping("/bankList")
	public String bankList(Model model, @RequestParam(required = false) Integer currentPageNo, HttpSession session) {
		// 当前用户id
		Integer m_id = ((Member) session.getAttribute(Constant.USER_SESSION)).getId();

		if (null == currentPageNo) {// 当前页
			currentPageNo = 1;
		}
		Integer pageSize = 5;// 页容量
		// 总页数
		Integer totalCount = bankaccountService.findListCount(m_id);
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);
		Integer from = pageSupport.getFrom();// limit开始值

		List<Bankaccount> bankaccounts = bankaccountService.findList(m_id, from, pageSize);

		model.addAttribute("bankaccounts", bankaccounts);
		model.addAttribute("pageSupport", pageSupport);

		return "front/member/bankList";
	}

	/**
	 * 删除用户银行
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/bankDel")
	@ResponseBody
	public String bankDel(@RequestParam Integer id) {
		if (null != id) {
			if (bankaccountService.del(id)) {
				return "true";
			}
			return "false";
		}
		return "null";
	}

	/**
	 * 进入用户银行信息添加
	 * 
	 * @param bankaccount
	 * @param model
	 * @return
	 */
	@RequestMapping("/goBankAdd")
	public String goBankAdd(Bankaccount bankaccount, Model model) {
		List<Bankinformation> bankinformations = bankinformationService.findAll();
		model.addAttribute("bankinformations", bankinformations);
		return "front/member/bankAdd";
	}

	/**
	 * 执行用户银行信息添加
	 * 
	 * @param bankaccount
	 * @return
	 */
	@RequestMapping("/doBankAdd")
	public String doBankAdd(Bankaccount bankaccount) {
		if (bankaccountService.add(bankaccount)) {
			return "redirect:bankList";
		}
		return "redirect:goBankAdd";
	}

	/**
	 * 进入充值页面
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/goRecharge")
	public String goRecharge(HttpSession session, Model model) {
		// 当前用户id
		Integer m_id = ((Member) session.getAttribute(Constant.USER_SESSION)).getId();
		List<Bankaccount> bankaccounts = bankaccountService.findList(m_id, 0, 1000);

		model.addAttribute("bankaccounts", bankaccounts);

		return "front/member/recharge";
	}

	/**
	 * 进行充值操作
	 * 
	 * @param money
	 * @param session
	 * @return
	 */
	@RequestMapping("/doRecharge")
	public String doRecharge(@RequestParam Double money, HttpSession session) {
		// 当前用户id
		Integer m_id = ((Member) session.getAttribute(Constant.USER_SESSION)).getId();

		if (cash_flowService.recharge(m_id, money)) {
			return "redirect:main";
		}
		throw new RuntimeException("充值失败!!!");
	}

	/**
	 * 进入提现页面
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/goTixian")
	public String goTixian(Model model, HttpSession session) {
		// 当前用户id
		Integer m_id = ((Member) session.getAttribute(Constant.USER_SESSION)).getId();
		Fund_account fund_account = fund_accountService.findByMID(m_id);
		List<Bankaccount> bankaccounts = bankaccountService.findList(m_id, 0, 1000);

		if (null == fund_account) {// 如果没有账户则添加一个
			Fund_account fa = new Fund_account(m_id, 0.0, new Date());
			fund_accountService.add(fa);
			model.addAttribute("fund_account", fa);
		} else {
			model.addAttribute("fund_account", fund_account);
		}

		model.addAttribute("bankaccounts", bankaccounts);

		return "front/member/tixian";
	}

	/**
	 * 进行提现操作
	 * 
	 * @param money
	 * @param session
	 * @return
	 */
	@RequestMapping("/doTixian")
	public String doTixian(@RequestParam Double money, HttpSession session) {
		// 当前用户id
		Integer m_id = ((Member) session.getAttribute(Constant.USER_SESSION)).getId();

		if (cash_flowService.tixian(m_id, money)) {
			return "redirect:main";
		}
		throw new RuntimeException("提现失败!!!");
	}

	/**
	 * 进入个人设置
	 * 
	 * @return
	 */
	@RequestMapping("/goSetting")
	public String goSetting() {
		return "front/member/setting";
	}

	/**
	 * 进入修改添加支付密码
	 * 
	 * @return
	 */
	@RequestMapping("/goZFPassword")
	public String goZFPassword() {
		return "front/member/ZFPassword";
	}

	/**
	 * 进行修改添加支付密码
	 * 
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("/doZFPassword")
	public String doZFPassword(@RequestParam String password, HttpSession session) {
		// 当前用户id
		Integer m_id = ((Member) session.getAttribute(Constant.USER_SESSION)).getId();
		// 当前用户
		Member member = memberService.findMemberById(m_id);

		member.setPaymentpassword(SecurityUtils.md5Hex(password));
		if (memberService.alter(member)) {
			return "front/member/setting";
		}
		throw new RuntimeException("修改添加支付密码失败!!!");
	}

	/**
	 * 进入密码修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/goPasswordUpdate")
	public String goPasswordUpdate() {
		return "front/member/password";
	}

	/**
	 * 进行密码修改
	 * 
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("/doPasswordUpdate")
	public String doPasswordUpdate(@RequestParam String password, HttpSession session) {
		// 当前用户id
		Integer m_id = ((Member) session.getAttribute(Constant.USER_SESSION)).getId();
		// 当前用户
		Member member = memberService.findMemberById(m_id);

		member.setPassword(SecurityUtils.md5Hex(password));

		if (memberService.alter(member)) {
			return "front/member/setting";
		}
		throw new RuntimeException("密码修改失败!!!");
	}

	/**
	 * 进入手机修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/goPhoneUpdate")
	public String goPhoneUpdate() {
		return "front/member/phoneUpdate";
	}

	/**
	 * 进行手机修改
	 * 
	 * @param phone
	 * @param session
	 * @return
	 */
	@RequestMapping("/doPhoneUpdate")
	public String doPhoneUpdate(@RequestParam String phone, HttpSession session) {
		// 当前用户id
		Integer m_id = ((Member) session.getAttribute(Constant.USER_SESSION)).getId();
		// 当前用户
		Member member = memberService.findMemberById(m_id);

		member.setPhone(phone);
		if (memberService.alter(member)) {
			return "front/member/setting";
		}
		throw new RuntimeException("手机修改失败!!!");
	}

	/**
	 * 进入邮箱修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/goEmailUpdate")
	public String goEmailUpdate() {
		return "front/member/emailUpdate";
	}

	/**
	 * 修改邮箱
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/sendEmail")
	@ResponseBody
	public String sendEmail(HttpSession session) {
		// 当前用户id
		Integer m_id = ((Member) session.getAttribute(Constant.USER_SESSION)).getId();
		// 当前用户
		Member member = memberService.findMemberById(m_id);

		Random random = new Random();
		Integer i = random.nextInt(10000);
		if (i < 1000) {
			i = random.nextInt(10000);
		}
		String msg = "发送邮件" + i;
		EmailUtil.send(member.getEmail(), "测试发送邮件", msg);

		return i.toString();
	}

	/**
	 * 进入我的融资列表
	 * 
	 * @param session
	 * @param model
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/goMyLoan")
	public String goMyLoan(HttpSession session, Model model, @RequestParam(required = false) Integer currentPageNo) {
		// 当前用户id
		Integer m_id = ((Member) session.getAttribute(Constant.USER_SESSION)).getId();
		if (null == currentPageNo) {
			currentPageNo = 1;
		}
		Integer pageSize = 5;
		Integer totalCount = borrowmarkService.findByMIDCount(m_id);
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);
		Integer from = pageSupport.getFrom();
		List<Borrowmark> borrowmarks = borrowmarkService.findByMID(m_id, from, pageSize);

		model.addAttribute("borrowmarks", borrowmarks);
		model.addAttribute("pageSupport", pageSupport);

		return "front/member/myLoan";
	}

	/**
	 * 删除借款
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delBorrowmark")
	@ResponseBody
	public String delBorrowmark(@RequestParam Integer id) {
		Borrowmark borrowmark = borrowmarkService.findById(id);
		if (borrowmark.getStatus() != 1 || borrowmark.getStatus() != 3) {
			return "error";
		}
		if (borrowmarkService.del(id)) {
			return "true";
		}
		return "false";
	}

	@RequestMapping("/doRepayment")
	@ResponseBody
	public String doRepayment(@RequestParam Integer id) {
		if (repayment_recordService.doRepayment(id)) {
			return "true";
		}
		return "false";
	}
}
