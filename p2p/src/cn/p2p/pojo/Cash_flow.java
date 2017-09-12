package cn.p2p.pojo;

import java.util.Date;

/**
 * 会员资金流水记录
 * 
 */

public class Cash_flow implements java.io.Serializable {

	// Fields

	private Integer id;
	private String financial_tran_type;// 资金交易类型
	private Integer m_id;// 会员ID
	private Double income;// 收入
	private Double outlay;// 支出
	private Double user_fund_account_amount;// 当前资金
	private String remarks;// 备注
	private Date createtime;// 创建时间

	public Cash_flow() {
	}

	public Cash_flow(String financial_tran_type, Integer m_id, Double income, Double outlay,
			Double user_fund_account_amount, String remarks, Date createtime) {
		super();
		this.financial_tran_type = financial_tran_type;
		this.m_id = m_id;
		this.income = income;
		this.outlay = outlay;
		this.user_fund_account_amount = user_fund_account_amount;
		this.remarks = remarks;
		this.createtime = createtime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFinancial_tran_type() {
		return financial_tran_type;
	}

	public void setFinancial_tran_type(String financial_tran_type) {
		this.financial_tran_type = financial_tran_type;
	}

	public Integer getM_id() {
		return m_id;
	}

	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Double getOutlay() {
		return outlay;
	}

	public void setOutlay(Double outlay) {
		this.outlay = outlay;
	}

	public Double getUser_fund_account_amount() {
		return user_fund_account_amount;
	}

	public void setUser_fund_account_amount(Double user_fund_account_amount) {
		this.user_fund_account_amount = user_fund_account_amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}