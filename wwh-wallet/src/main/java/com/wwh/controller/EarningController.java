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
import com.wwh.service.IEarningService;
import com.wwh.util.CommonConstant;
import com.wwh.vo.BusinessRelationVO;
import com.wwh.vo.DiskDetailCustromVO;
import com.wwh.vo.DiskRelationCustromVO;
import com.wwh.vo.MerchantsSalesRelationVO;
import com.wwh.vo.NullPointVO;
import com.wwh.vo.PlatformInviteDetailExtendVO;
import com.wwh.vo.PlatformProfitExtendVO;
import com.wwh.vo.PointGrapRelationVO;
import com.wwh.vo.RecommendVO;
import com.wwh.vo.UserVO;

/**
 * 
 * @ClassName: EarningsController
 * @Description: 个人收益页面controller
 * @author: YuZihao
 * @date: 2016年11月6日 下午1:45:20
 */
@Controller
@RequestMapping("/earnings")
public class EarningController {

	@Autowired
	private IEarningService earningService;

	@RequestMapping("")
	public String toEarnings() {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return "wallet/profit/private-benefit";
	}

	/**
	 * 
	 * @Title: getPlatformProfit
	 * @Description: 获取用户的平台收益详情
	 * @return
	 * @return: WWHResultData<PlatformProfitVO>
	 */
	@RequestMapping("/platformprofit")
	@ResponseBody
	public WWHResultData<PlatformProfitExtendVO> getPlatformProfit(HttpSession session) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		WWHResultData<PlatformProfitExtendVO> wwhResultData = new WWHResultData<PlatformProfitExtendVO>();
		PlatformProfitExtendVO platformProfitExtendVO = earningService.getPlatformProfitByUserId(userVo.getUserId());
		if (platformProfitExtendVO == null) {
			platformProfitExtendVO = new PlatformProfitExtendVO();
		}
		platformProfitExtendVO.setPlatformInviteVO(earningService.getPlatformInvite(userVo));
		wwhResultData.setData(platformProfitExtendVO);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

	/**
	 * 
	 * @Title: getMerchantsSalesRelation
	 * @Description: 获取用户招的商家销售的提成记录（商家每销售一件商品用户的提成）
	 * @param businesspara
	 *            ALL默认全部,否则是商家ID
	 * @param currentPage
	 * @param pageSize
	 * @param session
	 * @return
	 * @throws Exception
	 * @return: PagedResult<MerchantsSalesRelationVO>
	 */
	@RequestMapping("/merchantssales/{businesspara}/{currentPage}/{pageSize}")
	@ResponseBody
	public PagedResult<MerchantsSalesRelationVO> getMerchantsSalesRelation(@PathVariable String businesspara,
			@PathVariable Integer currentPage, @PathVariable Integer pageSize, HttpSession session) throws Exception {
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		if (!businesspara.equals("ALL")) {
			userVo.setBusinessUserId(Long.valueOf(businesspara));
		}
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return earningService.getMerchantsSalesRelationByUserId(userVo, currentPage, pageSize);
	}

	/**
	 * 
	 * @Title: getBusinessDetail
	 * @Description: 获取用户所招的所有商家，分页效果暂时默认为第一页，一页10条数据
	 * @return
	 * @return: PagedResult<BusinessRelationVO>
	 */
	@RequestMapping("/businessdetail")
	@ResponseBody
	public PagedResult<BusinessRelationVO> getBusinessDetail(HttpSession session) throws Exception {
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return earningService.getBusinessRelationByUserId(userVo, 1, 10);
	}

	/**
	 * 
	 * @Title: getDiskProfitByUserId
	 * @Description: 等级系统收益详情列表
	 * @param statusOrtype
	 *            盘状态或者类型 枚举 ：FINISHED , RUNNING ，GRAP
	 *            ，TIYAN,HUIMIN,FUMIN,XINGMIN
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @return: PagedResult<DiskProfitVO>
	 */
	@RequestMapping("/diskprofitdetail/{statusOrtype}/{currentPage}/{pageSize}")
	@ResponseBody
	public PagedResult<?> getDiskProfitByUserId(@PathVariable String statusOrtype, @PathVariable Integer currentPage,
			@PathVariable Integer pageSize, HttpSession session) throws Exception {
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return earningService.getDiskProfitDetailByUserId(userVo, statusOrtype, currentPage, pageSize);
	}

