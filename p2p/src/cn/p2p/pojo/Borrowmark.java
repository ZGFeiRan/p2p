package cn.p2p.pojo;

import java.util.Date;

/**
 * 借款标的
 */

public class Borrowmark implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer m_id;// 借款人id
	private String borrowtitle;// 借款标题
	private Integer lp_id;// 借款用途
	private Double borrowmoney;// 借款金额
	private String borrowexplain;// 借款说明
	private Integer borrowterm;// 借款期限
	private Integer rm_id;// 还款方式id
	private Double loanfees;// 借款手续费
	private Double annualrate;// 年利率
	private Integer activetime;// 有效时间
	private Date loanapplicationtime;// 借款申请时间
	private Integer status;// 借款标状态(1.提交 2.审批通过 3审批不通过 4.已有投资 5.已放款 6.已结束)

	// 不对应数据库
	private String lp_str;// 借款用途
	private String rm_Str;// 还款方式

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getM_id() {
		return m_id;
	}

	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}


	public Double getBorrowmoney() {
		return borrowmoney;
	}

	public void setBorrowmoney(Double borrowmoney) {
		this.borrowmoney = borrowmoney;
	}

	public String getBorrowtitle() {
		return borrowtitle;
	}

	public void setBorrowtitle(String borrowtitle) {
		this.borrowtitle = borrowtitle;
	}

	public Integer getLp_id() {
		return lp_id;
	}

	public void setLp_id(Integer lp_id) {
		this.lp_id = lp_id;
	}

	public String getBorrowexplain() {
		return borrowexplain;
	}

	public void setBorrowexplain(String borrowexplain) {
		this.borrowexplain = borrowexplain;
	}

	public Integer getBorrowterm() {
		return borrowterm;
	}

	public void setBorrowterm(Integer borrowterm) {
		this.borrowterm = borrowterm;
	}

	public Integer getRm_id() {
		return rm_id;
	}

	public void setRm_id(Integer rm_id) {
		this.rm_id = rm_id;
	}

	public Double getLoanfees() {
		return loanfees;
	}

	public void setLoanfees(Double loanfees) {
		this.loanfees = loanfees;
	}

	public Double getAnnualrate() {
		return annualrate;
	}

	public void setAnnualrate(Double annualrate) {
		this.annualrate = annualrate;
	}

	public Integer getActivetime() {
		return activetime;
	}

	public void setActivetime(Integer activetime) {
		this.activetime = activetime;
	}

	public Date getLoanapplicationtime() {
		return loanapplicationtime;
	}

	public void setLoanapplicationtime(Date loanapplicationtime) {
		this.loanapplicationtime = loanapplicationtime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLp_str() {
		return lp_str;
	}

	public void setLp_str(String lp_str) {
		this.lp_str = lp_str;
	}

	public String getRm_Str() {
		return rm_Str;
	}

	public void setRm_Str(String rm_Str) {
		this.rm_Str = rm_Str;
	}

}