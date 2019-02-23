package com.wwh.vo;

import java.math.BigDecimal;

/**
 * 
 * @ClassName: ScoreUsageVO
 * @Description: 用户积分使用表
 * @author: yuzih
 * @date: 2016年10月26日 上午10:11:11
 */
public class ScoreUsageVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description:
	 */
	private static final long serialVersionUID = 5501617989870830751L;

	/**
	 * 使用积分
	 */
	private BigDecimal uasgeScore;
	/**
	 * 订单编号
	 */
	private String orderNumber;
	/**
	 * 订单金额
	 */
	private BigDecimal orderAmount;
	/**
	 * 积分使用状态
	 */
	private Character uasgeScoreStatus;

	public BigDecimal getUasgeScore() {
		return uasgeScore;
	}

	/**
	 * 
	 * @Title: setUasgeScore
	 * @Description: 使用积分
	 * @param uasgeScore
	 * @return: void
	 */
	public void setUasgeScore(BigDecimal uasgeScore) {
		this.uasgeScore = uasgeScore;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * 
	 * @Title: setOrderNumber
	 * @Description: 订单号码
	 * @param orderNumber
	 * @return: void
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	/**
	 * 
	 * @Title: setOrderAmount
	 * @Description: 订单金额
	 * @param orderAmount
	 * @return: void
	 */
	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Character getUasgeScoreStatus() {
		return uasgeScoreStatus;
	}

	/**
	 * 
	 * @Title: setUasgeScoreStatus
	 * @Description: 积分使用状态
	 * @param uasgeScoreStatus
	 * @return: void
	 */
	public void setUasgeScoreStatus(Character uasgeScoreStatus) {
		this.uasgeScoreStatus = uasgeScoreStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
