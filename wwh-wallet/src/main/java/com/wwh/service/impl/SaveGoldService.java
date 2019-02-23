package com.wwh.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.wwh.dao.IDiskDao;
import com.wwh.dao.IEarningDao;
import com.wwh.dao.IScoreDao;
import com.wwh.enums.PayStatusEnum;
import com.wwh.service.ISaveGoldService;
import com.wwh.util.BeanUtils;
import com.wwh.vo.DiskTypeProfitVO;
import com.wwh.vo.DiskUserRelationVO;
import com.wwh.vo.MilestoneVO;
import com.wwh.vo.PlatformInviteVO;
import com.wwh.vo.SaveGoldCustromVO;
import com.wwh.vo.UserVO;

@Service
public class SaveGoldService implements ISaveGoldService {

	@Autowired
	private IEarningDao earningDao;
	@Autowired
	private IScoreDao scoreDao;
	@Autowired
	private IDiskDao diskDao;

	@Override
	public SaveGoldCustromVO getPlatformProfitExtend(UserVO userVo) {
		// 查询出用户钱包信息
		SaveGoldCustromVO saveGoldCustromVO = scoreDao.getWalletByUserId2(userVo.getUserId());
		List<MilestoneVO> milestoneVOs = scoreDao.getMilestoneByUserId(userVo.getUserId());
		// 设置用户里程碑
		saveGoldCustromVO.setDiskType(milestoneVOs);
		PlatformInviteVO platformInviteVO = earningDao.getPlatformInvite(userVo.getUserId());
		// 设置用户邀请统计
		saveGoldCustromVO.setPlatformInviteVO(platformInviteVO);
		return saveGoldCustromVO;
	}

