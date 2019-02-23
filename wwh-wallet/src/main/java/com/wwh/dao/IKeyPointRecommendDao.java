package com.wwh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwh.vo.KeyPointRecommendVO;

/**
 * 
 * @ClassName: IKeyPointRecommendDao
 * @Description: wallet_key_point_recommend_t关键推荐点表 ;当推荐点统计表点数 6 以上
 *               时，每多两个推荐点该表增加一条记录，
 * @author: lilinxiang
 * @date: 2016年11月14日 上午7:52:54
 */
public interface IKeyPointRecommendDao {

	// <select id="selectByKeyPointRecommend" resultMap="BaseResultMap"
	// parameterType="com.wwh.vo.KeyPointRecommendVO" >
	//
	//
	// <insert id="insert" parameterType="com.wwh.vo.KeyPointRecommendVO" >

	// /**
	// *
	// * @Title: selectByKeyPointRecommendWhereUserId
	// * @Description:
	// * @param poin_status
	// * @param diskType
	// * @param list
	// * @return
	// * @return: List<KeyPointRecommendVO>
	// */
	// public List<KeyPointRecommendVO> selectByKeyPointRecommendWhereUserId(
	// @Param("poin_status")String poin_status, @Param("diskType")String
	// diskType, @Param("list")List<Long> list);

	/**
	 * 
	 * @Title: selectByKeyPointRecommendWhereUserId
	 * @Description:
	 * @param poin_status
	 *            必须字段：
	 * @param diskType
	 *            必须字段：
	 * @param list
	 *            必须字段：
	 * @param totalPointPhr
	 *            必须字段： 点份数 ; 最大值3 , 6个点数 分成3 份
	 * @return
	 * @return: List<KeyPointRecommendVO>
	 */
	public List<KeyPointRecommendVO> selectByKeyPointRecommendWhereUserId(@Param("poinStatus") String poinStatus, @Param("diskType") String diskType,
			@Param("list") List<String> idCard, @Param("totalPointPhr") Integer totalPointPhr);

	public List<KeyPointRecommendVO> selectByKeyPointRecommend(KeyPointRecommendVO keyPointRecommendVO);

	public Integer insert(KeyPointRecommendVO keyPointRecommendVO);

	// <!-- 修改关键点 -->
	// <update id="updateByIdCardSelective"
	// parameterType="com.wwh.vo.KeyPointRecommendVO" >

	/**
	 * 
	 * @Title: updateByIdCardSelective
	 * @Description: 修改关键点
	 * @param keyPointRecommendVO
	 *            必须字段 idCard <br/>
	 * @return
	 * @return: Integer
	 */
	public Integer updateByIdCardSelective(KeyPointRecommendVO keyPointRecommendVO);

	public List<KeyPointRecommendVO> getKeyRecommendPointsByIdCard(@Param("idCard") String idCard);
	
	public List<KeyPointRecommendVO> getKeyRecommendPointsByUserId(@Param("userId") Long userId);

}
