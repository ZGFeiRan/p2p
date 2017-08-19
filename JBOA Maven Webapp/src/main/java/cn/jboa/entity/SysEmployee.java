package cn.jboa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 员工
 * 
 * @author 117
 *
 */

public class SysEmployee implements java.io.Serializable {

	// Fields

	private String sn;// 编号
	private SysPosition sysPosition;// 职位
	private SysDepartment sysDepartment;// 部门
	private String name;// 名字
	private String password;// 密码
	private String status;// 状态
	private Set bizClaimVouchersForNextDealSn = new HashSet(0);// 要审核的报销单
	private Set bizClaimVouchersForCreateSn = new HashSet(0);// 创建的报销单

	// Constructors

	/** default constructor */
	public SysEmployee() {
	}

	/** full constructor */
	public SysEmployee(SysPosition sysPosition, SysDepartment sysDepartment, String name, String password,
			String status, Set bizClaimVouchersForNextDealSn, Set bizClaimVouchersForCreateSn) {
		this.sysPosition = sysPosition;
		this.sysDepartment = sysDepartment;
		this.name = name;
		this.password = password;
		this.status = status;
		this.bizClaimVouchersForNextDealSn = bizClaimVouchersForNextDealSn;
		this.bizClaimVouchersForCreateSn = bizClaimVouchersForCreateSn;
	}

	// Property accessors

	public String getSn() {
		return this.sn;
	}

	@Override
	public String toString() {
		return "SysEmployee 员工[sn=" + sn + ", name=" + name + ", password=" + password + ", status=" + status + "]";
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public SysPosition getSysPosition() {
		return this.sysPosition;
	}

	public void setSysPosition(SysPosition sysPosition) {
		this.sysPosition = sysPosition;
	}

	public SysDepartment getSysDepartment() {
		return this.sysDepartment;
	}

	public void setSysDepartment(SysDepartment sysDepartment) {
		this.sysDepartment = sysDepartment;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getBizClaimVouchersForNextDealSn() {
		return this.bizClaimVouchersForNextDealSn;
	}

	public void setBizClaimVouchersForNextDealSn(Set bizClaimVouchersForNextDealSn) {
		this.bizClaimVouchersForNextDealSn = bizClaimVouchersForNextDealSn;
	}

	public Set getBizClaimVouchersForCreateSn() {
		return this.bizClaimVouchersForCreateSn;
	}

	public void setBizClaimVouchersForCreateSn(Set bizClaimVouchersForCreateSn) {
		this.bizClaimVouchersForCreateSn = bizClaimVouchersForCreateSn;
	}

}