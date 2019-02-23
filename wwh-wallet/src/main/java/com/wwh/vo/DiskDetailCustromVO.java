package com.wwh.vo;

import java.math.BigDecimal;
import java.util.List;

public class DiskDetailCustromVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 2335752534694240824L;

	/**
	 * 今日新增人数
	 */
	private Integer todayNewCounter;
	/**
	 * 加入资金
	 */
	private BigDecimal joinAmount = new BigDecimal(0);
	/**
	 * 总投入资金
	 */
	private BigDecimal allRcgAmount = new BigDecimal(0);
	/**
	 * 当前收益
	 */
	private BigDecimal currentProfit = new BigDecimal(0);
	/**
	 * 设置盘总人数
	 */
	private Integer currentCounter = 0;

	/**
	 * 我在该盘位置
	 */
	private Integer location;

	/**
	 * 角色编号
	 */
	private Long roleId;

	/**
	 * 头像路径
	 */
	private String picUrl = "default";
	/**
	 * 里程碑
	 */
	private String milestone;

	/**
	 * 抢点者
	 */
	private List<DiskDetailCustromVO> diskDetailCustromVOs;
	/**
	 * 盘状态
	 */
	private String diskStatus;
	/**
	 * 盘号
	 */
	private String diskSeq;
	/**
	 * 盘名
	 */
	private String diskName;
	/**
	 * 盘详情里面每一个位置的人的基本信息
	 */
	private List<WalletDiskRelationVO> diskRelationVOs;

	public List<WalletDiskRelationVO> getDiskRelationVOs() {
		return diskRelationVOs;
	}

	public void setDiskRelationVOs(List<WalletDiskRelationVO> diskRelationVOs) {
		this.diskRelationVOs = diskRelationVOs;
	}

	public String getDiskSeq() {
		return diskSeq;
	}

	public void setDiskSeq(String diskSeq) {
		this.diskSeq = diskSeq;
	}

	public String getDiskName() {
		return diskName;
	}

	public void setDiskName(String diskName) {
		this.diskName = diskName;
	}

	public List<DiskDetailCustromVO> getDiskDetailCustromVOs() {
		return diskDetailCustromVOs;
	}

	public void setDiskDetailCustromVOs(List<DiskDetailCustromVO> diskDetailCustromVOs) {
		this.diskDetailCustromVOs = diskDetailCustromVOs;
	}

	public String getMilestone() {
		return milestone;
	}

	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getCurrentCounter() {
		return currentCounter;
	}

	public void setCurrentCounter(Integer currentCounter) {
		this.currentCounter = currentCounter;
	}

	public Integer getTodayNewCounter() {
		return todayNewCounter;
	}

	public void setTodayNewCounter(Integer todayNewCounter) {
		this.todayNewCounter = todayNewCounter;
	}

	public BigDecimal getJoinAmount() {
		return joinAmount;
	}

	public void setJoinAmount(BigDecimal joinAmount) {
		this.joinAmount = joinAmount;
	}

	public BigDecimal getAllRcgAmount() {
		return allRcgAmount;
	}

	public void setAllRcgAmount(BigDecimal allRcgAmount) {
		this.allRcgAmount = allRcgAmount;
	}

	public BigDecimal getCurrentProfit() {
		return currentProfit;
	}

	public void setCurrentProfit(BigDecimal currentProfit) {
		this.currentProfit = currentProfit;
	}

	public String getDiskStatus() {
		return diskStatus;
	}

	public void setDiskStatus(String diskStatus) {
		this.diskStatus = diskStatus;
	}

}
