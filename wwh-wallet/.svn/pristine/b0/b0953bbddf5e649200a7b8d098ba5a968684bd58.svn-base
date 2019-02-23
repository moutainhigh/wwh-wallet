package com.wwh.service;

import java.util.List;

import com.wwh.common.PagedResult;
import com.wwh.vo.BusinessRelationVO;
import com.wwh.vo.DiskDetailCustromVO;
import com.wwh.vo.DiskRelationCustromVO;
import com.wwh.vo.MerchantsSalesRelationVO;
import com.wwh.vo.NullPointVO;
import com.wwh.vo.PlatformInviteDetailExtendVO;
import com.wwh.vo.PlatformInviteVO;
import com.wwh.vo.PlatformProfitExtendVO;
import com.wwh.vo.PointGrapRelationVO;
import com.wwh.vo.RecommendVO;
import com.wwh.vo.UserVO;

/**
 * 
 * @ClassName: IMyEarningsService
 * @Description: 我的收益页面service
 * @author: yuzih
 * @date: 2016年10月27日 下午1:49:22
 */
public interface IEarningService {
	/**
	 * 
	 * @Title: getPlatformProfitByUserId
	 * @Description: 获取用户的平台总收益数据
	 * @param userId
	 * @return
	 * @return: PlatformProfitExtendVO
	 */
	PlatformProfitExtendVO getPlatformProfitByUserId(Long userId);

	/**
	 * 
	 * @Title: getMerchantsSalesRelationByUserId
	 * @Description: 获取用户招的商家销售的提成记录（商家每销售一件商品用户的提成）
	 * @param userId
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            每页多少数据
	 * @return
	 * @return: List<MerchantsSalesRelationVO>
	 */
	PagedResult<MerchantsSalesRelationVO> getMerchantsSalesRelationByUserId(UserVO userVo, Integer currentPage,
			Integer pageSize);

	/**
	 * 
	 * @Title: getBusinessRelationByUserId
	 * @Description: 获取用户所招的所有商家详情
	 * @param userVo
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @return: PagedResult<BusinessRelationVO>
	 */
	PagedResult<BusinessRelationVO> getBusinessRelationByUserId(UserVO userVo, Integer currentPage, Integer pageSize);

	/**
	 * 
	 * @Title: getDiskProfitDetailByUserId
	 * @Description: 个人收益——会员等级收益——收益记录表
	 * @param userVo
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @return: PagedResult
	 */
	PagedResult<?> getDiskProfitDetailByUserId(UserVO userVo, String para, Integer currentPage, Integer pageSize);

	/**
	 * 
	 * @Title: getUnderThePlateByUserId
	 * @Description: 个人收益——会员等级收益——空点列表
	 * @param userVo
	 * @param diskType
	 *            diskType值可为ALL TIYAN HUIMIN FUMIN XINGMIN ，ALL为查询全部，其他顾名思义
	 * @return
	 * @return: List<NullPointVO>
	 */
	PagedResult<NullPointVO> getUnderThePlateNullPointByUserId(UserVO userVo, String diskType, Integer currentPage,
			Integer pageSize);

	/**
	 * 
	 * @Title: getUnderThePlateGrapPointByUserId
	 * @Description: 个人收益——会员等级收益——抢点列表 (因为是抢点，所以最多可以有9个点。)
	 * @param userVo
	 * @param diskType
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @return: PagedResult<PointGrapRelationVO>
	 */
	PagedResult<PointGrapRelationVO> getUnderThePlateGrapPointByUserId(UserVO userVo, String diskType,
			Integer currentPage, Integer pageSize);

	/**
	 * 
	 * @Title: getDiskUserRelationVOs
	 * @Description: 获取某个盘里面，用户之间的关系
	 * @param diskSeq
	 * @return
	 * @return: List<List<?>> 无论如何，里面都会有40条数据
	 */
	List<List<?>> getDiskUserRelationVOs(String diskSeq, Long userId);

	/**
	 * 
	 * @Title: getRecommendDetail
	 * @Description: 获取用户在某个系统中邀请的人详情
	 * @param userVo
	 * @param diskType
	 *            有个ALL
	 * @return
	 * @return: PagedResult<RecommendVO>
	 */
	PagedResult<RecommendVO> getRecommendDetail(UserVO userVo, String diskType, Integer currentPage, Integer pageSize);

	/**
	 * 
	 * @Title: getPlatformInviteDetail
	 * @Description: 获取用户邀请注册的用户(分页)
	 * @param userVo
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @return: PagedResult<PlatformInviteDetailExtendVO>
	 */
	PagedResult<PlatformInviteDetailExtendVO> getPlatformInviteDetail(UserVO userVo, Integer currentPage,
			Integer pageSize);

	/**
	 * 
	 * @Title: getPlatformInviteDetail2
	 * @Description: 获取用户邀请注册的用户 (不分页)
	 * @param userVo
	 * @return
	 * @return: List<PlatformInviteDetailExtendVO>
	 */
	List<PlatformInviteDetailExtendVO> getPlatformInviteDetail2(UserVO userVo);

	/**
	 * 
	 * @Title: getPlatformInviteDetail3
	 * @Description: 获取用户第一个被推荐人的二级推荐人(不分页)
	 * @param userVo
	 * @return
	 * @return: List<PlatformInviteDetailExtendVO>
	 */
	List<PlatformInviteDetailExtendVO> getPlatformInviteDetail3(UserVO userVo);

	/**
	 * 
	 * @Title: getPlatformInvite
	 * @Description: 获取用户邀请注册的统计信息
	 * @param userVo
	 * @return
	 * @return: PlatformInviteVO
	 */
	PlatformInviteVO getPlatformInvite(UserVO userVo);

	/**
	 * 
	 * @Title: getDiskDetail
	 * @Description: 获取盘详细信息
	 * @param userVo
	 * @param diskSeq
	 * @param diskType
	 * @return
	 * @return: DiskDetailCustromVO
	 */
	DiskDetailCustromVO getDiskDetail(String idCard, String diskType);

	/**
	 * 
	 * @Title: getDiskRelationCustromVO
	 * @Description: 移动端的个人收益盘中的各种数据
	 * @param diskType
	 * @param userVO
	 * @return
	 * @return: List<DiskRelationCustromVO>
	 */
	List<DiskRelationCustromVO> getDiskRelationCustromVO(String diskType, UserVO userVO);

	/**
	 * 
	 * @Title: getIdcardsByDiskType
	 * @Description: 获取用户在某个系统内的所有IDCARD
	 * @param userId
	 * @param diskType
	 * @return
	 * @return: List<String>
	 */
	List<String> getIdcardsByDiskType(Long userId, String diskType, String diskStatus);

	/**
	 * 
	 * @Title: getDiskDetailLists
	 * @Description: 根据IDCARDS 获取 盘详情VO
	 * @param idCards
	 * @return
	 * @return: List<DiskDetailCustromVO>
	 */
	List<DiskDetailCustromVO> getDiskDetailLists(List<String> idCards, String diskType);

	DiskRelationCustromVO getDiskRelationCustromVOByLocation(String diskType, String diskSeq, Integer location,UserVO userVo);

	String getDiskUserRelation();
}
