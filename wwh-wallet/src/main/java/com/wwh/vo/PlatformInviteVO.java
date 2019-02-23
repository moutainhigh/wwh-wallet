package com.wwh.vo;

/**
 * 
 * @ClassName: PlatformInviteVO
 * @Description: 平台邀请总表
 * @author: yuzih
 * @date: 2016年11月4日 下午5:48:40
 */
public class PlatformInviteVO extends BaseVO {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -8544455279525500459L;
	/**
	 * 我
	 */
	private Long inviteUserId;
	/**
	 * 邀请总人数
	 */
	private Integer inviteTotalCounter = 0;
	/**
	 * 邀请充值了的总人数
	 */
	private Integer invitePayCounter = 0;
	/**
	 * 二级用户注册数量
	 */
	private Integer level2UserCounter = 0;

	/**
	 * 一级用户注册数量
	 */
	private Integer level1UserCounter = 0;

	public Integer getLevel1UserCounter() {
		return level1UserCounter;
	}

	public void setLevel1UserCounter(Integer level1UserCounter) {
		this.level1UserCounter = level1UserCounter;
	}

	public Integer getLevel2UserCounter() {
		return level2UserCounter;
	}

	public void setLevel2UserCounter(Integer level2UserCounter) {
		this.level2UserCounter = level2UserCounter;
	}

	public Long getInviteUserId() {
		return inviteUserId;
	}

	public void setInviteUserId(Long inviteUserId) {
		this.inviteUserId = inviteUserId;
	}

	public Integer getInviteTotalCounter() {
		return inviteTotalCounter;
	}

	public void setInviteTotalCounter(Integer inviteTotalCounter) {
		this.inviteTotalCounter = inviteTotalCounter;
	}

	public Integer getInvitePayCounter() {
		return invitePayCounter;
	}

	public void setInvitePayCounter(Integer invitePayCounter) {
		this.invitePayCounter = invitePayCounter;
	}

}
