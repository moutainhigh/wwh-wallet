package com.wwh.vo;

/**
 * @ClassName: EliminateVO
 * @Description: 淘汰表
 * @author: yuzih
 * @date: 2016年12月11日 下午3:56:52
 */
public class EliminateVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 612017425241192604L;

	/**
	 * 盘号
	 */
	private String diskSeq;
	/**
	 * 身份ID
	 */
	private Long roleId;
	/**
	 * 淘汰类型
	 */
	private String eliminateType;
	/**
	 * 淘汰备注
	 */
	private String eliminateRemark;;
	/**
	 * 淘汰的IDCARD
	 */
	private String idCard;

	public String getDiskSeq() {
		return diskSeq;
	}

	public void setDiskSeq(String diskSeq) {
		this.diskSeq = diskSeq;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getEliminateType() {
		return eliminateType;
	}

	public void setEliminateType(String eliminateType) {
		this.eliminateType = eliminateType;
	}

	public String getEliminateRemark() {
		return eliminateRemark;
	}

	public void setEliminateRemark(String eliminateRemark) {
		this.eliminateRemark = eliminateRemark;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

}
