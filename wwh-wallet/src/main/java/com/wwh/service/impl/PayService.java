package com.wwh.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.dao.IFixedRebateDao;
import com.wwh.dao.IPayDetailDao;
import com.wwh.dao.IPlatformInviteDao;
import com.wwh.dao.IPlatformInviteDetailDao;
import com.wwh.dao.IPointDao;
import com.wwh.dao.IScoreDao;
import com.wwh.dao.IUserDao;
import com.wwh.dao.IWalletDiskRelationDao;
import com.wwh.enums.ActiveFlagEnum;
import com.wwh.enums.DatabaseType;
import com.wwh.enums.DeleteFlagEnum;
import com.wwh.enums.DiskStatusEnum;
import com.wwh.enums.FixedRebateEnum;
import com.wwh.enums.IsCalcuatedEnum;
import com.wwh.enums.PayAmountTypeEnum;
import com.wwh.enums.PayStatusEnum;
import com.wwh.enums.ProfitScoreTypeEnum;
import com.wwh.enums.WaittingTypeEnum;
import com.wwh.service.IDiskEnterService;
import com.wwh.service.IFixedRebateService;
import com.wwh.service.ILogService;
import com.wwh.service.IPayService;
import com.wwh.util.CommonConstant;
import com.wwh.util.SeqUtils;
import com.wwh.vo.FixedRebateVO;
import com.wwh.vo.IdcardRelationVO;
import com.wwh.vo.KeyPointRecommendVO;
import com.wwh.vo.Level2RecommendDetailVO;
import com.wwh.vo.NullPointVO;
import com.wwh.vo.PayDetailVO;
import com.wwh.vo.PlatformInviteDetailVO;
import com.wwh.vo.PlatformInviteVO;
import com.wwh.vo.PlatformProfitScoreVO;
import com.wwh.vo.RecommendAPointStatisticsVO;
import com.wwh.vo.RecommendBPointStatisticsVO;
import com.wwh.vo.RecommendVO;
import com.wwh.vo.SystemWalletVO;
import com.wwh.vo.WalletAmountVO;
import com.wwh.vo.WalletDiskRelationVO;

@Service
@Transactional
public class PayService implements IPayService {

	private static Logger logger = LogManager.getLogger(PayService.class);
	private static Map<String, Object> map = new HashMap<>();
	@Autowired
	private IPayDetailDao payDetailDao;

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IScoreDao scoreDao;

	@Autowired
	private IPointDao pointDao;

	@Autowired
	private IDiskEnterService diskEnterService;

	@Autowired
	private ILogService logService;
	@Autowired
	private IWalletDiskRelationDao walletDiskRelationDao;

	@Autowired
	private IPlatformInviteDetailDao platformInviteDetailDao;

	@Autowired
	private IPlatformInviteDao platformInviteDao;
	
	@Autowired
	private IFixedRebateDao fixedRebateDao;
	
	@Autowired
	private IFixedRebateService fixedRebateService;
	@Override
	public PayDetailVO prePay(PayDetailVO payDetailVO) throws Exception {
		String payType = payDetailVO.getPayAmountType();
		if (payType.equals(PayAmountTypeEnum.OTHER.name())) {
			if (payDetailVO.getAmount().doubleValue() < 0) {
				logger.error("error 恶意支付" + payType + "遭遇到恶意充值");
				throw new Exception("error 恶意支付" + payType + "遭遇到恶意充值");
			}
		} else if (payType.equals(PayAmountTypeEnum.TIYAN.name())) {
			if (payDetailVO.getAmount().doubleValue() != 500) {
				logger.error("error 恶意支付" + payType + "遭遇到恶意充值");
				throw new Exception("error 恶意支付" + payType + "遭遇到恶意充值");
			}
		} else if (payType.equals(PayAmountTypeEnum.HUIMIN.name())) {
			if (payDetailVO.getAmount().doubleValue() != 5000) {
				logger.error("error 恶意支付" + payType + "遭遇到恶意充值");
				throw new Exception("error 恶意支付" + payType + "遭遇到恶意充值");
			}
		} else if (payType.equals(PayAmountTypeEnum.FUMIN.name())) {
			if (payDetailVO.getAmount().doubleValue() != 50000) {
				logger.error("error 恶意支付" + payType + "遭遇到恶意充值");
				throw new Exception("error 恶意支付" + payType + "遭遇到恶意充值");
			}
		}

		payDetailVO.setPayStatus(PayStatusEnum.PAYPREED.name());
		payDetailVO.setUserId(payDetailVO.getRechargeUserId());

		if (null != payDetailVO.getAmount()) {
			payDetailVO.setScore(BigDecimal.valueOf(payDetailVO.getAmount().doubleValue() * 2));
		}
		// 生成一个idCard
		payDetailVO.setIdCard(SeqUtils.generateIdCardSN());
		payDetailVO.setIsCalcuated(IsCalcuatedEnum.N.name());
		payDetailVO.setActiveFlag(ActiveFlagEnum.Y.name());
		payDetailVO.setDeleteFlag(DeleteFlagEnum.N.name());
		payDetailVO.setCreatedBy(payDetailVO.getRechargeUserId());
		payDetailVO.setLastUpdatedBy(payDetailVO.getRechargeUserId());

		String seq = SeqUtils.generateRechargeOrderSN();

		payDetailVO.setPaySeq(seq);

		payDetailDao.insert(payDetailVO);

		return payDetailVO;
	}

