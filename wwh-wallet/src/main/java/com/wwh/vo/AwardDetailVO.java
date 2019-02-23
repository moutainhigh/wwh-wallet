package com.wwh.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AwardDetailVO {
	// 各种收益的数量
	private BigDecimal myProfitAamount;
	// 奖励模式
	private String awardType;
	// 奖励模式名称
	private String awardTypeRemark;
	// 奖励来源
	private String userName;
	// 创建时间
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "CCT")
	private Date createdDate;

	// =================总监收益=================
	// 被抢点总监
	private String directorName;
	// 抢得点数
	private Integer profitPoint;
	// 已获得次数
	private Integer grapProfitTimes;
	// ==================系统奖励===================
	// 剩余金额
	private BigDecimal remainAmount;
	// 所属系统
	private String diskType;
	// 奖励比例
	private String awardConfig;
	// 总奖励金额
	private String totalAmount;
	// ====================职位收益==================
	// 收益次数
	private String profitTimes;
	// 所属职位
	private String roles;
	// ===================推荐奖励====================
	// 充值金额
	private BigDecimal chargeAmount;

	public BigDecimal getMyProfitAamount() {
		return myProfitAamount;
	}

	public void setMyProfitAamount(BigDecimal myProfitAamount) {
		this.myProfitAamount = myProfitAamount;
	}

	public String getAwardType() {
		return awardType;
	}

	public void setAwardType(String awardType) {
		this.awardType = awardType;
	}

	public String getAwardTypeRemark() {
		return awardTypeRemark;
	}

	public void setAwardTypeRemark(String awardTypeRemark) {
		this.awardTypeRemark = awardTypeRemark;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public Integer getProfitPoint() {
		return profitPoint;
	}

	public void setProfitPoint(Integer profitPoint) {
		this.profitPoint = profitPoint;
	}

	public Integer getGrapProfitTimes() {
		return grapProfitTimes;
	}

	public void setGrapProfitTimes(Integer grapProfitTimes) {
		this.grapProfitTimes = grapProfitTimes;
	}

	public BigDecimal getRemainAmount() {
		return remainAmount;
	}

	public void setRemainAmount(BigDecimal remainAmount) {
		this.remainAmount = remainAmount;
	}

	public String getDiskType() {
		return diskType;
	}

	public void setDiskType(String diskType) {
		this.diskType = diskType;
	}

	public String getAwardConfig() {
		return awardConfig;
	}

	public void setAwardConfig(String awardConfig) {
		this.awardConfig = awardConfig;
	}

	public String getProfitTimes() {
		return profitTimes;
	}

	public void setProfitTimes(String profitTimes) {
		this.profitTimes = profitTimes;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public BigDecimal getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	@Override
	public String toString() {
		return "AwardDetailVO [myProfitAamount=" + myProfitAamount + ", awardType=" + awardType + ", awardTypeRemark="
				+ awardTypeRemark + ", userName=" + userName + ", createdDate=" + createdDate + ", directorName="
				+ directorName + ", profitPoint=" + profitPoint + ", grapProfitTimes=" + grapProfitTimes
				+ ", remainAmount=" + remainAmount + ", diskType=" + diskType + ", awardConfig=" + awardConfig
				+ ", profitTimes=" + profitTimes + ", roles=" + roles + ", chargeAmount=" + chargeAmount + "]";
	}
}
