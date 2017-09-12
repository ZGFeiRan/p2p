package cn.p2p.pojo;

/**
 * 借款用途
 */

public class Loanpurpose implements java.io.Serializable {

	private Integer id;
	private String loanpurpose;// 借款用途
	private String notes;// 备注

	public Loanpurpose() {
	}

	public Loanpurpose(String loanpurpose, String notes) {
		this.loanpurpose = loanpurpose;
		this.notes = notes;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoanpurpose() {
		return this.loanpurpose;
	}

	public void setLoanpurpose(String loanpurpose) {
		this.loanpurpose = loanpurpose;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}