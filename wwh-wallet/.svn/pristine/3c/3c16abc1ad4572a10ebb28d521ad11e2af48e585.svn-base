package com.wwh.vo;

import java.util.List;

/**
 * 
 * @ClassName: WalletAmountExtendVO
 * @Description: 用户钱包扩展类
 * @author: yuzih
 * @date: 2016年10月27日 上午11:22:58
 */
public class WalletAmountExtendVO extends WalletAmountVO {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -4402976503786572418L;

	/**
	 * 充值记录数量
	 */
	private Integer rcgRecordCounts = 0;
	/**
	 * 积分使用记录数量
	 */
	private Integer useRecordCounts = 0;
	/**
	 * 注册收益记录数量
	 */
	private Integer regRecordCounts = 0;
	/**
	 * 充值收益记录数量
	 */
	private Integer rcgProfitRecordCounts = 0;

	/**
	 * 所有积分收益数量
	 */
	private Integer allCounts = 0;

	public Integer getAllCounts() {
		return allCounts;
	}

	public void setAllCounts(Integer allCounts) {
		this.allCounts = allCounts;
	}

	/**
	 * 平台roleId
	 */
	private Long wwhRoleId;
	/**
	 * 是否是体验系统用户
	 */
	private boolean tiyan = false;
	/**
	 * 是否是惠民系统用户
	 */
	private boolean huimin = false;
	/**
	 * 是否是富民系统用户
	 */
	private boolean fumin = false;
	/**
	 * 是否是兴民系统用户
	 */
	private boolean xingmin = false;

	/**
	 * 用户邀请详情统计
	 */
	private PlatformInviteVO platformInviteVO;

	public Integer getRcgRecordCounts() {
		return rcgRecordCounts;
	}

	public void setRcgRecordCounts(Integer rcgRecordCounts) {
		this.rcgRecordCounts = rcgRecordCounts;
	}

	public Integer getUseRecordCounts() {
		return useRecordCounts;
	}

	public void setUseRecordCounts(Integer useRecordCounts) {
		this.useRecordCounts = useRecordCounts;
	}

	public Integer getRegRecordCounts() {
		return regRecordCounts;
	}

	public void setRegRecordCounts(Integer regRecordCounts) {
		this.regRecordCounts = regRecordCounts;
	}

	public Integer getRcgProfitRecordCounts() {
		return rcgProfitRecordCounts;
	}

	public void setRcgProfitRecordCounts(Integer rcgProfitRecordCounts) {
		this.rcgProfitRecordCounts = rcgProfitRecordCounts;
	}

	public Long getWwhRoleId() {
		return wwhRoleId;
	}

	public void setWwhRoleId(Long wwhRoleId) {
		this.wwhRoleId = wwhRoleId;
	}

	public PlatformInviteVO getPlatformInviteVO() {
		return platformInviteVO;
	}

	public void setPlatformInviteVO(PlatformInviteVO platformInviteVO) {
		this.platformInviteVO = platformInviteVO;
	}

	public boolean isTiyan() {
		return tiyan;
	}

	public void setTiyan(boolean tiyan) {
		this.tiyan = tiyan;
	}

	public boolean isHuimin() {
		return huimin;
	}

	public void setHuimin(boolean huimin) {
		this.huimin = huimin;
	}

	public boolean isFumin() {
		return fumin;
	}

	public void setFumin(boolean fumin) {
		this.fumin = fumin;
	}

	public boolean isXingmin() {
		return xingmin;
	}

	public void setXingmin(boolean xingmin) {
		this.xingmin = xingmin;
	}

	/**
	 * 
	 * @Title: setDiskType
	 * @Description: 自动判断用户拥有哪些系统
	 * @param milestoneVOs
	 * @return: void
	 */
	public void setDiskType(List<MilestoneVO> milestoneVOs) {
		if (milestoneVOs.size() == 0 || milestoneVOs == null) {
			return;
		}
		for (MilestoneVO milestoneVO : milestoneVOs) {
			switch (milestoneVO.getDiskType()) {
			case "TIYAN":
				this.setTiyan(true);
				break;
			case "HUIMIN":
				this.setHuimin(true);
				break;
			case "FUMIN":
				this.setFumin(true);
				break;
			case "XINGMIN":
				this.setXingmin(true);
				break;
			}
		}
	}

}
