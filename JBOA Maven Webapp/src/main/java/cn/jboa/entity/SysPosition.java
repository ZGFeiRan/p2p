package cn.jboa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 职位
 * 
 * @author 117
 *
 */

public class SysPosition implements java.io.Serializable {

	// Fields

	private Integer id;
	private String nameCn;
	private String nameEn;
	private Set sysEmployees = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysPosition() {
	}

	/** full constructor */
	public SysPosition(String nameCn, String nameEn, Set sysEmployees) {
		this.nameCn = nameCn;
		this.nameEn = nameEn;
		this.sysEmployees = sysEmployees;
	}

	// Property accessors

	@Override
	public String toString() {
		return "SysPosition职位 [id=" + id + ", nameCn=" + nameCn + ", nameEn=" + nameEn + "]";
	}

	public String getNameCn() {
		return this.nameCn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public Set getSysEmployees() {
		return this.sysEmployees;
	}

	public void setSysEmployees(Set sysEmployees) {
		this.sysEmployees = sysEmployees;
	}

}