package cn.p2p.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Path.Node;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.p2p.pojo.Borrowmark;
import cn.p2p.pojo.BorrowmarkDetails;
import cn.p2p.pojo.Fund_account;
import cn.p2p.pojo.Member;
import cn.p2p.service.BorrowmarkDetailsService;
import cn.p2p.service.BorrowmarkService;
import cn.p2p.service.Fund_accountService;
import cn.p2p.util.Constant;
import cn.p2p.util.PageSupport;

@Controller
@RequestMapping("/front/invest")
public class FrontInvestController {
	@Resource
	private BorrowmarkService borrowmarkService;
	@Resource
	private Fund_accountService fund_accountService;
	@Resource
	private BorrowmarkDetailsService borrowmarkDetailsService;

	/**
	 * 进入投资首页
	 * 
	 * @param model
	 * @param currentPageNo
	 * @param session
	 * @return
	 */
	@RequestMapping("/main")
	public String main(Model model, @RequestParam(required = false) Integer currentPageNo, HttpSession session) {
		// 当前用户id
		Integer m_id = ((Member) session.getAttribute(Constant.USER_SESSION)).getId();
		if (null == currentPageNo) {
			currentPageNo = 1;
		}
		Integer pageSize = 5;

		Integer totalCount = borrowmarkService.findCount(2);
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);

		Integer from = pageSupport.getFrom();

		List<Borrowmark> borrowmarks = borrowmarkService.findPage(2, from, pageSize);
		Fund_account fund_account = fund_accountService.findByMID(m_id);

		model.addAttribute("borrowmarks", borrowmarks);
		model.addAttribute("pageSupport", pageSupport);
		model.addAttribute("fund_account", fund_account);

		return "front/invest/main";
	}

	/**
	 * 进行投资
	 * 
	 * @param b_id
	 * @param session
	 * @return
	 */
	@RequestMapping("/doInvest")
	@ResponseBody
	public String doInvest(@RequestParam Integer b_id, HttpSession session) {
		// 当前用户id
		Integer m_id = ((Member) session.getAttribute(Constant.USER_SESSION)).getId();
		if (borrowmarkService.doInvest(m_id, b_id)) {
			return "true";
		}
		return "false";
	}

	/**
	 * 进入标的详情页面
	 * 
	 * @param b_id
	 * @param model
	 * @return
	 */
	@RequestMapping("/goBorrowDetail")
	public String goBorrowDetail(@RequestParam Integer b_id, Model model) {
		Borrowmark borrowmark = borrowmarkService.findById(b_id);
		BorrowmarkDetails borrowmarkDetails = borrowmarkDetailsService.findByBID(b_id);

		model.addAttribute("borrowmark", borrowmark);
		model.addAttribute("borrowmarkDetails", borrowmarkDetails);

		return "front/invest/borrowDetail";
	}
}
