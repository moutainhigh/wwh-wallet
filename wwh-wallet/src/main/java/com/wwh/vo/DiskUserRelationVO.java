package com.wwh.vo;

import java.math.BigDecimal;

/**
 * 
 * @ClassName: DiskUserRelationVO
 * @Description: 盘和用户之间的关系表(由于字段都一致，所以4个表合成一个)
 * @author: yuzih
 * @date: 2016年11月2日 下午3:15:09
 */
public class DiskUserRelationVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1337532959306026009L;

	/**
	 * 用户昵称
	 */
	private String nickName;
	/**
	 * 用户头像地址
	 */
	private String headImgUrl;
	/**
	 * 盘编号
	 */
	private String diskSeq;
	/**
	 * 盘状态
	 */
	private String diskStatus;
	/**
	 * 角色编号
	 */
	private Long roleId;
	/**
	 * 盘位置
	 */
	private Integer localtion;
	/**
	 * 用户身份唯一编号
	 */
	private String idCard;

	/**
	 * 该盘目前总收益
	 */
	private BigDecimal currentProfit;

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public BigDecimal getCurrentProfit() {
		return currentProfit;
	}

	public void setCurrentProfit(BigDecimal currentProfit) {
		this.currentProfit = currentProfit;
	}

	public String getDiskSeq() {
		return diskSeq;
	}

	public void setDiskSeq(String diskSeq) {
		this.diskSeq = diskSeq;
	}

	public String getDiskStatus() {
		return diskStatus;
	}

	public void setDiskStatus(String diskStatus) {
		this.diskStatus = diskStatus;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Integer getLocaltion() {
		return localtion;
	}

	public void setLocaltion(Integer localtion) {
		this.localtion = localtion;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
