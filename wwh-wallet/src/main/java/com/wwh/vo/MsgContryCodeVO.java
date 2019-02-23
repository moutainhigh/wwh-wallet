package com.wwh.vo;

/**
 * 短信国家编号国际编号
 * 
 * @author u1
 *
 */
public class MsgContryCodeVO {
	// 主键id
	private Long id;
	// 国家名称
	private String contryName;
	// 国家编号
	private String contryCode;
	// 国家简称
	private String contryItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContryName() {
		return contryName;
	}

	public void setContryName(String contryName) {
		this.contryName = contryName;
	}

	public String getContryCode() {
		return contryCode;
	}

	public void setContryCode(String contryCode) {
		this.contryCode = contryCode;
	}

	public String getContryItem() {
		return contryItem;
	}

	public void setContryItem(String contryItem) {
		this.contryItem = contryItem;
	}

	@Override
	public String toString() {
		return "MsgContryCodeVO [id=" + id + ", contryName=" + contryName + ", contryCode=" + contryCode
				+ ", contryItem=" + contryItem + "]";
	}
}
