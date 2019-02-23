package com.wwh.vo;

public class CityVO extends BaseVO{
	
	/**
	 * 城市vo
	 */
	private static final long serialVersionUID = -6027140944224947674L;

	private String cityCode;
	
	private String cityName;
	
	private String provinceCode;

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
}
