package cn.jboa.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 报销单
 * 
 * @author 117
 *
 */

public class BizClaimVoucher implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysEmployee sysEmployeeByNextDealSn;// 下一个处理的人
	private SysEmployee sysEmployeeByCreateSn;// 创建的员工
	private Date createTime;// 创建时间
	private Date modifyTime;// 修改时间
	private String event;// 事件
	private Double totalAccount;// 总帐单
	private String status;// 状态
	private Set bizClaimVoucherDetails = new HashSet(0);// 报销单的明细
	private Set bizCheckResults = new HashSet(0);// 报销单的审核结果

	// Constructors

	/** default constructor */
	public BizClaimVoucher() {
	}

	/** full constructor */
	public BizClaimVoucher(SysEmployee sysEmployeeByNextDealSn, SysEmployee sysEmployeeByCreateSn, Timestamp createTime,
			Timestamp modifyTime, String event, Double totalAccount, String status, Set bizClaimVoucherDetails,
			Set bizCheckResults) {
		this.sysEmployeeByNextDealSn = sysEmployeeByNextDealSn;
		this.sysEmployeeByCreateSn = sysEmployeeByCreateSn;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.event = event;
		this.totalAccount = totalAccount;
		this.status = status;
		this.bizClaimVoucherDetails = bizClaimVoucherDetails;
		this.bizCheckResults = bizCheckResults;
	}

	// Property accessors

	@Override
	public String toString() {
		return "BizClaimVoucher报销单 [id=" + id + ", createTime=" + createTime + ", modifyTime=" + modifyTime + ",事件 event="
				+ event + ", totalAccount=" + totalAccount + ", status=" + status + "]";
	}

	public SysEmployee getSysEmployeeByNextDealSn() {
		return this.sysEmployeeByNextDealSn;
	}

	public void setSysEmployeeByNextDealSn(SysEmployee sysEmployeeByNextDealSn) {
		this.sysEmployeeByNextDealSn = sysEmployeeByNextDealSn;
	}

	public SysEmployee getSysEmployeeByCreateSn() {
		return this.sysEmployeeByCreateSn;
	}

	public void setSysEmployeeByCreateSn(SysEmployee sysEmployeeByCreateSn) {
		this.sysEmployeeByCreateSn = sysEmployeeByCreateSn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Double getTotalAccount() {
		return this.totalAccount;
	}

	public void setTotalAccount(Double totalAccount) {
		this.totalAccount = totalAccount;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getBizClaimVoucherDetails() {
		return this.bizClaimVoucherDetails;
	}

	public void setBizClaimVoucherDetails(Set bizClaimVoucherDetails) {
		this.bizClaimVoucherDetails = bizClaimVoucherDetails;
	}

	public Set getBizCheckResults() {
		return this.bizCheckResults;
	}

	public void setBizCheckResults(Set bizCheckResults) {
		this.bizCheckResults = bizCheckResults;
	}

}