	@Override
	public PayDetailVO getPayDetailByPayAmountTypeAndPaySeq(String payAmountType, String paySeq) {

		PayDetailVO payDetailVO = new PayDetailVO();
		payDetailVO.setPayAmountType(payAmountType);
		payDetailVO.setPaySeq(paySeq);
		List<PayDetailVO> detailVOs = payDetailDao.selectByPayDetail(payDetailVO);

		if (null != detailVOs && detailVOs.size() > 0) {
			payDetailVO = detailVOs.get(0);
		}
		return payDetailVO;
	}

	@Override
	public PayDetailVO updatePrePaySuccess(String payAmountType, String paySeq, String returnCode) throws Exception {

		PayDetailVO payDetailVO = new PayDetailVO();
		payDetailVO.setPayAmountType(payAmountType);
		payDetailVO.setPaySeq(paySeq);

		List<PayDetailVO> detailVOs = payDetailDao.selectByPayDetail(payDetailVO);
		payDetailVO = detailVOs.get(0);
		payDetailVO.setReturnCode(returnCode);
		payDetailVO.setPayStatus(PayStatusEnum.PAYSUCCESSED.name());
		payDetailDao.updateByPrimaryKeySelective(payDetailVO);

		return payDetailVO;
	}

	/**
	 * 
	 * @Title: addPointToUser
	 * @Description: 给指定用户增加推荐点
	 * @param inviteUserId
	 *            为该用户增加推荐点
	 * @param receiveUserId
	 *            被邀请人
	 * @param diskType
	 *            系统类型
	 * @return: void
	 */
	public void addPointToInviteUser(Long inviteUserId, Long receiveUserId, String diskType, String isDirect) {
		logger.info("进入增加推荐点的方法: addPointToInviteUser");
		// 先插入对应系统的推荐点流水表记录
		RecommendVO recommendVO = new RecommendVO();
		recommendVO.setInviteUserId(inviteUserId);
		recommendVO.setReceiveUserId(receiveUserId);
		recommendVO.setCreatedBy(receiveUserId);
		recommendVO.setLastUpdatedBy(receiveUserId);
		recommendVO.setDiskType(diskType);
		recommendVO.setIsDirect(isDirect);
		pointDao.addPoint(recommendVO);

		// 同步更新统计表（A表和B表）
		// 先判断该推荐点的A,B状态
		switch (point_is_AB(inviteUserId, diskType)) {
		case "A":
			logger.info("进入增加a推荐点方法");
			// 如果是A状态则更新A状态统计表
			// 有两种情况，一种是用户从来没参与过，统计表中没有用户的该系统记录
			// 另一种是用户参与过，只需要增加推荐点就可以
			RecommendAPointStatisticsVO aPointStatisticsVO = new RecommendAPointStatisticsVO();
			aPointStatisticsVO.setDiskType(diskType);
			aPointStatisticsVO.setUserId(inviteUserId);
			aPointStatisticsVO.setRemainRecommendPoint(1);
			aPointStatisticsVO.setTotalRecommendPoint(1);
			aPointStatisticsVO.setUseUpRecommendPoint(0);
			aPointStatisticsVO.setCreatedBy(receiveUserId);
			aPointStatisticsVO.setLastUpdatedBy(receiveUserId);
			aPointStatisticsVO.setReduce('N');
			pointDao.updateAPointStatistics(aPointStatisticsVO);
			// 为入盘用户的上级用户在该系统所有盘中的身份 更新 空点状态
			List<IdcardRelationVO> idcardRelationVOs = walletDiskRelationDao
					.getIdCardRelationByCurrentIdCard(inviteUserId, null);
			List<String> idcardsY = new ArrayList<>();
			for (IdcardRelationVO idcardRelationVO : idcardRelationVOs) {
				if (idcardRelationVO.getStatuxx().equals("Y") && idcardRelationVO.getCurrentDiskType().equals(diskType)
						&& !idcardRelationVO.getCurrentRoleId().equals(1L)) {
					idcardsY.add(idcardRelationVO.getCurrentIdCard());
				}
			}
			RecommendAPointStatisticsVO aPointStatisticsVO1 = pointDao.getUserAPointBydiskType(inviteUserId, diskType);
			// 拿出所有的盘号
			if (idcardsY.size() != 0) {
				List<WalletDiskRelationVO> diskRelationVOs = walletDiskRelationDao.getDiskRelationsByIdCards(diskType,
						idcardsY);
				NullPointVO nullPointVO = new NullPointVO();
				nullPointVO.setUserId(inviteUserId);
				nullPointVO.setDiskType(diskType);
				nullPointVO.setEmptyPoint(3 - (aPointStatisticsVO1.getRemainRecommendPoint() / 2));
				nullPointVO.setIsUsable("Y");
				nullPointVO.setLastUpdatedBy(receiveUserId);
				nullPointVO.setCreatedBy(receiveUserId);
				for (WalletDiskRelationVO walletDiskRelationVO : diskRelationVOs) {
					nullPointVO.setIdCard(walletDiskRelationVO.getIdCard());
					nullPointVO.setDiskSeq(walletDiskRelationVO.getDiskSeq());
					pointDao.addNullPoint(nullPointVO);
				}
			}

			// 先拿出未增加前的点数
			Integer beforeCounterA = pointDao.getUserAPointBydiskType(inviteUserId, diskType).getRemainRecommendPoint()
					- 1;
			// 判断是否增加关键推荐点表数据
			if (beforeCounterA > 6 && beforeCounterA % 2 != 0) {
				KeyPointRecommendVO keyPointRecommendVO = new KeyPointRecommendVO();
				keyPointRecommendVO.setPoinStatus("A");
				keyPointRecommendVO.setDiskType(diskType);
				keyPointRecommendVO.setUserId(inviteUserId);
				// A状态点 的IDCARD 是无意义的,把他设置为error
				keyPointRecommendVO.setIdCard("error");
				keyPointRecommendVO.setIsUsable("Y");
				keyPointRecommendVO.setCreatedBy(receiveUserId);
				keyPointRecommendVO.setLastUpdatedBy(receiveUserId);
				pointDao.addKeyPointByPointType(keyPointRecommendVO);
				// 如果增加了关键推荐点表数据，那么要把 推荐点统计表 增加已使用和减少可使用的点数
				aPointStatisticsVO.setUseUpRecommendPoint(2);
				aPointStatisticsVO.setRemainRecommendPoint(2);
				aPointStatisticsVO.setReduce('Y');
				pointDao.updateAPointStatistics(aPointStatisticsVO);
			}
			break;
		default:
			logger.info("进入增加b推荐点方法");
			// 如果是B状态则更新B状态统计表
			// B状态推荐点要更新到用户最新的一个总监或者带点出局总监的IDCARD上，所以要先查询出最新的IDCARD
			WalletDiskRelationVO newEstIdcard = getNewestFinishedUsableIdCard(inviteUserId, diskType);
			// 通过该IDCARD 更新对应纪录
			RecommendBPointStatisticsVO bPointStatisticsVO = new RecommendBPointStatisticsVO();
			bPointStatisticsVO.setDiskType(diskType);
			bPointStatisticsVO.setUserId(inviteUserId);
			bPointStatisticsVO.setRemainRecommendPoint(1);
			bPointStatisticsVO.setTotalRecommendPoint(1);
			bPointStatisticsVO.setUseUpRecommendPoint(0);
			bPointStatisticsVO.setCreatedBy(receiveUserId);
			bPointStatisticsVO.setLastUpdatedBy(receiveUserId);
			bPointStatisticsVO.setIdCard(newEstIdcard.getIdCard());
			bPointStatisticsVO.setReduce('N');
			// 该情况只会增加推荐点
			pointDao.updateBPointStatistics(bPointStatisticsVO);
			// 获取之前有多少个推荐点
			if (newEstIdcard != null) {
				Integer beforeCounterB = pointDao.getBPointCountByIdCard(newEstIdcard.getIdCard())
						.getTotalRecommendPoint() - 1;
				// 判断是否增加关键推荐点表数据
				if (beforeCounterB % 2 != 0) {
					KeyPointRecommendVO keyPointRecommendVO = new KeyPointRecommendVO();
					keyPointRecommendVO.setPoinStatus("B");
					keyPointRecommendVO.setDiskType(diskType);
					keyPointRecommendVO.setUserId(inviteUserId);
					keyPointRecommendVO.setRoleId(newEstIdcard.getRoleId());
					keyPointRecommendVO.setIdCard(newEstIdcard.getIdCard());
					keyPointRecommendVO.setCreatedBy(inviteUserId);
					keyPointRecommendVO.setLastUpdatedBy(inviteUserId);
					keyPointRecommendVO.setIsUsable("Y");
					pointDao.addKeyPointByPointType(keyPointRecommendVO);
					// 如果增加了关键推荐点表数据，那么要把 推荐点统计表 增加已使用和减少可使用的点数
					bPointStatisticsVO.setReduce('Y');
					pointDao.updateBPointStatistics(bPointStatisticsVO);
				}
			}
		}
	}

