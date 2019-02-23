package com.wwh.service.impl;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwh.controller.RegisterController;
import com.wwh.dao.IPlatformInviteDao;
import com.wwh.dao.IPlatformInviteDetailDao;
import com.wwh.dao.IPlatformProfitScoreDao;
import com.wwh.dao.IRegisterScoreAwardConfigDao;
import com.wwh.dao.IWalletAmountDao;
import com.wwh.enums.ActiveFlagEnum;
import com.wwh.enums.DeleteFlagEnum;
import com.wwh.enums.IsRechargedEnum;
import com.wwh.enums.ProfitScoreTypeEnum;
import com.wwh.enums.StatusEnum;
import com.wwh.service.IUserRegisterService;
import com.wwh.util.CommonConstant;
import com.wwh.vo.PlatformInviteDetailVO;
import com.wwh.vo.PlatformInviteVO;
import com.wwh.vo.PlatformProfitScoreVO;
import com.wwh.vo.RegisterScoreAwardConfigVO;
import com.wwh.vo.WalletAmountVO;

@Service
public class UserRegisterService implements IUserRegisterService {

	private static Logger logger = LogManager.getLogger(RegisterController.class);

	@Autowired
	private IRegisterScoreAwardConfigDao registerScoreAwardConfigDao;
	@Autowired
	private IPlatformInviteDetailDao platformInviteDetailDao;
	@Autowired
	private IPlatformInviteDao platformInviteDao;
	@Autowired
	private IWalletAmountDao walletAmountDao;
	@Autowired
	private IPlatformProfitScoreDao platformProfitScoreDao;

	@Override
	public boolean register(Long receiveUserId, Long inviteUserId, String language, Long operatorId) throws Exception {

		if (null == receiveUserId || null == inviteUserId || 0 == receiveUserId || 0 == inviteUserId) {
			logger.info("register  参数不对");

			throw new Exception("参数不对");
		}

		// 1、参数验证， 业务验证
		// 2、记录邀请人,记录总邀请人
		// 3、为邀请人加积分 ,为接受人加积分, 修改邀请人、接受人总积分

		PlatformInviteDetailVO platformInviteDetailVO = generatorPlatformInviteDetailVO(receiveUserId, inviteUserId);

		int returnGenerator = platformInviteDetailDao.insert(platformInviteDetailVO);

		if (returnGenerator == 0) {
			logger.info("邀请积分奖励添加失败 ");
			throw new Exception("邀请积分奖励添加失败");
		}

		PlatformInviteVO platformInviteVO = platformInviteDao.getByInviteUserId(inviteUserId);

		if (null == platformInviteVO) {

			platformInviteVO = generatorPlatformInviteVO(inviteUserId);

			int invite = platformInviteDao.insert(platformInviteVO);
			if (invite == 0) {
				logger.info("统计我的邀请人数,初始化失败 ");
				throw new Exception("统计我的邀请人数,初始化失败");
			}

		} else {

			if (null != platformInviteVO.getInviteTotalCounter()) {
				platformInviteVO.setInviteTotalCounter(platformInviteVO.getInviteTotalCounter() + 1);

				// 必须要设进去 inviteUserId
				platformInviteVO.setInviteUserId(inviteUserId);
				int platformInvite = platformInviteDao.updatePlatformInviteByInviteUserId(platformInviteVO);
				if (platformInvite == 0) {
					logger.info("统计我的邀请人数失败 ");
					throw new Exception("统计我的邀请人数失败");
				}
			}
		}

		Double currentAwardScore = registerScoreAwardConfigDao.getCurrentPlatformScoreAward();

		if (null == currentAwardScore) {

			RegisterScoreAwardConfigVO registerScoreAwardConfigVO = generatorRegisterScoreAwardConfigVO();

			int registerScorecfg = registerScoreAwardConfigDao.insert(registerScoreAwardConfigVO);
			if (registerScorecfg == 0) {
				logger.info("平台注册默认奖励积分 ，初始化失败 ");
				throw new Exception("平台注册默认奖励积分 ，初始化失败");
			}

			currentAwardScore = registerScoreAwardConfigVO.getAwardScore().doubleValue();
		}

		// 2、为邀请人加积分
		// 为接受人加积分
		PlatformProfitScoreVO platformProfitScoreVO = generatorPlatformProfitScoreVO(inviteUserId, currentAwardScore,
				ProfitScoreTypeEnum.INVIITEREGISTERPROFIT);

		Integer scoreInsert = platformProfitScoreDao.insert(platformProfitScoreVO);

		if (null == scoreInsert || scoreInsert == 0) {
			logger.info("邀请人积分奖励累加出现异常 ");
			throw new Exception("邀请人积分奖励累加出现异常");
		}

		WalletAmountVO invite = walletAmountDao.getByUserId(inviteUserId);
		if (null == invite) {

			// 首次插入
			invite = generatorWalletAmountVO(inviteUserId, currentAwardScore);

			Long effectiveNumber = walletAmountDao.insert(invite);

			if (effectiveNumber == null || effectiveNumber == 0) {
				logger.info("邀请人钱包计算出现异常 ");
				throw new Exception("邀请人钱包计算出现异常");
			}

		} else {
			double calcInviteProfitScore = Double.valueOf(invite.getTotalScore().toString()) + currentAwardScore;
			invite.setTotalScore(BigDecimal.valueOf(calcInviteProfitScore));
			Long inviteProfit = walletAmountDao.updateByPrimaryKeySelective(invite);
			if (inviteProfit == null || inviteProfit == 0) {
				logger.info("邀请人钱包计算出现异常 ");
				throw new Exception("邀请人钱包计算出现异常");
			}
		}

		// 接受人
		platformProfitScoreVO = generatorPlatformProfitScoreVO(receiveUserId, currentAwardScore,
				ProfitScoreTypeEnum.REGISTERPROFIT);

		scoreInsert = platformProfitScoreDao.insert(platformProfitScoreVO);

		if (null == scoreInsert || scoreInsert == 0) {
			logger.info("接受人积分奖励累加出现异常 ");
			throw new Exception("接受人积分奖励累加出现异常");
		}

		WalletAmountVO receive = walletAmountDao.getByUserId(receiveUserId);
		if (null == receive) {

			// 首次插入
			receive = generatorWalletAmountVO(receiveUserId, currentAwardScore);

			Long effectiveNumber = walletAmountDao.insert(receive);

			if (effectiveNumber == null || effectiveNumber == 0) {
				logger.info("接受人钱包计算出现异常 ");
				throw new Exception("接受人钱包计算出现异常");
			}

		} else {
			double calcInviteProfitScore = Double.valueOf(receive.getTotalScore().toString()) + currentAwardScore;
			receive.setTotalScore(BigDecimal.valueOf(calcInviteProfitScore));
			Long inviteProfit = walletAmountDao.updateByPrimaryKeySelective(receive);
			if (inviteProfit == null || inviteProfit == 0) {
				logger.info("接受人钱包计算出现异常 ");
				throw new Exception("接受人钱包计算出现异常");
			}
		}

		return true;
	}

