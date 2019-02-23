package com.wwh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.common.PagedResult;
import com.wwh.common.WWHResultData;
import com.wwh.enums.DatabaseType;
import com.wwh.service.IScoreService;
import com.wwh.util.CommonConstant;
import com.wwh.vo.MilestoneVO;
import com.wwh.vo.PayVO;
import com.wwh.vo.PlatformProfitScoreVO;
import com.wwh.vo.ScoreUsageVO;
import com.wwh.vo.UserVO;
import com.wwh.vo.WalletAmountExtendVO;

@Controller
@RequestMapping("/score")
public class ScoreController {

	@Autowired
	private IScoreService scoreService;

	/**
	 * 
	 * @Title: toScoreHtml
	 * @Description: 跳转到积分页面
	 * @return
	 * @return: String
	 */
	@RequestMapping("")
	public String toScoreHtml() {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return "wallet/bonus/my-bonus-points";
	}

	/**
	 * 
	 * 
	 * @Title: getUserWalletDetailByUser
	 * @Description: 获取用户钱包和里程碑
	 * @return
	 * @return: WWHResultData<WalletAmountVO>
	 */
	@RequestMapping("/userwalletdetail")
	@ResponseBody
	public WWHResultData<WalletAmountExtendVO> getWalletDetailByUser(HttpSession session) throws Exception {
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		WWHResultData<WalletAmountExtendVO> wwhResultData = new WWHResultData<>();
		WalletAmountExtendVO walletAmountExtendVO = scoreService.getUserWalletByUser(userVo);
		List<MilestoneVO> milestoneVOs = scoreService.getUserMilestoneVoByUser(userVo);
		walletAmountExtendVO.setDiskType(milestoneVOs);
		wwhResultData.setData(walletAmountExtendVO);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

	/**
	 * 
	 * @Title: getRechargeList
	 * @Description: 获取用户充值详情
	 * @param currentPage
	 *            第几页
	 * @param pageSize
	 *            每页多少条数据
	 * @return
	 * @return: PagedResult<PayVO>
	 */
	@RequestMapping("/rechargelist/{diskType}/{currentPage}/{pageSize}")
	@ResponseBody
	public PagedResult<PayVO> getRechargeList(@PathVariable String diskType, @PathVariable Integer currentPage,
			@PathVariable Integer pageSize, HttpSession session) throws Exception {
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return scoreService.getRechargeListByUser(userVo, diskType, currentPage, pageSize);
	}

	/**
	 * 
	 * @Title: getScoreUsageList
	 * @Description: 获取用户积分使用详情
	 * @param currentPage
	 *            第几页
	 * @param pageSize
	 *            每页多少条数据
	 * @return
	 * @return: PagedResult<ScoreUsageVO>
	 */
	@RequestMapping("/scoreusagelist/{currentPage}/{pageSize}")
	@ResponseBody
	public PagedResult<ScoreUsageVO> getScoreUsageList(@PathVariable Integer currentPage,
			@PathVariable Integer pageSize, HttpSession session) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return scoreService.getUserScoreUsageByUserId(userVo, currentPage, pageSize);
	}

	/**
	 * 
	 * @Title: getScoreProfitList
	 * @Description: 获取积分收益详情
	 * @param profitScoreType
	 *            收益来源 ：注册(REGISTERPROFIT)还是充值(INVITERECHARGEPROFIT)
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @return: PagedResult<PlatformProfitScoreVO>
	 */
	@RequestMapping("/registscoreprofitlist/{currentPage}/{pageSize}")
	@ResponseBody
	public PagedResult<PlatformProfitScoreVO> getRegistScoreProfitList(@PathVariable Integer currentPage,
			@PathVariable Integer pageSize, HttpSession session) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return scoreService.getRegistScoreProfitByUserId(userVo, currentPage, pageSize);
	}

	/**
	 * 查询充值收益记录
	 * 
	 * @param profitScoreType
	 * @param currentPage
	 * @param pageSize
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/chargescoreprofitlist/{currentPage}/{pageSize}")
	@ResponseBody
	public PagedResult<PlatformProfitScoreVO> getChargeScoreProfitList(@PathVariable Integer currentPage,
			@PathVariable Integer pageSize, HttpSession session) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return scoreService.getChargeScoreProfitByUserId(userVo, currentPage, pageSize);
	}

}
