package cn.p2p.pojo;

/**
 * 基本资料
 */

public class Basicinformation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer m_id;// 会员id
	private Integer age;// 年龄
	private Integer sex;// 性别
	private String birthdate;// 出生日期
	private String qq;
	private String contactaddress;// 联系地址
	private String education;// 学历
	private String graduationschool;// 毕业学校
	private Integer maritalstatus;// 婚姻状况
	private Integer whetherChild;// 是否有孩子
	private Integer whetherSocialsecurity;// 是否有社保
	private Double monthlysalary;// 月薪
	private String personalprofile;// 个人简介

	// Constructors

	/** default constructor */
	public Basicinformation() {
	}

	public Basicinformation(Integer m_id, Integer age, Integer sex, String birthdate, String qq, String contactaddress,
			String education, String graduationschool, Integer maritalstatus, Integer whetherChild,
			Integer whetherSocialsecurity, Double monthlysalary, String personalprofile) {
		super();
		this.m_id = m_id;
		this.age = age;
		this.sex = sex;
		this.birthdate = birthdate;
		this.qq = qq;
		this.contactaddress = contactaddress;
		this.education = education;
		this.graduationschool = graduationschool;
		this.maritalstatus = maritalstatus;
		this.whetherChild = whetherChild;
		this.whetherSocialsecurity = whetherSocialsecurity;
		this.monthlysalary = monthlysalary;
		this.personalprofile = personalprofile;
	}

	@Override
	public String toString() {
		return "Basicinformation [id=" + id + ", m_id=" + m_id + ", age=" + age + ", sex=" + sex + ", birthdate="
				+ birthdate + ", qq=" + qq + ", contactaddress=" + contactaddress + ", education=" + education
				+ ", graduationschool=" + graduationschool + ", maritalstatus=" + maritalstatus + ", whetherChild="
				+ whetherChild + ", whetherSocialsecurity=" + whetherSocialsecurity + ", monthlysalary=" + monthlysalary
				+ ", personalprofile=" + personalprofile + "]";
	}

}