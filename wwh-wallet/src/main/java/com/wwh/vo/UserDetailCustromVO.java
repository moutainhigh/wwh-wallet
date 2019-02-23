package com.wwh.vo;

import java.math.BigDecimal;

/**
 * 
 * @ClassName: UserDetailCustromVO
 * @Description: 手机端用户收益页面自定义VO
 * @author: yuzih
 * @date: 2016年12月22日 上午11:52:02
 */
public class UserDetailCustromVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -8467402443247191474L;

	/**
	 * 用户头像
	 */
	private String headIMG;
	/**
	 * 直推人数
	 */
	private Integer directPush;
	/**
	 * 盘号
	 */
	private String diskSeq;
	/**
	 * 盘名
	 */
	private String diskName;
	/**
	 * 角色编号
	 */
	private Long roleId;
	/**
	 * 盘中位置
	 */
	private Integer location;
	/**
	 * 当前收益
	 */
	private BigDecimal currentProfit;
	/**
	 * 储备金
	 */
	private BigDecimal saveAmount;
	/**
	 * 可提现
	 */
	private BigDecimal withdrawalsAmount;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 身份编号
	 */
	private String idCard;

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getHeadIMG() {
		return headIMG;
	}

	public void setHeadIMG(String headIMG) {
		this.headIMG = headIMG;
	}

	public Integer getDirectPush() {
		return directPush;
	}

	public void setDirectPush(Integer directPush) {
		this.directPush = directPush;
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

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public BigDecimal getCurrentProfit() {
		return currentProfit;
	}

	public void setCurrentProfit(BigDecimal currentProfit) {
		this.currentProfit = currentProfit;
	}

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

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
