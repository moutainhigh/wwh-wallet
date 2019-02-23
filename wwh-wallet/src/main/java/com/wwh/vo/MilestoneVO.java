package com.wwh.vo;

/**
 * 
 * @ClassName: MilestoneVO 
 * @Description: 会员里程碑表
 * @author: yuzih
 * @date: 2016年10月25日 上午10:06:58
 */
public class MilestoneVO extends BaseVO {


	private static final long serialVersionUID = 1571405081548316960L;

	/**
	 * 本盘类型; 500 ， 5000，50000的盘
	 */
	private String diskType;
	/**
	 * 是否到达  Y N
	 */
	private Character isArried;

	public String getDiskType() {
		return diskType;
	}

	public void setDiskType(String diskType) {
		this.diskType = diskType;
	}

	public Character getIsArried() {
		return isArried;
	}

	public void setIsArried(Character isArried) {
		this.isArried = isArried;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
