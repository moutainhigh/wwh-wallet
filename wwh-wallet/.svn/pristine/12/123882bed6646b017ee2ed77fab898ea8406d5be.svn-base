package com.wwh.enums;

public enum DiskEnum {
	TIYAN("TIYAN",1,"体验系统"),
	HUIMIN("HUIMIN",2,"惠民系统"),
	FUMIN("FUMIN",3,"富民系统"),
	XINGMIN("XINGMIN",4,"兴民系统");
	 
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

	private DiskEnum() {
	}

	private DiskEnum(String name, int code, String discription) {
		this.name = name;
		this.code = code;
		this.discription = discription;
	}

	public static int getCodeByName(String name) {
		for (DiskEnum role : DiskEnum.values()) {
			if (role.getName().equals(name)) {
				return role.getCode();
			}
		}
		return -1;
	}
	/**
	 * 
	 * @Title: getNextNameByName 
	 * @Description: 获得下一个盘 ，名称
	 * @param name
	 * @return
	 * @return: String
	 */
	public static String getNextNameByName(String name) {

		int v = -1;

		v = getCodeByName(name);

		String returnName = DiskEnum.values()[v].getName();

		return returnName;
	}
	
}
