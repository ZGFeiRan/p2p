package cn.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class FrontCompanyContorller {

	@RequestMapping("/CompanyProfile")
	public String CompanyProfile() {
		return "front/company/CompanyProfile";
	}

	@RequestMapping("/TeamManagement")
	public String TeamManagement() {
		return "front/company/TeamManagement";
	}

	@RequestMapping("/CooperativePartner")
	public String CooperativePartner() {
		return "front/company/CooperativePartner";
	}

	@RequestMapping("/TeamPresence")
	public String TeamPresence() {
		return "front/company/TeamPresence";
	}

	@RequestMapping("/LegalPolicy")
	public String LegalPolicy() {
		return "front/company/LegalPolicy";
	}

	@RequestMapping("/LegalStatement")
	public String LegalStatement() {
		return "front/company/LegalStatement";
	}

	@RequestMapping("/TariffDescription")
	public String TariffDescription() {
		return "front/company/TariffDescription";
	}

	@RequestMapping("/ConnectionOut")
	public String ConnectionOut() {
		return "front/company/ConnectionOut";
	}

}
