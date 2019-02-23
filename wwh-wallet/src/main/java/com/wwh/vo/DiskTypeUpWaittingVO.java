package com.wwh.vo;

import java.math.BigDecimal;

public class DiskTypeUpWaittingVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description:
	 */
	private static final long serialVersionUID = 3960933765484580244L;

	/**
	 * 等待晋升系统类型
	 */
	private String diskType;
	/**
	 * 等待用户ID
	 */
	private Long userId;
	/**
	 * 等待身份
	 */
	private String idCard;
	/**
	 * 上一个IDCARD
	 */
	private String lastIdCard;
	/**
	 * 等待状态
	 */
	private String waittingStatus;
	/**
	 * 需要补全金额
	 */
	private BigDecimal differenceAmount;

	/**
	 * 系统赠送金额
	 */
	private BigDecimal systemGiveAmount = new BigDecimal(0);

	public String getLastIdCard() {
		return lastIdCard;
	}

	public void setLastIdCard(String lastIdCard) {
		this.lastIdCard = lastIdCard;
	}

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

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getWaittingStatus() {
		return waittingStatus;
	}

	public void setWaittingStatus(String waittingStatus) {
		this.waittingStatus = waittingStatus;
	}

	public BigDecimal getDifferenceAmount() {
		return differenceAmount;
	}

	public void setDifferenceAmount(BigDecimal differenceAmount) {
		this.differenceAmount = differenceAmount;
	}

	public BigDecimal getSystemGiveAmount() {
		return systemGiveAmount;
	}

	public void setSystemGiveAmount(BigDecimal systemGiveAmount) {
		this.systemGiveAmount = systemGiveAmount;
	}

}
