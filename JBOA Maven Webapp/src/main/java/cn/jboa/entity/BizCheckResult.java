package cn.jboa.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 审核结果
 * 
 * @author 117
 *
 */

public class BizCheckResult implements java.io.Serializable {

	// Fields

	private Integer id;
	private BizClaimVoucher bizClaimVoucher;// 报销单
	private Date checkTime;// 审核时间
	private String checkerSn;// 审核人
	private String result;// 审核结果
	private String comm;// 审批意见

	// Constructors

	@Override
	public String toString() {
		return "BizCheckResult审核结果 [id=" + id + ", checkTime=" + checkTime + ", checkerSn=" + checkerSn + ", result="
				+ result + ",审批意见 comm=" + comm + "]";
	}

	/** default constructor */
	public BizCheckResult() {
	}

	/** full constructor */
	public BizCheckResult(BizClaimVoucher bizClaimVoucher, Timestamp checkTime, String checkerSn, String result,
			String comm) {
		this.bizClaimVoucher = bizClaimVoucher;
		this.checkTime = checkTime;
		this.checkerSn = checkerSn;
		this.result = result;
		this.comm = comm;
	}

	// Property accessors

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

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckerSn() {
		return this.checkerSn;
	}

	public void setCheckerSn(String checkerSn) {
		this.checkerSn = checkerSn;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getComm() {
		return this.comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

}