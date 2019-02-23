package com.wwh.vo;

public class CountryVO extends BaseVO{
	
	/**
	 * 国家vo
	 */
	private static final long serialVersionUID = -1601429904910474441L;

	//国家编号
	private String countryCode;
	//国家名称
	private String countryName;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
