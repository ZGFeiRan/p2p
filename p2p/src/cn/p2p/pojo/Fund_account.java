package cn.p2p.pojo;

import java.util.Date;

/**
 * 用户资金总表
 * 
 */

public class Fund_account implements java.io.Serializable {

	private Integer id;
	private Integer m_id;// 用户ID
	private Double amount;// 金额
	private Date create_date;// 创建时间
	private Date update_date;// 修改时间

	public Fund_account() {
	}

	public Fund_account(Integer m_id, Double amount, Date create_date) {
		super();
		this.m_id = m_id;
		this.amount = amount;
		this.create_date = create_date;
	}

	public Fund_account(Integer m_id, Date update_date, Double amount) {
		super();
		this.m_id = m_id;
		this.amount = amount;
		this.update_date = update_date;
	}

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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

}