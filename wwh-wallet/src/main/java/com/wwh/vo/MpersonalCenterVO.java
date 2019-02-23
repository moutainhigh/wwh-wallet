package com.wwh.vo;

/**
 * 手机端的个人中心
 * 
 * @author u1
 *
 */
public class MpersonalCenterVO {
	// 我推荐的人
	private String myRecorment;
	// 总收益金币
	private String totalProfit;

	public String getMyRecorment() {
		return myRecorment;
	}

	public void setMyRecorment(String myRecorment) {
		this.myRecorment = myRecorment;
	}

	public String getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(String totalProfit) {
		this.totalProfit = totalProfit;
	}

}
