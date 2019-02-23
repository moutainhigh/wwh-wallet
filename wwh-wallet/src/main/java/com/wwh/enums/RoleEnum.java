package com.wwh.enums;

/**
 * 
 * @ClassName: RoleEnum 
 * @Description: 角色枚举
 * @author: Administrator
 * @date: 2016年10月26日 下午5:54:15
 */
public enum RoleEnum  {
	
	DIRECTOR("DIRECTOR",1,"总监"),
	MANAGER("MANAGER",2,"经理"),
	PLAN("PLAN",3,"规划师"),
	MEMBER("MEMBER",4,"会员"),
	PROVINCEAGENT("PROVINCEAGENT",5,"省代理"),
	CITYAGENT("CITYAGENT",6,"市代理"),
	DISTRICTAGENT("DISTRICTAGENT",7,"区代理");
	
	private  String name;
	
	private  int code;
	
	private  String discription;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	private RoleEnum() {
	}

	private RoleEnum(String name, int code, String discription) {
		this.name = name;
		this.code = code;
		this.discription = discription;
	}
	
	public static  int getCodeByName(String name) {
		for (RoleEnum role : RoleEnum.values()) {
			if (role.name.equals(name)) {
				return role.code;
			}
		}
		return -1;
	}
	
	
	
}
