package com.wwh.vo;

import java.math.BigDecimal;

/**
 * wallet_disk_type_profit_t系统类型收益表
 * 
 * @author asd
 * @version 1.0
 * @created 09-11月-2016 14:37:11
 */
public class DiskTypeProfitVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 2454496835604282947L;
	/**
	 * disk_profit_amount 盘收益金额
	 */
	private BigDecimal diskProfitAmount;
	/**
	 * 本盘类型; tiyan ， huimin，fumin的盘
	 */
	private String diskType;
	/**
	 * user_id 用户编号
	 */
	private Long userId;

	public String getDiskType() {
		return diskType;
	}

	public void setDiskType(String diskType) {
		this.diskType = diskType;
	}

	@Override
	public Long getUserId() {
		return userId;
	}

	@Override
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BigDecimal getDiskProfitAmount() {
		return diskProfitAmount;
	}

	public void setDiskProfitAmount(BigDecimal diskProfitAmount) {
		this.diskProfitAmount = diskProfitAmount;
	}

	@Override
	public String toString() {
		return "DiskTypeProfitVO [diskProfitAmount=" + diskProfitAmount + ", diskType=" + diskType + ", userId=" + userId + "]";
	}

}