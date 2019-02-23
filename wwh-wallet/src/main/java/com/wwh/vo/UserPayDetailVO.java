package com.wwh.vo;

import java.math.BigDecimal;

/**
 * use under500 500 5000 50000 不等充值金额
 * 
 * @ClassName: PayDetailVO
 * @author: Administrator
 * @date: 2016年10月25日 下午4:45:23
 */
public class UserPayDetailVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 5760361565300294705L;

	/**
	 * 唯一序列号
	 */
	private String paySeq;

	/**
	 * 获得积分
	 */
	private BigDecimal score;

	/**
	 * 充值金额
	 */
	private BigDecimal amount;
	/**
	 * 是否计算
	 */
	private String isCalcuated;
	/**
	 * 充值状态
	 */
	private String payStatus;
	/**
	 * 对接第三方充值成功后返回吗
	 */
	private String returnCode;
	public String getPaySeq() {
		return paySeq;
	}
	public void setPaySeq(String paySeq) {
		this.paySeq = paySeq;
	}
	public BigDecimal getScore() {
		return score;
	}
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getIsCalcuated() {
		return isCalcuated;
	}
	public void setIsCalcuated(String isCalcuated) {
		this.isCalcuated = isCalcuated;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	

}
