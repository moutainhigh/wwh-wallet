package com.wwh.vo;

import java.util.List;

/**
 * 
 * @ClassName: DefinedProfitConfigVO
 * @Description: 自定义 VO , 与业务表 无关
 * @author: lilinxiang
 * @date: 2016年11月12日 下午8:02:40
 */
public class DefinedProfitConfigVO {
	
	private Integer rechargeMan;

	private String profitMan;

	private List<String> profitManList;

	public Integer getRechargeMan() {
		return rechargeMan;
	}

	public void setRechargeMan(Integer rechargeMan) {
		this.rechargeMan = rechargeMan;
	}

	public String getProfitMan() {
		return profitMan;
	}

	public List<String> getProfitManList() {
		return profitManList;
	}

	public void setProfitManList(List<String> profitManList) {
		this.profitManList = profitManList;
	}

	public void setProfitMan(String profitMan) {
		this.profitMan = profitMan;
	}

	@Override
	public String toString() {
		return "DefinedProfitConfigVO [rechargeMan=" + rechargeMan + ", profitMan=" + profitMan + ", profitManList=" + profitManList + "]";
	}

	 
 
}
