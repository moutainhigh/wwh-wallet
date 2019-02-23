package com.wwh.vo;

public class MemberCareerCustromVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 3991438472446920845L;

	/**
	 * 体验系统
	 */
	private MemberCareerSystemDetailCustromVO tiyan;
	/**
	 * 惠民系统
	 */
	private MemberCareerSystemDetailCustromVO huimin;
	/**
	 * 富民系统
	 */
	private MemberCareerSystemDetailCustromVO fumin;
	/**
	 * 兴民系统
	 */
	private MemberCareerSystemDetailCustromVO xingmin;

	public MemberCareerSystemDetailCustromVO getTiyan() {
		return tiyan;
	}

	public void setTiyan(MemberCareerSystemDetailCustromVO tiyan) {
		this.tiyan = tiyan;
	}

	public MemberCareerSystemDetailCustromVO getHuimin() {
		return huimin;
	}

	public void setHuimin(MemberCareerSystemDetailCustromVO huimin) {
		this.huimin = huimin;
	}

	public MemberCareerSystemDetailCustromVO getFumin() {
		return fumin;
	}

	public void setFumin(MemberCareerSystemDetailCustromVO fumin) {
		this.fumin = fumin;
	}

	public MemberCareerSystemDetailCustromVO getXingmin() {
		return xingmin;
	}

	public void setXingmin(MemberCareerSystemDetailCustromVO xingmin) {
		this.xingmin = xingmin;
	}

}
