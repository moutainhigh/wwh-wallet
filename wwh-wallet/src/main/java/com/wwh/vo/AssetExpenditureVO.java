package com.wwh.vo;

import java.math.BigDecimal;

public class AssetExpenditureVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 2978333445561194561L;
	/**
	 * 支出金额
	 */
	private BigDecimal expenditureAmount;
	/**
	 * 支出目标
	 */
	private Long targetUserId;
	/**
	 * 状态SUCCESSED FAILDED
	 */
	private String status;

	public BigDecimal getExpenditureAmount() {
		return expenditureAmount;
	}

	public void setExpenditureAmount(BigDecimal expenditureAmount) {
		this.expenditureAmount = expenditureAmount;
	}

	public Long getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(Long targetUserId) {
		this.targetUserId = targetUserId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
