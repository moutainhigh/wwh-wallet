package com.wwh.service;

import com.wwh.vo.FriendCircleCustromVO;
import com.wwh.vo.FriendCircleMainCustromVO;
import com.wwh.vo.UserVO;

/**
 * 
 * @ClassName: IFriendCircleService 
 * @Description: 朋友圈service
 * @author: YuZihao
 * @date: 2016年11月6日 下午1:55:55
 */
public interface IFriendCircleService {

	/**
	 * 
	 * @Title: getFriendCircleCustromVO 
	 * @Description: 获取朋友圈页面所有的数据
	 * @param userVo
	 * @return
	 * @return: FriendCircleMainCustromVO
	 */
	FriendCircleMainCustromVO getFriendCircleMainCustromVO(UserVO userVo);
	/**
	 * 
	 * @Title: getFriendCircleCustromVO 
	 * @Description:  获取朋友圈二级页面数据
	 * @param userVo
	 * @param level1UserId
	 * @return
	 * @return: FriendCircleCustromVO
	 */
	FriendCircleCustromVO getFriendCircleCustromVO(UserVO userVo, Long level1UserId);
}
