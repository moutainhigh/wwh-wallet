package com.wwh.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wwh.enums.PayStatusEnum;

/**
 * 手机端充值记录vo
 * 
 * @author u1
 *
 */
public class MPayRecordsVO {
	// 充值时间
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "CCT")
	private Date chargeDate;
	// 充值金额
	private BigDecimal chargeAmount;
	// 返送积分
	private BigDecimal returnScore;
	// 充值状态
	private String payStatus;
	// 充值记录状态名称
	private String payStatusName;

	public Date getChargeDate() {
		return chargeDate;
	}

	public void setChargeDate(Date chargeDate) {
		this.chargeDate = chargeDate;
	}

	public BigDecimal getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public BigDecimal getReturnScore() {
		return returnScore;
	}

	public void setReturnScore(BigDecimal returnScore) {
		this.returnScore = returnScore;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getPayStatusName() {

		if (payStatus.equals(PayStatusEnum.PAYSUCCESSED.name())) {
			payStatusName = "支付成功";
		}
		if (payStatus.equals(PayStatusEnum.PAYCANCELED.name())) {
			payStatusName = "支付取消";
		}
		if (payStatus.equals(PayStatusEnum.PAYPREED.name())) {
			payStatusName = "等待支付";
		}
		return payStatusName;
	}

	public void setPayStatusName(String payStatusName) {
		this.payStatusName = payStatusName;
	}
}
