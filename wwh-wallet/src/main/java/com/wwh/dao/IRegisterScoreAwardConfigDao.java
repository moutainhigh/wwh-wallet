package com.wwh.dao;

import com.wwh.vo.RegisterScoreAwardConfigVO;

public interface IRegisterScoreAwardConfigDao {
	/**
	 * 拿到盘当前积分奖励配置
	 * 
	 * @param language
	 * @param operatorId
	 */
	public Double getCurrentPlatformScoreAward();
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: TODO
	 * @param registerScoreAwardConfigVO
	 * @return
	 * @return: int
	 */
	public int insert(RegisterScoreAwardConfigVO registerScoreAwardConfigVO);  
	
	/**
	 * 更新平台注册积分奖励
	 * @Title: updateRegisterScoreAwardConfig 
	 * @Description: 更新平台注册奖励积分配置信息
	 * @param registerScoreAwardConfigVO
	 * @return
	 * @return: Integer
	 */
	public Integer updateRegisterScoreAwardConfig(RegisterScoreAwardConfigVO registerScoreAwardConfigVO);
	/**
	 * 获取配置积分详情信息
	 * @Title: getReisterScorAwardConfigInfo 
	 * @Description: TODO
	 * @return
	 * @return: RegisterScoreAwardConfigVO
	 */
	public RegisterScoreAwardConfigVO getReisterScorAwardConfigInfo();
}
