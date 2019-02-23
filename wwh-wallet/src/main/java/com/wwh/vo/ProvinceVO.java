package com.wwh.vo;

public class ProvinceVO extends BaseVO{
	
	
	/**
	 * 省份vo
	 */
	private static final long serialVersionUID = 8166919490176757485L;

	private String provinceCode;
	
	private String provinceName;
	
	private String countryCode;

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
}
