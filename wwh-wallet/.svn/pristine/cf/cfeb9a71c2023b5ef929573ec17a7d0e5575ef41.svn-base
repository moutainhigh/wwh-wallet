package com.wwh.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.common.WWHResultData;
import com.wwh.enums.DatabaseType;
import com.wwh.service.IFriendCircleService;
import com.wwh.util.CommonConstant;
import com.wwh.vo.FriendCircleCustromVO;
import com.wwh.vo.FriendCircleMainCustromVO;
import com.wwh.vo.UserVO;

/**
 * 
 * @ClassName: FriendCircleController
 * @Description: 朋友圈controller
 * @author: YuZihao
 * @date: 2016年11月6日 下午12:29:56
 */
@Controller
@RequestMapping("/friendcircle")
public class FriendCircleController {
	@Autowired
	private IFriendCircleService friendCircleService;

	/**
	 * 
	 * @Title: getBusinessCustrom
	 * @Description:朋友圈页面上的所有数据
	 * @param session
	 * @return
	 * @return: WWHResultData<BusinessCustromVO>
	 */
	@RequestMapping("/frienddetail")
	@ResponseBody
	public WWHResultData<FriendCircleMainCustromVO> getFriendCircleMainCustromVO(HttpSession session) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		WWHResultData<FriendCircleMainCustromVO> wwhResultData = new WWHResultData<>();
		wwhResultData.setData(friendCircleService.getFriendCircleMainCustromVO(userVo));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

	@RequestMapping("/level2uservo/{userId}/{level1UserId}")
	@ResponseBody
	public WWHResultData<FriendCircleCustromVO> getFriendCircleCustromVO(@PathVariable Long userId,
			@PathVariable Long level1UserId) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		WWHResultData<FriendCircleCustromVO> wwhResultData = new WWHResultData<>();
		UserVO userVo = new UserVO();
		userVo.setUserId(userId);
		wwhResultData.setData(friendCircleService.getFriendCircleCustromVO(userVo, level1UserId));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

}
