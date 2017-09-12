package cn.p2p.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.p2p.pojo.Borrowmark;
import cn.p2p.service.BorrowmarkService;
import cn.p2p.util.PageSupport;

@Controller
@RequestMapping("/back/borrow")
public class BackBorrowmarkContorller {
	@Resource
	private BorrowmarkService borrowmarkService;

	/**
	 * 进入借款列表
	 * 
	 * @param model
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/goBorrowList")
	public String goBorrowList(Model model, @RequestParam(required = false) Integer currentPageNo) {
		if (null == currentPageNo) {
			currentPageNo = 1;
		}
		Integer pageSize = 5;

		Integer totalCount = borrowmarkService.findAllCount();
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);
		Integer from = pageSupport.getFrom();
		List<Borrowmark> borrowmarks = borrowmarkService.findAll(from, pageSize);

		model.addAttribute("borrowmarks", borrowmarks);
		model.addAttribute("pageSupport", pageSupport);

		return "back/borrow/borrowList";
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
		if (borrowmark.getStatus() != 3) {
			return "error";
		}
		if (borrowmarkService.del(id)) {
			return "true";
		}
		return "false";
	}

	/**
	 * 进入审核界面
	 * 
	 * @param model
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/goBorrowCheck")
	public String goBorrowCheck(Model model, @RequestParam(required = false) Integer currentPageNo) {
		if (null == currentPageNo) {
			currentPageNo = 1;
		}
		Integer pageSize = 5;

		Integer totalCount = borrowmarkService.findCount(1);
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);
		Integer from = pageSupport.getFrom();
		List<Borrowmark> borrowmarks = borrowmarkService.findPage(1, from, pageSize);

		model.addAttribute("borrowmarks", borrowmarks);
		model.addAttribute("pageSupport", pageSupport);

		return "back/borrow/borrowCheck";
	}

	/**
	 * 进行审核
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping("/doBorrowCheck")
	public String doBorrowCheck(@RequestParam Integer id, @RequestParam Integer status) {
		if (borrowmarkService.checkBorrow(id, status)) {
			return "redirect:goBorrowCheck";
		}
		throw new RuntimeException("审核失败!!!");
	}

	/**
	 * 进入放款界面
	 * 
	 * @param model
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/goMakeLoan")
	public String goMakeLoan(Model model, @RequestParam(required = false) Integer currentPageNo) {
		if (null == currentPageNo) {
			currentPageNo = 1;
		}
		Integer pageSize = 5;

		Integer totalCount = borrowmarkService.findCount(4);
		PageSupport pageSupport = new PageSupport(currentPageNo, totalCount, pageSize);
		Integer from = pageSupport.getFrom();
		List<Borrowmark> borrowmarks = borrowmarkService.findPage(4, from, pageSize);

		model.addAttribute("borrowmarks", borrowmarks);
		model.addAttribute("pageSupport", pageSupport);

		return "back/borrow/makeLoan";
	}

	/**
	 * 进行放款
	 * 
	 * @param b_id
	 * @return
	 */
	@RequestMapping("/doMakeLoan")
	@ResponseBody
	public String doMakeLoan(@RequestParam Integer b_id) {
		if (borrowmarkService.doMarkLoan(b_id)) {
			return "true";
		}
		return "false";
	}
}
