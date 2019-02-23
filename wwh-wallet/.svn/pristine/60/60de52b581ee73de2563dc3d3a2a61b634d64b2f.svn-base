package com.wwh.dao;

import java.util.List;

import com.wwh.vo.PlatformProfitVO;

/**
 * 
 * @ClassName: IPlatformProfitDao
 * @Description: 平台总收益表 wallet_platform_profit_t
 * @author: lilinxiang
 * @date: 2016年11月14日 上午1:36:59
 */
public interface IPlatformProfitDao {

	/**
	 * 
	 * @Title: selectByPlatformProfit
	 * @Description: 查询会员平台收益
	 * @param platformProfitVO
	 * @return
	 * @return: List<PlatformProfitVO>
	 */
	public List<PlatformProfitVO> selectByPlatformProfit(PlatformProfitVO platformProfitVO);

	/**
	 * 
	 * @Title: increasePlatformProfitByUserIdSelective
	 * @Description: 累加平台总收益表
	 * @param platformProfitVO
	 *            必须字段 user_id <br/>
	 * @return
	 * @return: Integer
	 */
	public Integer increasePlatformProfitByUserIdSelective(PlatformProfitVO platformProfitVO);

	/**
	 * 
	 * @Title: insertPlatformProfit
	 * @Description: 新增平台总收益表 wallet_platform_profit_t
	 * @param platformProfitVO
	 * @return
	 * @return: Integer
	 */
	public Integer insertPlatformProfit(PlatformProfitVO platformProfitVO);
	
	/**
	 * 
	 * @Title: updatePlatformProfitByUserId 
	 * @Description: 新增或者修改
	 * @param platformProfitVO
	 * @return: void
	 */
	public void updatePlatformProfitByUserId(PlatformProfitVO platformProfitVO);
}