	/**
	 * 
	 * @Title: point_is_AB
	 * @Description: 给用户增加推荐点时判断该点为A点还是B点
	 * @param inviteUserId
	 * @param diskType
	 * @return
	 * @return: char
	 */
	public String point_is_AB(Long inviteUserId, String diskType) {
		// 默认是A点
		boolean isA = true;
		// 先判断用户在该系统中是否有参与过。
		// 用来存储用户的所有参与记录
		List<WalletDiskRelationVO> diskRelationVOs = walletDiskRelationDao.getDiskRelationsByUserId(diskType,
				inviteUserId, null);
		// 用来储存用户在该系统中的所有已结束的记录
		List<WalletDiskRelationVO> diskProfitFinished = new ArrayList<>();
		// 用来存储用户在该系统中的所有未结束的记录
		List<WalletDiskRelationVO> diskProfitRunning = new ArrayList<>();
		// 如果集合为大小为0，那么则该用户没有参与过该系统，为该用户的下个该系统身份预存一个A状态推荐点。
		// 该推荐点为系统A点（没有任何参与过系统的A点）
		if (diskRelationVOs.size() == 0) {
			return isA ? "A" : "B";
		} else {
			// 判断该用户是否在该系统中还有未结束的身份
			for (WalletDiskRelationVO diskRelationVO : diskRelationVOs) {
				// 用户未结束的身份记录
				if (diskRelationVO.getDiskStatus().equals("RUNNING")) {
					diskProfitRunning.add(diskRelationVO);
				} else {
					// 用户历史身份记录
					diskProfitFinished.add(diskRelationVO);
				}
			}
			// 用户还有在运行的身份
			if (diskProfitRunning.size() > 0) {
				// 判断用户在运行的所有身份是否都为总监，如果都是总监身份，那就是B点
				for (WalletDiskRelationVO diskRelationVO : diskProfitRunning) {
					// 如果有非总监身份，则该推荐点就是A点
					if (diskRelationVO.getRoleId() != 1) {
						// A点:只要有一个是非总监身份，那就是A点
						return isA ? "A" : "B";
					}
				}
				isA = false;

			} else {
				List<WalletDiskRelationVO> diskRelationVOsDirectors = new ArrayList<>();
				List<String> idCards = new ArrayList<>();
				// 所有已结束的身份如果都不是总监 ,那么 还是A点
				for (WalletDiskRelationVO walletDiskRelationVO : diskProfitFinished) {
					idCards.add(walletDiskRelationVO.getIdCard());
					if (walletDiskRelationVO.getRoleId().equals(1L)) {
						diskRelationVOsDirectors.add(walletDiskRelationVO);
					}
				}
				if (diskRelationVOsDirectors.size() == 0) {
					isA = true;
				} else {
					// 判断所有身份是否都没有任何剩余推荐点,如果没有,则为A点
					List<RecommendBPointStatisticsVO> bPointStatisticsVOs = pointDao.getBPointCountByIdCards(idCards);
					for (RecommendBPointStatisticsVO recommendBPointStatisticsVO : bPointStatisticsVOs) {
						if (recommendBPointStatisticsVO.getRemainRecommendPoint() != 0) {
							isA = false;
							break;
						}
					}
				}
			}
		}
		// 1、如果有参与过，但是已经不在体验系统中活动，则判断该身份（如果有多个已结束身份，则累加到最新一条记录）是否拥有可使用的B状态推荐点，如果有则累加上去。
		// 如果该身份没有可使用B状态推荐点（已经使用完了，或者刚好6点晋升到结束），则为萌新的下一个体验系统的身份预存一个A状态推荐点。
		// 2、如果有参与过，且还在该系统中（非总监的身份）活动，则为体验系统增加一个A状态推荐点。
		// 3、如果有参与过，且还在该系统中（总监的身份）活动，则为该身份（如果有多个总监活动身份，则累加到最新一条记录）增加一个B状态推荐点。
		// 4、如果有参与过，且在该系统中同时存在总监和非总监的身份，则优先把推荐点分配给非总监身份
		// （注：A状态推荐点跟随系统，且只要在系统中有一个身份发生晋升，那么该系统的所有A状态推荐点减去6点用来晋升，其余的全部改为该身份的B状态推荐点）
		// 5、如果没有参与过，则为萌新的下个体验系统身份预存一个A状态推荐点。
		return isA ? "A" : "B";
	}

