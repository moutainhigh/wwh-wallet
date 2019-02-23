package com.wwh.vo;

public class RegionUserVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -3150594364467389592L;

	/**
	 * 地区编号
	 */
	private String regionCode;
	/**
	 * 地区级别
	 */
	private Integer regionLevel;

	public Integer getRegionLevel() {
		return regionLevel;
	}

	public void setRegionLevel(Integer regionLevel) {
		this.regionLevel = regionLevel;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

}
