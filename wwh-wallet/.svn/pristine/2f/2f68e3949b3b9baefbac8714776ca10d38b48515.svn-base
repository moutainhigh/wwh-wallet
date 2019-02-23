package com.wwh.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.dao.IMShareDao;
import com.wwh.enums.DatabaseType;
import com.wwh.enums.DiskEnum;
import com.wwh.service.IMShareService;
import com.wwh.util.StringUtils;
import com.wwh.vo.MShareVO;
import com.wwh.vo.UserVO;

@Service
public class MShareService implements IMShareService {
	private static Logger logger = LogManager.getLogger(MShareService.class);

	@Autowired
	private IMShareDao mShareDao;

	public MShareVO getMshareInfo(Long userId) {
		logger.info("查询用户的分享信息 userId={}", userId);
		// 获取基本信息
		MShareVO mShareVO = mShareDao.queryUserInfo(userId);
		if (null != mShareVO) {
			List<UserVO> recommends = new ArrayList<UserVO>();
			// 我的路程碑信息
			List<String> memberStoneList = mShareDao.getMillStoneInfo(userId);
			mShareVO.setMemberStoneList(memberStoneList);
			// 查询我的一级推荐人
			List<UserVO> level1 = mShareDao.getLevel1Recommend(userId);
			// 查询我的二级推荐人
			List<UserVO> level2 = mShareDao.getLevel2Recommend(level1);
			// 将所有的人合并
			if (level1 != null && level1.size() != 0)
				recommends.addAll(level1);
			if (level2 != null && level2.size() != 0)
				recommends.addAll(level2);
			// 设置总推荐人数
			mShareVO.setTotalInvite(recommends.size());
			// 只有当邀请人数>0的时候才去查询哪些详情 不然没意义啊
			if (recommends.size() > 0) {
				// 各种会员人数
				Map<String, Integer> count = new HashMap<String, Integer>();
				// Integer tiyan = mShareDao.countByDiskType(recommends,
				// DiskEnum.TIYAN.name());
				// Integer huimin = mShareDao.countByDiskType(recommends,
				// DiskEnum.HUIMIN.name());
				// Integer fumin = mShareDao.countByDiskType(recommends,
				// DiskEnum.FUMIN.name());
				// Integer xingmin = mShareDao.countByDiskType(recommends,
				// DiskEnum.XINGMIN.name());
				// Integer other = mShareDao.countByDiskType(recommends,
				// "OTHER");

				// 各种会员信息
				Map<String, List<UserVO>> map = new HashMap<String, List<UserVO>>();
				List<UserVO> tUser = mShareDao.getUserInfo(recommends, DiskEnum.TIYAN.name());
				List<UserVO> hUser = mShareDao.getUserInfo(recommends, DiskEnum.HUIMIN.name());
				List<UserVO> fUser = mShareDao.getUserInfo(recommends, DiskEnum.FUMIN.name());
				List<UserVO> xUser = mShareDao.getUserInfo(recommends, DiskEnum.XINGMIN.name());
				List<UserVO> oUser = mShareDao.getOtherUserInfo(recommends);
				count.put("TIYAN", tUser.size());
				count.put("HUIMIN", hUser.size());
				count.put("FUMIN", fUser.size());
				count.put("XINGMIN", xUser.size());
				count.put("OTHER", oUser.size());
				mShareVO.setMemberNum(count);
				tUser = getUsrList(tUser);
				hUser = getUsrList(hUser);
				fUser = getUsrList(fUser);
				xUser = getUsrList(xUser);
				oUser = getUsrList(oUser);
				map.put("TIYAN", tUser);
				map.put("HUIMIN", hUser);
				map.put("FUMIN", fUser);
				map.put("XINGMIN", xUser);
				map.put("OTHER", oUser);
				mShareVO.setUservoList(map);
			}
		}
		return mShareVO;
	}

	// 获取用户的头像信息
	public List<UserVO> getUsrList(List<UserVO> userList) {
		List<UserVO> uservoList = new ArrayList<UserVO>();
		if (null != userList && userList.size() > 0) {
			DatabaseContextHolder.setDatabaseType(DatabaseType.mallDataSource);
			for (UserVO user : userList) {
				String pic = mShareDao.getPicByUserId(user.getUserId());
				if (StringUtils.isEmpty(pic)) {
					user.setPicUrl(pic);
				}
				uservoList.add(user);
			}
		}
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return uservoList;
	}

	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();
		List<String> b = new ArrayList<String>();
		List<String> d = new ArrayList<String>();
		List<String> c = new ArrayList<String>();
		a.add("1");
		b.add("2");
		c.addAll(a);
		c.addAll(b);
		c.addAll(d);
		System.out.println(c.toString());
		System.out.println(d.size());

	}
}
