package com.wwh.vo;

import java.math.BigDecimal;

/**
 * 
 * @ClassName: PlatformProfitVO
 * @Description: 平台总收益表
 * @author: yuzih
 * @date: 2016年10月27日 上午11:11:46
 */
public class PlatformProfitVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description:
	 */
	private static final long serialVersionUID = 387654538527975241L;

	/**
	 * 抢点收益总金额
	 */
	private BigDecimal platformGrapTotalAmount = new BigDecimal(0);
	/**
	 * 兴民系统抢点收益总金额
	 */
	private BigDecimal xingminGrapAmount = new BigDecimal(0);
	/**
	 * 富民系统抢点收益总金额
	 */
	private BigDecimal fuminGrapAmount = new BigDecimal(0);
	/**
	 * 惠民系统抢点收益总金额
	 */
	private BigDecimal huiminGrapAmount = new BigDecimal(0);
	/**
	 * 体验系统抢点收益总金额
	 */
	private BigDecimal tiyanGrapAmount = new BigDecimal(0);
	/**
	 * decimal(18,2) default NULL comment '平台收益总金额',
	 */
	private BigDecimal platformTotalAmount = new BigDecimal(0);
	/**
	 * decimal(18,2) default NULL comment '平台可提现金额',
	 */
	private BigDecimal platformWithdrawalsAmount = new BigDecimal(0);
	/**
	 * decimal(18,2) default NULL comment '平台已提现总金额',
	 */
	private BigDecimal platformUsedAmount = new BigDecimal(0);
	/**
	 * decimal(18,2) default NULL comment '平台剩余总金额',
	 */
	private BigDecimal platformRemainAmount = new BigDecimal(0);
	/**
	 * decimal(18,2) default NULL comment '会员等级收益总金额',
	 */
	private BigDecimal memberTotalAmount = new BigDecimal(0);
	/**
	 * decimal(18,2) comment '会员等级收益可提现金额',
	 */
	private BigDecimal memberWithdrawalsAmount = new BigDecimal(0);

	/**
	 * 储备金总金额
	 */
	private BigDecimal saveAmount = new BigDecimal(0);

	/**
	 * decimal(18,2) default NULL comment '会员等级已提现总金额',
	 */
	private BigDecimal memberUsedAmount = new BigDecimal(0);
	/**
	 * decimal(18,2) default NULL comment '会员等级剩余总金额',
	 */
	private BigDecimal memberRemainAmount = new BigDecimal(0);
	/**
	 * decimal(18,2) default NULL comment '招商分红收益总金额',
	 */
	private BigDecimal businessTotalAmount = new BigDecimal(0);
	/**
	 * decimal(18,2) comment '招商分红已提现金额',
	 */
	private BigDecimal businessUsedAmount = new BigDecimal(0);
	/**
	 * decimal(18,2) comment '招商分红可提现金额',
	 */
	private BigDecimal businessWithdrawalsAmount = new BigDecimal(0);

	/**
	 * 兴民储备金
	 */
	private BigDecimal xingminSaveAmount = new BigDecimal(0);
	/**
	 * 富民储备金
	 */
	private BigDecimal fuminSaveAmount = new BigDecimal(0);
	/**
	 * 惠民储备金
	 */
	private BigDecimal huiminSaveAmount = new BigDecimal(0);
	/**
	 * 体验储备金
	 */
	private BigDecimal tiyanSaveAmount = new BigDecimal(0);
	/**
	 * 兴民可提现
	 */
	private BigDecimal xingminWithdrawalsAmount = new BigDecimal(0);
	/**
	 * 富民可提现
	 */
	private BigDecimal fuminWithdrawalsAmount = new BigDecimal(0);
	/**
	 * 惠民可提现
	 */
	private BigDecimal huiminWithdrawalsAmount = new BigDecimal(0);
	/**
	 * 体验可提现
	 */
	private BigDecimal tiyanWithdrawalsAmount = new BigDecimal(0);

	/**
	 * 兴民盘收益
	 */
	private BigDecimal xingminDiskProfitAmount = new BigDecimal(0);
	/**
	 * 富民盘收益
	 */
	private BigDecimal fuminDiskProfitAmount = new BigDecimal(0);
	/**
	 * 惠民盘收益
	 */
	private BigDecimal huiminDiskProfitAmount = new BigDecimal(0);
	/**
	 * 体验盘收益
	 */
	private BigDecimal tiyanDiskProfitAmount = new BigDecimal(0);

	public BigDecimal getXingminSaveAmount() {
		return xingminSaveAmount;
	}

	public void setXingminSaveAmount(BigDecimal xingminSaveAmount) {
		this.xingminSaveAmount = xingminSaveAmount;
	}

	public BigDecimal getFuminSaveAmount() {
		return fuminSaveAmount;
	}

	public void setFuminSaveAmount(BigDecimal fuminSaveAmount) {
		this.fuminSaveAmount = fuminSaveAmount;
	}

	public BigDecimal getHuiminSaveAmount() {
		return huiminSaveAmount;
	}

	public void setHuiminSaveAmount(BigDecimal huiminSaveAmount) {
		this.huiminSaveAmount = huiminSaveAmount;
	}

	public BigDecimal getTiyanSaveAmount() {
		return tiyanSaveAmount;
	}

	public void setTiyanSaveAmount(BigDecimal tiyanSaveAmount) {
		this.tiyanSaveAmount = tiyanSaveAmount;
	}

	public BigDecimal getSaveAmount() {
		return saveAmount;
	}

	public void setSaveAmount(BigDecimal saveAmount) {
		this.saveAmount = saveAmount;
	}

	public BigDecimal getPlatformTotalAmount() {
		return platformTotalAmount;
	}

	public void setPlatformTotalAmount(BigDecimal platformTotalAmount) {
		this.platformTotalAmount = platformTotalAmount;
	}

	public BigDecimal getPlatformWithdrawalsAmount() {
		return platformWithdrawalsAmount;
	}

	public void setPlatformWithdrawalsAmount(BigDecimal platformWithdrawalsAmount) {
		this.platformWithdrawalsAmount = platformWithdrawalsAmount;
	}

	public BigDecimal getPlatformUsedAmount() {
		return platformUsedAmount;
	}

	public void setPlatformUsedAmount(BigDecimal platformUsedAmount) {
		this.platformUsedAmount = platformUsedAmount;
	}

	public BigDecimal getPlatformRemainAmount() {
		return platformRemainAmount;
	}

	public void setPlatformRemainAmount(BigDecimal platformRemainAmount) {
		this.platformRemainAmount = platformRemainAmount;
	}

	public BigDecimal getMemberTotalAmount() {
		return memberTotalAmount;
	}

	public void setMemberTotalAmount(BigDecimal memberTotalAmount) {
		this.memberTotalAmount = memberTotalAmount;
	}

	public BigDecimal getMemberWithdrawalsAmount() {
		return memberWithdrawalsAmount;
	}

	public void setMemberWithdrawalsAmount(BigDecimal memberWithdrawalsAmount) {
		this.memberWithdrawalsAmount = memberWithdrawalsAmount;
	}

	public BigDecimal getMemberUsedAmount() {
		return memberUsedAmount;
	}

	public void setMemberUsedAmount(BigDecimal memberUsedAmount) {
		this.memberUsedAmount = memberUsedAmount;
	}

	public BigDecimal getMemberRemainAmount() {
		return memberRemainAmount;
	}

	public void setMemberRemainAmount(BigDecimal memberRemainAmount) {
		this.memberRemainAmount = memberRemainAmount;
	}

	public BigDecimal getBusinessTotalAmount() {
		return businessTotalAmount;
	}

	public void setBusinessTotalAmount(BigDecimal businessTotalAmount) {
		this.businessTotalAmount = businessTotalAmount;
	}

	public BigDecimal getBusinessUsedAmount() {
		return businessUsedAmount;
	}

	public void setBusinessUsedAmount(BigDecimal businessUsedAmount) {
		this.businessUsedAmount = businessUsedAmount;
	}

	public BigDecimal getBusinessWithdrawalsAmount() {
		return businessWithdrawalsAmount;
	}

	public void setBusinessWithdrawalsAmount(BigDecimal businessWithdrawalsAmount) {
		this.businessWithdrawalsAmount = businessWithdrawalsAmount;
	}

	public BigDecimal getPlatformGrapTotalAmount() {
		return platformGrapTotalAmount;
	}

	public void setPlatformGrapTotalAmount(BigDecimal platformGrapTotalAmount) {
		this.platformGrapTotalAmount = platformGrapTotalAmount;
	}

	public BigDecimal getXingminGrapAmount() {
		return xingminGrapAmount;
	}

	public void setXingminGrapAmount(BigDecimal xingminGrapAmount) {
		this.xingminGrapAmount = xingminGrapAmount;
	}

	public BigDecimal getFuminGrapAmount() {
		return fuminGrapAmount;
	}

	public void setFuminGrapAmount(BigDecimal fuminGrapAmount) {
		this.fuminGrapAmount = fuminGrapAmount;
	}

	public BigDecimal getHuiminGrapAmount() {
		return huiminGrapAmount;
	}

	public void setHuiminGrapAmount(BigDecimal huiminGrapAmount) {
		this.huiminGrapAmount = huiminGrapAmount;
	}

	public BigDecimal getTiyanGrapAmount() {
		return tiyanGrapAmount;
	}

	public void setTiyanGrapAmount(BigDecimal tiyanGrapAmount) {
		this.tiyanGrapAmount = tiyanGrapAmount;
	}

	public BigDecimal getXingminDiskProfitAmount() {
		return xingminDiskProfitAmount;
	}

	public void setXingminDiskProfitAmount(BigDecimal xingminDiskProfitAmount) {
		this.xingminDiskProfitAmount = xingminDiskProfitAmount;
	}

	public BigDecimal getFuminDiskProfitAmount() {
		return fuminDiskProfitAmount;
	}

	public void setFuminDiskProfitAmount(BigDecimal fuminDiskProfitAmount) {
		this.fuminDiskProfitAmount = fuminDiskProfitAmount;
	}

	public BigDecimal getHuiminDiskProfitAmount() {
		return huiminDiskProfitAmount;
	}

	public void setHuiminDiskProfitAmount(BigDecimal huiminDiskProfitAmount) {
		this.huiminDiskProfitAmount = huiminDiskProfitAmount;
	}

	public BigDecimal getTiyanDiskProfitAmount() {
		return tiyanDiskProfitAmount;
	}

	public void setTiyanDiskProfitAmount(BigDecimal tiyanDiskProfitAmount) {
		this.tiyanDiskProfitAmount = tiyanDiskProfitAmount;
	}

	public BigDecimal getXingminWithdrawalsAmount() {
		return xingminWithdrawalsAmount;
	}

	public void setXingminWithdrawalsAmount(BigDecimal xingminWithdrawalsAmount) {
		this.xingminWithdrawalsAmount = xingminWithdrawalsAmount;
	}

	public BigDecimal getFuminWithdrawalsAmount() {
		return fuminWithdrawalsAmount;
	}

	public void setFuminWithdrawalsAmount(BigDecimal fuminWithdrawalsAmount) {
		this.fuminWithdrawalsAmount = fuminWithdrawalsAmount;
	}

	public BigDecimal getHuiminWithdrawalsAmount() {
		return huiminWithdrawalsAmount;
	}

	public void setHuiminWithdrawalsAmount(BigDecimal huiminWithdrawalsAmount) {
		this.huiminWithdrawalsAmount = huiminWithdrawalsAmount;
	}

	public BigDecimal getTiyanWithdrawalsAmount() {
		return tiyanWithdrawalsAmount;
	}

	public void setTiyanWithdrawalsAmount(BigDecimal tiyanWithdrawalsAmount) {
		this.tiyanWithdrawalsAmount = tiyanWithdrawalsAmount;
	}

}
