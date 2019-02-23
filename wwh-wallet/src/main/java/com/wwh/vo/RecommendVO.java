package com.wwh.vo;

/**
 * 
 * @ClassName: RecommendVO
 * @Description: 推荐点表（也就是邀请关系表） 不同系统有不同的表，但是字段内容都一样。
 * @author: yuzih
 * @date: 2016年11月4日 上午8:53:54
 */
public class RecommendVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -3235967820694505061L;

	/**
	 * 邀请人
	 */
	private Long inviteUserId;
	/**
	 * 被邀请人
	 */
	private Long receiveUserId;
	/**
	 * 是否直系
	 */
	private String isDirect;

	public String getIsDirect() {
		return isDirect;
	}

	public void setIsDirect(String isDirect) {
		this.isDirect = isDirect;
	}

	/**
	 * 被邀请人昵称
	 */
	private String nickName;
	/**
	 * 系统类型
	 */
	private String diskType;

	public String getDiskType() {
		return diskType;
	}

	public void setDiskType(String diskType) {
		this.diskType = diskType;
	}

	@Override
	public String getNickName() {
		return nickName;
	}

	@Override
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

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

}
