package com.wwh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwh.vo.MShareVO;
import com.wwh.vo.UserVO;

public interface IMShareDao {
	/**
	 * 查询一级推荐人
	 * 
	 * @param userId
	 * @return
	 */
	List<UserVO> getLevel1Recommend(@Param("userId") Long userId);

	/**
	 * 查询二级推荐人
	 * 
	 * @param userVoList
	 * @return
	 */
	List<UserVO> getLevel2Recommend(@Param("userVoList") List<UserVO> userVoList);

	/**
	 * 获取里程碑信息
	 * 
	 * @param userId
	 * @return
	 */
	List<String> getMillStoneInfo(@Param("userId") Long userId);

	/**
	 * 查询各个系统的人数
	 * 
	 * @param userId
	 * @param diskType
	 * @return
	 */
	Integer countByDiskType(@Param("userVoList") List<UserVO> userVoList, @Param("diskType") String diskType);

	/**
	 * 获取用户分享详情信息
	 * 
	 * @return
	 */
	MShareVO queryUserInfo(@Param("userId") Long userId);

	/**
	 * 获取用户的图片
	 * 
	 * @param userId
	 * @return
	 */
	String getPicByUserId(@Param("userId") Long userId);

	/**
	 * 
	 * @param userId
	 * @param diskType
	 * @return
	 */
	List<UserVO> getUserInfo(@Param("userVoList") List<UserVO> userVoList, @Param("diskType") String diskType);

	/**
	 * 查询普通会员得记录数
	 * 
	 * @param userId
	 * @param userVoList
	 * @return
	 */
	List<UserVO> getOtherUserInfo(@Param("userVoList") List<UserVO> userVoList);
}
