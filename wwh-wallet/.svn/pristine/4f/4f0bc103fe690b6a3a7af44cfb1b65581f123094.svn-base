package com.wwh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.wwh.common.PagedResult;
import com.wwh.dao.IScoreDao;
import com.wwh.service.IScoreService;
import com.wwh.util.BeanUtils;
import com.wwh.vo.MilestoneVO;
import com.wwh.vo.PayVO;
import com.wwh.vo.PlatformProfitScoreVO;
import com.wwh.vo.ScoreUsageVO;
import com.wwh.vo.UserVO;
import com.wwh.vo.WalletAmountExtendVO;

@Service
public class ScoreService implements IScoreService {

	@Autowired
	private IScoreDao scoreDao;

	@Override
	public List<MilestoneVO> getUserMilestoneVoByUser(UserVO userVo) {
		List<MilestoneVO> milestoneVOs = new ArrayList<>();
		milestoneVOs = scoreDao.getMilestoneByUserId(userVo.getUserId());
		return milestoneVOs;
	}

	@Override
	public PagedResult<PayVO> getRechargeListByUser(UserVO userVo, String diskType, Integer currentPage, Integer pageSize) {
		currentPage = currentPage == null ? 1 : currentPage;
		pageSize = pageSize == null ? 10 : pageSize;
		// startPage是告诉拦截器说我要开始分页了
		PageHelper.startPage(currentPage, pageSize);
		return BeanUtils.toPagedResult(scoreDao.getAllRechargeListByUserId(userVo.getUserId(), diskType));

	}

	@Override
	public PagedResult<ScoreUsageVO> getUserScoreUsageByUserId(UserVO userVo, Integer currentPage, Integer pageSize) {
		currentPage = currentPage == null ? 1 : currentPage;
		pageSize = pageSize == null ? 10 : pageSize;
		// startPage是告诉拦截器说我要开始分页了
		PageHelper.startPage(currentPage, pageSize);
		return BeanUtils.toPagedResult(scoreDao.getScoreUsageByUserId(userVo.getUserId()));
	}

	@Override
	public WalletAmountExtendVO getUserWalletByUser(UserVO userVo) {
		WalletAmountExtendVO walletAmountVO = scoreDao.getWalletByUserId(userVo.getUserId());
		if(walletAmountVO == null){
			walletAmountVO = new WalletAmountExtendVO();
		}
		walletAmountVO.setRcgRecordCounts(scoreDao.getAllRechargeListByUserId(userVo.getUserId(), "ALL").size());
		walletAmountVO.setRegRecordCounts(scoreDao.getRegistScoreProfitDetailByUserId(userVo.getUserId()).size());
		walletAmountVO.setRcgProfitRecordCounts(scoreDao.getChargeScoreProfitDetailByUserId(userVo.getUserId()).size());
		walletAmountVO.setUseRecordCounts(scoreDao.getScoreUsageByUserId(userVo.getUserId()).size());
		walletAmountVO.setAllCounts(scoreDao.getAllScoreProfitDetailByUserId(userVo.getUserId()).size());
		return walletAmountVO == null ? new WalletAmountExtendVO() : walletAmountVO;
	}

	@Override
	public PagedResult<PlatformProfitScoreVO> getRegistScoreProfitByUserId(UserVO userVo, Integer currentPage, Integer pageSize) {
		currentPage = currentPage == null ? 1 : currentPage;
		pageSize = pageSize == null ? 10 : pageSize;
		// startPage是告诉拦截器说我要开始分页了
		PageHelper.startPage(currentPage, pageSize);
		return BeanUtils.toPagedResult(scoreDao.getRegistScoreProfitDetailByUserId(userVo.getUserId()));
	}

	@Override
	public PagedResult<PlatformProfitScoreVO> getChargeScoreProfitByUserId(UserVO userVo, Integer currentPage, Integer pageSize) {
		currentPage = currentPage == null ? 1 : currentPage;
		pageSize = pageSize == null ? 10 : pageSize;
		// startPage是告诉拦截器说我要开始分页了
		PageHelper.startPage(currentPage, pageSize);
		return BeanUtils.toPagedResult(scoreDao.getChargeScoreProfitDetailByUserId(userVo.getUserId()));
	}

}
