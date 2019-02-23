package com.wwh.vo;

/**
 * 
 * @ClassName: NullPointVO
 * @Description: 空点表
 * @author: yuzih
 * @date: 2016年11月2日 下午4:02:29
 */
public class NullPointVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description:
	 */
	private static final long serialVersionUID = 3486492160528949053L;

	/**
	 * 盘类型
	 */
	private String diskType;
	/**
	 * 盘编号
	 */
	private String diskSeq;
	/**
	 * 空点数
	 */
	private Integer emptyPoint;
	/**
	 * 用户编号
	 */
	private Long UserId;
	/**
	 * 用户身份唯一标识
	 */
	private String IdCard;

	/**
	 * 是否可用 Y,N
	 */
	private String isUsable;
	/**
	 * 用户昵称
	 */
	private String nickName = "无名氏";
	/**
	 * 用户身份
	 */
	private String roleName;
	/**
	 * 显示给用户的盘号
	 * 
	 * @return
	 */
	private String diskName;

	public String getDiskName() {
		return diskName;
	}

	public void setDiskName(String diskName) {
		this.diskName = diskName;
	}

	public Integer getEmptyPoint() {
		return emptyPoint;
	}

	public void setEmptyPoint(Integer emptyPoint) {
		this.emptyPoint = emptyPoint;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String getNickName() {
		return nickName;
	}

	@Override
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getDiskType() {
		return diskType;
	}

	public void setDiskType(String diskType) {
		this.diskType = diskType;
	}

	public String getDiskSeq() {
		return diskSeq;
	}

	public void setDiskSeq(String diskSeq) {
		this.diskSeq = diskSeq;
	}

	@Override
	public Long getUserId() {
		return UserId;
	}

	@Override
	public void setUserId(Long userId) {
		UserId = userId;
	}

	public String getIdCard() {
		return IdCard;
	}

	public void setIdCard(String idCard) {
		IdCard = idCard;
	}

	public String getIsUsable() {
		return isUsable;
	}

	public void setIsUsable(String isUsable) {
		this.isUsable = isUsable;
	}

	@Override
	public String toString() {
		return "NullPointVO [diskType=" + diskType + ", diskSeq=" + diskSeq + ", emptyPoint=" + emptyPoint + ", UserId=" + UserId + ", IdCard=" + IdCard
				+ ", isUsable=" + isUsable + ", nickName=" + nickName + ", roleName=" + roleName + ", diskName=" + diskName + "]";
	}

}
