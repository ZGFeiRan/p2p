package cn.jboa.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.jboa.service.BizClaimVoucherService;

@Controller
public class AddVoucherAction extends ActionSupport {
	@Resource
	private BizClaimVoucherService bizClaimVoucherService;
	private String name;
}
