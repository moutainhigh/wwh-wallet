package com.wwh.vo;

import java.math.BigDecimal;
import java.util.Date;

public class MemberCareerSystemDetailCustromVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 6202526781967973781L;

	/**
	 * 充值总次数,包括1-499
	 */
	private Integer rcgCount;
	/**
	 * 成为总监次数(最少1+2)
	 */
	private Integer directorCount;
	/**
	 * 晋升总监最快时间(最少1+2)
	 */
	private Date the_fastest_time_to_be_Director;
	/**
	 * 满点总监次数
	 */
	private Integer allProfitDirectorCount;
	/**
	 * 一个身份最高收益记录
	 */
	private BigDecimal maxProfit;

	public Integer getRcgCount() {
		return rcgCount;
	}

	public void setRcgCount(Integer rcgCount) {
		this.rcgCount = rcgCount;
	}

	public Integer getDirectorCount() {
		return directorCount;
	}

	public void setDirectorCount(Integer directorCount) {
		this.directorCount = directorCount;
	}

	public Date getThe_fastest_time_to_be_Director() {
		return the_fastest_time_to_be_Director;
	}

	public void setThe_fastest_time_to_be_Director(Date the_fastest_time_to_be_Director) {
		this.the_fastest_time_to_be_Director = the_fastest_time_to_be_Director;
	}

	public Integer getAllProfitDirectorCount() {
		return allProfitDirectorCount;
	}

	public void setAllProfitDirectorCount(Integer allProfitDirectorCount) {
		this.allProfitDirectorCount = allProfitDirectorCount;
	}

	public BigDecimal getMaxProfit() {
		return maxProfit;
	}

	public void setMaxProfit(BigDecimal maxProfit) {
		this.maxProfit = maxProfit;
	}

}