	@Override
	public SaveGoldCustromVO getProfitExtendVO(UserVO userVo, Integer currentPage, Integer pageSize) {
		currentPage = currentPage == null ? 1 : currentPage;
		pageSize = pageSize == null ? 10 : pageSize;

		SaveGoldCustromVO goldCustromVO = scoreDao.getWalletByUserId2(userVo.getUserId());
		// 设置用户里程碑
		List<MilestoneVO> milestoneVOs = scoreDao.getMilestoneByUserId(userVo.getUserId());
		if (null == milestoneVOs || milestoneVOs.size() == 0) {
			return goldCustromVO;
		}
		goldCustromVO.setDiskType(milestoneVOs);
		// 设置用户邀请详情
		/*
		 * PlatformInviteVO platformInviteVO =
		 * earningDao.getPlatformInvite(userVo.getUserId());
		 * goldCustromVO.setPlatformInviteVO(platformInviteVO);
		 */

		// 设置系统的邀请人数
		goldCustromVO.setTiyanInvitePerson(earningDao.selectInvitePerson("TIYAN", userVo.getUserId()));
		goldCustromVO.setHuiminInvitePerson(earningDao.selectInvitePerson("HUIMIN", userVo.getUserId()));
		goldCustromVO.setFuminInvitePerson(earningDao.selectInvitePerson("FUMIN", userVo.getUserId()));
		goldCustromVO.setXingminInvitePerson(earningDao.selectInvitePerson("XINGMIN", userVo.getUserId()));

		// 查询用户在系统中最后一个盘的状态
		goldCustromVO.setTiyanDiskStatus(diskDao.getDiskStatus(userVo.getUserId(), "TIYAN"));
		goldCustromVO.setHuiminDiskStatus(diskDao.getDiskStatus(userVo.getUserId(), "HUIMIN"));
		goldCustromVO.setFuminDiskStatus(diskDao.getDiskStatus(userVo.getUserId(), "FUMIN"));
		goldCustromVO.setXingminDiskStatus(diskDao.getDiskStatus(userVo.getUserId(), "XINGMIN"));

		// 查询用户等待晋升的总储备金数
		Integer tiyanUpWaittingRecords = earningDao.countUpWaittingRecords("TIYAN", userVo.getUserId());
		Integer huiminUpWaittingRecords = earningDao.countUpWaittingRecords("HUIMIN", userVo.getUserId());
		goldCustromVO.setTiyanUpWaittingRecords(tiyanUpWaittingRecords);
		goldCustromVO.setHuiminUpWaittingRecords(huiminUpWaittingRecords);
		// 设置所有未晋升的储备金总和
		if (tiyanUpWaittingRecords > 0) {
			goldCustromVO.setTiyanUpWaittingSaveGold(earningDao.countUpWaittingSaveGold("TIYAN", userVo.getUserId()));
		}
		if (huiminUpWaittingRecords > 0) {
			goldCustromVO.setHuiminUpWaittingSaveGold(earningDao.countUpWaittingSaveGold("HUIMIN", userVo.getUserId()));
		}
		// 体验系统和惠民系统的储备金数量

		goldCustromVO.setTiyanSaveAmount(earningDao.getSaveAmountByType("TIYAN", userVo.getUserId()));
		goldCustromVO.setHuiminSaveAmount(earningDao.getSaveAmountByType("HUIMIN", userVo.getUserId()));
		goldCustromVO.setFuminSaveAmount(earningDao.getSaveAmountByType("FUMIN", userVo.getUserId()));
		goldCustromVO.setFuminSaveAmount(earningDao.getSaveAmountByType("XINGMIN", userVo.getUserId()));
		// 设置用户在各个系统的总收益
		DiskTypeProfitVO diskTypeProfitVO = earningDao.getProfitBySysType("TIYAN", userVo.getUserId());
		goldCustromVO.setTiyanProfit(
				diskTypeProfitVO == null ? BigDecimal.valueOf(0) : diskTypeProfitVO.getDiskProfitAmount());
		diskTypeProfitVO = earningDao.getProfitBySysType("HUIMIN", userVo.getUserId());
		goldCustromVO.setHuiminProfit(
				diskTypeProfitVO == null ? BigDecimal.valueOf(0) : diskTypeProfitVO.getDiskProfitAmount());
		diskTypeProfitVO = earningDao.getProfitBySysType("FUMIN", userVo.getUserId());
		goldCustromVO.setFuminProfit(
				diskTypeProfitVO == null ? BigDecimal.valueOf(0) : diskTypeProfitVO.getDiskProfitAmount());
		diskTypeProfitVO = earningDao.getProfitBySysType("XINGMIN", userVo.getUserId());
		goldCustromVO.setXingminProfit(
				diskTypeProfitVO == null ? BigDecimal.valueOf(0) : diskTypeProfitVO.getDiskProfitAmount());
		// 设置用户在各个系统中的总充值金额
		goldCustromVO.setTiyanRcg(
				earningDao.getRcgBySysType("TIYAN", userVo.getUserId(), PayStatusEnum.PAYSUCCESSED.name()));
		goldCustromVO.setHuiminRcg(
				earningDao.getRcgBySysType("HUIMIN", userVo.getUserId(), PayStatusEnum.PAYSUCCESSED.name()));
		goldCustromVO.setFuminRcg(
				earningDao.getRcgBySysType("FUMIN", userVo.getUserId(), PayStatusEnum.PAYSUCCESSED.name()));
		goldCustromVO.setXingminRcg(
				earningDao.getRcgBySysType("XINGMIN", userVo.getUserId(), PayStatusEnum.PAYSUCCESSED.name()));

		// 查询用户的a推荐点个数
		goldCustromVO.setTiyanARecommentPoint(diskDao.selectRecommentPoint(userVo.getUserId(), "TIYAN"));
		goldCustromVO.setHuiminARecommentPoint(diskDao.selectRecommentPoint(userVo.getUserId(), "HUIMIN"));
		goldCustromVO.setFuminARecommentPoint(diskDao.selectRecommentPoint(userVo.getUserId(), "FUMIN"));
		goldCustromVO.setXingminARecommentPoint(diskDao.selectRecommentPoint(userVo.getUserId(), "XINGMIN"));

		// 查询用户在各个最后一个盘中的角色id
		goldCustromVO.setTiyanRoleId(earningDao.getRoleByUserId("TIYAN", userVo.getUserId()));
		goldCustromVO.setHuiminRoleId(earningDao.getRoleByUserId("HUIMIN", userVo.getUserId()));
		goldCustromVO.setFuminRoleId(earningDao.getRoleByUserId("FUMIN", userVo.getUserId()));
		goldCustromVO.setXingminRoleId(earningDao.getRoleByUserId("XINGMIN", userVo.getUserId()));

		return goldCustromVO;
	}

