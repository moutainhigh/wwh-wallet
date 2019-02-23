package com.wwh.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @ClassName: MerchantsSalesRelationVO
 * @Description: 商品销售关系表
 * @author: yuzih
 * @date: 2016年10月28日 下午2:19:57
 */
public class MerchantsSalesRelationVO extends BaseVO {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 3962341733668177722L;
	/**
	 * 订单编号
	 */
	private String orderNumber;
	/**
	 * 使用积分
	 */
	private BigDecimal scoreUsage;
	/**
	 * 商品交易时间
	 */
	private Date saleTime;
	/**
	 * 实际付款金额
	 */
	private BigDecimal orderAmount;
	/**
	 * 订单状态 枚举
	 */
	private String orderStatus;
	/**
	 * 用户收益
	 */
	private BigDecimal myProfitAmount;
	/**
	 * 商家编号
	 */
	private Long businessUserId;
	/**
	 * 订单状态名称
	 */
	private String orderStatusName;
	/**
	 * 商家名称
	 */
	private String businessName;

	public String getOrderStatusName() {
		if (orderStatus.equals("SUCCESSED")) {
			orderStatusName = "交易成功";
		}
		if (orderStatus.equals("CANCELED")) {
			orderStatusName = "交易失败";
		}
		if (orderStatus.equals("RETURNED")) {
			orderStatusName = "退货退款";
		}
		if (orderStatus.equals("NEWED")) {
			orderStatusName = "新建";
		}
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public BigDecimal getScoreUsage() {
		return scoreUsage;
	}

	public void setScoreUsage(BigDecimal scoreUsage) {
		this.scoreUsage = scoreUsage;
	}

	public Date getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public BigDecimal getMyProfitAmount() {
		return myProfitAmount;
	}

	public void setMyProfitAmount(BigDecimal myProfitAmount) {
		this.myProfitAmount = myProfitAmount;
	}

	public Long getBusinessUserId() {
		return businessUserId;
	}

	public void setBusinessUserId(Long businessUserId) {
		this.businessUserId = businessUserId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
}
