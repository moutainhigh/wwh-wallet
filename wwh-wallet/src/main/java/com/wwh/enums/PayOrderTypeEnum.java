package com.wwh.enums;
/**
 * 支付方式
 * 
 * @author lilinxiang 2016年11月2日 下午3:06:52
 *
 */
public enum PayOrderTypeEnum {
	WWHAILPAY(1,"WWHAILPAY"),
	WWHWEIXINPAY(2,"WWHWEIXINPAY"),
	WWHUNIONPAY(3,"WWHUNIONPAY");
	 
	private  int code;
	private  String name;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private PayOrderTypeEnum() {
	}
	private PayOrderTypeEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}
	 
	
}
