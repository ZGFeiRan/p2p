package cn.p2p.pojo;

import java.util.Date;

/**
 * 还款记录
 */

public class Repayment_record implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer borrow_id;// 标的ID
	private Integer payer_user_id;// 付款用户
	private Integer payee_user_id;// 收款用户
	private Integer period_id;// 期号
	private Double amount;// 金额
	private Double bj;// 本金
	private Double lx;// 利息
	private Date should_return_date;// 应还日期
	private String status;// 状态,WH:未还;YH:已还;
	private Date actual_return_date;// 实际还款时间

	// Constructors

	/** default constructor */
	public Repayment_record() {
	}

	public Repayment_record(Integer borrow_id, Integer payer_user_id, Integer payee_user_id, Integer period_id,
			Double amount, Double bj, Double lx, Date should_return_date, String status) {
		super();
		this.borrow_id = borrow_id;
		this.payer_user_id = payer_user_id;
		this.payee_user_id = payee_user_id;
		this.period_id = period_id;
		this.amount = amount;
		this.bj = bj;
		this.lx = lx;
		this.should_return_date = should_return_date;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Repayment_record [id=" + id + ", borrow_id=" + borrow_id + ", payer_user_id=" + payer_user_id
				+ ", payee_user_id=" + payee_user_id + ", period_id=" + period_id + ", amount=" + amount + ", bj=" + bj
				+ ", lx=" + lx + ", should_return_date=" + should_return_date + ", status=" + status
				+ ", actual_return_date=" + actual_return_date + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBorrow_id() {
		return borrow_id;
	}

	public void setBorrow_id(Integer borrow_id) {
		this.borrow_id = borrow_id;
	}

	public Integer getPayer_user_id() {
		return payer_user_id;
	}

	public void setPayer_user_id(Integer payer_user_id) {
		this.payer_user_id = payer_user_id;
	}

	public Integer getPayee_user_id() {
		return payee_user_id;
	}

	public void setPayee_user_id(Integer payee_user_id) {
		this.payee_user_id = payee_user_id;
	}

	public Integer getPeriod_id() {
		return period_id;
	}

	public void setPeriod_id(Integer period_id) {
		this.period_id = period_id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getBj() {
		return bj;
	}

	public void setBj(Double bj) {
		this.bj = bj;
	}

	public Double getLx() {
		return lx;
	}

	public void setLx(Double lx) {
		this.lx = lx;
	}

	public Date getShould_return_date() {
		return should_return_date;
	}

	public void setShould_return_date(Date should_return_date) {
		this.should_return_date = should_return_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getActual_return_date() {
		return actual_return_date;
	}

	public void setActual_return_date(Date actual_return_date) {
		this.actual_return_date = actual_return_date;
	}

}