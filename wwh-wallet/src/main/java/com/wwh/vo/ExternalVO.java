package com.wwh.vo;

public class ExternalVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 序列
	 */
	private static final long serialVersionUID = 2047298381657994920L;

	/**
	 * 会员ID
	 */
	private String memberId;

	/**
	 * 商家ID
	 */
	private String sellderId;

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
	 * 推广人ID
	 */
	private String referenceId;

	/**
	 * 交易订单编号
	 */
	private String orderNumber;

	/**
	 * 使用积分
	 */
	private String uasgeScore;

	/**
	 * 实际付款金额
	 */
	private String realPayableAmount;

	/**
	 * 
	 */
	private String profitAmount;

	/**
	 * 订单状态
	 */
	private String orderStatus;

	/**
	 * 订单交易时间
	 */
	private String saleTime;

	/**
	 * 返还积分
	 */
	private String returnScore;

	/**
	 * 订单消费金额
	 */
	private String orderAmount;

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

	/**
	 * 头像url
	 */
	private String imgUrl;
	
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getSellderId() {
		return sellderId;
	}

	public void setSellderId(String sellderId) {
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

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getUasgeScore() {
		return uasgeScore;
	}

	public void setUasgeScore(String uasgeScore) {
		this.uasgeScore = uasgeScore;
	}

	public String getRealPayableAmount() {
		return realPayableAmount;
	}

	public void setRealPayableAmount(String realPayableAmount) {
		this.realPayableAmount = realPayableAmount;
	}

	public String getProfitAmount() {
		return profitAmount;
	}

	public void setProfitAmount(String profitAmount) {
		this.profitAmount = profitAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(String saleTime) {
		this.saleTime = saleTime;
	}

	public String getReturnScore() {
		return returnScore;
	}

	public void setReturnScore(String returnScore) {
		this.returnScore = returnScore;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
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
	
	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String toString() {
		return "memberId:" + memberId + " sellderId:" + sellderId + " referenceId:" + referenceId + " orderNumber:" + orderNumber + " uasgeScore:" + uasgeScore
				+ " realPayableAmount:" + realPayableAmount + " profitAmount:" + profitAmount + " orderStatus:" + orderStatus + " saleTime:" + saleTime
				+ " returnScore:" + returnScore + " orderAmount:" + orderAmount + " mobilePhone:" + mobilePhone + " email:" + email + " realName:" + realName;
	}
}
