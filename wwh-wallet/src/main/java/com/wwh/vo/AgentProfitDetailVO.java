package com.wwh.vo;

import java.math.BigDecimal;

public class AgentProfitDetailVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 2821417587972994297L;

	/**
	 * 代理商编号
	 */
	private Long agentId;
	/**
	 * 收益总金额
	 */
	private BigDecimal profitAmount;
	/**
	 * 收益状态
	 */
	private String profitStatus;
	/**
	 * 收益编号
	 */
	private String profitId;

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public BigDecimal getProfitAmount() {
		return profitAmount;
	}

	public void setProfitAmount(BigDecimal profitAmount) {
		this.profitAmount = profitAmount;
	}

	public String getProfitStatus() {
		return profitStatus;
	}

	public void setProfitStatus(String profitStatus) {
		this.profitStatus = profitStatus;
	}

	public String getProfitId() {
		return profitId;
	}

	public void setProfitId(String profitId) {
		this.profitId = profitId;
	}

}
