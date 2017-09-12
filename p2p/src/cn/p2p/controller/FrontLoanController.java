package cn.p2p.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.p2p.dao.RepaymentmethodsMapper;
import cn.p2p.pojo.Borrowmark;
import cn.p2p.pojo.Loanpurpose;
import cn.p2p.pojo.Member;
import cn.p2p.pojo.Repaymentmethods;
import cn.p2p.service.BorrowmarkService;
import cn.p2p.service.LoanpurposeService;
import cn.p2p.service.RepaymentmethodsService;
import cn.p2p.util.Constant;
import cn.p2p.util.PageSupport;

@Controller
@RequestMapping("/front/loan")
public class FrontLoanController {
	@Resource
	private BorrowmarkService borrowmarkService;
	@Resource
	private LoanpurposeService loanpurposeService;
	@Resource
	private RepaymentmethodsService repaymentmethodsService;

	/**
	 * 进入借款首页
	 * 
	 * @param model
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/main")
	public String main(Model model, @RequestParam(required = false) Integer currentPageNo) {
		if (null == currentPageNo) {
			currentPageNo = 1;
		}
		Integer pageSize = 5;

		Integer totalCount = borrowmarkService.findCount(5);
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);

		Integer from = pageSupport.getFrom();

		List<Borrowmark> borrowmarks = borrowmarkService.findPage(5, from, pageSize);

		model.addAttribute("borrowmarks", borrowmarks);
		model.addAttribute("pageSupport", pageSupport);

		return "front/loan/main";
	}

	/**
	 * 进入借款页
	 * 
	 * @param model
	 * @param borrowmark
	 * @return
	 */
	@RequestMapping("/goLoan")
	public String goLoan(Model model, Borrowmark borrowmark) {
		List<Loanpurpose> loanpurposes = loanpurposeService.findByPage(0, 1000);
		List<Repaymentmethods> repayList = repaymentmethodsService.findByPage(0, 1000);

		model.addAttribute("repayList", repayList);
		model.addAttribute("loanpurposes", loanpurposes);

		return "front/loan/loan";
	}

	/**
	 * 借款
	 * 
	 * @param borrowmark
	 * @param session
	 * @return
	 */
	@RequestMapping("/doLoan")
	public String doLoan(Borrowmark borrowmark, HttpSession session) {
		// 当前用户id
		Integer m_id = ((Member) session.getAttribute(Constant.USER_SESSION)).getId();
		borrowmark.setStatus(1);
		borrowmark.setLoanapplicationtime(new Date());
		borrowmark.setM_id(m_id);
		if (borrowmarkService.add(borrowmark)) {
			return "front/loan/loanSuccess";
		}
		return "front/loan/loan";
	}
}
