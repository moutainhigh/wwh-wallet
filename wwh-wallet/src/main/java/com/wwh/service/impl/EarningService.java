package com.wwh.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.wwh.common.DatabaseContextHolder;
import com.wwh.common.PagedResult;
import com.wwh.dao.IDiskDao;
import com.wwh.dao.IEarningDao;
import com.wwh.dao.IEmptyPointDiskDao;
import com.wwh.dao.IKeyPointRecommendDao;
import com.wwh.dao.ILevelRelationshipDao;
import com.wwh.dao.IPointDao;
import com.wwh.dao.IPointGrapRelationDao;
import com.wwh.dao.IUserDao;
import com.wwh.dao.IWalletDiskRelationDao;
import com.wwh.enums.DatabaseType;
import com.wwh.service.IEarningService;
import com.wwh.util.BeanUtils;
import com.wwh.util.DiskRelationRuleUtils;
import com.wwh.vo.BusinessRelationVO;
import com.wwh.vo.DiskDetailCustromVO;
import com.wwh.vo.DiskProfitVO;
import com.wwh.vo.DiskRelationCustromVO;
import com.wwh.vo.DiskUserRelationVO;
import com.wwh.vo.DiskVO;
import com.wwh.vo.IdcardRelationVO;
import com.wwh.vo.KeyPointRecommendVO;
import com.wwh.vo.LevelRelationshipVO;
import com.wwh.vo.MerchantsSalesRelationVO;
import com.wwh.vo.NullPointVO;
import com.wwh.vo.PlatformInviteDetailExtendVO;
import com.wwh.vo.PlatformInviteVO;
import com.wwh.vo.PlatformProfitExtendVO;
import com.wwh.vo.PointGrapRelationVO;
import com.wwh.vo.ProfitDetailVO;
import com.wwh.vo.RecommendAPointStatisticsVO;
import com.wwh.vo.RecommendBPointStatisticsVO;
import com.wwh.vo.RecommendVO;
import com.wwh.vo.UserVO;
import com.wwh.vo.WalletDiskRelationVO;

@Service
public class EarningService implements IEarningService {

	private static Logger logger = LogManager.getLogger(EarningService.class);

	@Autowired
	private IEarningDao earningDao;
	@Autowired
	private IDiskDao diskDao;
	@Autowired
	private IWalletDiskRelationDao walletDiskRelationDao;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IPointDao pointDao;
	@Autowired
	private IPointGrapRelationDao pointGrapRelationDao;
	@Autowired
	private IEmptyPointDiskDao emptyPointDiskDao;
	@Autowired
	private ILevelRelationshipDao levelRelationshipDao;
	@Autowired
	private IKeyPointRecommendDao keyPointRecommendDao;

	@Override
	public PlatformProfitExtendVO getPlatformProfitByUserId(Long userId) {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		PlatformProfitExtendVO platformProfitExtendVO = earningDao.getPlatformProfitByUserId(userId);
		if (platformProfitExtendVO == null) {
			platformProfitExtendVO = new PlatformProfitExtendVO();
		}
		List<WalletDiskRelationVO> tiyans = walletDiskRelationDao.selectMyRunningDiskByUserId(userId, "TIYAN");
		List<WalletDiskRelationVO> huimins = walletDiskRelationDao.selectMyRunningDiskByUserId(userId, "HUIMIN");
		List<WalletDiskRelationVO> fumins = walletDiskRelationDao.selectMyRunningDiskByUserId(userId, "FUMIN");
		List<WalletDiskRelationVO> xingmins = walletDiskRelationDao.selectMyRunningDiskByUserId(userId, "XINGMIN");
		platformProfitExtendVO.setTiyan(tiyans == null || tiyans.size() == 0 ? "N" : "Y");
		platformProfitExtendVO.setHuimin(huimins == null || huimins.size() == 0 ? "N" : "Y");
		platformProfitExtendVO.setFumin(fumins == null || fumins.size() == 0 ? "N" : "Y");
		platformProfitExtendVO.setXingmin(xingmins == null || xingmins.size() == 0 ? "N" : "Y");
		return platformProfitExtendVO;
	}

	@Override
	public PagedResult<MerchantsSalesRelationVO> getMerchantsSalesRelationByUserId(UserVO userVo, Integer currentPage,
			Integer pageSize) {
		currentPage = currentPage == null ? 1 : currentPage;
		pageSize = pageSize == null ? 10 : pageSize;
		// startPage是告诉拦截器说我要开始分页了
		PageHelper.startPage(currentPage, pageSize);
		return BeanUtils.toPagedResult(
				earningDao.getMerchantsSalesRelationByUserId(userVo.getUserId(), userVo.getBusinessUserId()));
	}

	@Override
	public PagedResult<BusinessRelationVO> getBusinessRelationByUserId(UserVO userVo, Integer currentPage,
			Integer pageSize) {
		currentPage = currentPage == null ? 1 : currentPage;
		pageSize = pageSize == null ? 10 : pageSize;
		// startPage是告诉拦截器说我要开始分页了
		PageHelper.startPage(currentPage, pageSize);
		return BeanUtils.toPagedResult(earningDao.getBusinessRelationByUserId(userVo.getUserId()));
	}

	@Override
	public PagedResult<?> getDiskProfitDetailByUserId(UserVO userVo, String para, Integer currentPage,
			Integer pageSize) {
		logger.info("进入查询用户收益详情记录的方法：userId={},para={}", userVo.getUserId(), para);
		currentPage = currentPage == null ? 1 : currentPage;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(currentPage, pageSize);
		// if (para.equals("ALL")) {
		/*
		 * List<ProfitDetailVO> profitDetailVOs =
		 * earningDao.getMemberProfitDetailByUserId(userVo.getUserId(),
		 * "TIYAN");
		 * profitDetailVOs.addAll(earningDao.getMemberProfitDetailByUserId(
		 * userVo.getUserId(), "HUIMIN"));
		 * profitDetailVOs.addAll(earningDao.getMemberProfitDetailByUserId(
		 * userVo.getUserId(), "FUMIN"));
		 * profitDetailVOs.addAll(earningDao.getMemberProfitDetailByUserId(
		 * userVo.getUserId(), "XINGMIN"));
		 */
		List<ProfitDetailVO> profitDetailVOs = earningDao.queryMemberAllProfitInfo(userVo.getUserId(), para);
		return BeanUtils.toPagedResult(profitDetailVOs);
		// } else {
		// return
		// BeanUtils.toPagedResult(earningDao.getMemberProfitDetailByUserId(userVo.getUserId(),
		// para));
		// }
	}

