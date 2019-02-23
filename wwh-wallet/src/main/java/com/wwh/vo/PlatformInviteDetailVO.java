package com.wwh.vo;

/**
 * 
 * @ClassName: PlatformInviteDetailVO
 * @Description: 平台邀请详情表
 * @author: yuzih
 * @date: 2016年11月4日 下午5:49:04
 */
public class PlatformInviteDetailVO extends BaseVO {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 3638303972407703090L;

	/**
	 * 邀请人
	 */
	private Long inviteUserId;
	/**
	 * 被邀请人
	 */
	private Long receiveUserId;
	/**
	 * 是否充值 Y N
	 */
	private String isRecharged;

	public Long getInviteUserId() {
		return inviteUserId;
	}

	public void setInviteUserId(Long inviteUserId) {
		this.inviteUserId = inviteUserId;
	}

	public Long getReceiveUserId() {
		return receiveUserId;
	}

	public void setReceiveUserId(Long receiveUserId) {
		this.receiveUserId = receiveUserId;
	}

	public String getIsRecharged() {
		return isRecharged;
	}

	public void setIsRecharged(String isRecharged) {
		this.isRecharged = isRecharged;
	}
}
