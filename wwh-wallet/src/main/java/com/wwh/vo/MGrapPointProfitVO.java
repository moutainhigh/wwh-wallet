package com.wwh.vo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 手机端抢点收益vo
 * 
 * @author u1
 *
 */
public class MGrapPointProfitVO {

	// 创建时间
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "CCT")
	private String createDate;
	// 收益金额
	private BigDecimal profitAmount;
	// 收益的人数
	private Integer diskCounter;
	// 盘号
	private String diskName;
	// 用户id
	private Long user;
	// 提供收益的人
	private String userName;

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public BigDecimal getProfitAmount() {
		return profitAmount;
	}

	public void setProfitAmount(BigDecimal profitAmount) {
		this.profitAmount = profitAmount;
	}

	public Integer getDiskCounter() {
		return diskCounter;
	}

	public void setDiskCounter(Integer diskCounter) {
		this.diskCounter = diskCounter;
	}

	public String getDiskName() {
		return diskName;
	}

	public void setDiskName(String diskName) {
		this.diskName = diskName;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "MGrapPointProfitVO [createDate=" + createDate + ", profitAmount=" + profitAmount + ", diskCounter="
				+ diskCounter + ", diskName=" + diskName + ", user=" + user + ", userName=" + userName + "]";
	}
}
