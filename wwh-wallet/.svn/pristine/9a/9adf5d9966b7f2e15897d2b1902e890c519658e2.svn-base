package com.wwh.service;

import java.math.BigDecimal;

/**
 * 钱包积分接口
 * @author asd
 * @version 1.0
 * @updated 09-11月-2016 14:36:47
 */
public interface IAmountScoreService {

	/**
	 * 增加积分，邀请积分奖励
	 * 
	 * @param increaseScore
	 * @param inviteUserId
	 * @param receiveUserId
	 */
	public int increaseMyScoreInvite(BigDecimal increaseScore, Long inviteUserId, Long receiveUserId);

	/**
	 * 增加积分，注册积分奖励
	 * 
	 * @param increaseScore
	 * @param inviteUserId
	 * @param receiveUserId
	 */
	public Integer increaseMyScoreRegister(BigDecimal increaseScore, Long inviteUserId, Long receiveUserId);

	/**
	 * 消耗积分
	 * 
	 * @param userId
	 * @param userUpScore
	 */
	public Integer useUpScore(Long userId, BigDecimal userUpScore);

}