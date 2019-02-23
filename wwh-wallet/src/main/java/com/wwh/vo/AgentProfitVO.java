package com.wwh.vo;

import java.math.BigDecimal;

public class AgentProfitVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -7965552580707414644L;

	/**
	 * 代理商编号
	 */
	private Long agentId;
	/**
	 * 收益总金额
	 */
	private BigDecimal totalAmount = BigDecimal.valueOf(0);
	/**
	 * 剩余金额
	 */
	private BigDecimal remainAmount = BigDecimal.valueOf(0);
	/**
	 * 已使用金额
	 */
	private BigDecimal usedAmount = BigDecimal.valueOf(0);

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getRemainAmount() {
		return remainAmount;
	}

	public void setRemainAmount(BigDecimal remainAmount) {
		this.remainAmount = remainAmount;
	}

	public BigDecimal getUsedAmount() {
		return usedAmount;
	}

	public void setUsedAmount(BigDecimal usedAmount) {
		this.usedAmount = usedAmount;
	}

}
