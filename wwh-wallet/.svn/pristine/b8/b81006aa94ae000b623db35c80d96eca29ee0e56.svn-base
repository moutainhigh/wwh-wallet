package com.wwh.service;

import java.math.BigDecimal;
import java.util.List;

import com.wwh.common.ResultMsg;
import com.wwh.vo.ExternalVO;
import com.wwh.vo.OrderVO;
import com.wwh.vo.UserVO;

public interface IExternalService {

	/**
	 * 
	 * @Title: relation
	 * @Description: 记录邀请关系
	 * @param inviteUserId
	 * @param receiveUserId
	 * @return
	 * @throws Exception
	 * @return: ResultMsg<Object>
	 */
	public ResultMsg<Object> relation(ExternalVO externalVO) throws Exception;

	/**
	 * 
	 * @Title: registerMember
	 * @Description: 注册
	 * @param inviteUserId
	 * @param receiveUserId
	 * @return
	 * @throws Exception
	 * @return: ResultMsg<Object>
	 */
	public ResultMsg<Object> registerMember(ExternalVO externalVO) throws Exception;
	
	/**
	 * 
	 * @Title: calcScore
	 * @Description: 用户注册实名认证后给用户和用户推荐人赠送积分
	 * @param externalVO
	 * @throws Exception
	 * @return: void
	 */
	public ResultMsg<Object> giveScore(ExternalVO externalVO) throws Exception;

	/**
	 * 
	 * @Title: recordWalletUser
	 * @Description: 记录钱包用户信息
	 * @param userVO
	 * @throws Exception
	 * @return: void
	 */
	public void recordWalletUser(OrderVO orderVO) throws Exception;

	/**
	 * 
	 * @Title: recordWalletUserRole
	 * @Description: 记录钱包用户角色关系
	 * @param userVO
	 * @throws Exception
	 * @return: void
	 */
	public void recordWalletUserRole(Long userId, Long roleId) throws Exception;

	/**
	 * 
	 * @Title: recordUserRelation
	 * @Description: 记录邀请关系流水信息
	 * @param inviteUserId
	 * @param receiveUserId
	 * @throws Exception
	 * @return: void
	 */
	public void recordUserRelation(Long inviteUserId, Long receiveUserId) throws Exception;

	/**
	 * 
	 * @Title: calcInvitationNum
	 * @Description: 计算邀请人一级用户数量
	 * @param inviteUserId
	 * @param receiveUserId
	 * @throws Exception
	 * @return: void
	 */
	public void calcInvitationNum(Long inviteUserId, Long receiveUserId) throws Exception;

	/**
	 * 
	 * @Title: calcParentInvitationNum
	 * @Description: 计算邀请人上级的二级用户数量
	 * @param inviteUserId
	 * @param receiveUserId
	 * @throws Exception
	 * @return: void
	 */
	public void calcParentInvitationNum(Long inviteUserId, Long receiveUserId) throws Exception;

	/**
	 * 
	 * @Title: recordInviteProfitScore
	 * @Description: 记录邀请者所得收益积分流水信息
	 * @param inviteUserId
	 * @param receiveUserId
	 * @param score
	 * @param scoreRemark
	 * @throws Exception
	 * @return: void
	 */
	public void recordInviteProfitScore(Long inviteUserId, Long receiveUserId, BigDecimal score, String profitScoretype, String scoreRemark) throws Exception;

	/**
	 * 
	 * @Title: recordReceiveProfitScore
	 * @Description: 记录被邀请者所得收益积分流水信息
	 * @param inviteUserId
	 * @param receiveUserId
	 * @param score
	 * @param scoreRemark
	 * @throws Exception
	 * @return: void
	 */
	public void recordReceiveProfitScore(Long inviteUserId, Long receiveUserId, BigDecimal score, String profitScoretype, String scoreRemark) throws Exception;

	/**
	 * 
	 * @Title: calcInviteWalletProfitScore
	 * @Description: 计算邀请者钱包收益积分
	 * @param inviteUserId
	 * @param receiveUserId
	 * @param score
	 * @throws Exception
	 * @return: void
	 */
	public void calcInviteWalletProfitScore(Long inviteUserId, Long receiveUserId, BigDecimal score) throws Exception;

	/**
	 * 
	 * @Title: calcReceiveWalletProfitScore
	 * @Description: 计算被邀请者钱包收益积分
	 * @param inviteUserId
	 * @param receiveUserId
	 * @param score
	 * @throws Exception
	 * @return: void
	 */
	public void calcReceiveWalletProfitScore(Long inviteUserId, Long receiveUserId, BigDecimal score) throws Exception;

	/**
	 * 
	 * @Title: getRegisterAwardScore
	 * @Description: 获取平台注册奖励积分
	 * @return
	 * @throws Exception
	 * @return: Double
	 */
	public BigDecimal getRegisterAwardScore() throws Exception;

