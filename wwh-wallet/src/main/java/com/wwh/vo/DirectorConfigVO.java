package com.wwh.vo;

import java.math.BigDecimal;

/**
 * 总监可提现，储备金配置表
 * 
 * @author asd
 * @version 1.0
 * @created 09-11月-2016 14:37:23
 */
public class DirectorConfigVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -6030428726872796242L;

	/**
	 * 盘类型
	 */
	private String diskType;

	/**
	 * 所得空点数
	 */
	private Integer getEmptyPoints;

	/**
	 * 储备金金额
	 */
	private BigDecimal reserveAmount;

	/**
	 * 可提现金额
	 */
	private BigDecimal canWithdrawAmount;

	/**
	 * 单笔被抢金额
	 */
	private BigDecimal passiveAmount;

	public String getDiskType() {
		return diskType;
	}

	public void setDiskType(String diskType) {
		this.diskType = diskType;
	}

	public Integer getGetEmptyPoints() {
		return getEmptyPoints;
	}

	public void setGetEmptyPoints(Integer getEmptyPoints) {
		this.getEmptyPoints = getEmptyPoints;
	}

	public BigDecimal getReserveAmount() {
		return reserveAmount;
	}

	public void setReserveAmount(BigDecimal reserveAmount) {
		this.reserveAmount = reserveAmount;
	}

	public BigDecimal getCanWithdrawAmount() {
		return canWithdrawAmount;
	}

	public void setCanWithdrawAmount(BigDecimal canWithdrawAmount) {
		this.canWithdrawAmount = canWithdrawAmount;
	}

	public BigDecimal getPassiveAmount() {
		return passiveAmount;
	}

	public void setPassiveAmount(BigDecimal passiveAmount) {
		this.passiveAmount = passiveAmount;
	}

}