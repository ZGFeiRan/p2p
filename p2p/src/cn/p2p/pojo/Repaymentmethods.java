package cn.p2p.pojo;

/**
 * 还款方式
 */

public class Repaymentmethods implements java.io.Serializable {

	// Fields

	private Integer id;
	private String repaymentmethods;// 还款方式
	private String identifiers;// 标识符
	private String algorithminformation;// 算法信息

	// Constructors

	/** default constructor */
	public Repaymentmethods() {
	}

	/** full constructor */
	public Repaymentmethods(String repaymentmethods, String identifiers, String algorithminformation) {
		this.repaymentmethods = repaymentmethods;
		this.identifiers = identifiers;
		this.algorithminformation = algorithminformation;
	}

	// Property accessors

	@Override
	public String toString() {
		return "Repaymentmethods [id=" + id + ", repaymentmethods=" + repaymentmethods + ", identifiers=" + identifiers
				+ ", algorithminformation=" + algorithminformation + "]";
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRepaymentmethods() {
		return this.repaymentmethods;
	}

	public void setRepaymentmethods(String repaymentmethods) {
		this.repaymentmethods = repaymentmethods;
	}

	public String getIdentifiers() {
		return this.identifiers;
	}

	public void setIdentifiers(String identifiers) {
		this.identifiers = identifiers;
	}

	public String getAlgorithminformation() {
		return this.algorithminformation;
	}

	public void setAlgorithminformation(String algorithminformation) {
		this.algorithminformation = algorithminformation;
	}

}