package cn.p2p.pojo;

import java.util.Date;

/**
 * /**
 * 
 * 投标记录
 */
public class Tender_record implements java.io.Serializable {
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 标的ID
	 */
	private Integer borrow_id;
	/**
	 * 投资人用户id
	 */
	private Integer m_id;
	/**
	 * 投标金额
	 */
	private double tender_amount;
	/**
	 * 投标时间
	 */
	private java.util.Date tender_date;
	/**
	 * 是否放款,(Y,已放,N.未放)
	 */
	private String is_fangkuan;

	private String realname;

	public Tender_record() {
	}

	public Tender_record(Integer borrow_id, Integer m_id, double tender_amount, Date tender_date, String is_fangkuan) {
		super();
		this.borrow_id = borrow_id;
		this.m_id = m_id;
		this.tender_amount = tender_amount;
		this.tender_date = tender_date;
		this.is_fangkuan = is_fangkuan;
	}

	@Override
	public String toString() {
		return "Tender_record [id=" + id + ", borrow_id=" + borrow_id + ", m_id=" + m_id + ", tender_amount="
				+ tender_amount + ", tender_date=" + tender_date + ", is_fangkuan=" + is_fangkuan + ", realname="
				+ realname + "]";
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

	public Integer getM_id() {
		return m_id;
	}

	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}

	public double getTender_amount() {
		return tender_amount;
	}

	public void setTender_amount(double tender_amount) {
		this.tender_amount = tender_amount;
	}

	public java.util.Date getTender_date() {
		return tender_date;
	}

	public void setTender_date(java.util.Date tender_date) {
		this.tender_date = tender_date;
	}

	public String getIs_fangkuan() {
		return is_fangkuan;
	}

	public void setIs_fangkuan(String is_fangkuan) {
		this.is_fangkuan = is_fangkuan;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

}
