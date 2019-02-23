package com.wwh.vo;

public class ApplyWithdrawVO extends BaseVO {

	/**
	 * 申请提现vo
	 */
	private static final long serialVersionUID = -9071730297725497380L;

	// 平台可提现总金额
	private String platformWithdrawalsAmount;

	// 招商分红可提现金额
	private String businessWithdrawalsAmount;

	// 会员收益可提现金额
	private String memberWithdrawalsAmount;

	// 储备金可提现总金额
	private String saveGoldWithdrawalsAmount;

	// 真实姓名
	private String realName;

	// 微信号
	private String weixinName;
	// 微信名称
	private String weixinNum;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPlatformWithdrawalsAmount() {
		return platformWithdrawalsAmount;
	}

	public void setPlatformWithdrawalsAmount(String platformWithdrawalsAmount) {
		this.platformWithdrawalsAmount = platformWithdrawalsAmount;
	}

	public String getBusinessWithdrawalsAmount() {
		return businessWithdrawalsAmount;
	}

	public void setBusinessWithdrawalsAmount(String businessWithdrawalsAmount) {
		this.businessWithdrawalsAmount = businessWithdrawalsAmount;
	}

	public String getMemberWithdrawalsAmount() {
		return memberWithdrawalsAmount;
	}

	public void setMemberWithdrawalsAmount(String memberWithdrawalsAmount) {
		this.memberWithdrawalsAmount = memberWithdrawalsAmount;
	}

	public String getSaveGoldWithdrawalsAmount() {
		return saveGoldWithdrawalsAmount;
	}

	public void setSaveGoldWithdrawalsAmount(String saveGoldWithdrawalsAmount) {
		this.saveGoldWithdrawalsAmount = saveGoldWithdrawalsAmount;
	}

	public String getWeixinName() {
		return weixinName;
	}

	public void setWeixinName(String weixinName) {
		this.weixinName = weixinName;
	}

	public String getWeixinNum() {
		return weixinNum;
	}

	public void setWeixinNum(String weixinNum) {
		this.weixinNum = weixinNum;
	}

	@Override
	public String toString() {
		return "ApplyWithdrawVO [platformWithdrawalsAmount=" + platformWithdrawalsAmount
				+ ", businessWithdrawalsAmount=" + businessWithdrawalsAmount + ", memberWithdrawalsAmount="
				+ memberWithdrawalsAmount + ", saveGoldWithdrawalsAmount=" + saveGoldWithdrawalsAmount + ", realName="
				+ realName + ", weixinName=" + weixinName + ", weixinNum=" + weixinNum + "]";
	}

}