	/**
	 * 
	 * @Title: getNewestFinishedUsableIdCard
	 * @Description: 获取用户最新一个已结束且还拥有未用完B推荐点的身份
	 * @param userId
	 * @param diskType
	 * @return
	 * @return: String
	 */
	public WalletDiskRelationVO getNewestFinishedUsableIdCard(Long userId, String diskType) {
		// 获取用户总监以上的记录
		WalletDiskRelationVO walletDiskRelationVO = new WalletDiskRelationVO();
		walletDiskRelationVO.setUserId(userId);
		walletDiskRelationVO.setDiskType(diskType);
		walletDiskRelationVO.setRoleId(1L);
		List<WalletDiskRelationVO> diskRelationVOs = walletDiskRelationDao
				.selectDiskRelationBySelective(walletDiskRelationVO);
		List<WalletDiskRelationVO> diskRelationVOsRunning = new ArrayList<>();
		for (WalletDiskRelationVO diskRelationVO : diskRelationVOs) {
			if (diskRelationVO.getDiskStatus().equals(DiskStatusEnum.RUNNING.name())) {
				diskRelationVOsRunning.add(diskRelationVO);
			}
		}
		// 如果盘中有未出局总监身份,则直接返回该身份
		if (diskRelationVOsRunning.size() != 0) {
			return diskRelationVOsRunning.get(0);
		}
		// 获取该用户的所有B点记录
		List<RecommendBPointStatisticsVO> recommendBPointStatisticsVOs = pointDao
				.getBPointCountByUserIdAndDiskType(userId, diskType);
		RecommendBPointStatisticsVO temp = recommendBPointStatisticsVOs.size() > 0 ? recommendBPointStatisticsVOs.get(0)
				: null;
		// 如果为NULL，该用户没有在该系统中留下过记录
		if (temp == null) {
			return null;
		} else {
			for (RecommendBPointStatisticsVO recommendBPointStatisticsVO : recommendBPointStatisticsVOs) {
				if (recommendBPointStatisticsVO.getRemainRecommendPoint() > 0) {
					if (temp.getLastUpdatedDate().compareTo(recommendBPointStatisticsVO.getLastUpdatedDate()) < 0) {
						temp = recommendBPointStatisticsVO;
					}
				}
			}
			List<String> records = new ArrayList<>();
			records.add(temp.getIdCard());
			walletDiskRelationDao.getDiskRelationsByIdCards(diskType, records);
			return walletDiskRelationDao.getDiskRelationsByIdCards(diskType, records).get(0);
		}
	}

