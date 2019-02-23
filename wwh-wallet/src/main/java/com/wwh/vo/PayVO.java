package com.wwh.vo;

import java.math.BigDecimal;

import com.wwh.enums.PayStatusEnum;

/**
 * 
 * @ClassName: PayVO
 * @Description: 充值详情表， 由于所有平台的表都一样，所以一个VO就够了
 * @author: yuzih
 * @date: 2016年10月25日 上午10:06:24
 */
public class PayVO extends BaseVO {

	private static final long serialVersionUID = -1035975903512053325L;
	/**
	 * 用户唯一身份标识
	 */
	private String paySeq;
	/**
	 * 积分
	 */
	private BigDecimal score;
	/**
	 * 金额
	 */
	private BigDecimal amount;
	/**
	 * 是否已经计算
	 */
	private String isCalcuated;
	/**
	 * 枚举：支付状态 new waitted successed
	 */
	private String payStatus;
	/**
	 * 第三方支付回执编号
	 */
	private String returnCode;
	
	private String payStatusName;
	
	//订单支付系统类型
	private String payAmountType;

	public String getPayAmountType() {
		return payAmountType;
	}

	public void setPayAmountType(String payAmountType) {
		this.payAmountType = payAmountType;
	}

	public String getPayStatusName() {
		if(payStatus.equals(PayStatusEnum.PAYSUCCESSED.name())){
			payStatusName ="支付成功";
		}
		if(payStatus.equals(PayStatusEnum.PAYCANCELED.name())){
			payStatusName ="支付取消";
		}
		if(payStatus.equals(PayStatusEnum.PAYPREED.name())){
			payStatusName ="等待支付";
		}
		return payStatusName;
	}

	public void setPayStatusName(String payStatusName) {
	
		this.payStatusName = payStatusName;
	}

	public String getPaySeq() {
		return paySeq;
	}

	public void setPaySeq(String paySeq) {
		this.paySeq = paySeq == null ? null : paySeq.trim();
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
		this.isCalcuated = isCalcuated == null ? null : isCalcuated.trim();
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus == null ? null : payStatus.trim();
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode == null ? null : returnCode.trim();
	}

}