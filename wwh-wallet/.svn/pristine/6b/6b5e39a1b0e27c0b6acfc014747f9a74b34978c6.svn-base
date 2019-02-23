package com.wwh.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 账号
 * 
 * @author lilinxiang 2016年11月2日 下午2:09:18
 *
 */
public enum PayAmountTypeEnum {
	OTHER(1, "OTHER"), 
	TIYAN(2, "TIYAN"), 
	HUIMIN(3,"HUIMIN"), 
	FUMIN(4, "FUMIN"), 
	XINGMIN(5,"XINGMIN");

	private int code;
	private String name;

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

	private PayAmountTypeEnum() {
	}

	private PayAmountTypeEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public static List<String> listAll() {
		List<String> list = new ArrayList<>();
		for (PayAmountTypeEnum enum1 : PayAmountTypeEnum.values()) {

			list.add(enum1.name);
		}
		return list;
	}

	public static int getCodeByName(String name) {
		for (PayAmountTypeEnum status : PayAmountTypeEnum.values()) {
			if (status.name().equals(name)) {
				return status.getCode();
			}
		}
		return -1;
	}

	public static PayAmountTypeEnum getEnumByName(String name) {
		for (PayAmountTypeEnum s : PayAmountTypeEnum.values()) {
			if (s.name().equals(name)) {
				return s;
			}
		}
		return null;
	}
}
