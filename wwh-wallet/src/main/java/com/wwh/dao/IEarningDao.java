package com.wwh.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwh.vo.AgentProfitDetailVO;
import com.wwh.vo.AgentProfitVO;
import com.wwh.vo.BusinessRelationVO;
import com.wwh.vo.DiskProfitVO;
import com.wwh.vo.DiskTypeProfitVO;
import com.wwh.vo.DiskUserRelationVO;
import com.wwh.vo.MerchantsSalesRelationVO;
import com.wwh.vo.NullPointVO;
import com.wwh.vo.PlatformInviteDetailExtendVO;
import com.wwh.vo.PlatformInviteVO;
import com.wwh.vo.PlatformProfitExtendVO;
import com.wwh.vo.PointGrapRelationVO;
import com.wwh.vo.ProfitDetailVO;
import com.wwh.vo.RecommendVO;
import com.wwh.vo.UserVO;
import com.wwh.vo.WalletProfitDetailVO;

public interface IEarningDao {
	/**
	 * 
	 * @Title: getPlatformProfitByUserId
	 * @Description: 获取用户的平台收益详情(包括‘我的收益’，‘已提现’等)
	 * @param userId
	 * @return
	 * @return: PlatformProfitVO
	 */
	PlatformProfitExtendVO getPlatformProfitByUserId(Long userId);

	/**
	 * 
	 * @Title: getBusinessRelationByUserId
	 * @Description: 查询用户招的商家详情
	 * @param userId
	 * @return
	 * @return: BusinessRelationVO
	 */
	List<BusinessRelationVO> getBusinessRelationByUserId(Long userId);

	/**
	 * 
	 * @Title: getMerchantsSalesRelationByUserId
	 * @Description: 查询用户的某个商家的交易提成详情
	 *               如果不指定商家则查询出所有商家的交易提成详情（如果不指定请把businessUserId设置为null）
	 * @param userId
	 * @param businessUserId
	 * @return
	 * @return: MerchantsSalesRelationVO
	 */
	List<MerchantsSalesRelationVO> getMerchantsSalesRelationByUserId(@Param("userId") Long userId,
			@Param("businessUserId") Long businessUserId);

	/**
	 * 
	 * @Description: 获取用户某个盘的收益
	 * @param userId
	 * @param diskStatus
	 *            盘状态（FINISHED 结束 ，RUNNING 活动） 可为空
	 * @param diskSeq
	 *            盘号 ，可为空
	 * @param diskType
	 *            盘类型， 可为空
	 * @return
	 * @return: List<DiskProfitVO>
	 */
	List<DiskProfitVO> getDiskProfitByAnyThings(@Param("userId") Long userId, @Param("diskStatus") String diskStatus,
			@Param("diskSeq") String diskSeq, @Param("diskType") String diskType);

	/**
	 * 
	 * @Title: getMemberProfitDetailByUserId
	 * @Description: 获取用户在会员等级系统的收益流水
	 * @param userId
	 * @param diskType
	 * @return
	 * @return: List<ProfitDetailVO>
	 */
	List<ProfitDetailVO> getMemberProfitDetailByUserId(@Param("userId") Long userId,
			@Param("diskType") String diskType);

	/**
	 * 
	 * @Title: getUserDiskProfitByGrapPoint
	 * @Description: 获取用户抢点的收益
	 * @param userId
	 * @return
	 * @return: List<PointGrapRelationVO>
	 */
	List<PointGrapRelationVO> getDiskProfitByGrapPoint(@Param("userId") Long userId);

	/**
	 * 
	 * @Title: getUnderThePlateByUserId
	 * @Description: 获取用户所在盘下面三个子盘空点信息
	 * @param userId
	 * @return
	 * @return: List<NullPointVO>
	 */
	List<NullPointVO> getUnderThePlateNullPointByUserId(@Param("userId") Long userId,
			@Param("diskType") String diskType);

	/**
	 * 
	 * @Title: getUnderThePlateGrapPointByUserId
	 * @Description: 获取用户所在盘下面三个子盘抢点信息
	 * @param userId
	 * @param diskType
	 * @return
	 * @return: List<PointGrapRelationVO>
	 */
	List<PointGrapRelationVO> getUnderThePlateGrapPointByUserId(@Param("userId") Long userId,
			@Param("diskType") String diskType);

	/**
	 * 
	 * @Title: getDiskUserRelationByDiskSeq
	 * @Description: 获取某个盘里面每一个用户的详情
	 * @param diskType
	 * @param diskSeq
	 * @return
	 * @return: List<DiskUserRelationVO>
	 */
	List<DiskUserRelationVO> getDiskUserRelationByDiskSeq(@Param("diskType") String diskType,
			@Param("diskSeq") String diskSeq);