	/**
	 * 
	 * @Title: updatePointAndScore
	 * @Description: 第一步到第十一步
	 * @param paySeq
	 * @param payAmountType
	 * @param payAmount
	 * @return: void
	 */
	public void updatePointAndScore(String paySeq, String payAmountType, BigDecimal payAmount) throws Exception {
		logger.info("结算 用户 积分收益 ,点亮里程碑 :updatePointAndScore  start");
		// 通过充值唯一标识来获取该用户信息
		Long userId = userDao.getUserIdByPaySeq(paySeq, payAmountType);
		// 点亮用户里程碑
		userDao.updateMilestone(payAmountType, userId);
		// 积分相关
		// 1、算出给用户多少积分 ----- (其他金额判断)
		BigDecimal score;
		if (payAmountType.equals("OTHER")) {
			score = payAmount.multiply(new BigDecimal(2));
		} else {
			score = scoreDao.getScoreRcgConfig(payAmountType);
		}
		// 平台积分收益详情表插入数据
		PlatformProfitScoreVO platformProfitScoreVO = new PlatformProfitScoreVO();
		platformProfitScoreVO.setUserId(userId);
		platformProfitScoreVO.setProfitScore(score);
		platformProfitScoreVO.setProfitScoreRemark("充值" + payAmountType + "获得积分");
		platformProfitScoreVO.setProfitScoreType(ProfitScoreTypeEnum.RECHARGEPROFIT.toString());
		platformProfitScoreVO.setRechargeAmount(payAmount);
		// 充值默认来源为-999999
		platformProfitScoreVO.setSourceUserId(CommonConstant.SYSTEM_USER_ID);
		scoreDao.insertScoreProfitRecord(platformProfitScoreVO);
		// 更新钱包积分
		WalletAmountVO walletAmountVO = new WalletAmountVO();
		walletAmountVO.setTotalScore(score);
		walletAmountVO.setRechargeAmount(payAmount);
		walletAmountVO.setRemainScore(score);
		walletAmountVO.setPlatformTotalAmount(new BigDecimal(0));
		walletAmountVO.setUsedScore(new BigDecimal(0));
		walletAmountVO.setUserId(userId);
		scoreDao.updateWallteScore(walletAmountVO);
		// 给平台收益表增加对应的积分支出
		SystemWalletVO systemWalletVO = new SystemWalletVO();
		systemWalletVO.setSystemId(CommonConstant.SYSTEM_USER_ID);
		systemWalletVO.setSystemWalletTotalAmount(payAmount);
		systemWalletVO.setSystemExpenditureScore(score);
		systemWalletVO.setCreatedBy(userId);
		systemWalletVO.setLastUpdatedBy(userId);
		// 把充值记录改为已结算
		scoreDao.updateRcgIsCalcuated(paySeq, payAmountType);
		// 获取用户的推荐人ID
		Long tmpUserId = userDao.getUserReferenceIdByUserId(userId);
		// -999999时，没有上级推荐人,自然也就没有上上级推荐人
		if (null != tmpUserId && !CommonConstant.SYSTEM_USER_ID.equals(tmpUserId)
				&& !CommonConstant.PAYTYPE_1_499.equals(payAmountType)) {
			logger.info("有上级推荐人 ,给上级加积分");
			// 给上级用户增加积分
			// 查询出需要为上级用户增加多少积分
			BigDecimal scoreAward = scoreDao.getScoreAwardConfigVO(payAmountType).getInviteAwardScore();
			// 上级用户钱包表修改
			walletAmountVO.setTotalScore(scoreAward);
			walletAmountVO.setRechargeAmount(new BigDecimal(0));
			walletAmountVO.setRemainScore(scoreAward);
			walletAmountVO.setPlatformTotalAmount(new BigDecimal(0));
			walletAmountVO.setUsedScore(new BigDecimal(0));
			walletAmountVO.setUserId(tmpUserId);
			scoreDao.updateWallteScore(walletAmountVO);
			// 给平台收益表增加对应的积分支出
			systemWalletVO.setSystemExpenditureScore(scoreAward.add(score));
			// 上级积分收益流水插入
			platformProfitScoreVO.setUserId(tmpUserId);
			platformProfitScoreVO.setProfitScore(scoreAward);
			platformProfitScoreVO.setProfitScoreRemark("下级用户充值" + payAmountType + "获得积分");
			platformProfitScoreVO.setProfitScoreType(ProfitScoreTypeEnum.INVIITERECHARGEPROFIT.toString());
			platformProfitScoreVO.setRechargeAmount(payAmount);
			// 默认来源为 下级用户ID
			platformProfitScoreVO.setSourceUserId(userId);
			scoreDao.insertScoreProfitRecord(platformProfitScoreVO);
		}
		scoreDao.updateSystemProfitByVO(systemWalletVO);
		logger.info("结算 用户 积分收益 ,点亮里程碑 :updatePointAndScore  end");
	}

