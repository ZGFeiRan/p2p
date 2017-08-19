package cn.jboa.entity;

/**
 * 数据字典
 * 
 * @author 117
 *
 */

public class DataDictionary implements java.io.Serializable {

	// Fields

	private Integer id;
	private String typecode;// 类型编码
	private String typename;// 类型名称
	private Integer valueid;// id
	private String valuename;// 名称

	// Constructors

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Integer getValueid() {
		return valueid;
	}

	public void setValueid(Integer valueid) {
		this.valueid = valueid;
	}

	public String getValuename() {
		return valuename;
	}

	public void setValuename(String valuename) {
		this.valuename = valuename;
	}

}