	@Override
	public PagedResult<NullPointVO> getUnderThePlateNullPointByUserId(UserVO userVo, String diskType,
			Integer currentPage, Integer pageSize) {
		currentPage = currentPage == null ? 1 : currentPage;
		pageSize = pageSize == null ? 10 : pageSize;
		List<NullPointVO> nullPointVOs = new ArrayList<>();
		if (!diskType.equals("ALL")) {
			WalletDiskRelationVO walletDiskRelationVO = new WalletDiskRelationVO();
			walletDiskRelationVO.setActiveFlag("Y");
			walletDiskRelationVO.setDeleteFlag("N");
			walletDiskRelationVO.setUserId(userVo.getUserId());
			walletDiskRelationVO.setDiskStatus("RUNNING");
			walletDiskRelationVO.setDiskType(diskType);
			List<WalletDiskRelationVO> diskRelationVOs = walletDiskRelationDao
					.selectDiskRelationBySelective(walletDiskRelationVO);
			List<String> diskSeqs = new ArrayList<>();
			List<String> idCards = new ArrayList<>();
			for (WalletDiskRelationVO walletDiskRelationVO2 : diskRelationVOs) {
				diskSeqs.add(walletDiskRelationVO2.getDiskSeq());
			}
			if (diskSeqs.size() != 0) {
				List<DiskVO> diskVOs = diskDao.getDiskNamesByDiskSeqs(diskSeqs);
				// 通过盘号获得所有这些盘的经理IDCARDS
				List<WalletDiskRelationVO> managesLists = walletDiskRelationDao.getManagersByDiskSeqs("RUNNING", 2L,
						diskSeqs, diskType);
				for (WalletDiskRelationVO walletDiskRelationVO2 : managesLists) {
					idCards.add(walletDiskRelationVO2.getIdCard());
				}
				// 获得这些经理的userId
				List<Long> userIds = new ArrayList<>();
				for (WalletDiskRelationVO manage : managesLists) {
					userIds.add(manage.getUserId());
				}
				List<UserVO> userVOs = userDao.getUsersByUserIds(userIds);
				// startPage是告诉拦截器说我要开始分页了
				PageHelper.startPage(currentPage, pageSize);
				nullPointVOs = emptyPointDiskDao.getNullPointByIdCards(idCards);
				for (NullPointVO nullPointVO : nullPointVOs) {
					for (DiskVO diskVO : diskVOs) {
						if (nullPointVO.getDiskSeq().equals(diskVO.getDiskSeq())) {
							nullPointVO.setDiskSeq(diskVO.getDiskName());
						}
					}
				}
				for (NullPointVO nullPointVO : nullPointVOs) {
					for (UserVO userVO : userVOs) {
						if (userVO.getUserId().equals(nullPointVO.getUserId())) {
							nullPointVO.setNickName(userVO.getUserName());
						}
					}
				}
				return BeanUtils.toPagedResult(nullPointVOs);
			}
		} else {
			WalletDiskRelationVO walletDiskRelationVO = new WalletDiskRelationVO();
			walletDiskRelationVO.setActiveFlag("Y");
			walletDiskRelationVO.setDeleteFlag("N");
			walletDiskRelationVO.setUserId(userVo.getUserId());
			walletDiskRelationVO.setDiskStatus("RUNNING");
			walletDiskRelationVO.setDiskType("TIYAN");
			// 拿到该用户在该系统中正在运行的所有盘关系
			List<WalletDiskRelationVO> diskRelationVOs = walletDiskRelationDao
					.selectDiskRelationBySelective(walletDiskRelationVO);
			walletDiskRelationVO.setDiskType("HUIMIN");
			diskRelationVOs.addAll(walletDiskRelationDao.selectDiskRelationBySelective(walletDiskRelationVO));
			walletDiskRelationVO.setDiskType("FUMIN");
			diskRelationVOs.addAll(walletDiskRelationDao.selectDiskRelationBySelective(walletDiskRelationVO));
			walletDiskRelationVO.setDiskType("XINGMIN");
			diskRelationVOs.addAll(walletDiskRelationDao.selectDiskRelationBySelective(walletDiskRelationVO));
			// 拿到所有盘号
			List<String> diskSeqs = new ArrayList<>();
			for (WalletDiskRelationVO walletDiskRelationVO2 : diskRelationVOs) {
				diskSeqs.add(walletDiskRelationVO2.getDiskSeq());
			}
			if (diskSeqs.size() != 0) {
				List<DiskVO> diskVOs = diskDao.getDiskNamesByDiskSeqs(diskSeqs);
				List<String> idCards = new ArrayList<>();
				// 通过盘号获得所有这些盘的经理
				List<WalletDiskRelationVO> managesLists = walletDiskRelationDao.getManagersByDiskSeqs("RUNNING", 2L,
						diskSeqs, "TIYAN");
				managesLists.addAll(walletDiskRelationDao.getManagersByDiskSeqs("RUNNING", 2L, diskSeqs, "HUIMIN"));
				managesLists.addAll(walletDiskRelationDao.getManagersByDiskSeqs("RUNNING", 2L, diskSeqs, "FUMIN"));
				managesLists.addAll(walletDiskRelationDao.getManagersByDiskSeqs("RUNNING", 2L, diskSeqs, "XINGMIN"));
				// 获得这些经理的userId
				List<Long> userIds = new ArrayList<>();
				for (WalletDiskRelationVO manage : managesLists) {
					userIds.add(manage.getUserId());
				}
				// 通过盘号获得所有这些盘的经理IDCARDS
				for (WalletDiskRelationVO walletDiskRelationVO2 : managesLists) {
					idCards.add(walletDiskRelationVO2.getIdCard());
				}
				List<UserVO> userVOs = userDao.getUsersByUserIds(userIds);
				// startPage是告诉拦截器说我要开始分页了
				PageHelper.startPage(currentPage, pageSize);
				nullPointVOs = emptyPointDiskDao.getNullPointByIdCards(idCards);
				for (NullPointVO nullPointVO : nullPointVOs) {
					for (DiskVO diskVO : diskVOs) {
						if (nullPointVO.getDiskSeq().equals(diskVO.getDiskSeq())) {
							nullPointVO.setDiskSeq(diskVO.getDiskName());
						}
					}
				}
				for (NullPointVO nullPointVO : nullPointVOs) {
					for (DiskVO diskVO : diskVOs) {
						if (nullPointVO.getDiskSeq().equals(diskVO.getDiskSeq())) {
							nullPointVO.setDiskSeq(diskVO.getDiskName());
						}
					}
				}
				for (NullPointVO nullPointVO : nullPointVOs) {
					for (UserVO userVO : userVOs) {
						if (userVO.getUserId().equals(nullPointVO.getUserId())) {
							nullPointVO.setNickName(userVO.getUserName());
						}
					}
				}
				return BeanUtils.toPagedResult(nullPointVOs);
			}
		}
		return BeanUtils.toPagedResult(nullPointVOs);
	}

