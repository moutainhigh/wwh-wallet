package com.wwh.vo;

public class WithdrawalLogVO extends BaseVO{

	private static final long serialVersionUID = -8807110227164289026L;
	
	private String withdrawalId;
	
	private String operation;
	
	private String withdrawalWay;
	
	public String getWithdrawalId() {
		return withdrawalId;
	}

	public void setWithdrawalId(String withdrawalId) {
		this.withdrawalId = withdrawalId;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getWithdrawalWay() {
		return withdrawalWay;
	}

	public void setWithdrawalWay(String withdrawalWay) {
		this.withdrawalWay = withdrawalWay;
	}
}
