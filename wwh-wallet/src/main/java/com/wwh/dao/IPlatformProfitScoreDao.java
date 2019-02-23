package com.wwh.dao;

import java.util.List;

import com.wwh.vo.PlatformProfitScoreVO;

/**
 * 
 * @ClassName: IPlatformProfitScoreDao 
 * @Description:平台积分收益详情表 wallet_platform_profit_score_t 
 * @author:  lilinxiang
 * @date: 2016年11月9日 下午5:20:39
 */
public interface IPlatformProfitScoreDao {

	
	/**
	 * 
	 * @Title: getById 
	 * @Description: 获得平台积分收益详情，通过id
	 * @param id
	 * @return
	 * @return: PlatformProfitScoreVO
	 */
	public PlatformProfitScoreVO getById(Long id);
	
	
	public Integer updatePlatformInviteByUserId(PlatformProfitScoreVO platformProfitScoreVO);
	
	/**
	 * 
	 * @Title: updatePlatformInviteById 
	 * @Description: 修改平台积分收益详情
	 * @param platformProfitScoreVO
	 * @return
	 * @return: Integer
	 */
	public Integer updatePlatformInviteById(PlatformProfitScoreVO platformProfitScoreVO);
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入平台积分收益详情
	 * @param platformProfitScoreVO
	 * @return
	 * @return: Long
	 */
	public Integer insert(PlatformProfitScoreVO platformProfitScoreVO);
	
	/**
	 * 
	 * @Title: insertBatch 
	 * @Description: 批量插入平台积分收益详情
	 * @param records
	 * @return
	 * @return: Integer
	 */
	public Integer insertBatch(List<PlatformProfitScoreVO> records);
}
