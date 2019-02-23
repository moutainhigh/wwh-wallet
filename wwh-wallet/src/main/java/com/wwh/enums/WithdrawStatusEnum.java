package com.wwh.enums;

public enum WithdrawStatusEnum {
	//未处理  已处理  暂停中
	
	NO("NO","银行审批中"),
	YES("YES","已处理"),
	WAIT("WAIT","银行审批中");
	
	private String name;
	private String discription;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	private WithdrawStatusEnum(String name, String discription) {
		this.name = name;
	
		this.discription = discription;
	}

	public static int getCodeByName(String name) {
		for (RoleEnum role : RoleEnum.values()) {
			if (role.getName().equals(name)) {
				return role.getCode();
			}
		}
		return -1;
	}
}
