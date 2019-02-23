package com.wwh.service;

import java.util.List;

import com.wwh.common.PagedResult;
import com.wwh.vo.MilestoneVO;
import com.wwh.vo.PayVO;
import com.wwh.vo.PlatformProfitScoreVO;
import com.wwh.vo.ScoreUsageVO;
import com.wwh.vo.UserVO;
import com.wwh.vo.WalletAmountExtendVO;
/**
 * 
 * @ClassName: IScoreService 
 * @Description: 个人积分service
 * @author: yuzih
 * @date: 2016年10月27日 下午1:50:16
 */
public interface IScoreService {

	/**
	 * 
	 * @Title: getUserWalletByUser
	 * @Description: 获取用户的钱包信息
	 * @param userVo
	 * @return
	 * @return: WalletAmountVO
	 */
	WalletAmountExtendVO getUserWalletByUser(UserVO userVo);


	/**
	 * @Title: getUserMilestoneVoByUser
	 * @Description: 获取用户所有的里程碑
	 * @param userVo
	 * @return
	 * @return: List<MilestoneVO>
	 */
	List<MilestoneVO> getUserMilestoneVoByUser(UserVO userVo);

	/**
	 * @Title: getRechargeListByUser
	 * @Description: 根据用户名获取充值记录 分页
	 * @param userVo
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            每页多少记录
	 * @return
	 * @return: PagedResult<PayVO>
	 */
	PagedResult<PayVO> getRechargeListByUser(UserVO userVo, String diskType,Integer currentPage, Integer pageSize);

	/**
	 * 
	 * @Title: getUserScoreUsageByUserId
	 * @Description: 获取用户积分使用记录
	 * @param userId
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @return: PagedResult<ScoreUsageVO>
	 */
	PagedResult<ScoreUsageVO> getUserScoreUsageByUserId(UserVO userVo, Integer currentPage, Integer pageSize);

	/**
	 * 
	 * @Title: getScoreProfitByUserId
	 * @Description: 获取注册积分收益记录
	 * @param userId
	 * @param profitScoreType
	 *            枚举，ProfitScoreTypeEnum
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @return: PagedResult<PlatformProfitScoreVO>
	 */
	PagedResult<PlatformProfitScoreVO> getRegistScoreProfitByUserId(UserVO userVo, Integer currentPage,Integer pageSize);
	
	/**
	 * 获取充值积分收益记录
	 * @param userVo
	 * @param profitScoreType
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PagedResult<PlatformProfitScoreVO> getChargeScoreProfitByUserId(UserVO userVo, Integer currentPage,Integer pageSize);
}
