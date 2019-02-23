package com.wwh.vo;

import java.math.BigDecimal;

public class WithdrawalVO extends BaseVO {

	private static final long serialVersionUID = -3818736573889455994L;

	private String withdrawalId;

	private String targetAccount;

	private double withdrawalAmount;

	private String diskType;

	// 招商分红提现金额
	private BigDecimal busWithdrawAmount = new BigDecimal(0.00);
	// 会员收益提现金额
	private BigDecimal memberWithdrawAmount = new BigDecimal(0.00);

	private BigDecimal saveGoldWithdrawAmount = new BigDecimal(0.00);
	// 微信名称
	private String weixinName;
	// 微信号码
	private String weixinNum;

	public BigDecimal getBusWithdrawAmount() {
		return busWithdrawAmount;
	}

	public void setBusWithdrawAmount(BigDecimal busWithdrawAmount) {
		this.busWithdrawAmount = busWithdrawAmount;
	}

	public BigDecimal getMemberWithdrawAmount() {
		return memberWithdrawAmount;
	}

	public void setMemberWithdrawAmount(BigDecimal memberWithdrawAmount) {
		this.memberWithdrawAmount = memberWithdrawAmount;
	}

	private String withdrawalWay;

	private String withdrawalStatus;

	public String getWithdrawalId() {
		return withdrawalId;
	}

	public void setWithdrawalId(String withdrawalId) {
		this.withdrawalId = withdrawalId;
	}

	public String getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(String targetAccount) {
		this.targetAccount = targetAccount;
	}

	public double getWithdrawalAmount() {
		return withdrawalAmount;
	}

	public void setWithdrawalAmount(double withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}

	public String getWithdrawalWay() {
		return withdrawalWay;
	}

	public void setWithdrawalWay(String withdrawalWay) {
		this.withdrawalWay = withdrawalWay;
	}

	public String getWithdrawalStatus() {
		return withdrawalStatus;
	}

	public void setWithdrawalStatus(String withdrawalStatus) {
		this.withdrawalStatus = withdrawalStatus;
	}

	public BigDecimal getSaveGoldWithdrawAmount() {
		return saveGoldWithdrawAmount;
	}

	public void setSaveGoldWithdrawAmount(BigDecimal saveGoldWithdrawAmount) {
		this.saveGoldWithdrawAmount = saveGoldWithdrawAmount;
	}

	public String getDiskType() {
		return diskType;
	}

	public void setDiskType(String diskType) {
		this.diskType = diskType;
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
		return "WithdrawalVO [withdrawalId=" + withdrawalId + ", targetAccount=" + targetAccount + ", withdrawalAmount="
				+ withdrawalAmount + ", diskType=" + diskType + ", busWithdrawAmount=" + busWithdrawAmount
				+ ", memberWithdrawAmount=" + memberWithdrawAmount + ", saveGoldWithdrawAmount="
				+ saveGoldWithdrawAmount + ", weixinName=" + weixinName + ", weixinNum=" + weixinNum
				+ ", withdrawalWay=" + withdrawalWay + ", withdrawalStatus=" + withdrawalStatus + "]";
	}

}
