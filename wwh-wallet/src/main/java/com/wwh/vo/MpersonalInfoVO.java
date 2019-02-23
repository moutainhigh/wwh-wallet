package com.wwh.vo;

import java.util.Date;

/**
 * 手机端的个人信息页面详情
 * 
 * @author u1
 *
 */
public class MpersonalInfoVO {
	// 用户名
	private String userName;
	// 性别 （性别（0，未录入、1，女、2，男，默认0）
	private Integer gender;
	// 生日
	private Date birthday;
	// 手机号
	private String phone;
	// 邮箱
	private String email;
	// 我的地址
	private String address;
	// 是否实名认证
	private Integer isIdValid;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getIsIdValid() {
		return isIdValid;
	}

	public void setIsIdValid(Integer isIdValid) {
		this.isIdValid = isIdValid;
	}
}
