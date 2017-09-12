package cn.p2p.pojo;

/**
 * 角色
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer id;
	private String rolename;// 角色名称
	private String notes;// 备注

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String rolename, String notes) {
		this.rolename = rolename;
		this.notes = notes;
	}

	// Property accessors

	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + ", notes=" + notes + "]";
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}