	/**
	 * 
	 * @Title: getUnderThePlateNullPointData
	 * @Description: 个人收益——会员等级收益 —— 空点列表
	 * @param diskType
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @return: PagedResult<NullPointVO>
	 */
	@RequestMapping("/undertheplatenullpointdata/{diskType}/{currentPage}/{pageSize}")
	@ResponseBody
	public PagedResult<NullPointVO> getUnderThePlateNullPointData(@PathVariable String diskType,
			@PathVariable Integer currentPage, @PathVariable Integer pageSize, HttpSession session) throws Exception {

		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return earningService.getUnderThePlateNullPointByUserId(userVo, diskType, currentPage, pageSize);
	}

	/**
	 * 
	 * @Title: getUnderThePlateGrapPointData
	 * @Description: 个人收益——会员等级收益—— 抢点列表
	 * @param diskType
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @return: PagedResult<PointGrapRelationVO>
	 */
	@RequestMapping("/undertheplategrappointdata/{diskType}/{currentPage}/{pageSize}")
	@ResponseBody
	public PagedResult<PointGrapRelationVO> getUnderThePlateGrapPointData(@PathVariable String diskType,
			@PathVariable Integer currentPage, @PathVariable Integer pageSize, HttpSession session) throws Exception {
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return earningService.getUnderThePlateGrapPointByUserId(userVo, diskType, currentPage, pageSize);
	}