	@Override
	public PagedResult<PointGrapRelationVO> getUnderThePlateGrapPointByUserId(UserVO userVo, String diskType,
			Integer currentPage, Integer pageSize) {
		currentPage = currentPage == null ? 1 : currentPage;
		pageSize = pageSize == null ? 10 : pageSize;
		if (!diskType.equals("ALL")) {
			// 拿到我在该系统中所有的正在活动的盘号
			WalletDiskRelationVO walletDiskRelationVO = new WalletDiskRelationVO();
			walletDiskRelationVO.setActiveFlag("Y");
			walletDiskRelationVO.setDeleteFlag("N");
			walletDiskRelationVO.setUserId(userVo.getUserId());
			walletDiskRelationVO.setDiskStatus("RUNNING");
			walletDiskRelationVO.setDiskType(diskType);
			// 拿到该用户在该系统中正在运行的所有盘关系
			List<WalletDiskRelationVO> diskRelationVOs = walletDiskRelationDao
					.selectDiskRelationBySelective(walletDiskRelationVO);
			// 拿到所有盘号
			List<String> diskSeqs = new ArrayList<>();
			for (WalletDiskRelationVO walletDiskRelationVO2 : diskRelationVOs) {
				diskSeqs.add(walletDiskRelationVO2.getDiskSeq());
			}
			if (diskSeqs.size() != 0) {
				// 拿到所有通盘
				List<DiskVO> diskVOs = diskDao.getByDiskSeqs(diskSeqs);
				diskSeqs.clear();
				for (DiskVO diskVO : diskVOs) {
					diskSeqs.add(diskVO.getDiskParentSeq());
				}
				if (diskSeqs.size() != 0) {
					diskVOs = diskDao.getDiskByParentDiskSeqs(diskSeqs);
					diskSeqs.clear();
					for (DiskVO diskVO : diskVOs) {
						diskSeqs.add(diskVO.getDiskSeq());
					}
					if (diskSeqs.size() != 0) {
						// startPage是告诉拦截器说我要开始分页了
						PageHelper.startPage(currentPage, pageSize);
						List<PointGrapRelationVO> grapRelationVOs = pointGrapRelationDao
								.getGrapRelationsByDiskSeqs(diskSeqs);
						List<String> idCards = new ArrayList<>();
						for (PointGrapRelationVO pointGrapRelationVO : grapRelationVOs) {
							idCards.add(pointGrapRelationVO.getIdCard());
						}
						if (idCards.size() != 0) {
							List<IdcardRelationVO> idcardRelationVOs = walletDiskRelationDao
									.getAllIdCardRelationByCurrentIdCards(idCards);
							List<Long> userIds = new ArrayList<>();
							for (IdcardRelationVO idcardRelationVO : idcardRelationVOs) {
								for (PointGrapRelationVO grapRelationVO : grapRelationVOs) {
									if (idcardRelationVO.getCurrentIdCard().equals(grapRelationVO.getIdCard())) {
										grapRelationVO.setUserId(idcardRelationVO.getUserId());
									}
								}
								userIds.add(idcardRelationVO.getUserId());
							}
							if (userIds.size() != 0) {
								List<UserVO> userVOs = userDao.getUsersByUserIds(userIds);
								for (PointGrapRelationVO pointGrapRelationVO : grapRelationVOs) {
									for (UserVO userVO2 : userVOs) {
										if (pointGrapRelationVO.getUserId().equals(userVO2.getUserId())) {
											pointGrapRelationVO.setNickName(userVO2.getUserName());
										}
									}
									for (IdcardRelationVO idcardRelationVO : idcardRelationVOs) {
										if (pointGrapRelationVO.getUserId().equals(idcardRelationVO.getUserId())) {
											pointGrapRelationVO.setRoleId(idcardRelationVO.getCurrentRoleId());
										}
									}
									for (DiskVO diskVO : diskVOs) {
										if (diskVO.getDiskSeq().equals(pointGrapRelationVO.getDiskSeq())) {
											pointGrapRelationVO.setDiskSeq(diskVO.getDiskName());
										}
									}
								}
								return BeanUtils.toPagedResult(grapRelationVOs);
							}
						}
					}

				}

			}
			return BeanUtils.toPagedResult(new ArrayList<PointGrapRelationVO>());

		} else {
			// 拿到我在该系统中所有的正在活动的盘号
			WalletDiskRelationVO walletDiskRelationVO = new WalletDiskRelationVO();
			walletDiskRelationVO.setActiveFlag("Y");
			walletDiskRelationVO.setDeleteFlag("N");
			walletDiskRelationVO.setUserId(userVo.getUserId());
			walletDiskRelationVO.setDiskStatus("RUNNING");
			walletDiskRelationVO.setDiskType("TIYAN");
			// 拿到该用户在该系统中正在运行的所有盘关系
			List<WalletDiskRelationVO> diskRelationVOs = walletDiskRelationDao
					.selectDiskRelationBySelective(walletDiskRelationVO);
			walletDiskRelationVO.setDiskType("HUIMIN");
			diskRelationVOs.addAll(walletDiskRelationDao.selectDiskRelationBySelective(walletDiskRelationVO));
			walletDiskRelationVO.setDiskType("FUMIN");
			diskRelationVOs.addAll(walletDiskRelationDao.selectDiskRelationBySelective(walletDiskRelationVO));
			walletDiskRelationVO.setDiskType("XINGMIN");
			diskRelationVOs.addAll(walletDiskRelationDao.selectDiskRelationBySelective(walletDiskRelationVO));
			// 拿到所有盘号
			List<String> diskSeqs = new ArrayList<>();
			for (WalletDiskRelationVO walletDiskRelationVO2 : diskRelationVOs) {
				diskSeqs.add(walletDiskRelationVO2.getDiskSeq());
			}
			if (diskSeqs.size() != 0) {
				// 拿到所有通盘
				List<DiskVO> diskVOs = diskDao.getByDiskSeqs(diskSeqs);
				diskSeqs.clear();
				for (DiskVO diskVO : diskVOs) {
					diskSeqs.add(diskVO.getDiskParentSeq());
				}
				if (diskSeqs.size() != 0) {
					diskVOs = diskDao.getDiskByParentDiskSeqs(diskSeqs);
					diskSeqs.clear();
					for (DiskVO diskVO : diskVOs) {
						diskSeqs.add(diskVO.getDiskSeq());
					}
					if (diskSeqs.size() != 0) {
						// startPage是告诉拦截器说我要开始分页了
						PageHelper.startPage(currentPage, pageSize);
						List<PointGrapRelationVO> grapRelationVOs = pointGrapRelationDao
								.getGrapRelationsByDiskSeqs(diskSeqs);
						List<String> idCards = new ArrayList<>();
						for (PointGrapRelationVO pointGrapRelationVO : grapRelationVOs) {
							idCards.add(pointGrapRelationVO.getIdCard());
						}
						if (idCards.size() != 0) {
							List<IdcardRelationVO> idcardRelationVOs = walletDiskRelationDao
									.getAllIdCardRelationByCurrentIdCards(idCards);
							List<Long> userIds = new ArrayList<>();
							for (IdcardRelationVO idcardRelationVO : idcardRelationVOs) {
								for (PointGrapRelationVO grapRelationVO : grapRelationVOs) {
									if (idcardRelationVO.getCurrentIdCard().equals(grapRelationVO.getIdCard())) {
										grapRelationVO.setUserId(idcardRelationVO.getUserId());
									}
								}
								userIds.add(idcardRelationVO.getUserId());
							}
							if (userIds.size() != 0) {
								List<UserVO> userVOs = userDao.getUsersByUserIds(userIds);
								for (PointGrapRelationVO pointGrapRelationVO : grapRelationVOs) {
									for (UserVO userVO2 : userVOs) {
										if (pointGrapRelationVO.getUserId().equals(userVO2.getUserId())) {
											pointGrapRelationVO.setNickName(userVO2.getUserName());
										}
									}
									for (IdcardRelationVO idcardRelationVO : idcardRelationVOs) {
										if (pointGrapRelationVO.getIdCard()
												.equals(idcardRelationVO.getCurrentIdCard())) {
											pointGrapRelationVO.setRoleId(idcardRelationVO.getCurrentRoleId());
										}
									}
									for (DiskVO diskVO : diskVOs) {
										if (diskVO.getDiskSeq().equals(pointGrapRelationVO.getDiskSeq())) {
											pointGrapRelationVO.setDiskSeq(diskVO.getDiskName());
										}
									}
								}
								return BeanUtils.toPagedResult(grapRelationVOs);
							}
						}
					}

				}

			}
			return BeanUtils.toPagedResult(new ArrayList<PointGrapRelationVO>());
		}
	}

