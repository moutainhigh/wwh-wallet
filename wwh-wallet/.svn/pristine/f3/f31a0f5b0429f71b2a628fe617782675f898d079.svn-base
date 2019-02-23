package com.wwh.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwh.vo.AssetExpenditureVO;
import com.wwh.vo.MilestoneVO;
import com.wwh.vo.PayVO;
import com.wwh.vo.PlatformProfitScoreVO;
import com.wwh.vo.PlatformScoreAwardConfigVO;
import com.wwh.vo.SaveGoldCustromVO;
import com.wwh.vo.ScoreUsageVO;
import com.wwh.vo.SystemWalletVO;
import com.wwh.vo.WalletAmountExtendVO;
import com.wwh.vo.WalletAmountVO;

/**
 * 
 * @ClassName: IScoreDao
 * @Description: 积分使用， 里程碑 接口 wallet_member_milestone_t
 * @author: lilinxiang
 * @date: 2016年11月9日 下午5:14:50
 */
public interface IScoreDao {

	/**
	 * @Title: getAllRechargeList
	 * @Description: 获取用户的充值详情
	 * @param map
	 * @return
	 * @return: List<PayVO>
	 */
	List<PayVO> getAllRechargeListByUserId(@Param("userId") Long userId, @Param("diskType") String diskType);

	/**
	 * 
	 * @Title: updateMilestoneByUserId
	 * @Description: 修改用户里程碑
	 * @param userId
	 * @return
	 * @return: Integer
	 */
	public Integer updateMilestoneByUserId(Long userId);

	/**
	 * 
	 * @Title: insertBatchMilestone
	 * @Description: 批量插入里程碑
	 * @param milestone
	 * @return
	 * @return: Integer
	 */
	public Integer insertBatchMilestone(MilestoneVO milestone);

	/**
	 * 
	 * @Title: insertMilestone
	 * @Description: 插入里程碑
	 * @param milestone
	 * @return
	 * @return: Integer
	 */
	public Integer insertMilestone(MilestoneVO milestone);

	/**
	 * @Title: getUserLevelByUser
	 * @Description: 查询用户拥有那些里程碑
	 * @param userVo
	 * @return
	 * @return: List<MilestoneVO>
	 */
	List<MilestoneVO> getMilestoneByUserId(Long userId);

	/**
	 * @Title: getUserWalletDetailByUser
	 * @Description: 获取用户钱包详情
	 * @param userVo
	 * @return
	 * @return: WalletAmountVO
	 */
	WalletAmountExtendVO getWalletByUserId(Long userId);

	/**
	 * @Title: getUserWalletDetailByUser
	 * @Description: 获取用户钱包详情
	 * @param userVo
	 * @return
	 * @return: WalletAmountVO
	 */
	SaveGoldCustromVO getWalletByUserId2(Long userId);

	/**
	 * 
	 * @Title: getUserScoreUsageByUserId
	 * @Description: 获取用户积分使用记录
	 * @param userId
	 * @return
	 * @return: List<ScoreUsageVO>
	 */
	List<ScoreUsageVO> getScoreUsageByUserId(Long userId);

	/**
	 * 
	 * @Title: getUserScoreProfitDetail
	 * @Description: 获取用户注册积分收益记录
	 * @param userId
	 * @return
	 * @return: List<PlatformProfitScoreVO>
	 */
	List<PlatformProfitScoreVO> getRegistScoreProfitDetailByUserId(@Param("userId") Long userId);
	
	/**
	 * 
	 * @Title: getAllScoreProfitDetailByUserId 
	 * @Description: 获取用户积分收益流水表的所有记录
	 * @param userId
	 * @return
	 * @return: List<PlatformProfitScoreVO>
	 */
	List<PlatformProfitScoreVO> getAllScoreProfitDetailByUserId(@Param("userId") Long userId);

	/**
	 * 
	 * @Title: getUserScoreProfitDetail
	 * @Description: 获取用户充值积分收益记录
	 * @param userId
	 * @return
	 * @return: List<PlatformProfitScoreVO>
	 */
	List<PlatformProfitScoreVO> getChargeScoreProfitDetailByUserId(@Param("userId") Long userId);

	/**
	 * 
	 * @Title: getScoreRcgConfig
	 * @Description: 获取充值积分奖励配置
	 * @param payType
	 * @return
	 * @return: BigDecimal
	 */
	BigDecimal getScoreRcgConfig(String payType);

	/**
	 * 
	 * @Title: insertScoreProfitRecord
	 * @Description: 插入积分收益流水表
	 * @param platformProfitScoreVO
	 * @return
	 * @return: Boolean
	 */
	Boolean insertScoreProfitRecord(PlatformProfitScoreVO platformProfitScoreVO);

	/**
	 * 
	 * @Title: updateWallteScore
	 * @Description: 更新钱包数据
	 * @param walletAmountVO
	 * @return
	 * @return: Boolean
	 */
	Boolean updateWallteScore(WalletAmountVO walletAmountVO);

	/**
	 * 
	 * @Title: updateRcgIsCalcuated
	 * @Description: 修改充值记录为已计算
	 * @param paySeq
	 * @param payAmountType
	 * @return
	 * @return: Boolean
	 */
	Boolean updateRcgIsCalcuated(@Param("paySeq") String paySeq, @Param("payAmountType") String payAmountType);

	/**
	 * 
	 * @Title: getScoreAwardConfigVO
	 * @Description: 查询充值积分赠送配置表
	 * @param diskType
	 * @return
	 * @return: PlatformScoreAwardConfigVO
	 */
	PlatformScoreAwardConfigVO getScoreAwardConfigVO(@Param("diskType") String diskType);

	/**
	 * 
	 * @Title: updateSystemProfitByVO
	 * @Description: 修改系统收益表
	 * @param systemWalletVO
	 * @return: void
	 */
	void updateSystemProfitByVO(SystemWalletVO systemWalletVO);
	
	void addAssetExpenditureVO(AssetExpenditureVO assetExpenditureVO);
}
