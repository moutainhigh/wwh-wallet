package com.wwh.vo;

import java.math.BigDecimal;
import java.util.Date;

public class OrderVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 序列
	 */
	private static final long serialVersionUID = -30424081717059965L;

	/**
	 * 会员ID
	 */
	private Long memberId;

	/**
	 * 商家ID
	 */
	private Long sellderId;

	/**
	 * 商家名称
	 */
	private String sellderName;

	/**
	 * 商家来源
	 */
	private String sellderRegisterType;

	/**
	 * 招商商家配置类型
	 */
	private String sellderConfigType;

	/**
	 * 商家推广人ID
	 */
	private Long referenceId;

	/**
	 * 交易订单编号
	 */
	private String orderNumber;

	/**
	 * 使用积分
	 */
	private BigDecimal uasgeScore = new BigDecimal(0);

	/**
	 * 实际付款金额
	 */
	private BigDecimal realPayableAmount = new BigDecimal(0);

	/**
	 * 用户分润金额
	 */
	private BigDecimal profitAmount = new BigDecimal(0);

	/**
	 * 招商分红金额
	 */
	private BigDecimal businessAmount = new BigDecimal(0);

	/**
	 * 订单状态
	 */
	private String orderStatus;

	/**
	 * 订单交易时间
	 */
	private Date saleTime;

	/**
	 * 返还积分
	 */
	private BigDecimal returnScore = new BigDecimal(0);

	/**
	 * 订单消费金额
	 */
	private BigDecimal orderAmount = new BigDecimal(0);

	/**
	 * 手机号
	 */
	private String mobilePhone;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 真实姓名
	 */
	private String realName;
	
	/**
	 * 性别（0，未录入、1，女、2，男，默认0）
	 */
	private Integer gender;

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getSellderId() {
		return sellderId;
	}

	public void setSellderId(Long sellderId) {
		this.sellderId = sellderId;
	}

	public String getSellderName() {
		return sellderName;
	}

	public void setSellderName(String sellderName) {
		this.sellderName = sellderName;
	}

	public String getSellderRegisterType() {
		return sellderRegisterType;
	}

	public void setSellderRegisterType(String sellderRegisterType) {
		this.sellderRegisterType = sellderRegisterType;
	}

	public String getSellderConfigType() {
		return sellderConfigType;
	}

	public void setSellderConfigType(String sellderConfigType) {
		this.sellderConfigType = sellderConfigType;
	}

	public Long getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public BigDecimal getUasgeScore() {
		return uasgeScore;
	}

	public void setUasgeScore(BigDecimal uasgeScore) {
		this.uasgeScore = uasgeScore;
	}

	public BigDecimal getRealPayableAmount() {
		return realPayableAmount;
	}

	public void setRealPayableAmount(BigDecimal realPayableAmount) {
		this.realPayableAmount = realPayableAmount;
	}

	public BigDecimal getProfitAmount() {
		return profitAmount;
	}

	public void setProfitAmount(BigDecimal profitAmount) {
		this.profitAmount = profitAmount;
	}

	public BigDecimal getBusinessAmount() {
		return businessAmount;
	}

	public void setBusinessAmount(BigDecimal businessAmount) {
		this.businessAmount = businessAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}

	public BigDecimal getReturnScore() {
		return returnScore;
	}

	public void setReturnScore(BigDecimal returnScore) {
		this.returnScore = returnScore;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
}