	@Override
	public List<List<?>> getDiskUserRelationVOs(String diskSeq, Long userId) {
		DiskVO diskVo = diskDao.getByDiskSeq(diskSeq);
		List<DiskUserRelationVO> userRelationVOs = earningDao.getDiskUserRelationByDiskSeq(diskVo.getDiskType(),
				diskSeq);
		List<Long> userIds = new ArrayList<>();
		for (DiskUserRelationVO diskUserRelationVO : userRelationVOs) {
			userIds.add(diskUserRelationVO.getUserId());
		}
		DatabaseContextHolder.setDatabaseType(DatabaseType.mallDataSource);
		List<UserVO> pics = earningDao.getUserPicUrl(userIds);
		for (UserVO userVO : pics) {
			for (DiskUserRelationVO diskUserRelationVO : userRelationVOs) {
				if (diskUserRelationVO.getUserId().equals(userVO.getMemberId())) {
					diskUserRelationVO.setHeadImgUrl(userVO.getPicUrl());
				}
			}
		}
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		List<List<?>> bigList = new ArrayList<>();
		// list1用来存放总监，里面只有总监一个对象
		List<DiskUserRelationVO> list1 = new ArrayList<DiskUserRelationVO>();
		// list2用来存放经理，里面只有三个经理
		List<DiskUserRelationVO> list2 = new ArrayList<DiskUserRelationVO>();
		// list3 用来存放 三个小组，每个小组里面最多有3个规划师
		List<List<?>> list3 = new ArrayList<>();
		// list4用来存放 三个小组 每个小组里面最多有9个会员
		List<List<?>> list4 = new ArrayList<>();
		// list5里面放用户自己
		List<DiskUserRelationVO> list5 = new ArrayList<>();
		// list6里面放抢点人 （可能为空,最多三条数据）
		List<DiskUserRelationVO> list6 = new ArrayList<DiskUserRelationVO>();
		// list7里面放三个字段
		DiskUserRelationVO tmp = new DiskUserRelationVO();
		List<PointGrapRelationVO> grapUser = diskDao.getPointGrapRelationByDiskSeq(diskSeq);
		DiskProfitVO diskProfitVO;
		if (grapUser.size() != 0) {
			for (PointGrapRelationVO pointGrapRelationVO : grapUser) {
				IdcardRelationVO idcardRelationVO = walletDiskRelationDao
						.getIdCardRelationByCurrentIdCard(null, pointGrapRelationVO.getIdCard()).get(0);
				List<DiskProfitVO> diskProfitVOs = earningDao.getDiskProfitByAnyThings(idcardRelationVO.getUserId(),
						null, diskSeq, null);
				diskProfitVO = diskProfitVOs.size() == 0 ? null : diskProfitVOs.get(0);
				tmp.setCurrentProfit(diskProfitVO.getDiskProfitAmount());
				tmp.setUserId(diskProfitVO.getUserId());
				tmp.setNickName(diskProfitVO.getNickName());
				list6.add(tmp);
			}
		}
		List<String> list7 = new ArrayList<String>();
		switch (diskVo.getDiskType()) {
		case "TIYAN":
			list7.add("银卡会员");
			list7.add("500");
			list7.add("4");
			break;
		case "HUIMIN":
			list7.add("金卡会员");
			list7.add("5000");
			list7.add("4");
			break;
		case "FUMIN":
			list7.add("钻卡会员");
			list7.add("50000");
			list7.add("4");
			break;
		case "XINGMIN":
			list7.add("至尊会员");
			list7.add("500000");
			list7.add("4");
			break;
		}

		// 下面的list是为了配合前端页面数据绑定将他们分为小组
		List<DiskUserRelationVO> list31 = new ArrayList<DiskUserRelationVO>();
		List<DiskUserRelationVO> list32 = new ArrayList<DiskUserRelationVO>();
		List<DiskUserRelationVO> list33 = new ArrayList<DiskUserRelationVO>();
		List<DiskUserRelationVO> list41 = new ArrayList<DiskUserRelationVO>();
		List<DiskUserRelationVO> list42 = new ArrayList<DiskUserRelationVO>();
		List<DiskUserRelationVO> list43 = new ArrayList<DiskUserRelationVO>();
		for (DiskUserRelationVO diskUserRelationVO : userRelationVOs) {
			if (diskUserRelationVO.getRoleId() == 1) {
				list1.add(diskUserRelationVO);
			} else if (diskUserRelationVO.getRoleId() == 2) {
				list2.add(diskUserRelationVO);
			} else if (diskUserRelationVO.getRoleId() == 3) {
				if ("5,6,7".contains(diskUserRelationVO.getLocaltion().toString())) {
					list31.add(diskUserRelationVO);
				} else if ("8,9,10".contains(diskUserRelationVO.getLocaltion().toString())) {
					list32.add(diskUserRelationVO);
				} else if ("11,12,13".contains(diskUserRelationVO.getLocaltion().toString())) {
					list33.add(diskUserRelationVO);
				}
			} else if (diskUserRelationVO.getRoleId() == 4) {
				if ("14,17,20,23,26,29,32,35,38".contains(diskUserRelationVO.getLocaltion().toString())) {
					list41.add(diskUserRelationVO);
				} else if ("15,18,21,24,27,30,33,36,39".contains(diskUserRelationVO.getLocaltion().toString())) {
					list42.add(diskUserRelationVO);
				} else if ("16,19,22,25,28,31,34,37,40".contains(diskUserRelationVO.getLocaltion().toString())) {
					list43.add(diskUserRelationVO);
				}
			}
			if (userId.toString().equals(diskUserRelationVO.getUserId().toString())) {
				list5.add(diskUserRelationVO);
			}
		}
		list3.add(list31);
		list3.add(list32);
		list3.add(list33);
		list4.add(list41);
		list4.add(list42);
		list4.add(list43);
		bigList.add(list1);
		bigList.add(list2);
		bigList.add(list3);
		bigList.add(list4);
		bigList.add(list5);
		bigList.add(list6);
		bigList.add(list7);
		return bigList;
	}

