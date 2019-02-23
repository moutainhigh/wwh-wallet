package com.wwh.vo;

import java.math.BigDecimal;

/**
 * 手机端会员之路vo
 * 
 * @author u1
 *
 */
public class MmemberRoledVO {

	// 用户在某个系统中的里程碑信息
	private boolean milstoneFlag = false;

	// 统计当总监得次数
	private Integer directorCount;

	// 最高收益记录
	private BigDecimal maxProfitRecords;

	// 晋升总监最快记录
	private String fastDirectorTime;

	// 盘创建到盘结束得时间毫秒数
	private Long timesatamp;

	// 晋升满点记录
	private Integer promotionTimes;

	public boolean isMilstoneFlag() {
		return milstoneFlag;
	}

	public void setMilstoneFlag(boolean milstoneFlag) {
		this.milstoneFlag = milstoneFlag;
	}

	public Integer getDirectorCount() {
		return directorCount;
	}

	public void setDirectorCount(Integer directorCount) {
		this.directorCount = directorCount;
	}

	public BigDecimal getMaxProfitRecords() {
		return maxProfitRecords;
	}

	public void setMaxProfitRecords(BigDecimal maxProfitRecords) {
		this.maxProfitRecords = maxProfitRecords;
	}

	public String getFastDirectorTime() {
		return fastDirectorTime;
	}

	public void setFastDirectorTime(String fastDirectorTime) {
		this.fastDirectorTime = fastDirectorTime;
	}

	public Integer getPromotionTimes() {
		return promotionTimes;
	}

	public void setPromotionTimes(Integer promotionTimes) {
		this.promotionTimes = promotionTimes;
	}

	public Long getTimesatamp() {
		return timesatamp;
	}

	public void setTimesatamp(Long timesatamp) {
		this.timesatamp = timesatamp;
	}
}
