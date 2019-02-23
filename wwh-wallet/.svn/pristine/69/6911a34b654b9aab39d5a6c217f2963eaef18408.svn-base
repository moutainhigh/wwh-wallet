package com.wwh.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.wwh.util.CommonConstant;

/**
 * 收益详情类
 * 
 * @author asd
 * @version 1.0
 * @created 09-11月-2016 14:37:08
 */
public class ProfitDetailVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description:
	 */
	private static final long serialVersionUID = -140554847358282169L;
	/**
	 * 盘序列号
	 */
	private String diskSeq;
	/**
	 * 盘真正的序号
	 */
	private String diskRealSeq;
	/**
	 * 身份唯一标识
	 */
	private String idCard;
	/**
	 * join_disk_time 入盘时间
	 */
	private Date joinDiskTime;
	/**
	 * 充值人
	 */
	private Long payUserId = CommonConstant.SYSTEM_USER_ID;
	/**
	 * 收益金额
	 */
	private BigDecimal profitAmount;
	/**
	 * 枚举：收益目标类型： 平台 platform，会员 member
	 */
	private String profitTargetType;
	/**
	 * 收益人编号
	 */
	private Long profitUserId;
	/**
	 * 角色编号
	 */
	private Long roleId;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 储备金
	 */
	private BigDecimal saveAmount;
	/**
	 * 可提现
	 */
	private BigDecimal withdrawalsAmount;

	/**
	 * 盘类型; tiyan ， huimin，fumin的盘
	 */
	private String diskType;

	/**
	 * 用户昵称
	 */
	private String nickNanme;

	/**
	 * 盘人数
	 */
	private Integer diskCounter;

	public String getNickNanme() {
		return nickNanme;
	}

	public void setNickNanme(String nickNanme) {
		this.nickNanme = nickNanme;
	}

	public Integer getDiskCounter() {
		return diskCounter;
	}

	public void setDiskCounter(Integer diskCounter) {
		this.diskCounter = diskCounter;
	}

	public String getDiskSeq() {
		return diskSeq;
	}

	public void setDiskSeq(String diskSeq) {
		this.diskSeq = diskSeq;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Date getJoinDiskTime() {
		return joinDiskTime;
	}

	public void setJoinDiskTime(Date joinDiskTime) {
		this.joinDiskTime = joinDiskTime;
	}

	public BigDecimal getProfitAmount() {
		return profitAmount;
	}

	public void setProfitAmount(BigDecimal profitAmount) {
		this.profitAmount = profitAmount;
	}

	public String getProfitTargetType() {
		return profitTargetType;
	}

	public void setProfitTargetType(String profitTargetType) {
		this.profitTargetType = profitTargetType;
	}

	public Long getProfitUserId() {
		return profitUserId;
	}

	public void setProfitUserId(Long profitUserId) {
		this.profitUserId = profitUserId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public BigDecimal getSaveAmount() {
		return saveAmount;
	}

	public void setSaveAmount(BigDecimal saveAmount) {
		this.saveAmount = saveAmount;
	}

	public String getDiskType() {
		return diskType;
	}

	public void setDiskType(String diskType) {
		this.diskType = diskType;
	}

	public Long getPayUserId() {
		return payUserId;
	}

	public void setPayUserId(Long payUserId) {
		this.payUserId = payUserId;
	}

	public BigDecimal getWithdrawalsAmount() {
		return withdrawalsAmount;
	}

	public void setWithdrawalsAmount(BigDecimal withdrawalsAmount) {
		this.withdrawalsAmount = withdrawalsAmount;
	}

	public String getDiskRealSeq() {
		return diskRealSeq;
	}

	public void setDiskRealSeq(String diskRealSeq) {
		this.diskRealSeq = diskRealSeq;
	}

	@Override
	public String toString() {
		return "ProfitDetailVO [diskSeq=" + diskSeq + ", diskRealSeq=" + diskRealSeq + ", idCard=" + idCard
				+ ", joinDiskTime=" + joinDiskTime + ", payUserId=" + payUserId + ", profitAmount=" + profitAmount
				+ ", profitTargetType=" + profitTargetType + ", profitUserId=" + profitUserId + ", roleId=" + roleId
				+ ", roleName=" + roleName + ", saveAmount=" + saveAmount + ", withdrawalsAmount=" + withdrawalsAmount
				+ ", diskType=" + diskType + ", nickNanme=" + nickNanme + ", diskCounter=" + diskCounter + "]";
	}
}