	@Override
	public PagedResult<RecommendVO> getRecommendDetail(UserVO userVo, String diskType, Integer currentPage,
			Integer pageSize) {
		currentPage = currentPage == null ? 1 : currentPage;
		pageSize = pageSize == null ? 10 : pageSize;
		// startPage是告诉拦截器说我要开始分页了
		PageHelper.startPage(currentPage, pageSize);
		return BeanUtils.toPagedResult(earningDao.getRecommendDetail(diskType, userVo.getUserId()));
	}

	@Override
	public PagedResult<PlatformInviteDetailExtendVO> getPlatformInviteDetail(UserVO userVo, Integer currentPage,
			Integer pageSize) {
		currentPage = currentPage == null ? 1 : currentPage;
		pageSize = pageSize == null ? 10 : pageSize;
		// startPage是告诉拦截器说我要开始分页了
		PageHelper.startPage(currentPage, pageSize);
		return BeanUtils.toPagedResult(earningDao.getPlatformInviteDetail(userVo.getUserId()));
	}

	@Override
	public List<PlatformInviteDetailExtendVO> getPlatformInviteDetail2(UserVO userVo) {
		return earningDao.getPlatformInviteDetail(userVo.getUserId());
	}

	@Override
	public List<PlatformInviteDetailExtendVO> getPlatformInviteDetail3(UserVO userVo) {
		List<PlatformInviteDetailExtendVO> list = earningDao.getPlatformInviteDetail(userVo.getUserId());
		list = earningDao.getPlatformInviteDetail(list.get(0).getReceiveUserId());
		return list;
	}

	@Override
	public PlatformInviteVO getPlatformInvite(UserVO userVo) {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		PlatformInviteVO platformInviteVO = earningDao.getPlatformInvite(userVo.getUserId());
		if (platformInviteVO == null) {
			platformInviteVO = new PlatformInviteVO();
		}
		platformInviteVO.setLevel2UserCounter(earningDao.getLevel2Counter(userVo.getUserId()));
		return platformInviteVO;
	}

	@Override
	public List<DiskRelationCustromVO> getDiskRelationCustromVO(String diskType, UserVO userVO) {
		List<DiskRelationCustromVO> diskRelationCustromVOs = diskDao.getDiskRelationCustromVO(diskType,
				userVO.getUserId());
		if(diskRelationCustromVOs.size()==0){
			diskRelationCustromVOs = diskDao.getDiskRelationCustromVO1(diskType,
					userVO.getUserId());
		}
		for (DiskRelationCustromVO diskRelationCustromVO : diskRelationCustromVOs) {
			diskRelationCustromVO
					.setMemberCounter(diskDao.getDiskMemberCounter(diskRelationCustromVO.getDiskSeq(), diskType));
			if (diskRelationCustromVO.getRoleId() == 1) {
				RecommendBPointStatisticsVO recommendBPointStatisticsVO = pointDao
						.getBPointCountByIdCard(diskRelationCustromVO.getIdCard());
				List<KeyPointRecommendVO> keyPointRecommendVOs = keyPointRecommendDao
						.getKeyRecommendPointsByIdCard(diskRelationCustromVO.getIdCard());
				if (recommendBPointStatisticsVO == null) {
					if (keyPointRecommendVOs != null) {
						diskRelationCustromVO.setRecommendPoints(keyPointRecommendVOs.size());
					} else {
						diskRelationCustromVO.setRecommendPoints(0);
					}
				} else {
					if (keyPointRecommendVOs != null) {
						diskRelationCustromVO.setRecommendPoints(recommendBPointStatisticsVO.getRemainRecommendPoint()
								+ (keyPointRecommendVOs.size() * 2));
					} else {
						diskRelationCustromVO.setRecommendPoints(recommendBPointStatisticsVO.getRemainRecommendPoint());
					}
				}
			} else {
				RecommendAPointStatisticsVO recommendAPointStatisticsVO = pointDao
						.getAStatisticsByUserId(userVO.getUserId(), diskType);
				List<KeyPointRecommendVO> keyPointRecommendVOs = keyPointRecommendDao
						.getKeyRecommendPointsByUserId(userVO.getUserId());
				if (recommendAPointStatisticsVO == null) {
					if (keyPointRecommendVOs != null) {
						diskRelationCustromVO.setRecommendPoints(keyPointRecommendVOs.size());
					} else {
						diskRelationCustromVO.setRecommendPoints(0);
					}
					diskRelationCustromVO.setRecommendPoints(0);
				} else {
					if (keyPointRecommendVOs != null) {
						diskRelationCustromVO.setRecommendPoints(recommendAPointStatisticsVO.getRemainRecommendPoint()
								+ (keyPointRecommendVOs.size() * 2));
					} else {
						diskRelationCustromVO.setRecommendPoints(recommendAPointStatisticsVO.getRemainRecommendPoint());
					}
				}
			}
			List<NullPointVO> nullPointVOs = getUnderThePlateNullPointByUserId(userVO, diskType);
			Integer emptyPoint = 0;
			if (null != nullPointVOs && nullPointVOs.size() > 0) {
				for (int i = 0; i < nullPointVOs.size(); i++) {
					emptyPoint = emptyPoint + nullPointVOs.get(i).getEmptyPoint();
				}
			}
			diskRelationCustromVO.setNullPoints(emptyPoint);
			List<Integer> unders = DiskRelationRuleUtils.getUnderList(diskRelationCustromVO.getLocaltion());
			if (unders != null) {
				List<WalletDiskRelationVO> diskRelationVOs = walletDiskRelationDao
						.getDiskRelationVOBylocation(diskRelationCustromVO.getDiskSeq(), diskType, unders);
				List<Integer> locations = new ArrayList<>();
				for (WalletDiskRelationVO diskRelationVO : diskRelationVOs) {
					locations.add(diskRelationVO.getLocaltion());
				}
				diskRelationCustromVO.setMyUnder(diskRelationVOs.size());
				diskRelationCustromVO.setMyUnderLocation(locations);
			} else {
				diskRelationCustromVO.setMyUnder(0);
			}
			List<WalletDiskRelationVO> diskRelationVOs = walletDiskRelationDao.selectDiskRelation(diskType,
					diskRelationCustromVO.getDiskSeq());
			List<Long> userIds = new ArrayList<>();
			for (WalletDiskRelationVO walletDiskRelationVO : diskRelationVOs) {
				userIds.add(walletDiskRelationVO.getUserId());
			}
			List<UserVO> userVOs = userDao.getUsersByUserIds(userIds);
			List<Integer> locations = new ArrayList<>();
			if (null != userVOs && userVOs.size() > 0) {
				for (UserVO userVO1 : userVOs) {
					for (WalletDiskRelationVO walletDiskRelationVO : diskRelationVOs) {
						if (userVO1.getUserId().equals(walletDiskRelationVO.getUserId())) {
							if (null != userVO1.getReferenceId()) {
								if (userVO1.getReferenceId().equals(userVO.getUserId())) {
									locations.add(walletDiskRelationVO.getLocaltion());
								}
							}
						}
					}
				}
			}
			diskRelationCustromVO.setMyPushLocation(locations);
			diskRelationCustromVO.setDirectPush(locations.size());
		}
		return diskRelationCustromVOs;
	}

