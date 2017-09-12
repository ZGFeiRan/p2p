package cn.p2p.pojo;

import java.util.Date;

/**
 * 借款标的详情
 */

public class BorrowmarkDetails implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer total_period;// 还款总期数
	private Integer rest_period;// 剩余期数
	private Date next_payment_day;// 下次还款日期
	private Date approve_date;// 审核时间
	private Date liubiao_date;// 流标时间
	private Date lending_date;// 放款时间
	private Date clear_date;// 结清时间
	private Date value_date;// 起息日期
	private Date finish_date;// 结束日期
	private Integer borrow_id;// 借款标ID

	// Constructors

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTotal_period() {
		return total_period;
	}

	public void setTotal_period(Integer total_period) {
		this.total_period = total_period;
	}

	public Integer getRest_period() {
		return rest_period;
	}

	public void setRest_period(Integer rest_period) {
		this.rest_period = rest_period;
	}

	public Date getNext_payment_day() {
		return next_payment_day;
	}

	public void setNext_payment_day(Date next_payment_day) {
		this.next_payment_day = next_payment_day;
	}

	public Date getApprove_date() {
		return approve_date;
	}

	public void setApprove_date(Date approve_date) {
		this.approve_date = approve_date;
	}

	public Date getLending_date() {
		return lending_date;
	}

	public void setLending_date(Date lending_date) {
		this.lending_date = lending_date;
	}

	public Date getClear_date() {
		return clear_date;
	}

	public void setClear_date(Date clear_date) {
		this.clear_date = clear_date;
	}

	public Date getValue_date() {
		return value_date;
	}

	public void setValue_date(Date value_date) {
		this.value_date = value_date;
	}

	public Date getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}

	public Integer getBorrow_id() {
		return borrow_id;
	}

	public void setBorrow_id(Integer borrow_id) {
		this.borrow_id = borrow_id;
	}

	public Date getLiubiao_date() {
		return liubiao_date;
	}

	public void setLiubiao_date(Date liubiao_date) {
		this.liubiao_date = liubiao_date;
	}

}