	/**
	 * 
	 * @Title: getRecommendDetail
	 * @Description: 获取用户在某个系统中邀请的人数
	 * @param diskType
	 * @param userId
	 * @return
	 * @return: List<RecommendVO>
	 */
	List<RecommendVO> getRecommendDetail(@Param("diskType") String diskType, @Param("userId") Long userId);

	/**
	 * 
	 * @Title: getPlatformInviteDetail
	 * @Description: 获取用户邀请注册的用户详情
	 * @param userId
	 * @return
	 * @return: List<PlatformInviteDetailVO>
	 */
	List<PlatformInviteDetailExtendVO> getPlatformInviteDetail(Long userId);

	/**
	 * 
	 * @Title: getPlatformInvite
	 * @Description: 获取用户平台邀请统计
	 * @param userId
	 * @return
	 * @return: PlatformInviteVO
	 */
	PlatformInviteVO getPlatformInvite(Long userId);

	/**
	 * 
	 * @Title: getLevel2Counter
	 * @Description: 获取用户二级用户数量 (注册即可)
	 * @param userId
	 * @return
	 * @return: Integer
	 */
	Integer getLevel2Counter(Long userId);

	/**
	 * 
	 * @Title: getProfitBySysType
	 * @Description: 获取某个系统的总收益
	 * @param diskType
	 * @param userId
	 * @return
	 * @return: BigDecimal
	 */
	DiskTypeProfitVO getProfitBySysType(@Param("diskType") String diskType, @Param("userId") Long userId);

	/**
	 * 
	 * @Title: getRcgBySysType
	 * @Description: 获取用户在某个系统的总充值记录
	 * @param diskType
	 * @param userId
	 * @return
	 * @return: BigDecimal
	 */
	BigDecimal getRcgBySysType(@Param("diskType") String diskType, @Param("userId") Long userId,
			@Param("payStatus") String payStatus);

	/**
	 * 
	 * @Title: getWithdrawalsAmountByType
	 * @Description: 查询用户在各个系统中的可提现金额
	 * @param diskType
	 * @param userId
	 * @return
	 * @return: BigDecimal
	 */
	BigDecimal getWithdrawalsAmountByType(@Param("diskType") String diskType, @Param("userId") Long userId);

	/**
	 * 
	 * @Title: getSaveAmountByType
	 * @Description: 查询用户在各个系统中的储备金
	 * @param diskType
	 * @param userId
	 * @return
	 * @return: BigDecimal
	 */
	BigDecimal getSaveAmountByType(@Param("diskType") String diskType, @Param("userId") Long userId);

	/**
	 * 根据用户id 查询用户在某个系统种最后有做一个角色id
	 * 
	 * @param diskType
	 * @param userId
	 * @return
	 */
	String getRoleByUserId(@Param("diskType") String diskType, @Param("userId") Long userId);

	/**
	 * 获取用户在当前系统中邀请的人数
	 * 
	 * @param diskType
	 * @param userId
	 * @return
	 */
	Integer selectInvitePerson(@Param("diskType") String diskType, @Param("userId") Long userId);

	List<UserVO> getUserPicUrl(@Param("userIds") List<Long> userIds);

	/**
	 * 获取用户等待晋升表记录总数
	 * 
	 * @param diskType
	 * @param userId
	 * @return
	 */
	Integer countUpWaittingRecords(@Param("diskType") String diskType, @Param("userId") Long userId);

	/**
	 * 
	 * @param diskType
	 * @param userId
	 * @return
	 */
	BigDecimal countUpWaittingSaveGold(@Param("diskType") String diskType, @Param("userId") Long userId);

	/**
	 * 查询
	 * 
	 * @param userId
	 * @param diskType
	 * @return
	 */
	List<ProfitDetailVO> queryMemberAllProfitInfo(@Param("userId") Long userId, @Param("diskType") String diskType);
	
	/**
	 * 
	 * @Title: addWalletProfitDetailVO 
	 * @Description: 插入系统收益流水表
	 * @param walletProfitDetailVO
	 * @return: void
	 */
	void addWalletProfitDetailVO(WalletProfitDetailVO walletProfitDetailVO);
	
	/**
	 * 
	 * @Title: addAgentProfitDetailVO 
	 * @Description: 添加代理商收益详情记录
	 * @param agentProfitDetailVO
	 * @return: void
	 */
	void addAgentProfitDetailVO(AgentProfitDetailVO agentProfitDetailVO);
	/**
	 * 
	 * @Title: updateAgentProfitVOByAgentId 
	 * @Description: 更新代理商收益统计表
	 * @param agentProfitVO
	 * @return: void
	 */
	void updateAgentProfitVOByAgentId(AgentProfitVO agentProfitVO);

}