	private RegisterScoreAwardConfigVO generatorRegisterScoreAwardConfigVO() {
		RegisterScoreAwardConfigVO registerScoreAwardConfigVO = new RegisterScoreAwardConfigVO();
		registerScoreAwardConfigVO.setActiveFlag(ActiveFlagEnum.Y.name());
		registerScoreAwardConfigVO
				.setAwardScore(BigDecimal.valueOf(CommonConstant.PLATFORM_REGISTER_SCORE_AWARD_DEFAULT));
		registerScoreAwardConfigVO.setCreatedBy(CommonConstant.SYSTEM_USER_ID);
		registerScoreAwardConfigVO.setDeleteFlag(DeleteFlagEnum.N.name());
		registerScoreAwardConfigVO.setLastUpdatedBy(CommonConstant.SYSTEM_USER_ID);
		registerScoreAwardConfigVO.setStatus(StatusEnum.Y.name());

		return registerScoreAwardConfigVO;
	}

	private PlatformInviteVO generatorPlatformInviteVO(Long inviteUserId) {
		PlatformInviteVO platformInviteVO = new PlatformInviteVO();
		platformInviteVO.setActiveFlag(ActiveFlagEnum.Y.name());
		platformInviteVO.setCreatedBy(inviteUserId);
		platformInviteVO.setDeleteFlag(DeleteFlagEnum.N.name());
		platformInviteVO.setInvitePayCounter(0);
		platformInviteVO.setInviteTotalCounter(1);
		platformInviteVO.setLastUpdatedBy(inviteUserId);
		platformInviteVO.setInviteUserId(inviteUserId);
		return platformInviteVO;
	}

	private PlatformProfitScoreVO generatorPlatformProfitScoreVO(Long userId, double currentAwardScore,
			ProfitScoreTypeEnum profitScoreTypeEnum) {
		PlatformProfitScoreVO platformProfitScoreVO = new PlatformProfitScoreVO();
		platformProfitScoreVO.setActiveFlag(ActiveFlagEnum.Y.name());
		platformProfitScoreVO.setCreatedBy(userId);
		platformProfitScoreVO.setDeleteFlag(DeleteFlagEnum.N.name());
		platformProfitScoreVO.setLastUpdatedBy(userId);
		platformProfitScoreVO.setProfitScore(BigDecimal.valueOf(currentAwardScore));
		platformProfitScoreVO.setProfitScoreRemark("remark");
		platformProfitScoreVO.setProfitScoreType(profitScoreTypeEnum.name());
		platformProfitScoreVO.setUserId(userId);

		return platformProfitScoreVO;
	}

	private WalletAmountVO generatorWalletAmountVO(Long userId, double currentAwardScore) {

		WalletAmountVO walletAmountVO = new WalletAmountVO();

		walletAmountVO.setActiveFlag(ActiveFlagEnum.Y.name());
		walletAmountVO.setCreatedBy(userId);
		walletAmountVO.setDeleteFlag(DeleteFlagEnum.N.name());
		walletAmountVO.setLastUpdatedBy(userId);
		walletAmountVO.setPlatformTotalAmount(BigDecimal.valueOf(0));
		walletAmountVO.setRechargeAmount(BigDecimal.valueOf(0));
		walletAmountVO.setTotalScore(BigDecimal.valueOf(currentAwardScore));
		walletAmountVO.setUsedScore(BigDecimal.valueOf(0));
		walletAmountVO.setUserId(userId);

		return walletAmountVO;
	}

	private PlatformInviteDetailVO generatorPlatformInviteDetailVO(Long receiveUserId, Long inviteUserId) {
		PlatformInviteDetailVO platformInviteDetailVO = new PlatformInviteDetailVO();

		platformInviteDetailVO.setActiveFlag(ActiveFlagEnum.Y.name());
		platformInviteDetailVO.setCreatedBy(receiveUserId);
		platformInviteDetailVO.setDeleteFlag(DeleteFlagEnum.N.name());
		platformInviteDetailVO.setInviteUserId(inviteUserId);
		platformInviteDetailVO.setIsRecharged(IsRechargedEnum.N.name());
		platformInviteDetailVO.setLastUpdatedBy(receiveUserId);
		platformInviteDetailVO.setReceiveUserId(receiveUserId);
		return platformInviteDetailVO;
	}
}