	/**
	 * 
	 * @Title: isCalcuated
	 * @Description: 判断该支付编号是否已经结算
	 * @param payAmountType
	 * @param paySeq
	 * @return
	 * @return: Boolean
	 */
	public Boolean isCalcuated(String payAmountType, String paySeq) {
		String result = payDetailDao.isCalcuated(payAmountType, paySeq);
		if (result.equals("Y")) {
			logger.info(paySeq + "已经结算!");
			return true;
		} else {
			logger.info(paySeq + "未结算!");
			return false;
		}
	}

	/**
	 * 获取未支付时间超过30分钟的支付记录
	 */
	@Override
	public List<PayDetailVO> getPayDetailMoreThan30Min() {
		return payDetailDao.getPayDetailMoreThan30Min();
	}

	/**
	 * 更新订单信息
	 */
	@Override
	public Integer updatePayDetailById(PayDetailVO payDetailVo) {
		return payDetailDao.updateByPrimaryKeySelective(payDetailVo);
	}

	/**
	 * 
	 * @Title: aboutPoint
	 * @Description: 关于推荐点分配的操作
	 * @param payAmountType
	 * @param userId
	 * @return: void
	 */
	@Override
	public void aboutPoint(String payAmountType, Long userId) {
		logger.info("成功进入系统,推荐点开始分配:aboutPoint start");
		// 推荐点相关
		if (PayAmountTypeEnum.OTHER.name().equals(payAmountType)) {
			// 如果是1-499，那么不需要给任何人加推荐点
			return;
		}
		// 获取用户的推荐人ID
		Long tmpUserId = userDao.getUserReferenceIdByUserId(userId); // 这是上一级
		logger.info("上级用户推荐人ID为：" + tmpUserId);
		// -999999时，没有上级推荐人,自然也就没有上上级推荐人
		if (null == tmpUserId || CommonConstant.SYSTEM_USER_ID.equals(tmpUserId)) {
			logger.info("没有推荐人, 分配结束:aboutPoint end");
			return;
		}
		logger.info("给上级用户增加推荐点");
		Integer tempInt = pointDao.getRecommendCounterBydiskType(tmpUserId, payAmountType); // 上级推荐的人数
		logger.info("上级用户推荐的人数 tempInt={}", tempInt);
		// 给上级用户增加推荐点
		addPointToInviteUser(tmpUserId, userId, payAmountType, "Y");
		// 如果是该用户第一次进入系统,则给他的上级用户更新 邀请表数据
		PlatformInviteDetailVO platformInviteDetailVO = platformInviteDetailDao
				.getPlatformInviteDetailVOByUserId(userId);
		if (platformInviteDetailVO != null) {
			if (platformInviteDetailVO.getIsRecharged().equals("N")) {
				platformInviteDetailDao.updatePlatformInviteDetailToY(userId);
				PlatformInviteVO platformInviteVO = new PlatformInviteVO();
				platformInviteVO.setInviteUserId(tmpUserId);
				platformInviteVO.setInvitePayCounter(1);
				platformInviteDao.updatePlatformInviteByUserId(platformInviteVO);
			}
		}
		// 这个地方要先判断上级用户在该系统内是否已经有在我之前的推荐点了。
		// 如果没有的话，要查询出我的上上级用户，给他一个该系统的推荐点。
		logger.info("进入为用户增加二级推荐点方法11111111");
		if (null != tmpUserId && !CommonConstant.SYSTEM_USER_ID.equals(tmpUserId) && tempInt == 0) {
			// 获得上上级推荐人ID
			Long tmp2UserId = userDao.getUserReferenceIdByUserId(tmpUserId);
			logger.info("上上级用户推荐人ID为：" + tmp2UserId);
			// -999999时，也同理
			if (null != tmp2UserId && !CommonConstant.SYSTEM_USER_ID.equals(tmp2UserId)) {
				logger.info("给上上级用户增加推荐点");
				// 给上上级用户增加推荐点
				addPointToInviteUser(tmp2UserId, userId, payAmountType, "N");
				// 记录下二级推荐点的来源
				Level2RecommendDetailVO level2RecommendDetailVO = new Level2RecommendDetailVO();
				level2RecommendDetailVO.setUserId(tmp2UserId);
				level2RecommendDetailVO.setLevel1UserId(tmpUserId);
				switch (payAmountType) {
				case "TIYAN":
					level2RecommendDetailVO.setTiyanUserId(userId);
					break;
				case "HUIMIN":
					level2RecommendDetailVO.setHuiminUserId(userId);
					break;
				case "FUMIN":
					level2RecommendDetailVO.setFuminUserId(userId);
					break;
				case "XINGMIN":
					level2RecommendDetailVO.setXingminUserId(userId);
					break;
				}
				level2RecommendDetailVO.setCreatedBy(userId);
				level2RecommendDetailVO.setLastUpdatedBy(userId);
				logger.info("增加二级推荐详情");
				pointDao.addLevel2PointDetail(level2RecommendDetailVO);
			}
		}
		logger.info("成功进入系统,推荐点开始分配:aboutPoint end");
	}

