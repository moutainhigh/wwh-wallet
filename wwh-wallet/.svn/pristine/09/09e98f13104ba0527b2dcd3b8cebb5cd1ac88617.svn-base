package com.wwh.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 收益详情表 ，由于 所有平台的收益详情表都一样，所以一个VO就够了。
 * 
 * @ClassName: ProfitVO
 * @Description: TODO
 * @author: yuzih
 * @date: 2016年10月25日 上午10:03:43
 */
public class ProfitVO extends BaseVO {

	private static final long serialVersionUID = -2307838182885191335L;

	/**
	 * 收益人
	 */
	private Long profitUserId;

	/**
	 * 收益金额
	 */
	private BigDecimal profitAmount = new BigDecimal(0);

	/**
	 * 储备金金额
	 */
	private BigDecimal saveAmount = new BigDecimal(0);

	/**
	 * 可提现金额
	 */
	private BigDecimal withdrawalsAmount = new BigDecimal(0);

	/**
	 * 枚举：收益目标类型： 平台 platform，会员 member
	 */
	private String profitTargetType;

	/**
	 * 本盘序号
	 */
	private String diskSeq = "";

	/**
	 * 枚举：收益来源 本盘 self，抢盘 grap
	 */
	private String profitFrom;

	/**
	 * 身份唯一编号
	 */
	private String idCard;

	/**
	 * 充值人
	 */
	private Long payUserId;

	/**
	 * 加入盘时间
	 */
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="CCT")
	private Date joinDiskTime;

	/**
	 * 角色编号
	 */
	private Long roleId;

	public BigDecimal getSaveAmount() {
		return saveAmount;
	}

	public void setSaveAmount(BigDecimal saveAmount) {
		this.saveAmount = saveAmount;
	}

	public BigDecimal getWithdrawalsAmount() {
		return withdrawalsAmount;
	}

	public void setWithdrawalsAmount(BigDecimal withdrawalsAmount) {
		this.withdrawalsAmount = withdrawalsAmount;
	}

	public Long getProfitUserId() {
		return profitUserId;
	}

	public void setProfitUserId(Long profitUserId) {
		this.profitUserId = profitUserId;
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
		this.profitTargetType = profitTargetType == null ? null : profitTargetType.trim();
	}

	public String getDiskSeq() {
		return diskSeq;
	}

	public void setDiskSeq(String diskSeq) {
		this.diskSeq = diskSeq == null ? null : diskSeq.trim();
	}

	public String getProfitFrom() {
		return profitFrom;
	}

	public void setProfitFrom(String profitFrom) {
		this.profitFrom = profitFrom == null ? null : profitFrom.trim();
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard == null ? null : idCard.trim();
	}

	public Long getPayUserId() {
		return payUserId;
	}

	public void setPayUserId(Long payUserId) {
		this.payUserId = payUserId;
	}

	public Date getJoinDiskTime() {
		return joinDiskTime;
	}

	public void setJoinDiskTime(Date joinDiskTime) {
		this.joinDiskTime = joinDiskTime;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}