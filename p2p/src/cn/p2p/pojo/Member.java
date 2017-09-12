package cn.p2p.pojo;

import java.util.Date;

/**
 * 会员
 */

public class Member implements java.io.Serializable {

	private Integer id;
	private String username;// 用户名
	private String password;// 密码
	private String paymentpassword;// 支付密码
	private String phone;// 手机号码
	private String email;
	private Date registrationtime;// 注册时间
	private Integer r_id;// 权限id

	// Constructors

	/** default constructor */
	public Member() {
	}

	public Member(String username, String password, String paymentpassword, String phone, String email,
			Date registrationtime, Integer r_id) {
		super();
		this.username = username;
		this.password = password;
		this.paymentpassword = paymentpassword;
		this.phone = phone;
		this.email = email;
		this.registrationtime = registrationtime;
		this.r_id = r_id;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", password=" + password + ", paymentpassword="
				+ paymentpassword + ", phone=" + phone + ", email=" + email + ", registrationtime=" + registrationtime
				+ ", r_id=" + r_id + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPaymentpassword() {
		return paymentpassword;
	}

	public void setPaymentpassword(String paymentpassword) {
		this.paymentpassword = paymentpassword;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistrationtime() {
		return registrationtime;
	}

	public void setRegistrationtime(Date registrationtime) {
		this.registrationtime = registrationtime;
	}

	public Integer getR_id() {
		return r_id;
	}

	public void setR_id(Integer r_id) {
		this.r_id = r_id;
	}

}