	@Override
	public Boolean updatePrePaySuccessAndDoNext(String payAmountType, String paySeq, PayDetailVO payDetailVO)
			throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		logger.info("进入结算积分和入盘 方法 : updatePrePaySuccessAndDoNext ");
		map.put("payAmountType", payAmountType);
		map.put("paySeq", paySeq);
		map.put("payDetailVO", payDetailVO);
		logService.writeLog("updatePrePaySuccessAndDoNext", map,
				"This method is executed after the success of the recharge.", payDetailVO.getUserId());
		map.clear();
		Boolean isCalcuatedFlag = isCalcuated(payAmountType, paySeq);
		logger.info("isCalcuated return :" + isCalcuatedFlag);
		// 这里需要判断该订单是否已经结算
		if (isCalcuatedFlag) {
			return true;
		}
		// 收益结算
		map.put("paySeq", paySeq);
		map.put("payAmountType", payAmountType);
		map.put("payAmount", payDetailVO.getAmount());
		logService.writeLog("updatePointAndScore", map,
				"This method is the calculation of points and points of recommendation.", payDetailVO.getUserId());
		map.clear();
		updatePointAndScore(paySeq, payAmountType, payDetailVO.getAmount());
		// 如果是1-499 的充值,则不用执行 等待和入盘的动作
		if (!payAmountType.equals(PayAmountTypeEnum.OTHER.name())) {
			map.put("diskTypeEnum", payAmountType);
			map.put("receiveUserId", payDetailVO.getUserId());
			map.put("receiveUserIdCard", payDetailVO.getPaySeq());
			map.put("waittingType", WaittingTypeEnum.WAITTING.name());
			logService.writeLog("updateWaittingDisk", map, "IDcard enter wait.", payDetailVO.getUserId());
			map.clear();
			FixedRebateVO fixedRebateVo=null;
			//定返功能（先判断是否开启定返获取充值信息）
			if(fixedRebateService.getRebateConfig(CommonConstant.ONOFF_FIXEDREBATE)){
				logger.info("充值成功,插入定返统计信息");
				fixedRebateVo=new FixedRebateVO();
				//已开启定返获取充值信息，插入此次充值身份定返记录
				fixedRebateVo.setUserId(payDetailVO.getUserId());
				fixedRebateVo.setIdCard(payDetailVO.getIdCard());
				fixedRebateVo.setPayAmount(payDetailVO.getAmount());
				fixedRebateVo.setTotalAmount(payDetailVO.getAmount().multiply(BigDecimal.valueOf(CommonConstant.FIXEDREBATE_RATE)));
				fixedRebateVo.setReturnedAmount(new BigDecimal(0));//初始已返为0
				fixedRebateVo.setSysType(payAmountType);
				fixedRebateVo.setRebateStauts(FixedRebateEnum.WAITTING.name());//充值初始等待定返
				fixedRebateVo.setCreatedBy(payDetailVO.getUserId());
				fixedRebateVo.setLastUpdatedBy(payDetailVO.getUserId());
				fixedRebateDao.insertRebateInfo(fixedRebateVo);
			}
			//先判断是否开启定返充值成功后该身份的定返开启
			if(fixedRebateService.getRebateConfig(CommonConstant.ONOFF_PAYFIXEDREBATE)){
				logger.info("充值成功,开始定返");
				 fixedRebateVo=new FixedRebateVO();
				//入盘成功更新定返状态，开始定返。
				fixedRebateVo.setUserId(payDetailVO.getUserId());
				fixedRebateVo.setIdCard(payDetailVO.getIdCard());
				fixedRebateVo.setRebateStauts(FixedRebateEnum.RUNNING.name());//开始定返
				fixedRebateDao.updateRebateInfo(fixedRebateVo);
			}
			// 先把该充值身份塞入等待盘中
			diskEnterService.updateWaittingDisk(payAmountType, payDetailVO.getUserId(), paySeq,
					WaittingTypeEnum.WAITTING.name());
			map.put("diskTypeEnum", payDetailVO.getPayAmountType());
			map.put("receiveUserId", payDetailVO.getUserId());
			map.put("receiveUserIdCard", payDetailVO.getPaySeq());
			logService.writeLog("tandemService", map, "Enter disk method step 1.", payDetailVO.getUserId());
			map.clear();
			// 入盘
			diskEnterService.tandemService(payDetailVO.getPayAmountType(), payDetailVO.getUserId(), paySeq, null);
			logger.info("结束 结算积分和入盘 方法 : updatePrePaySuccessAndDoNext");
		}
		return true;
	}

}