	@Override
	public DiskRelationCustromVO getDiskRelationCustromVOByLocation(String diskType, String diskSeq, Integer location,
			UserVO userVo) {
		DiskRelationCustromVO diskRelationCustromVO = new DiskRelationCustromVO();
		WalletDiskRelationVO diskRelationVO = walletDiskRelationDao
				.getDiskRelationVOBylocation(diskSeq, diskType, new ArrayList<Integer>(Arrays.asList(location))).get(0);
		DatabaseContextHolder.setDatabaseType(DatabaseType.mallDataSource);
		List<Long> userIds = new ArrayList<>();
		userIds.add(diskRelationVO.getUserId());
		List<UserVO> userVOs = earningDao.getUserPicUrl(userIds);
		if (userVOs.size() != 0) {
			diskRelationCustromVO.setHeadPic(userVOs.get(0).getPicUrl());
		}
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		userVOs = userDao.getUsersByUserIds(userIds);
		diskRelationCustromVO.setUserName(userVOs.get(0).getUserName());
		diskRelationCustromVO.setRoleId(diskRelationVO.getRoleId());
		if (diskRelationVO.getRoleId().equals(1L)) {
			RecommendBPointStatisticsVO recommendBPointStatisticsVO = pointDao
					.getBPointCountByIdCard(diskRelationVO.getIdCard());
			List<KeyPointRecommendVO> keyPointRecommendVOs = keyPointRecommendDao
					.getKeyRecommendPointsByIdCard(diskRelationVO.getIdCard());
			if (recommendBPointStatisticsVO == null) {
				if (keyPointRecommendVOs != null) {
					diskRelationCustromVO.setRecommendPoints(keyPointRecommendVOs.size());
				} else {
					diskRelationCustromVO.setRecommendPoints(0);
				}
			} else {
				if (keyPointRecommendVOs != null) {
					diskRelationCustromVO.setRecommendPoints(
							recommendBPointStatisticsVO.getRemainRecommendPoint() + (keyPointRecommendVOs.size() * 2));
				} else {
					diskRelationCustromVO.setRecommendPoints(recommendBPointStatisticsVO.getRemainRecommendPoint());
				}
			}
		} else {
			RecommendAPointStatisticsVO recommendAPointStatisticsVO = pointDao
					.getAStatisticsByUserId(diskRelationVO.getUserId(), diskType);
			List<KeyPointRecommendVO> keyPointRecommendVOs = keyPointRecommendDao
					.getKeyRecommendPointsByUserId(diskRelationVO.getUserId());
			if (recommendAPointStatisticsVO == null) {
				if (keyPointRecommendVOs != null) {
					diskRelationCustromVO.setRecommendPoints(keyPointRecommendVOs.size());
				} else {
					diskRelationCustromVO.setRecommendPoints(0);
				}
				diskRelationCustromVO.setRecommendPoints(0);
			} else {
				if (keyPointRecommendVOs != null) {
					diskRelationCustromVO.setRecommendPoints(
							recommendAPointStatisticsVO.getRemainRecommendPoint() + (keyPointRecommendVOs.size() * 2));
				} else {
					diskRelationCustromVO.setRecommendPoints(recommendAPointStatisticsVO.getRemainRecommendPoint());
				}
			}
		}
		List<WalletDiskRelationVO> diskRelationVOs = walletDiskRelationDao.selectDiskRelation(diskType, diskSeq);
		userIds = new ArrayList<>();
		for (WalletDiskRelationVO walletDiskRelationVO : diskRelationVOs) {
			userIds.add(walletDiskRelationVO.getUserId());
		}
		userVOs = userDao.getUsersByUserIds(userIds);
		List<Integer> locations = new ArrayList<>();
		for (UserVO userVO1 : userVOs) {
			for (WalletDiskRelationVO walletDiskRelationVO : diskRelationVOs) {
				if (userVO1.getUserId().equals(walletDiskRelationVO.getUserId())) {
					if (userVO1.getReferenceId().equals(diskRelationVO.getUserId())) {
						locations.add(walletDiskRelationVO.getLocaltion());
					}
				}
			}
		}
		diskRelationCustromVO.setMyPushLocation(locations);
		diskRelationCustromVO.setDirectPush(locations.size());

		return diskRelationCustromVO;
	}

