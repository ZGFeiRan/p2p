package cn.jboa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门
 * 
 * @author 117
 *
 */

public class SysDepartment implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set sysEmployees = new HashSet(0);// 员工

	// Constructors

	/** default constructor */
	public SysDepartment() {
	}

	/** full constructor */
	public SysDepartment(String name, Set sysEmployees) {
		this.name = name;
		this.sysEmployees = sysEmployees;
	}

	// Property accessors

	@Override
	public String toString() {
		return "SysDepartment部门 [id=" + id + ", name=" + name + "]";
	}

	public String getName() {
		return this.name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getSysEmployees() {
		return this.sysEmployees;
	}

	public void setSysEmployees(Set sysEmployees) {
		this.sysEmployees = sysEmployees;
	}

}