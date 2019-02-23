package com.wwh.vo;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserVO extends BaseVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7676831620812040247L;

	/**
	 * 会员ID
	 */
	private Long memberId;

	/**
	 * 用户密码
	 */
	private String password;

	/**
	 * 用户招商ID
	 */
	private Long businessUserId;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 手机号码
	 */
	private String mobilePhone;

	/**
	 * 会员头像url
	 */
	private String picUrl = "default";

	/**
	 * 性别（0，未录入、1，女、2，男，默认0）
	 */
	private Integer gender;

	/**
	 * 生日
	 */
	private Date birthday;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 身份证件类型（0、身份证，1、护照，默认0）
	 */
	private Integer idCardType;

	/**
	 * 身份证件号码
	 */
	private String idCardNo;

	/**
	 * 身份证件照片1（一般实名认证时使用）
	 */
	private String idCardPic1;

	/**
	 * 身份证件照片2（一般实名认证时使用）
	 */
	private String idCardPic2;

	/**
	 * 身份证件照片3（一般实名认证时使用）
	 */
	private String idCardPic3;

	/**
	 * 是否已经实名认证（1、已实名认证，0、未实名认证，默认0）
	 */
	private Integer isIdValid;

	/**
	 * 是否已经手机号认证（1、已认证手机号，0、未认证手机号，默认0）
	 */
	private Integer isMobileValid;

	/**
	 * 是否已经邮箱认证（1、已认证邮箱，0、未认证邮箱，默认0）
	 */
	private Integer isEmailValid;

	/**
	 * 会员级别id（对应t_member_level表主键）
	 */
	private Integer memberLevelId;

	/**
	 * 会员积分（随会员行为，如购物等可一直增长，一般用于决定会员级别，默认0）
	 */
	private Integer memberPoint;

	/**
	 * 推荐人类型（0，自己注册无推荐人、1，平台人员、2，商家人员、3，会员，默认0）
	 */
	private Integer referenceType;

	/**
	 * 推荐人id（根据推荐人类型不同，对应不同的表记录）
	 */
	private Long referenceId;
	/**
	 * 推荐人的手机号
	 */
	private String referencePhone;
	/**
	 * 推荐人的用户名
	 */
	private String referenceName;
	/**
	 * 是否在黑名单（0，不在黑名单，1、在黑名单，默认0）
	 */
	private Integer isBlacklist;

	/**
	 * 最近登陆时间
	 */
	private Date lastLoginTime;

	/**
	 * 登录失败时间
	 */
	private Date lastLoginFailTime;

	/**
	 * 登录失败次数（3次）
	 */
	private Integer lastLoginFailCount;

	/**
	 * 登录锁定状态(1：表示锁定、0：表示解锁)
	 */
	private Integer loginLockStatus;

	/**
	 * 操作人类型（0、系统自动操作，1、平台人员操作，2、商家人员操作，3、会员操作）
	 */
	private Integer operatorType;

	/**
	 * 操作人id（根据操作人类型会对应不同的表记录）
	 */
	private Integer operatorId;

	/**
	 * 分销商id
	 */
	private Integer distributorId;

	/**
	 * 实名认证审核状态，0：未审核；1、已审核，2、审核不通过，默认0
	 */
	private Integer idCardCensorStatus;

	/**
	 * 实名认证审核时间
	 */
	private Date idCardCensorTime;

	/**
	 * 实名认证审核备注
	 */
	private String idCardCensorMemo;

	/**
	 * 审核操作人id
	 */
	private Integer idCardCensorOperatorId;

	/**
	 * 审核操作人类型（0、系统自动操作，1、平台人员操作，2、商家人员操作，3、会员操作）
	 */
	private Integer idCardCensorOperatorType;

	/**
	 * 地址
	 */
	private String address;
	/**
	 * 国家编号
	 */
	private String countryCode;
	/**
	 * 省份编号
	 */
	private String provinceCode;
	/**
	 * 城市编号
	 */
	private String cityCode;
	/**
	 * 地区编号
	 */
	private String areaCode;
	/**
	 * 国家名称
	 */
	private String countryName;
	/**
	 * 省名称
	 */
	private String provinceName;
	/**
	 * 城市名称
	 */
	private String cityName;
	/**
	 * 地区名称
	 */
	private String areaName;
	private String memberName;
	private String userName;

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	private List<RoleVO> roleList;

	public List<RoleVO> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleVO> roleList) {
		this.roleList = roleList;
	}

	@Transient
	public Set<String> getRolesName() {
		List<RoleVO> roles = getRoleList();
		Set<String> set = new HashSet<String>();
		for (RoleVO role : roles) {
			set.add(role.getRoleName());
		}
		return set;
	}

	@Transient
	public long[] getRolesId() {
		List<RoleVO> roles = getRoleList();
		long[] roleId = new long[roles.size()];
		for (int i = 0; i < roles.size(); i++) {
			roleId[i] = Long.parseLong(roles.get(i).getRoleID());
		}
		return roleId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getBusinessUserId() {
		return businessUserId;
	}

	public void setBusinessUserId(Long businessUserId) {
		this.businessUserId = businessUserId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(Integer idCardType) {
		this.idCardType = idCardType;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getIdCardPic1() {
		return idCardPic1;
	}

	public void setIdCardPic1(String idCardPic1) {
		this.idCardPic1 = idCardPic1;
	}

	public String getIdCardPic2() {
		return idCardPic2;
	}

	public void setIdCardPic2(String idCardPic2) {
		this.idCardPic2 = idCardPic2;
	}

	public String getIdCardPic3() {
		return idCardPic3;
	}

	public void setIdCardPic3(String idCardPic3) {
		this.idCardPic3 = idCardPic3;
	}

	public Integer getIsIdValid() {
		return isIdValid;
	}

	public void setIsIdValid(Integer isIdValid) {
		this.isIdValid = isIdValid;
	}

	public Integer getIsMobileValid() {
		return isMobileValid;
	}

	public void setIsMobileValid(Integer isMobileValid) {
		this.isMobileValid = isMobileValid;
	}

	public Integer getIsEmailValid() {
		return isEmailValid;
	}

	public void setIsEmailValid(Integer isEmailValid) {
		this.isEmailValid = isEmailValid;
	}

	public Integer getMemberLevelId() {
		return memberLevelId;
	}

	public void setMemberLevelId(Integer memberLevelId) {
		this.memberLevelId = memberLevelId;
	}

	public Integer getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(Integer memberPoint) {
		this.memberPoint = memberPoint;
	}

	public Integer getReferenceType() {
		return referenceType;
	}

	public void setReferenceType(Integer referenceType) {
		this.referenceType = referenceType;
	}

	public Long getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}

	public Integer getIsBlacklist() {
		return isBlacklist;
	}

	public void setIsBlacklist(Integer isBlacklist) {
		this.isBlacklist = isBlacklist;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getLastLoginFailTime() {
		return lastLoginFailTime;
	}

	public void setLastLoginFailTime(Date lastLoginFailTime) {
		this.lastLoginFailTime = lastLoginFailTime;
	}

	public Integer getLastLoginFailCount() {
		return lastLoginFailCount;
	}

	public void setLastLoginFailCount(Integer lastLoginFailCount) {
		this.lastLoginFailCount = lastLoginFailCount;
	}

	public Integer getLoginLockStatus() {
		return loginLockStatus;
	}

	public void setLoginLockStatus(Integer loginLockStatus) {
		this.loginLockStatus = loginLockStatus;
	}

	public Integer getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public Integer getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(Integer distributorId) {
		this.distributorId = distributorId;
	}

	public Integer getIdCardCensorStatus() {
		return idCardCensorStatus;
	}

	public void setIdCardCensorStatus(Integer idCardCensorStatus) {
		this.idCardCensorStatus = idCardCensorStatus;
	}

	public Date getIdCardCensorTime() {
		return idCardCensorTime;
	}

	public void setIdCardCensorTime(Date idCardCensorTime) {
		this.idCardCensorTime = idCardCensorTime;
	}

	public String getIdCardCensorMemo() {
		return idCardCensorMemo;
	}

	public void setIdCardCensorMemo(String idCardCensorMemo) {
		this.idCardCensorMemo = idCardCensorMemo;
	}

	public Integer getIdCardCensorOperatorId() {
		return idCardCensorOperatorId;
	}

	public void setIdCardCensorOperatorId(Integer idCardCensorOperatorId) {
		this.idCardCensorOperatorId = idCardCensorOperatorId;
	}

	public Integer getIdCardCensorOperatorType() {
		return idCardCensorOperatorType;
	}

	public void setIdCardCensorOperatorType(Integer idCardCensorOperatorType) {
		this.idCardCensorOperatorType = idCardCensorOperatorType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getReferencePhone() {
		return referencePhone;
	}

	public void setReferencePhone(String referencePhone) {
		this.referencePhone = referencePhone;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