	public List<NullPointVO> getUnderThePlateNullPointByUserId(UserVO userVo, String diskType) {
		List<NullPointVO> nullPointVOs = new ArrayList<>();
		if (!diskType.equals("ALL")) {
			WalletDiskRelationVO walletDiskRelationVO = new WalletDiskRelationVO();
			walletDiskRelationVO.setActiveFlag("Y");
			walletDiskRelationVO.setDeleteFlag("N");
			walletDiskRelationVO.setUserId(userVo.getUserId());
			walletDiskRelationVO.setDiskStatus("RUNNING");
			walletDiskRelationVO.setDiskType(diskType);
			List<WalletDiskRelationVO> diskRelationVOs = walletDiskRelationDao
					.selectDiskRelationBySelective(walletDiskRelationVO);
			List<String> diskSeqs = new ArrayList<>();
			List<String> idCards = new ArrayList<>();
			for (WalletDiskRelationVO walletDiskRelationVO2 : diskRelationVOs) {
				diskSeqs.add(walletDiskRelationVO2.getDiskSeq());
			}
			if (diskSeqs.size() != 0) {
				List<DiskVO> diskVOs = diskDao.getDiskNamesByDiskSeqs(diskSeqs);
				List<WalletDiskRelationVO> managesLists = walletDiskRelationDao.getManagersByDiskSeqs("RUNNING", 2L,
						diskSeqs, diskType);
				for (WalletDiskRelationVO walletDiskRelationVO2 : managesLists) {
					idCards.add(walletDiskRelationVO2.getIdCard());
				}
				List<Long> userIds = new ArrayList<>();
				for (WalletDiskRelationVO manage : managesLists) {
					userIds.add(manage.getUserId());
				}
				List<UserVO> userVOs = userDao.getUsersByUserIds(userIds);
				nullPointVOs = emptyPointDiskDao.getNullPointByIdCards(idCards);
				for (NullPointVO nullPointVO : nullPointVOs) {
					for (DiskVO diskVO : diskVOs) {
						if (nullPointVO.getDiskSeq().equals(diskVO.getDiskSeq())) {
							nullPointVO.setDiskSeq(diskVO.getDiskName());
						}
					}
				}
				for (NullPointVO nullPointVO : nullPointVOs) {
					for (UserVO userVO : userVOs) {
						if (userVO.getUserId().equals(nullPointVO.getUserId())) {
							nullPointVO.setNickName(userVO.getUserName());
						}
					}
				}
				return nullPointVOs;
			}
		} else {
			WalletDiskRelationVO walletDiskRelationVO = new WalletDiskRelationVO();
			walletDiskRelationVO.setActiveFlag("Y");
			walletDiskRelationVO.setDeleteFlag("N");
			walletDiskRelationVO.setUserId(userVo.getUserId());
			walletDiskRelationVO.setDiskStatus("RUNNING");
			walletDiskRelationVO.setDiskType("TIYAN");
			List<WalletDiskRelationVO> diskRelationVOs = walletDiskRelationDao
					.selectDiskRelationBySelective(walletDiskRelationVO);
			walletDiskRelationVO.setDiskType("HUIMIN");
			diskRelationVOs.addAll(walletDiskRelationDao.selectDiskRelationBySelective(walletDiskRelationVO));
			walletDiskRelationVO.setDiskType("FUMIN");
			diskRelationVOs.addAll(walletDiskRelationDao.selectDiskRelationBySelective(walletDiskRelationVO));
			walletDiskRelationVO.setDiskType("XINGMIN");
			diskRelationVOs.addAll(walletDiskRelationDao.selectDiskRelationBySelective(walletDiskRelationVO));
			List<String> diskSeqs = new ArrayList<>();
			for (WalletDiskRelationVO walletDiskRelationVO2 : diskRelationVOs) {
				diskSeqs.add(walletDiskRelationVO2.getDiskSeq());
			}
			if (diskSeqs.size() != 0) {
				List<DiskVO> diskVOs = diskDao.getDiskNamesByDiskSeqs(diskSeqs);
				List<String> idCards = new ArrayList<>();
				List<WalletDiskRelationVO> managesLists = walletDiskRelationDao.getManagersByDiskSeqs("RUNNING", 2L,
						diskSeqs, "TIYAN");
				managesLists.addAll(walletDiskRelationDao.getManagersByDiskSeqs("RUNNING", 2L, diskSeqs, "HUIMIN"));
				managesLists.addAll(walletDiskRelationDao.getManagersByDiskSeqs("RUNNING", 2L, diskSeqs, "FUMIN"));
				managesLists.addAll(walletDiskRelationDao.getManagersByDiskSeqs("RUNNING", 2L, diskSeqs, "XINGMIN"));
				List<Long> userIds = new ArrayList<>();
				for (WalletDiskRelationVO manage : managesLists) {
					userIds.add(manage.getUserId());
				}
				for (WalletDiskRelationVO walletDiskRelationVO2 : managesLists) {
					idCards.add(walletDiskRelationVO2.getIdCard());
				}
				List<UserVO> userVOs = userDao.getUsersByUserIds(userIds);
				nullPointVOs = emptyPointDiskDao.getNullPointByIdCards(idCards);
				for (NullPointVO nullPointVO : nullPointVOs) {
					for (DiskVO diskVO : diskVOs) {
						if (nullPointVO.getDiskSeq().equals(diskVO.getDiskSeq())) {
							nullPointVO.setDiskSeq(diskVO.getDiskName());
						}
					}
				}
				for (NullPointVO nullPointVO : nullPointVOs) {
					for (DiskVO diskVO : diskVOs) {
						if (nullPointVO.getDiskSeq().equals(diskVO.getDiskSeq())) {
							nullPointVO.setDiskSeq(diskVO.getDiskName());
						}
					}
				}
				for (NullPointVO nullPointVO : nullPointVOs) {
					for (UserVO userVO : userVOs) {
						if (userVO.getUserId().equals(nullPointVO.getUserId())) {
							nullPointVO.setNickName(userVO.getUserName());
						}
					}
				}
				return nullPointVOs;
			}
		}
		return nullPointVOs;
	}

	@Override
	public String getDiskUserRelation() {
		LevelRelationshipVO levelRelationshipVO = levelRelationshipDao.selectLevelRelation();
		return levelRelationshipVO == null ? "N" : levelRelationshipVO.getLevelRelation();
	}

	@Override
	public List<String> getIdcardsByDiskType(Long userId, String diskType, String diskStatus) {
		List<WalletDiskRelationVO> diskRelationVOs = walletDiskRelationDao.getDiskRelationsByUserId(diskType, userId,
				diskStatus);
		List<String> idCards = new ArrayList<>();
		for (WalletDiskRelationVO walletDiskRelationVO : diskRelationVOs) {
			idCards.add(walletDiskRelationVO.getIdCard());
		}
		return idCards;
	}

