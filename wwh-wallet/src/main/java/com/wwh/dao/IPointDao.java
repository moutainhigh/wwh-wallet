package com.wwh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwh.vo.KeyPointRecommendVO;
import com.wwh.vo.Level2RecommendDetailVO;
import com.wwh.vo.NullPointVO;
import com.wwh.vo.RecommendAPointStatisticsVO;
import com.wwh.vo.RecommendBPointStatisticsVO;
import com.wwh.vo.RecommendVO;

public interface IPointDao {
	/**
	 * 
	 * @Title: addPiont
	 * @Description: 添加推荐点流水表记录
	 * @param recommendVO
	 * @return
	 * @return: void
	 */
	void addPoint(RecommendVO recommendVO);

	/**
	 * 
	 * @Title: getBPointCountByIdCard
	 * @Description: 获取某个身份下B状态推荐点数
	 * @param idCard
	 * @return
	 * @return: RecommendPointBStatisticsVO
	 */
	RecommendBPointStatisticsVO getBPointCountByIdCard(String idCard);

	/**
	 * 
	 * @Title: getBPointCountByIdCards
	 * @Description: 获取某个身份下B状态推荐点数
	 * @param idCards
	 * @return
	 * @return: List<RecommendBPointStatisticsVO>
	 */
	List<RecommendBPointStatisticsVO> getBPointCountByIdCards(@Param("idCards") List<String> idCards);

	/**
	 * 
	 * @Title: getBPointCountByUserIdAndDiskType
	 * @Description: 获取某个用户在某个系统下的所有B状态点纪录
	 * @param userId
	 * @param diskType
	 * @return
	 * @return: List<RecommendPointBStatisticsVO>
	 */
	List<RecommendBPointStatisticsVO> getBPointCountByUserIdAndDiskType(@Param("userId") Long userId,
			@Param("diskType") String diskType);

	/**
	 * 
	 * @Title: getBPointCountByUserIdAndDiskType
	 * @Description: 查询B表 ，B状态人，最多找3条记录
	 * @param userId
	 * @param idCard
	 * @param diskType
	 * @param totalPointPhr
	 *            最多找3 条记录
	 * @return
	 * @return: List<RecommendBPointStatisticsVO>
	 */
	public List<RecommendBPointStatisticsVO> queryRecommendBPointStatisticsByExample(@Param("diskType") String diskType,
			@Param("totalPointPhr") Integer totalPointPhr);

	/**
	 * 
	 * @Title: updateAPointStatistics
	 * @Description: 更新A状态统计表中的总点数和剩余点数
	 * @param aPointStatisticsVO
	 * @return: void
	 */
	void updateAPointStatistics(RecommendAPointStatisticsVO aPointStatisticsVO);

	/**
	 * 
	 * @Title: updateBPointStatistics
	 * @Description: 更新B状态统计表中的总点数和剩余点数
	 * @param bPointStatisticsVO
	 * @return: void
	 */
	void updateBPointStatistics(RecommendBPointStatisticsVO bPointStatisticsVO);

	/**
	 * 
	 * @Title: addKeyPointByPointType
	 * @Description: 增加关键推荐点表数据
	 * @param keyPointRecommendVO
	 * @return: void
	 */
	void addKeyPointByPointType(KeyPointRecommendVO keyPointRecommendVO);

	/**
	 * 
	 * @Title: getUserAPointBydiskType
	 * @Description: 获取用户某个系统的A状态推荐点统计
	 * @param userId
	 * @param diskType
	 * @return
	 * @return: RecommendAPointStatisticsVO
	 */
	RecommendAPointStatisticsVO getUserAPointBydiskType(@Param("userId") Long userId,
			@Param("diskType") String diskType);

	/**
	 * 
	 * @Title: getRecommendCounterBydiskType
	 * @Description: 获取用户上级推荐人在某个系统中的推荐人数量
	 * @param userId
	 *            用户ID
	 * @param diskType
	 *            系统类型
	 * @return
	 * @return: Integer 推荐人数量
	 */
	Integer getRecommendCounterBydiskType(@Param("userId") Long userId, @Param("diskType") String diskType);

	/**
	 * 
	 * @Title: getAStatisticsByUserIds
	 * @Description: 获取所有的userId的A状态推荐点详情
	 * @param userIds
	 * @param diskType
	 * @return
	 * @return: List<RecommendAPointStatisticsVO>
	 */
	List<RecommendAPointStatisticsVO> getAStatisticsByUserIds(@Param("records") List<Long> userIds,
			@Param("diskType") String diskType);

	/**
	 * 
	 * @Title: getAStatisticsByUserId
	 * @Description: 获取某个userId的A状态推荐点详情
	 * @param userIds
	 * @param diskType
	 * @return
	 * @return: List<RecommendAPointStatisticsVO>
	 */
	RecommendAPointStatisticsVO getAStatisticsByUserId(@Param("userId") Long userId,
			@Param("diskType") String diskType);

	/**
	 * 
	 * @Title: addNullPoint
	 * @Description: 添加空点记录
	 * @param nullPointVO
	 * @return: void
	 */
	void addNullPoint(NullPointVO nullPointVO);

	/**
	 * 
	 * @Title: addLevel2PointDetail
	 * @Description: 添加二级推荐详情
	 * @param level2RecommendDetailVO
	 * @return: void
	 */
	void addLevel2PointDetail(Level2RecommendDetailVO level2RecommendDetailVO);

	/**
	 * 
	 * @Title: getAllSysReceiveUserIdByUserId
	 * @Description: 获取用户的已充值推荐人 (一级或二级)
	 * @param userId
	 * @param isDirect
	 * @return
	 * @return: List<Long>
	 */
	List<Long> getAllSysReceiveUserIdByUserId(@Param("userId") Long userId, @Param("isDirect") String isDirect);

	List<Level2RecommendDetailVO> getLevel2PointDetailsByUserIds(@Param("userId") Long userId,
			@Param("level1UserIds") List<Long> level1UserIds);

	/**
	 * 
	 * @Title: getLevel2PointDetailsByUserId
	 * @Description: 查询出用户的某个一级推荐人的二级推荐点空位情况
	 * @param userId
	 * @param level1UserId
	 * @return
	 * @return: Level2RecommendDetailVO
	 */
	Level2RecommendDetailVO getLevel2PointDetailsByUserId(@Param("userId") Long userId,
			@Param("level1UserId") Long level1UserId);

	/**
	 * 更新空点记录
	 * 
	 * @param nullPointVo
	 * @return
	 */
	Integer updateEmptyPoint(NullPointVO nullPointVo);
}
