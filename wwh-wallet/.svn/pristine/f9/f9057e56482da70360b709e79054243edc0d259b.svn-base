package com.wwh.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @ClassName: DiskProfitVO
 * @Description: 盘总收益表
 * @author: yuzih
 * @date: 2016年11月2日 上午11:35:53
 */
public class DiskProfitVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 8645258290462028107L;

	/**
	 * 用户昵称
	 */
	private String nickName;
	/**
	 * 盘编号
	 */
	private String diskSeq;
	/**
	 * 盘类型，枚举 500，5000，50000，500000
	 */
	private String diskType;
	/**
	 * 可提现金额
	 */
	private BigDecimal withdrawalsAmount = new BigDecimal(0);
	/**
	 * 储备金
	 */
	private BigDecimal saveAmount = new BigDecimal(0);

	/**
	 * 总收益
	 */
	private BigDecimal diskProfitAmount = new BigDecimal(0);
	/**
	 * 角色编号
	 */
	private Long roleId;
	/**
	 * 盘目前总人数
	 */
	private Integer diskCounter = 0;
	/**
	 * 加入盘时间
	 */
	private Date joinDiskTime;
	/**
	 * 盘状态 枚举 RUNNING,FINISHED
	 */
	private String diskStatus;
	/**
	 * 用户身份唯一标识
	 */
	private String idCard;

	/**
	 * 显示用的盘号
	 */
	private String diskName;
	/**
	 * 是否该盘人员 Y,N
	 */
	private String isThisDisk = "Y";

	public String getIsThisDisk() {
		return isThisDisk;
	}

	public void setIsThisDisk(String isThisDisk) {
		this.isThisDisk = isThisDisk;
	}

	public String getDiskName() {
		return diskName;
	}

	public void setDiskName(String diskName) {
		this.diskName = diskName;
	}

	@Override
	public String getNickName() {
		return nickName;
	}

	@Override
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getDiskSeq() {
		return diskSeq;
	}

	public void setDiskSeq(String diskSeq) {
		this.diskSeq = diskSeq;
	}

	public String getDiskType() {
		return diskType;
	}

	public void setDiskType(String diskType) {
		this.diskType = diskType;
	}

	public BigDecimal getWithdrawalsAmount() {
		return withdrawalsAmount;
	}

	public void setWithdrawalsAmount(BigDecimal withdrawalsAmount) {
		this.withdrawalsAmount = withdrawalsAmount;
	}

	public BigDecimal getSaveAmount() {
		return saveAmount;
	}

	public void setSaveAmount(BigDecimal saveAmount) {
		this.saveAmount = saveAmount;
	}

	public BigDecimal getDiskProfitAmount() {
		return diskProfitAmount;
	}

	public void setDiskProfitAmount(BigDecimal diskProfitAmount) {
		this.diskProfitAmount = diskProfitAmount;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Integer getDiskCounter() {
		return diskCounter;
	}

	public void setDiskCounter(Integer diskCounter) {
		this.diskCounter = diskCounter;
	}

	public Date getJoinDiskTime() {
		return joinDiskTime;
	}

	public void setJoinDiskTime(Date joinDiskTime) {
		this.joinDiskTime = joinDiskTime;
	}

	public String getDiskStatus() {
		return diskStatus;
	}

	public void setDiskStatus(String diskStatus) {
		this.diskStatus = diskStatus;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "DiskProfitVO [nickName=" + nickName + ", diskSeq=" + diskSeq + ", diskType=" + diskType + ", withdrawalsAmount=" + withdrawalsAmount
				+ ", saveAmount=" + saveAmount + ", diskProfitAmount=" + diskProfitAmount + ", roleId=" + roleId + ", diskCounter=" + diskCounter
				+ ", joinDiskTime=" + joinDiskTime + ", diskStatus=" + diskStatus + ", idCard=" + idCard + ", diskName=" + diskName + "]";
	}

}
