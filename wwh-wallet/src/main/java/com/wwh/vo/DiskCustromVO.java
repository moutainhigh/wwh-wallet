package com.wwh.vo;

import java.math.BigDecimal;

/**
 * 
 * @ClassName: DiskCustromVO
 * @Description: 首页自定义VO
 * @author: YuZihao
 * @date: 2016年11月6日 下午1:08:08
 */
public class DiskCustromVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 7866274403676601306L;
	/**
	 * 系统所有的收益
	 */
	private BigDecimal allPlatformTotalAmount = new BigDecimal(0);
	/**
	 * 系统所有的充值金额
	 */
	private BigDecimal allRechargeAmount = new BigDecimal(0);
	/**
	 * 系统参与人数
	 */
	private Long allDiskCounter = 0L;

	/**
	 * 体验系统参与人数
	 */
	private Integer tiyanDiskCounter = 0;
	/**
	 * 惠民系统参与人数
	 */
	private Integer huiminDiskCounter = 0;
	/**
	 * 富民系统参与人数
	 */
	private Integer fuminDiskCounter = 0;
	/**
	 * 兴民系统参与人数
	 */
	private Integer xingminDiskCounter = 0;

	/**
	 * 当前用户体验系统总收益
	 */
	private BigDecimal tiyanAmountByCurrentUser = new BigDecimal(0);
	/**
	 * 当前用户惠民系统总收益
	 */
	private BigDecimal huiminAmountByCurrentUser = new BigDecimal(0);
	/**
	 * 当前用户富民系统总收益
	 */
	private BigDecimal fuminAmountByCurrentUser = new BigDecimal(0);
	/**
	 * 当前用户兴民系统总收益
	 */
	private BigDecimal xingminAmountByCurrentUser = new BigDecimal(0);

	/**
	 * 当前用户体验系统充值总金额
	 */
	private BigDecimal tiyanRcgByCurrentUser = new BigDecimal(0);
	/**
	 * 当前用户惠民系统充值总金额
	 */
	private BigDecimal huiminRcgByCurrentUser = new BigDecimal(0);
	/**
	 * 当前用户富民系统充值总金额
	 */
	private BigDecimal fuminRcgByCurrentUser = new BigDecimal(0);
	/**
	 * 当前用户兴民系统充值总金额
	 */
	private BigDecimal xingminRcgByCurrentUser = new BigDecimal(0);

	/**
	 * 当前用户招商分红收益总金额
	 */
	private BigDecimal businessAmountByCurrentUser = new BigDecimal(0);

	/**
	 * 用户招商数量
	 */
	private Integer businessCounter = 0;

	/**
	 * 招商分红总收益
	 */
	private BigDecimal allBusinessProfitAmount = new BigDecimal(0);

	public Integer getBusinessCounter() {
		return businessCounter;
	}

	public void setBusinessCounter(Integer businessCounter) {
		this.businessCounter = businessCounter;
	}

	public BigDecimal getTiyanRcgByCurrentUser() {
		return tiyanRcgByCurrentUser;
	}

	public void setTiyanRcgByCurrentUser(BigDecimal tiyanRcgByCurrentUser) {
		this.tiyanRcgByCurrentUser = tiyanRcgByCurrentUser;
	}

	public BigDecimal getHuiminRcgByCurrentUser() {
		return huiminRcgByCurrentUser;
	}

	public void setHuiminRcgByCurrentUser(BigDecimal huiminRcgByCurrentUser) {
		this.huiminRcgByCurrentUser = huiminRcgByCurrentUser;
	}

	public BigDecimal getFuminRcgByCurrentUser() {
		return fuminRcgByCurrentUser;
	}

	public void setFuminRcgByCurrentUser(BigDecimal fuminRcgByCurrentUser) {
		this.fuminRcgByCurrentUser = fuminRcgByCurrentUser;
	}

	public BigDecimal getXingminRcgByCurrentUser() {
		return xingminRcgByCurrentUser;
	}

	public void setXingminRcgByCurrentUser(BigDecimal xingminRcgByCurrentUser) {
		this.xingminRcgByCurrentUser = xingminRcgByCurrentUser;
	}

	public BigDecimal getBusinessAmountByCurrentUser() {
		return businessAmountByCurrentUser;
	}

	public void setBusinessAmountByCurrentUser(BigDecimal businessAmountByCurrentUser) {
		this.businessAmountByCurrentUser = businessAmountByCurrentUser;
	}

	public BigDecimal getTiyanAmountByCurrentUser() {
		return tiyanAmountByCurrentUser;
	}

	public void setTiyanAmountByCurrentUser(BigDecimal tiyanAmountByCurrentUser) {
		this.tiyanAmountByCurrentUser = tiyanAmountByCurrentUser;
	}

	public BigDecimal getHuiminAmountByCurrentUser() {
		return huiminAmountByCurrentUser;
	}

	public void setHuiminAmountByCurrentUser(BigDecimal huiminAmountByCurrentUser) {
		this.huiminAmountByCurrentUser = huiminAmountByCurrentUser;
	}

	public BigDecimal getFuminAmountByCurrentUser() {
		return fuminAmountByCurrentUser;
	}

	public void setFuminAmountByCurrentUser(BigDecimal fuminAmountByCurrentUser) {
		this.fuminAmountByCurrentUser = fuminAmountByCurrentUser;
	}

	public BigDecimal getXingminAmountByCurrentUser() {
		return xingminAmountByCurrentUser;
	}

	public void setXingminAmountByCurrentUser(BigDecimal xingminAmountByCurrentUser) {
		this.xingminAmountByCurrentUser = xingminAmountByCurrentUser;
	}

	public Integer getTiyanDiskCounter() {
		return tiyanDiskCounter;
	}

	public void setTiyanDiskCounter(Integer tiyanDiskCounter) {
		this.tiyanDiskCounter = tiyanDiskCounter;
	}

	public Integer getHuiminDiskCounter() {
		return huiminDiskCounter;
	}

	public void setHuiminDiskCounter(Integer huiminDiskCounter) {
		this.huiminDiskCounter = huiminDiskCounter;
	}

	public Integer getFuminDiskCounter() {
		return fuminDiskCounter;
	}

	public void setFuminDiskCounter(Integer fuminDiskCounter) {
		this.fuminDiskCounter = fuminDiskCounter;
	}

	public Integer getXingminDiskCounter() {
		return xingminDiskCounter;
	}

	public void setXingminDiskCounter(Integer xingminDiskCounter) {
		this.xingminDiskCounter = xingminDiskCounter;
	}

	public BigDecimal getAllRechargeAmount() {
		return allRechargeAmount;
	}

	public void setAllRechargeAmount(BigDecimal allRechargeAmount) {
		this.allRechargeAmount = allRechargeAmount;
	}

	public Long getAllDiskCounter() {
		return allDiskCounter;
	}

	public void setAllDiskCounter(Long allDiskCounter) {
		this.allDiskCounter = allDiskCounter;
	}

	public BigDecimal getAllBusinessProfitAmount() {
		return allBusinessProfitAmount;
	}

	public void setAllBusinessProfitAmount(BigDecimal allBusinessProfitAmount) {
		this.allBusinessProfitAmount = allBusinessProfitAmount;
	}

	public BigDecimal getAllPlatformTotalAmount() {
		return allPlatformTotalAmount;
	}

	public void setAllPlatformTotalAmount(BigDecimal allPlatformTotalAmount) {
		this.allPlatformTotalAmount = allPlatformTotalAmount;
	}

}
