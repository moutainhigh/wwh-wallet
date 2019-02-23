package com.wwh.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwh.vo.AwardDetailVO;
import com.wwh.vo.MCounsumptionDetailVO;
import com.wwh.vo.MGrapPointProfitVO;
import com.wwh.vo.MPayRecordsVO;
import com.wwh.vo.MpersonalCenterVO;
import com.wwh.vo.MpersonalInfoVO;
import com.wwh.vo.PersonalVO;
import com.wwh.vo.PlatformProfitScoreVO;
import com.wwh.vo.UserVO;

public interface IMInterfaceDao {

	/**
	 * 手机端，获取用户个人中心页面信息
	 * 
	 * @param userId
	 * @return
	 */
	MpersonalCenterVO getPersonalInfo(Long userId);

	/**
	 * 查询用户当总监得次数
	 * 
	 * @param diskType
	 * @param userId
	 * @return
	 */
	Integer getDirectorTimes(@Param("diskType") String diskType, @Param("userId") Long userId);

	/**
	 * 查询用户在某个系统得最大收益数
	 * 
	 * @param diskType
	 * @param userId
	 * @return
	 */
	BigDecimal maxProfit(@Param("diskType") String diskType, @Param("userId") Long userId);

	/**
	 * 查询用户满点晋升次数
	 * 
	 * @param diskType
	 * @param userId
	 * @return
	 */
	Integer fullPointsToDirector(@Param("diskType") String diskType, @Param("userId") Long userId);

	/**
	 * 查询用户用时最短的盘时间
	 * 
	 * @param diskType
	 * @param userId
	 * @return
	 */
	Long shortestTimeInDisk(@Param("diskType") String diskType, @Param("userId") Long userId);

	/**
	 * 查询用户的里程碑信息
	 * 
	 * @param diskType
	 * @param userId
	 * @return
	 */
	Long selectMilstoneInfo(@Param("diskType") String diskType, @Param("userId") Long userId);

	/**
	 * 查询用户的个人信息
	 * 
	 * @return
	 */
	MpersonalInfoVO selectPersonalInfo(Long userId);

	/**
	 * 获取用户平台积分收益记录
	 * 
	 * @param userId
	 * @return
	 */
	List<PlatformProfitScoreVO> getPlatformProfitScore(Long userId);

	/**
	 * 获取用户的充值记录
	 * 
	 * @param userId
	 * @return
	 */
	List<MPayRecordsVO> getPayRecordsInfo(Long userId);

	/**
	 * 获取总消费分红收益
	 * 
	 * @param userId
	 * @return
	 */
	BigDecimal getTotalCounsumProfit(Long userId);

	/**
	 * 获取今日的消费分红收益
	 * 
	 * @param userId
	 * @return
	 */
	BigDecimal getTodayCounsumProfit(Long userId);

	/**
	 * 获取最近一个月的消费分红收益
	 * 
	 * @param userId
	 * @return
	 */
	BigDecimal getMonthCounsumProfit(Long userId);

	/**
	 * 消费分红收益详情
	 * 
	 * @param userId
	 * @return
	 */
	List<MCounsumptionDetailVO> mCounsumptionDetail(Long userId);

	/**
	 * 抢点收益记录
	 * 
	 * @param userId
	 * @return
	 */
	List<MGrapPointProfitVO> grapProfitDetail(Long userId);

	/**
	 * 获取总的抢点收益
	 * 
	 * @param userId
	 * @return
	 */
	BigDecimal getTotalGrapDetail(Long userId);

	/**
	 * 返回用户的id
	 * 
	 * @param param
	 * @return
	 */
	UserVO getUserInfo(String param);

	/**
	 * 更新钱包的用户密码
	 * 
	 * @param password
	 * @param userId
	 */
	Integer updateWpassword(String password, Long userId);

	/**
	 * 更新商城用户密码
	 * 
	 * @param password
	 * @param userId
	 */
	Integer updateCpassword(String password, Long userId);

	/**
	 * 查询用户的个人信息
	 * 
	 * @param userId
	 * @return
	 */
	PersonalVO queryPersonalInfo(Long userId);

	/**
	 * 获取用户的里程碑信息
	 * 
	 * @param userId
	 * @return
	 */
	List<String> getMilestoneInfo(Long userId);

	/**
	 * 根据用户id擦汗寻手机号
	 * 
	 * @param userId
	 * @return
	 */
	String getPhoneById(Long userId);

	/**
	 * 查询积分奖励 和推荐奖励
	 * 
	 * @param id
	 * @return
	 */
	AwardDetailVO scoreDetial(Long id);

	/**
	 * 查询系统奖励
	 * 
	 * @return
	 */
	AwardDetailVO getSystemAward(Long id, Long userId);

	/**
	 * 查询职位奖励
	 * 
	 * @param id
	 * @param userId
	 * @return
	 */
	AwardDetailVO positionAward(Long id, Long userId, @Param("diskType") String diskType);

}
