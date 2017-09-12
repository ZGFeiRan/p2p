package cn.p2p.pojo;

/**
 * 银行信息
 * 
 * @author 117
 */

public class Bankinformation implements java.io.Serializable {

	private Integer id;
	private String bankcode;// 银行编号
	private String bankname;// 银行名称
	private String notes;// 备注

	public Bankinformation() {
	}

	public Bankinformation(String bankcode, String bankname, String notes) {
		this.bankcode = bankcode;
		this.bankname = bankname;
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Bankinformation [id=" + id + ", bankcode=" + bankcode + ", bankname=" + bankname + ", notes=" + notes
				+ "]";
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBankcode() {
		return this.bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getBankname() {
		return this.bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}