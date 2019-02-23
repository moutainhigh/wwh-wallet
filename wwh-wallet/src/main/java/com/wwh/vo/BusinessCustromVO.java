package com.wwh.vo;

import java.math.BigDecimal;

/**
 * 
 * @ClassName: BusinessCustromVO
 * @Description: 招商分红页面自定义VO
 * @author: YuZihao
 * @date: 2016年11月6日 下午1:07:46
 */
public class BusinessCustromVO extends BaseVO {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -6635071594206468993L;

	/**
	 * 招商分红历史总收益
	 */
	private BigDecimal businessAmount = new BigDecimal(0);
	/**
	 * 招商分红已提现金额
	 */
	private BigDecimal businessUsedAmount = new BigDecimal(0);
	/**
	 * 今日分红
	 */
	private BigDecimal todayBusinessAmount = new BigDecimal(0);
	/**
	 * 近30天分红
	 */
	private BigDecimal NearlyThirtyDaysBusinessAmount = new BigDecimal(0);

	public BigDecimal getBusinessAmount() {
		return businessAmount;
	}

	public void setBusinessAmount(BigDecimal businessAmount) {
		this.businessAmount = businessAmount;
	}

	public BigDecimal getBusinessUsedAmount() {
		return businessUsedAmount;
	}

	public void setBusinessUsedAmount(BigDecimal businessUsedAmount) {
		this.businessUsedAmount = businessUsedAmount;
	}

	public BigDecimal getTodayBusinessAmount() {
		return todayBusinessAmount;
	}

	public void setTodayBusinessAmount(BigDecimal todayBusinessAmount) {
		this.todayBusinessAmount = todayBusinessAmount;
	}

	public BigDecimal getNearlyThirtyDaysBusinessAmount() {
		return NearlyThirtyDaysBusinessAmount;
	}

	public void setNearlyThirtyDaysBusinessAmount(BigDecimal nearlyThirtyDaysBusinessAmount) {
		NearlyThirtyDaysBusinessAmount = nearlyThirtyDaysBusinessAmount;
	}

}