	@Override
	public List<DiskDetailCustromVO> getDiskDetailLists(List<String> idCards, String diskType) {
		List<DiskDetailCustromVO> detailCustromVOs = new ArrayList<>();
		for (String idCard : idCards) {
			detailCustromVOs.add(getDiskDetail(idCard, diskType));
		}
		return detailCustromVOs;
	}

	@Override
	public DiskDetailCustromVO getDiskDetail(String idCard, String diskType) {
		IdcardRelationVO idcardRelationVO = walletDiskRelationDao.getIdCardRelationByCurrentIdCard(null, idCard).get(0);

		List<DiskProfitVO> diskProfitList = earningDao.getDiskProfitByAnyThings(idcardRelationVO.getUserId(), null,
				idcardRelationVO.getCurrentDiskSeq(), diskType);
		if (null == diskProfitList || diskProfitList.size() < 1) {
			return null;
		}
		DiskProfitVO diskProfitVO = diskProfitList.get(0);
		DiskDetailCustromVO diskDetailCustromVO = new DiskDetailCustromVO();
		diskDetailCustromVO
				.setTodayNewCounter(diskDao.getDiskTodayNewCounter(idcardRelationVO.getCurrentDiskSeq(), diskType));
		diskDetailCustromVO.setCurrentCounter(diskProfitVO.getDiskCounter());
		diskDetailCustromVO.setCurrentProfit(diskProfitVO.getDiskProfitAmount());
		diskDetailCustromVO.setDiskStatus(diskProfitVO.getDiskStatus());
		switch (diskType) {
		case "TIYAN":
			diskDetailCustromVO.setJoinAmount(new BigDecimal(500));
			diskDetailCustromVO.setMilestone("银卡会员");
			break;
		case "HUIMIN":
			diskDetailCustromVO.setJoinAmount(new BigDecimal(5000));
			diskDetailCustromVO.setMilestone("金卡会员");
			break;
		case "FUMIN":
			diskDetailCustromVO.setJoinAmount(new BigDecimal(50000));
			diskDetailCustromVO.setMilestone("钻卡会员");
			break;
		case "XINGMIN":
			diskDetailCustromVO.setJoinAmount(new BigDecimal(500000));
			diskDetailCustromVO.setMilestone("至尊会员");
			break;
		}
		BigDecimal rcgAmount = diskDao.getDiskRechargeAmountByUserId(idcardRelationVO.getUserId(), diskType);
		diskDetailCustromVO.setAllRcgAmount(rcgAmount == null ? BigDecimal.valueOf(0) : rcgAmount);
		List<String> records = new ArrayList<>();
		records.add(idcardRelationVO.getCurrentIdCard());
		WalletDiskRelationVO diskRelationVO = walletDiskRelationDao.getDiskRelationsByIdCards(diskType, records).get(0);
		diskDetailCustromVO.setLocation(diskRelationVO.getLocaltion());
		diskDetailCustromVO.setRoleId(diskRelationVO.getRoleId());
		diskDetailCustromVO.setUserName(userDao.getUserByUserId(idcardRelationVO.getUserId()).getNickName());
		diskDetailCustromVO.setDiskSeq(diskProfitVO.getDiskSeq());
		diskDetailCustromVO.setDiskName(diskProfitVO.getDiskName());
		diskDetailCustromVO.setDiskRelationVOs(
				walletDiskRelationDao.selectDiskRelationOverWrite(diskType, diskProfitVO.getDiskSeq()));
		DatabaseContextHolder.setDatabaseType(DatabaseType.mallDataSource);
		List<Long> userIds = new ArrayList<>();
		userIds.add(idcardRelationVO.getUserId());
		List<UserVO> userVOs = earningDao.getUserPicUrl(userIds);
		if (userVOs.size() != 0) {
			diskDetailCustromVO.setPicUrl(userVOs.get(0).getPicUrl());
		}
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		if (diskDetailCustromVO.getRoleId().equals(1L)) {
			List<DiskDetailCustromVO> grapVOs = new ArrayList<>();
			List<String> diskSeqs = new ArrayList<>();
			diskSeqs.add(idcardRelationVO.getCurrentDiskSeq());
			List<PointGrapRelationVO> grapRelationVOs = pointGrapRelationDao.getGrapRelationsByDiskSeqs(diskSeqs);
			for (PointGrapRelationVO pointGrapRelationVO : grapRelationVOs) {
				DiskDetailCustromVO grapVO = new DiskDetailCustromVO();
				if (!pointGrapRelationVO.getIdCard().equals(idCard)) {
					idcardRelationVO = walletDiskRelationDao
							.getIdCardRelationByCurrentIdCard(null, pointGrapRelationVO.getIdCard()).get(0);
					DatabaseContextHolder.setDatabaseType(DatabaseType.mallDataSource);
					userIds.clear();
					userIds.add(idcardRelationVO.getUserId());
					userVOs.clear();
					userVOs = earningDao.getUserPicUrl(userIds);
					DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
					if (userVOs.size() != 0) {
						grapVO.setPicUrl(userVOs.get(0).getPicUrl());
					}
					grapVO.setAllRcgAmount(
							diskDao.getDiskRechargeAmountByUserId(idcardRelationVO.getUserId(), diskType));
					switch (diskType) {
					case "TIYAN":
						grapVO.setJoinAmount(new BigDecimal(500));
						grapVO.setMilestone("银卡会员");
						break;
					case "HUIMIN":
						grapVO.setJoinAmount(new BigDecimal(5000));
						grapVO.setMilestone("金卡会员");
						break;
					case "FUMIN":
						grapVO.setJoinAmount(new BigDecimal(50000));
						grapVO.setMilestone("砖石会员");
						break;
					case "XINGMIN":
						grapVO.setJoinAmount(new BigDecimal(500000));
						grapVO.setMilestone("至尊会员");
						break;
					}
					List<DiskProfitVO> diskProfitVOs = earningDao.getDiskProfitByAnyThings(idcardRelationVO.getUserId(),
							null, idcardRelationVO.getCurrentDiskSeq(), diskType);
					diskProfitVO = diskProfitVOs.size() == 0 ? new DiskProfitVO() : diskProfitVOs.get(0);
					grapVO.setCurrentProfit(diskProfitVO.getDiskProfitAmount());
					grapVOs.add(grapVO);
				}
				diskDetailCustromVO.setDiskDetailCustromVOs(grapVOs);
			}
		}
		return diskDetailCustromVO;
	}

}
