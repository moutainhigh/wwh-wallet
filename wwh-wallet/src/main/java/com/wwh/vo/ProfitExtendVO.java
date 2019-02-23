package com.wwh.vo;

/**
 * 
 * @ClassName: ProfitCustomVO
 * @Description: 收益详情类的扩展类
 * @author: yuzih
 * @date: 2016年10月26日 下午3:38:38
 */
public class ProfitExtendVO extends ProfitVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8887634567454332128L;


	/**
	 * 充值用户昵称
	 */
	private String payNickName;

	/**
	 * 身份描述
	 */
	private String role;

	/**
	 * 盘内当前会员的人数
	 */
	private Integer diskCounter = 0;

	public Integer getDiskCounter() {
		return diskCounter;
	}

	public void setDiskCounter(Integer diskCounter) {
		this.diskCounter = diskCounter;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPayNickName() {
		return payNickName;
	}

	public void setPayNickName(String payNickName) {
		this.payNickName = payNickName;
	}

}
