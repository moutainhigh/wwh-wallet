package com.wwh.vo;

public class BankVO extends BaseVO{
	private static final long serialVersionUID = 2085553721166102889L;
	
	//银行类型
	private String bankType;
	//银行名称
	private String bankName;

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
