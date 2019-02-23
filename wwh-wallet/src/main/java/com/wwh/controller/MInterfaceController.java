package com.wwh.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.common.PagedResult;
import com.wwh.service.IMInterfaceService;
import com.wwh.util.CommonConstant;
import com.wwh.vo.AwardDetailVO;
import com.wwh.vo.MConsumptionDividendVO;
import com.wwh.vo.MGrapPointProfitVO;
import com.wwh.vo.MPayRecordsVO;
import com.wwh.vo.MmemberRoledVO;
import com.wwh.vo.MpersonalCenterVO;
import com.wwh.vo.MpersonalInfoVO;
import com.wwh.vo.PersonalVO;
import com.wwh.vo.PlatformProfitScoreVO;
import com.wwh.vo.UserVO;

@Controller
@RequestMapping("/mobile")
public class MInterfaceController {
	@Autowired
	private IMInterfaceService mInterfaceService;

	/**
	 * 个人中心
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/mperson", method = { RequestMethod.POST, RequestMethod.GET })
	public MpersonalCenterVO getPersonalInfo(HttpSession session) {
		Long userId = (Long) session.getAttribute(CommonConstant.WALLET_USER_ID);
		return mInterfaceService.getPersonalInfo(userId);
	}

	/**
	 * 会员之路
	 * 
	 * @param diskType
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/mmemberRoled/{diskType}", method = { RequestMethod.POST, RequestMethod.GET })
	public MmemberRoledVO memberRold(@PathVariable("diskType") String diskType, HttpSession session) {
		Long userId = (Long) session.getAttribute(CommonConstant.WALLET_USER_ID);
		return mInterfaceService.getMemberRoleInfo(diskType, userId);
	}

	/**
	 * 个人信息
	 * 
	 * @param diskType
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/personal", method = { RequestMethod.POST, RequestMethod.GET })
	public MpersonalInfoVO personal(HttpSession session) {
		Long userId = (Long) session.getAttribute(CommonConstant.WALLET_USER_ID);
		return mInterfaceService.getPersonalInfomation(userId);
	}

	/**
	 * 获取充值记录
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/payrecords/{currentPage}/{pageSize}", method = { RequestMethod.POST, RequestMethod.GET })
	public PagedResult<MPayRecordsVO> payRecords(HttpSession session, @PathVariable Integer currentPage,
			@PathVariable Integer pageSize) {
		Long userId = (Long) session.getAttribute(CommonConstant.WALLET_USER_ID);
		return mInterfaceService.getPayRecordsInfo(userId, currentPage, pageSize);
	}

	/**
	 * 获取积分收益记录
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/scoreprofit/{currentPage}/{pageSize}", method = { RequestMethod.POST, RequestMethod.GET })
	public PagedResult<PlatformProfitScoreVO> scoreProfit(HttpSession session, @PathVariable Integer currentPage,
			@PathVariable Integer pageSize) {
		Long userId = (Long) session.getAttribute(CommonConstant.WALLET_USER_ID);
		return mInterfaceService.getPlatformProfitScore(userId, currentPage, pageSize);
	}

	/**
	 * 消费分红
	 * 
	 * @param session
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/consumptionDividend/{currentPage}/{pageSize}", method = { RequestMethod.POST,
			RequestMethod.GET })
	public MConsumptionDividendVO consumptionDividend(HttpSession session, @PathVariable Integer currentPage,
			@PathVariable Integer pageSize) {
		Long userId = (Long) session.getAttribute(CommonConstant.WALLET_USER_ID);
		return mInterfaceService.getMConsumptionDividend(userId, currentPage, pageSize);
	}

	/**
	 * 抢点收益记录
	 * 
	 * @param session
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/grapprofitdetail/{currentPage}/{pageSize}", method = { RequestMethod.POST,
			RequestMethod.GET })
	public PagedResult<MGrapPointProfitVO> garpProfitDetail(HttpSession session, @PathVariable Integer currentPage,
			@PathVariable Integer pageSize) {
		Long userId = (Long) session.getAttribute(CommonConstant.WALLET_USER_ID);
		return mInterfaceService.garpProfitDetail(userId, currentPage, pageSize);
	}

	/**
	 * 获取用户的抢点收益
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/totalGrapProfit", method = { RequestMethod.POST, RequestMethod.GET })
	public BigDecimal getTotalProfit(HttpSession session) {
		Long userId = (Long) session.getAttribute(CommonConstant.WALLET_USER_ID);
		return mInterfaceService.getTotalGrapDetail(userId);
	}

	/**
	 * 获取用户的用户信息
	 * 
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getuserinfo/{param}", method = { RequestMethod.POST, RequestMethod.GET })
	public UserVO getUserInfo(@PathVariable String param) {
		return mInterfaceService.getUserInfo(param);
	}

	/**
	 * 更改用户的密码
	 * 
	 * @param password
	 * @param userId
	 */
	@ResponseBody
	@RequestMapping(value = "/updatepassword/{password}/{userId}", method = { RequestMethod.POST, RequestMethod.GET })
	public boolean updatePassword(@PathVariable String password, @PathVariable Long userId) {
		return mInterfaceService.updateUserPassword(password, userId);
	}

	/**
	 * 查询个人中心信息
	 * 
	 * @param password
	 * @param userId
	 */
	@ResponseBody
	@RequestMapping(value = "/personal/{userId}", method = { RequestMethod.POST, RequestMethod.GET })
	public PersonalVO getPersonalInfo(@PathVariable Long userId) {
		return mInterfaceService.queryPersonalInfo(userId);
	}

	@ResponseBody
	@RequestMapping(value = "/gethone/{userId}", method = { RequestMethod.POST, RequestMethod.GET })
	public String getPhoneByUserId(@PathVariable Long userId) {
		return mInterfaceService.getPhoneByUserId(userId);
	}

	@ResponseBody
	@RequestMapping(value = "/scoredetail/{id}", method = { RequestMethod.POST, RequestMethod.GET })
	public AwardDetailVO getScoreDetial(@PathVariable Long id) {
		return mInterfaceService.scoreDetial(id);
	}

	@ResponseBody
	@RequestMapping(value = "/gethone/{id}/{userId}", method = { RequestMethod.POST, RequestMethod.GET })
	public AwardDetailVO systemaward(@PathVariable Long id, @PathVariable Long userId) {
		return mInterfaceService.getSystemAward(id, userId);
	}

	@ResponseBody
	@RequestMapping(value = "/gethone/{id}/{userId}/{diskType}", method = { RequestMethod.POST, RequestMethod.GET })
	public AwardDetailVO positionAward(@PathVariable Long id, @PathVariable Long userId,
			@PathVariable String diskType) {
		return mInterfaceService.positionAward(id, userId, diskType);
	}

}