	@Override
	public SaveGoldCustromVO getProfitExtendVO(UserVO userVo, String diskType, Integer currentPage, Integer pageSize) {
		currentPage = currentPage == null ? 1 : currentPage;
		pageSize = pageSize == null ? 10 : pageSize;

		SaveGoldCustromVO goldCustromVO = scoreDao.getWalletByUserId2(userVo.getUserId());
		if (null == goldCustromVO) {
			SaveGoldCustromVO goldCustromVO2 = new SaveGoldCustromVO();
			return goldCustromVO2;
		}
		// 设置用户里程碑
		// List<MilestoneVO> milestoneVOs =
		// scoreDao.getMilestoneByUserId(userVo.getUserId());
		// goldCustromVO.setDiskType(milestoneVOs);
		// 设置用户邀请详情
		// PlatformInviteVO platformInviteVO =
		// earningDao.getPlatformInvite(userVo.getUserId());
		// goldCustromVO.setPlatformInviteVO(platformInviteVO);
		if ("TIYAN".equals(diskType)) {
			// goldCustromVO.setTiyanProfit(earningDao.getProfitBySysType(diskType,
			// userVo.getUserId()));
			// 设置用户在各个系统中的总充值金额
			// goldCustromVO.setTiyanRcg(earningDao.getRcgBySysType(diskType,
			// userVo.getUserId(), PayStatusEnum.PAYSUCCESSED.name()));
			// 设置用户在各个系统中的当前会员人数
			Integer tiyanMember = diskDao.getDiskByType(userVo.getUserId(), diskType);

			goldCustromVO.setTiyanMemberCurrentCounter(tiyanMember == null ? 0 : tiyanMember);

			// 设置用户在各个系统中的可提现金额
			goldCustromVO
					.setTiyanWithdrawalsAmount(earningDao.getWithdrawalsAmountByType(diskType, userVo.getUserId()));
			// 设置用户在各个系统中的储备金 金额
			goldCustromVO.setTiyanSaveAmount(earningDao.getSaveAmountByType(diskType, userVo.getUserId()));
			// 查询用户的a推荐点个数
			// goldCustromVO.setTiyanARecommentPoint(diskDao.selectRecommentPoint(userVo.getUserId(),
			// diskType));
			// 设置用户各个系统的收益列表
			PageHelper.startPage(currentPage, pageSize);
			goldCustromVO.setTiyanList(
					BeanUtils.toPagedResult(diskDao.getDiskProfitDetailByDisk(userVo.getUserId(), diskType)));
		} else if ("HUIMIN".equals(diskType)) {
			// goldCustromVO.setHuiminProfit(earningDao.getProfitBySysType(diskType,
			// userVo.getUserId()));
			// 设置用户在各个系统中的总充值金额
			// goldCustromVO.setHuiminRcg(earningDao.getRcgBySysType(diskType,
			// userVo.getUserId(), PayStatusEnum.PAYSUCCESSED.name()));
			// 设置用户在各个系统中的当前会员人数
			Integer huiminMember = diskDao.getDiskByType(userVo.getUserId(), diskType);
			goldCustromVO.setHuiminMemberCurrentCounter(huiminMember == null ? 0 : huiminMember);
			// 设置用户在各个系统中的可提现金额
			goldCustromVO
					.setHuiminWithdrawalsAmount(earningDao.getWithdrawalsAmountByType(diskType, userVo.getUserId()));
			// 设置用户在各个系统中的储备金 金额
			goldCustromVO.setHuiminSaveAmount(earningDao.getSaveAmountByType(diskType, userVo.getUserId()));
			// 查询用户的a推荐点个数
			// goldCustromVO.setHuiminARecommentPoint(diskDao.selectRecommentPoint(userVo.getUserId(),
			// diskType));
			// 设置用户各个系统的收益列表
			PageHelper.startPage(currentPage, pageSize);
			goldCustromVO.setHuiminList(
					BeanUtils.toPagedResult(diskDao.getDiskProfitDetailByDisk(userVo.getUserId(), diskType)));

		} else if ("FUMIN".equals(diskType)) {
			// goldCustromVO.setFuminProfit(earningDao.getProfitBySysType(diskType,
			// userVo.getUserId()));
			// 设置用户在各个系统中的总充值金额
			// goldCustromVO.setFuminRcg(earningDao.getRcgBySysType(diskType,
			// userVo.getUserId(), PayStatusEnum.PAYSUCCESSED.name()));
			// 设置用户在各个系统中的当前会员人数
			Integer fuminMember = diskDao.getDiskByType(userVo.getUserId(), diskType);
			goldCustromVO.setFuminMenberCurrentCounter(fuminMember == null ? 0 : fuminMember);
			// 设置用户在各个系统中的可提现金额
			goldCustromVO
					.setFuminWithdrawalsAmount(earningDao.getWithdrawalsAmountByType(diskType, userVo.getUserId()));
			// 设置用户在各个系统中的储备金 金额
			goldCustromVO.setFuminSaveAmount(earningDao.getSaveAmountByType(diskType, userVo.getUserId()));
			// 查询用户的a推荐点个数
			// goldCustromVO.setFuminARecommentPoint(diskDao.selectRecommentPoint(userVo.getUserId(),
			// diskType));
			// 设置用户各个系统的收益列表
			PageHelper.startPage(currentPage, pageSize);
			goldCustromVO.setFuminList(
					BeanUtils.toPagedResult(diskDao.getDiskProfitDetailByDisk(userVo.getUserId(), diskType)));
		} else {
			// goldCustromVO.setXingminProfit(earningDao.getProfitBySysType(diskType,
			// userVo.getUserId()));
			// 设置用户在各个系统中的总充值金额
			// goldCustromVO.setXingminRcg(earningDao.getRcgBySysType(diskType,
			// userVo.getUserId(), PayStatusEnum.PAYSUCCESSED.name()));
			// 设置用户在各个系统中的当前会员人数
			Integer xingminMember = diskDao.getDiskByType(userVo.getUserId(), diskType);
			goldCustromVO.setXingminMenberCurrentCounter(xingminMember == null ? 0 : xingminMember);
			// 设置用户在各个系统中的可提现金额
			goldCustromVO
					.setXingminWithdrawalsAmount(earningDao.getWithdrawalsAmountByType(diskType, userVo.getUserId()));
			// 设置用户在各个系统中的储备金 金额
			goldCustromVO.setXingminSaveAmount(earningDao.getSaveAmountByType(diskType, userVo.getUserId()));
			// 查询用户的a推荐点个数
			// goldCustromVO.setXingminARecommentPoint(diskDao.selectRecommentPoint(userVo.getUserId(),
			// diskType));
			// 设置用户各个系统的收益列表
			PageHelper.startPage(currentPage, pageSize);
			goldCustromVO.setXingminList(
					BeanUtils.toPagedResult(diskDao.getDiskProfitDetailByDisk(userVo.getUserId(), diskType)));

		}
		return goldCustromVO;
	}