	/**
	 * 
	 * @Title: getRecommend
	 * @Description: 获取用户的一级和二级被推荐人(注册并充值的)
	 * @param session
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @return: PagedResult<RecommendVO>
	 */
	@RequestMapping("/recommend/{level}/{currentPage}/{pageSize}")
	@ResponseBody
	public PagedResult<RecommendVO> getRecommend(@PathVariable String level, @PathVariable Integer currentPage,
			@PathVariable Integer pageSize, HttpSession session) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVo = new UserVO();
		if (level.equals("1")) {
			userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		} else {
			userVo = new UserVO();
			userVo.setUserId((Long) session.getAttribute("level1UserId"));
		}
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		// 已充值的被推荐人和只注册的被推荐人不一样，充值之后会根据充值金额在某个系统（体验，惠民等）拥有身份，所以可以按照系统来区分
		return earningService.getRecommendDetail(userVo, "ALL", currentPage, pageSize);
	}

	/**
	 * 
	 * @Title: getInviteDetailLevel1
	 * @Description: 获取用户的一级被推荐人（只需注册即可。）
	 * @param session
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @return: PagedResult<PlatformInviteDetailExtendVO>
	 */
	@RequestMapping("/invitedetail/level1/{currentPage}/{pageSize}")
	@ResponseBody
	public PagedResult<PlatformInviteDetailExtendVO> getInviteDetailLevel1(@PathVariable Integer currentPage,
			@PathVariable Integer pageSize, HttpSession session) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		PagedResult<PlatformInviteDetailExtendVO> pagedResult = earningService.getPlatformInviteDetail(userVo,
				currentPage, pageSize);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return pagedResult;
	}

	/**
	 * 
	 * @Title: getInviteDetailLevel2
	 * @Description: 获取用户的一级被推荐人（不分页）
	 * @param level1UserId
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @return: PagedResult<PlatformInviteDetailExtendVO>
	 */
	@RequestMapping("/invitedetail/level1/{level1UserId}")
	@ResponseBody
	public WWHResultData<List<PlatformInviteDetailExtendVO>> getInviteDetailLevel2(@PathVariable Long level1UserId) {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVo = new UserVO();
		userVo.setUserId(level1UserId);
		WWHResultData<List<PlatformInviteDetailExtendVO>> wwhResultData = new WWHResultData<>();
		wwhResultData.setData(earningService.getPlatformInviteDetail2(userVo));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

	/**
	 * 
	 * @Title: jumpToDiskProfitDetail
	 * @Description: 个人收益——会员等级收益——收益记录——查看 初始化该页面
	 * @return
	 * @return: String
	 */
	@RequestMapping("/diskprofitdetail/{diskSeq}")
	@ResponseBody
	public WWHResultData<List<List<?>>> jumpToDiskProfitDetail(@PathVariable String diskSeq, HttpSession session)
			throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		String diskUserRelationDisplayConfig = earningService.getDiskUserRelation();
		// 盘中人关系数据
		WWHResultData<List<List<?>>> wwhResultData = new WWHResultData<List<List<?>>>();
		wwhResultData.setData(earningService.getDiskUserRelationVOs(diskSeq, userVo.getUserId()));
		wwhResultData.setDisplayConfig(diskUserRelationDisplayConfig);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

	/**
	 * 
	 * @Title: jumpToMyProfit
	 * @Description: 获取用户的第一个被推荐人的所有被推荐人
	 * @param session
	 * @return
	 * @return: WWHResultData<List<PlatformInviteDetailExtendVO>>
	 */
	@RequestMapping("/invitedetail/level2")
	@ResponseBody
	public WWHResultData<List<PlatformInviteDetailExtendVO>> jumpToMyProfit(HttpSession session) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		WWHResultData<List<PlatformInviteDetailExtendVO>> wwhResultData = new WWHResultData<>();
		List<PlatformInviteDetailExtendVO> vos = earningService.getPlatformInviteDetail3(userVo);
		wwhResultData.setData(vos);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

	/**
	 * 
	 * @Title: getDiskDetail
	 * @Description: 查看详情页面的各项数据
	 * @param idCard
	 * @param session
	 * @return
	 * @return: WWHResultData<DiskDetailCustromVO>
	 */
	@RequestMapping("/diskdetail/{idCard}")
	@ResponseBody
	public WWHResultData<DiskDetailCustromVO> getDiskDetail(@PathVariable String idCard) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		WWHResultData<DiskDetailCustromVO> wwhResultData = new WWHResultData<DiskDetailCustromVO>();
		String diskUserRelationDisplayConfig = earningService.getDiskUserRelation();
		wwhResultData.setData(earningService.getDiskDetail(idCard, null));
		wwhResultData.setDisplayConfig(diskUserRelationDisplayConfig);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

	/**
	 * 
	 * @Title: getDiskDetail
	 * @Description: 查看详情页面的各项数据(List版)
	 * @param idCard
	 * @param session
	 * @return
	 * @return: WWHResultData<DiskDetailCustromVO>
	 */
	@RequestMapping("/diskdetaillists/{diskType}")
	@ResponseBody
	public WWHResultData<List<DiskDetailCustromVO>> getDiskDetaillists(@PathVariable String diskType,
			HttpSession session) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		WWHResultData<List<DiskDetailCustromVO>> wwhResultData = new WWHResultData<List<DiskDetailCustromVO>>();
		Long userId = (Long) session.getAttribute(CommonConstant.WALLET_USER_ID);
		List<String> idCards = earningService.getIdcardsByDiskType(userId, diskType, "RUNNING");
		List<DiskDetailCustromVO> detailCustromVOs = earningService.getDiskDetailLists(idCards, diskType);
		String diskUserRelationDisplayConfig = earningService.getDiskUserRelation();
		wwhResultData.setData(detailCustromVOs);
		wwhResultData.setDisplayConfig(diskUserRelationDisplayConfig);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

	/**
	 * 
	 * @Title: getDiskRelationCustromVO
	 * @Description: 移动端的个人收益盘中的各种数据
	 * @param diskType
	 * @param session
	 * @return
	 * @return: WWHResultData<List<DiskRelationCustromVO>>
	 */
	@RequestMapping("/diskrelation/{diskType}")
	@ResponseBody
	public WWHResultData<List<DiskRelationCustromVO>> getDiskRelationCustromVO(@PathVariable String diskType,
			HttpSession session) {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		WWHResultData<List<DiskRelationCustromVO>> wwhResultData = new WWHResultData<>();
		wwhResultData.setData(earningService.getDiskRelationCustromVO(diskType, userVo));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

	/**
	 * 
	 * @Title: getDiskRelationDetailCustromVO
	 * @Description: 移动端的盘中指定位置的用户的无聊信息
	 * @param diskType
	 * @param diskSeq
	 * @param location
	 * @param session
	 * @return
	 * @return: WWHResultData<DiskRelationCustromVO>
	 */
	@RequestMapping("/diskrelationdetail/{diskType}/{diskSeq}/{location}")
	@ResponseBody
	public WWHResultData<DiskRelationCustromVO> getDiskRelationDetailCustromVO(@PathVariable String diskType,
			@PathVariable String diskSeq, @PathVariable Integer location, HttpSession session) {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		WWHResultData<DiskRelationCustromVO> wwhResultData = new WWHResultData<>();
		wwhResultData.setData(earningService.getDiskRelationCustromVOByLocation(diskType, diskSeq, location, userVo));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

}