	/**
	 * 
	 * @Title: getRemainScore
	 * @Description: 获取用户剩余积分
	 * @param userId
	 * @return
	 * @throws Exception
	 * @return: BigDecimal
	 */
	public ResultMsg<Object> getRemainScore(String memberId) throws Exception;

	/**
	 * 
	 * @Title: returnScore
	 * @Description: 新增积分
	 * @param userId
	 * @return
	 * @throws Exception
	 * @return: ResultMsg<Object>
	 */
	public ResultMsg<Object> returnScore(ExternalVO externalVO) throws Exception;

	/**
	 * 
	 * @Title: subscore
	 * @Description: 扣除积分
	 * @param userId
	 * @return
	 * @throws Exception
	 * @return: ResultMsg<Object>
	 */
	public ResultMsg<Object> subScore(List<ExternalVO> exList, String memberId) throws Exception;

	/**
	 * 
	 * @Title: recordUsageScore
	 * @Description: 记录已使用积分流水信息
	 * @param userId
	 * @param score
	 * @throws Exception
	 * @return: void
	 */
	public void recordUsageScore(Long userId, BigDecimal uasgeScore, String orderNumber, BigDecimal orderAmount) throws Exception;

	/**
	 * 
	 * @Title: bonus
	 * @Description: 推荐商家交易金额1%红利收益
	 * @param orderVO
	 * @return
	 * @throws Exception
	 * @return: ResultMsg<Object>
	 */
	public ResultMsg<Object> bonus(List<ExternalVO> exList, String memberId) throws Exception;

	/**
	 * 
	 * @Title: bonus
	 * @Description: 记录商家销售所产生的推广收益流水信息
	 * @param orderVO
	 * @throws Exception
	 * @return: void
	 */
	public void recordBonus(OrderVO orderVO) throws Exception;

	/**
	 * 
	 * @Title: getSaleAmount
	 * @Description: 商家交易配置返红利金额
	 * @return
	 * @throws Exception
	 * @return: BigDecimal
	 */
	public float getSaleAmount() throws Exception;

	/**
	 * 
	 * @Title: calcReferenceProfit
	 * @Description: 计算用户平台收益金额
	 * @return: void
	 */
	public void calcPlatformAmount(OrderVO orderVO) throws Exception;

	/**
	 * 
	 * @Title: calcReferenceWallet
	 * @Description: 计算系统用户钱包收入支出金额
	 * @return: void
	 */
	public void calcWalletAmount(OrderVO orderVO) throws Exception;

	/**
	 * 
	 * @Title: recordBusiness
	 * @Description: 记录商家和用户关系
	 * @param externalVO
	 * @return
	 * @throws Exception
	 * @return: ResultMsg<Object>
	 */
	public ResultMsg<Object> recordBusiness(ExternalVO externalVO) throws Exception;

	/**
	 * 
	 * @Title: recordSystemAmount
	 * @Description: 记录平台支出流水记录
	 * @param externalVO
	 * @throws Exception
	 * @return: void
	 */
	public void recordExpenditureAmount(OrderVO orderVO) throws Exception;

	/**
	 * 
	 * @Title: calcSystemAmount
	 * @Description: 计算系统钱包金额
	 * @param orderVO
	 * @throws Exception
	 * @return: void
	 */
	public void calcSystemAmount(OrderVO orderVO) throws Exception;

	/**
	 * 
	 * @Title: calcSystemScore
	 * @Description: 计算系统钱包积分
	 * @param orderVO
	 * @throws Exception
	 * @return: void
	 */
	public void calcSystemScore(Long systemId, BigDecimal score) throws Exception;

	/**
	 * 
	 * @Title: returnAmount
	 * @Description: 用户消费推荐用户会获得相应的金币分润
	 * @param exList
	 * @param memberId
	 * @return
	 * @throws Exception
	 * @return: ResultMsg<Object>
	 */
	public ResultMsg<Object> returnAmount(List<ExternalVO> exList, String memberId) throws Exception;

	/**
	 * 
	 * @Title: recordUserProfit
	 * @Description: 记录用户分润明细
	 * @param orderVO
	 * @throws Exception
	 * @return: void
	 */
	public void recordUserProfit(OrderVO orderVO) throws Exception;
	/**
	 * 用户注册实名认证后给用户和用户推荐人赠送积分
	 * @param externalVO
	 * @throws Exception
	 */
	public void giveScoreMethod(ExternalVO externalVO)throws Exception;
	
	/**
	 * 商城修改用户基本信息
	 * @param vo
	 * @return
	 */
	public int modifyMobilePhoneByUserId(UserVO vo) throws Exception;

}