	/**
	 * 
	 * @Title: getProfitExtendVO2
	 * @Description: 该方法是上面的拓展，可以通过盘号来搞收益记录
	 * @param userVo
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @return: SaveGoldCustromVO
	 */
	public SaveGoldCustromVO getProfitExtendVO2(UserVO userVo, Integer currentPage, Integer pageSize) {
		currentPage = currentPage == null ? 1 : currentPage;
		pageSize = pageSize == null ? 10 : pageSize;
		// startPage是告诉拦截器说我要开始分页了
		PageHelper.startPage(currentPage, pageSize);
		// 首先判断我在各个系统中有哪些盘
		List<DiskUserRelationVO> tempList = diskDao.getDiskUserRelation(userVo.getUserId(), "TIYAN");
		String diskSeq;
		SaveGoldCustromVO goldCustromVO = new SaveGoldCustromVO();
		// 获取用户在每一个系统中每一个盘的收益信息
		for (DiskUserRelationVO diskUserRelationVO : tempList) {
			diskSeq = diskUserRelationVO.getDiskSeq();
			goldCustromVO.setTiyanList(
					BeanUtils.toPagedResult(diskDao.getDiskProfitDetail2(userVo.getUserId(), "TIYAN", diskSeq)));
		}
		tempList = diskDao.getDiskUserRelation(userVo.getUserId(), "HUIMIN");
		System.out.println(tempList.size());
		for (DiskUserRelationVO diskUserRelationVO : tempList) {
			diskSeq = diskUserRelationVO.getDiskSeq();
			goldCustromVO.setHuiminList(
					BeanUtils.toPagedResult(diskDao.getDiskProfitDetail2(userVo.getUserId(), "HUIMIN", diskSeq)));
		}
		tempList = diskDao.getDiskUserRelation(userVo.getUserId(), "FUMIN");
		for (DiskUserRelationVO diskUserRelationVO : tempList) {
			diskSeq = diskUserRelationVO.getDiskSeq();
			goldCustromVO.setFuminList(
					BeanUtils.toPagedResult(diskDao.getDiskProfitDetail2(userVo.getUserId(), "FUMIN", diskSeq)));
		}
		tempList = diskDao.getDiskUserRelation(userVo.getUserId(), "XINGMIN");
		for (DiskUserRelationVO diskUserRelationVO : tempList) {
			diskSeq = diskUserRelationVO.getDiskSeq();
			goldCustromVO.setXingminList(
					BeanUtils.toPagedResult(diskDao.getDiskProfitDetail2(userVo.getUserId(), "XINGMIN", diskSeq)));
		}

		return goldCustromVO;

	}

}
