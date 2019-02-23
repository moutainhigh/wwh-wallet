package com.wwh.vo;

import com.wwh.enums.WithdrawStatusEnum;

/**
 * 提现记录vo
 * 
 * @author u1
 *
 */
public class WithdrawDetilVO extends BaseVO {

	private static final long serialVersionUID = -39226300526388593L;

	// 提现金额
	private String withdrawAmount;
	// 招商分红提现金额
	private String busWithdrawAmount;
	// 会员收益提现金额
	private String memberWithdrawAmount;
	// 储备金提现金额
	private String saveGoldWithdrawAmount;
	// 提现状态
	private String withdrawStatus;
	// 提现银行
	private String bankName;
	// 用户姓名
	private String realName;
	// 提现状态名称
	private String withdrawStatusName;
	// 微信名称
	private String weixinName;
	// 微信号
	private String weixinNum;

	public String getWithdrawStatusName() {

		if (WithdrawStatusEnum.NO.name().equals(withdrawStatus)) {
			withdrawStatusName = WithdrawStatusEnum.NO.getDiscription();
		}
		if (WithdrawStatusEnum.YES.name().equals(withdrawStatus)) {
			withdrawStatusName = WithdrawStatusEnum.YES.getDiscription();
		}
		if (WithdrawStatusEnum.WAIT.name().equals(withdrawStatus)) {
			withdrawStatusName = WithdrawStatusEnum.WAIT.getDiscription();
		}
		return withdrawStatusName;
	}

	public String getSaveGoldWithdrawAmount() {
		return saveGoldWithdrawAmount;
	}

	public void setSaveGoldWithdrawAmount(String saveGoldWithdrawAmount) {
		this.saveGoldWithdrawAmount = saveGoldWithdrawAmount;
	}

	public String getBusWithdrawAmount() {
		return busWithdrawAmount;
	}

	public void setBusWithdrawAmount(String busWithdrawAmount) {
		this.busWithdrawAmount = busWithdrawAmount;
	}

	public String getMemberWithdrawAmount() {
		return memberWithdrawAmount;
	}

	public void setMemberWithdrawAmount(String memberWithdrawAmount) {
		this.memberWithdrawAmount = memberWithdrawAmount;
	}

	public void setWithdrawStatusName(String withdrawStatusName) {
		this.withdrawStatusName = withdrawStatusName;
	}

	public String getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(String withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	public String getWithdrawStatus() {
		return withdrawStatus;
	}

	public void setWithdrawStatus(String withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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
		return "WithdrawDetilVO [withdrawAmount=" + withdrawAmount + ", busWithdrawAmount=" + busWithdrawAmount
				+ ", memberWithdrawAmount=" + memberWithdrawAmount + ", saveGoldWithdrawAmount="
				+ saveGoldWithdrawAmount + ", withdrawStatus=" + withdrawStatus + ", bankName=" + bankName
				+ ", realName=" + realName + ", withdrawStatusName=" + withdrawStatusName + ", weixinName=" + weixinName
				+ ", weixinNum=" + weixinNum + "]";
	}
}
