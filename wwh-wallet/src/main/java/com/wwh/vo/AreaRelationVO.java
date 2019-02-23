package com.wwh.vo;

public class AreaRelationVO extends BaseVO{
	
	private static final long serialVersionUID = 2009574286041922708L;
	/**
	 * 国家编号
	 */
	private String countryCode;
	/**
	 * 省份编号
	 */
	private String provinceCode;
	/**
	 * 城市编号
	 */
	private String cityCode;
	/**
	 * 地区编号
	 */
	private String areaCode;
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	
}
