package com.wwh.enums;

/**
 * 
 * @ClassName: RoleGrapPointEnum 
 * @Description: 角色枚举
 * @author:  lilinxiang
 * @date: 2016年11月13日 下午10:12:51
 */
public enum RoleGrapPointEnum {
	
	/**
	 * 出局总监
	 */
	PLATFORM("PLATFORM",6,"平台"),
	/**
	 * 出局总监
	 */
	DIRECTORELIMINATED("DIRECTORELIMINATED",5,"出局总监"),
	/**
	 * B点总监
	 */
	DIRECTORPOINTB("DIRECTORPOINTB",4,"B点总监"),
	/**
	 * 经理
	 */
	MANAGER("MANAGER",3,"经理"),
	/**
	 * 规划师
	 */
	PLAN("PLAN",2,"规划师"),
	/**
	 * 会员
	 */
	MEMBER("MEMBER",1,"会员");
	
	private String name;

	private int code;

	private String discription;

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

	private RoleGrapPointEnum() {
	}

	private RoleGrapPointEnum(String name, int code, String discription) {
		this.name = name;
		this.code = code;
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
