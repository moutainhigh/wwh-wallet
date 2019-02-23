package com.wwh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.dao.IEarningDao;
import com.wwh.dao.IPointDao;
import com.wwh.dao.IUserDao;
import com.wwh.enums.DatabaseType;
import com.wwh.service.IFriendCircleService;
import com.wwh.vo.FriendCircleCustromVO;
import com.wwh.vo.FriendCircleMainCustromVO;
import com.wwh.vo.Level2RecommendDetailVO;
import com.wwh.vo.UserVO;

@Service
public class FriendCircleService implements IFriendCircleService {

	@Autowired
	private IEarningDao earningDao;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IPointDao pointDao;

	@Override
	public FriendCircleMainCustromVO getFriendCircleMainCustromVO(UserVO userVo) {
		Long userId = userVo.getUserId();
		FriendCircleMainCustromVO friendCircleCustromVO = new FriendCircleMainCustromVO();
		friendCircleCustromVO.setUserId(userId);
		// 设置自己的头像
		DatabaseContextHolder.setDatabaseType(DatabaseType.mallDataSource);
		List<Long> userIds = new ArrayList<>();
		userIds.add(userId);
		List<UserVO> userVOs = earningDao.getUserPicUrl(userIds);
		if (userVOs.size() != 0) {
			friendCircleCustromVO.setHeadPic(userVOs.get(0).getPicUrl());
		}
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		// 设置自己的 名称
		userVOs = userDao.getUsersByUserIds(userIds);
		friendCircleCustromVO.setUserName(userVOs.get(0).getUserName());
//		List<Long> allSysReceiveUserIds = pointDao.getAllSysReceiveUserIdByUserId(userId, "Y");
		List<Long> allSysReceiveUserIds = userDao.getReceiveUserId(userId);
		friendCircleCustromVO.setMyPayUnderCount(allSysReceiveUserIds.size());
		// 设置二级位
		Integer remainLevel2Count = 0;
		if (allSysReceiveUserIds == null || allSysReceiveUserIds.size() == 0) {
			allSysReceiveUserIds = null;
		}
		List<Level2RecommendDetailVO> level2RecommendDetailVO = pointDao.getLevel2PointDetailsByUserIds(userId, allSysReceiveUserIds);
		for (Level2RecommendDetailVO level2RecommendDetailVO2 : level2RecommendDetailVO) {
			remainLevel2Count += level2RecommendDetailVO2.getRemainCount();
		}
		friendCircleCustromVO.setRemainLevel2Count(remainLevel2Count);
		if (allSysReceiveUserIds != null) {
			// 设置直推用户头像和用户名
			DatabaseContextHolder.setDatabaseType(DatabaseType.mallDataSource);
			userVOs = earningDao.getUserPicUrl(allSysReceiveUserIds);
			List<FriendCircleMainCustromVO> underLists = new ArrayList<>();
			if (userVOs.size() != 0) {
				FriendCircleMainCustromVO tempFriendCircleCustromVO;
				for (UserVO userVO : userVOs) {
					tempFriendCircleCustromVO = new FriendCircleMainCustromVO();
					tempFriendCircleCustromVO.setUserId(userVO.getMemberId());
					tempFriendCircleCustromVO.setUserName(userVO.getMemberName());
					tempFriendCircleCustromVO.setHeadPic(userVO.getPicUrl());
					underLists.add(tempFriendCircleCustromVO);
				}
			}
			friendCircleCustromVO.setFriendCircleCustromVOs(underLists);
			DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		}
		// 设置我的上级
		FriendCircleMainCustromVO tempFriendCircleCustromVO = new FriendCircleMainCustromVO();
		Long tmpUserId = userDao.getUserReferenceIdByUserId(userId);
		tempFriendCircleCustromVO.setUserId(tmpUserId);
		userIds.clear();
		userIds.add(tmpUserId);
		DatabaseContextHolder.setDatabaseType(DatabaseType.mallDataSource);
		userVOs = earningDao.getUserPicUrl(userIds);
		if (userVOs.size() != 0) {
			tempFriendCircleCustromVO.setHeadPic(userVOs.get(0).getPicUrl());
			tempFriendCircleCustromVO.setUserName(userVOs.get(0).getMemberName());
		}
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		friendCircleCustromVO.setSuperiorUser(tempFriendCircleCustromVO);
		// 设置我的上上级
		tmpUserId = userDao.getUserReferenceIdByUserId(tmpUserId);
		tempFriendCircleCustromVO = new FriendCircleMainCustromVO();
		tempFriendCircleCustromVO.setUserId(tmpUserId);
		userIds.clear();
		userIds.add(tmpUserId);
		DatabaseContextHolder.setDatabaseType(DatabaseType.mallDataSource);
		userVOs = earningDao.getUserPicUrl(userIds);
		if (userVOs.size() != 0) {
			tempFriendCircleCustromVO.setHeadPic(userVOs.get(0).getPicUrl());
			tempFriendCircleCustromVO.setUserName(userVOs.get(0).getMemberName());
		}
		friendCircleCustromVO.setSuperiorSuperiorUser(tempFriendCircleCustromVO);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return friendCircleCustromVO;
	}

	@Override
	public FriendCircleCustromVO getFriendCircleCustromVO(UserVO userVo, Long level1UserId) {
		Level2RecommendDetailVO level2RecommendDetailVO = pointDao.getLevel2PointDetailsByUserId(userVo.getUserId(), level1UserId);
		if (level2RecommendDetailVO == null) {
			return null;
		}
		FriendCircleCustromVO friendCircleCustromVO = new FriendCircleCustromVO();
		friendCircleCustromVO.setUserId(level2RecommendDetailVO.getUserId());
		friendCircleCustromVO.setLevel1UserId(level2RecommendDetailVO.getLevel1UserId());
		// 设置自己的头像
		DatabaseContextHolder.setDatabaseType(DatabaseType.mallDataSource);
		List<Long> userIds = new ArrayList<>();
		userIds.add(level2RecommendDetailVO.getLevel1UserId());
		List<UserVO> userVOs = earningDao.getUserPicUrl(userIds);
		if (userVOs.size() != 0) {
			friendCircleCustromVO.setLevel1UserPic(userVOs.get(0).getPicUrl());
			friendCircleCustromVO.setLevel1UserName(userVOs.get(0).getMemberName());
		}
		userIds.clear();
		userIds.add(level2RecommendDetailVO.getTiyanUserId());
		userVOs = earningDao.getUserPicUrl(userIds);
		if (userVOs.size() != 0) {
			friendCircleCustromVO.setTiyanUserVO(userVOs.get(0));
		}
		userIds.clear();
		userIds.add(level2RecommendDetailVO.getHuiminUserId());
		userVOs = earningDao.getUserPicUrl(userIds);
		if (userVOs.size() != 0) {
			friendCircleCustromVO.setHuiminUserVO(userVOs.get(0));
		}
		userIds.clear();
		userIds.add(level2RecommendDetailVO.getFuminUserId());
		userVOs = earningDao.getUserPicUrl(userIds);
		if (userVOs.size() != 0) {
			friendCircleCustromVO.setFuminUserVO(userVOs.get(0));
		}
		userIds.clear();
		userIds.add(level2RecommendDetailVO.getXingminUserId());
		userVOs = earningDao.getUserPicUrl(userIds);
		if (userVOs.size() != 0) {
			friendCircleCustromVO.setXingminUserVO(userVOs.get(0));
		}
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return friendCircleCustromVO;
	}

}
