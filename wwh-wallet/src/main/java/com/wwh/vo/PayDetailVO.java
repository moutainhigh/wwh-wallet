package com.wwh.vo;

import java.math.BigDecimal;

public class PayDetailVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -2844571055840013646L;
	/**
	 * 充值人
	 */
	private Long rechargeUserId;
	
	/**
	 * 支付状态
	 */
	private String payStatus;

	/**
	 * 返回码
	 */
	private String returnCode;

	/**
	 * 充值类型类型
	 */
	private String payOrderType;

	/**
	 * 下单金额类型
	 */
	private String payAmountType;
	
	/**
	 * 唯一序列号
	 */
	private String paySeq;
	/**
	 * 支付的idCard
	 */
	private String idCard;

	/**
	 * 获得积分
	 */
	private BigDecimal score;

	/**
	 * 充值金额
	 */
	private BigDecimal amount;
	/**
	 * 是否计算
	 */
	private String isCalcuated;

	
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Long getRechargeUserId() {
		return rechargeUserId;
	}

	public void setRechargeUserId(Long rechargeUserId) {
		this.rechargeUserId = rechargeUserId;
	}


	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getPayOrderType() {
		return payOrderType;
	}

	public void setPayOrderType(String payOrderType) {
		this.payOrderType = payOrderType;
	}

	public String getPayAmountType() {
		return payAmountType;
	}

	public void setPayAmountType(String payAmountType) {
		this.payAmountType = payAmountType;
	}

	public String getPaySeq() {
		return paySeq;
	}

	public void setPaySeq(String paySeq) {
		this.paySeq = paySeq;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getIsCalcuated() {
		return isCalcuated;
	}

	public void setIsCalcuated(String isCalcuated) {
		this.isCalcuated = isCalcuated;
	}

}
