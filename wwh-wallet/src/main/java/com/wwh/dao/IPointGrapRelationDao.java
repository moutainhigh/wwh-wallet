package com.wwh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwh.vo.KeyPointRecommendVO;
import com.wwh.vo.PointGrapRelationVO;

/**
 * 
 * @ClassName: IPointGrapRelationDao
 * @Description: 抢点关系表 wallet_point_grap_relation_t
 * @author: lilinxiang
 * @date: 2016年11月10日 下午2:55:13
 */
public interface IPointGrapRelationDao {
	/**
	 * 
	 * @Title: insertBatch
	 * @Description: 批量插入抢点关系
	 * @param pointGrapRelationVO
	 * @return
	 * @return: Integer
	 */
	public Integer insertBatch(PointGrapRelationVO pointGrapRelationVO);

	/**
	 * 
	 * @Title: insert
	 * @Description: 插入抢点关系
	 * @param pointGrapRelationVO
	 * @return
	 * @return: Integer
	 */
	public Integer insert(PointGrapRelationVO pointGrapRelationVO);

	/**
	 * 
	 * @Title: updateByDiskSeqSelective
	 * @Description: 修改抢点关系
	 * @param pointGrapRelationVO
	 * @return
	 * @return: Integer
	 */
	public Integer updateByDiskSeqSelective(PointGrapRelationVO pointGrapRelationVO);

	/**
	 * 
	 * @Title: selectByPointGrapRelationVO
	 * @Description: 查询抢点关系
	 * @param pointGrapRelationVO
	 * @return
	 * @return: List<PointGrapRelationVO>
	 */
	public List<PointGrapRelationVO> selectByPointGrapRelationVO(PointGrapRelationVO pointGrapRelationVO);

	/**
	 * 
	 * @Title: getProfitPointsByIdCard
	 * @Description: 获取某个IDCard的收益点数
	 * @param IdCard
	 * @return
	 * @return: Integer
	 */
	public PointGrapRelationVO getProfitPointsByIdCard(@Param("idCard") String idCard, @Param("diskSeq") String diskSeq);

	/**
	 * 
	 * @Title: getProfitPointsByDiskSeq
	 * @Description: 获取某个盘的总监职位利益分配记录
	 * @param diskSeq
	 * @return
	 * @return: List<PointGrapRelationVO>
	 */
	public List<PointGrapRelationVO> getProfitPointsByDiskSeq(String diskSeq);

	/**
	 * 
	 * @Title: getKeyPointFromUserIds
	 * @Description: 获取所有有资格抢点的userId
	 * @param diskType
	 * @param poinStatus
	 * @param userIds
	 * @return
	 * @return: KeyPointRecommendVO
	 */
	public List<KeyPointRecommendVO> getAKeyPointsFromUserIds(@Param("diskType") String diskType, @Param("records") List<Long> userIds,
			@Param("remainCount") Integer remainCount);

	/**
	 * 
	 * @Title: getBKeyPointsFromIdCard
	 * @Description: 获取总监的所有可抢点
	 * @param idCard
	 * @return
	 * @return: List<KeyPointRecommendVO>
	 */
	public List<KeyPointRecommendVO> getBKeyPointsFromIdCard(@Param("idCard") String idCard, @Param("remainCount") Integer remainCount);

	/**
	 * 
	 * @Title: getBKeyPointsFromGetoutDirector
	 * @Description: 获取出局总监的所有可抢点
	 * @param diskType
	 * @return
	 * @return: List<KeyPointRecommendVO>
	 */
	public List<KeyPointRecommendVO> getBKeyPointsFromGetoutDirector(@Param("diskType") String diskType, @Param("remainCount") Integer remainCount);

	/**
	 * 
	 * @Title: getKeyPointFromIdCards
	 * @Description: 获取所有有资格抢点的IdCard
	 * @param diskType
	 * @param poinStatus
	 * @param userIds
	 * @return
	 * @return: KeyPointRecommendVO
	 */
	public List<KeyPointRecommendVO> getKeyPointFromIdCards(@Param("diskType") String diskType, @Param("poinStatus") String poinStatus,
			@Param("records") List<String> idCards);

	public void updateIsUsableToN(KeyPointRecommendVO keyPointRecommendVO);

	public void addGrapRelationVO(PointGrapRelationVO grapRelationVO);
	
	List<PointGrapRelationVO> getGrapRelationsByDiskSeqs(@Param("records") List<String> diskSeqs);
}
