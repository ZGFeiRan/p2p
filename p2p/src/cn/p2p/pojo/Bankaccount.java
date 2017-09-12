package cn.p2p.pojo;

/**
 * 银行账户
 */

public class Bankaccount implements java.io.Serializable {


	private Integer id;
	private Integer m_id;// 会员id
	private String bankcode;// 银行编号
	private String bankaccount;// 银行账户
	private String accountholder;// 开户人

	// 不对应数据库
	private String bankname;// 银行名称

	// Constructors

	/** default constructor */
	public Bankaccount() {
	}

	public Bankaccount(Integer m_id, String bankcode, String bankaccount, String accountholder) {
		super();
		this.m_id = m_id;
		this.bankcode = bankcode;
		this.bankaccount = bankaccount;
		this.accountholder = accountholder;
	}

	@Override
	public String toString() {
		return "Bankaccount [id=" + id + ", m_id=" + m_id + ", bankcode=" + bankcode + ", bankaccount=" + bankaccount
				+ ", accountholder=" + accountholder + "]";
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

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	public String getAccountholder() {
		return accountholder;
	}

	public void setAccountholder(String accountholder) {
		this.accountholder = accountholder;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

}