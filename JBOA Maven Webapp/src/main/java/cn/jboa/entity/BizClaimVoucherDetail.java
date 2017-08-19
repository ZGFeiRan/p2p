package cn.jboa.entity;

/**
 * 报销单详情
 * 
 * @author 117
 *
 */
public class BizClaimVoucherDetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private BizClaimVoucher bizClaimVoucher;// 报销单
	private String item;// 报销项目
	private Double account;// 账单
	private String des;// 费用说明

	// Constructors

	/** default constructor */
	public BizClaimVoucherDetail() {
	}

	/** full constructor */
	public BizClaimVoucherDetail(BizClaimVoucher bizClaimVoucher, String item, Double account, String des) {
		this.bizClaimVoucher = bizClaimVoucher;
		this.item = item;
		this.account = account;
		this.des = des;
	}

	// Property accessors

	@Override
	public String toString() {
		return "BizClaimVoucherDetail报销单详情 [id=" + id + ",项目 item=" + item + ",账单 account=" + account + ",费用说明 des="
				+ des + "]";
	}

	public BizClaimVoucher getBizClaimVoucher() {
		return this.bizClaimVoucher;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBizClaimVoucher(BizClaimVoucher bizClaimVoucher) {
		this.bizClaimVoucher = bizClaimVoucher;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getAccount() {
		return this.account;
	}

	public void setAccount(Double account) {
		this.account = account;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}