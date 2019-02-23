package com.wwh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwh.dao.IBusinessDao;
import com.wwh.dao.IEarningDao;
import com.wwh.service.IBusinessService;
import com.wwh.vo.BusinessCustromVO;
import com.wwh.vo.PlatformProfitExtendVO;
import com.wwh.vo.UserVO;

@Service
public class BusinessService implements IBusinessService {
	@Autowired
	private IBusinessDao businessDao;
	@Autowired
	private IEarningDao EarningDao;

	@Override
	public BusinessCustromVO getBusinessCustrom(UserVO userVo) {
		BusinessCustromVO businessCustromVO = new BusinessCustromVO();
		//	设置今日分红
		businessCustromVO.setTodayBusinessAmount(businessDao.getTodayBusinessAmount(userVo.getUserId()));
		// 设置近三十天分红
		businessCustromVO.setNearlyThirtyDaysBusinessAmount(businessDao.getNearlyThirtyDaysBusinessAmount(userVo.getUserId()));
		PlatformProfitExtendVO platformProfitExtendVO = EarningDao.getPlatformProfitByUserId(userVo.getUserId());
		if(platformProfitExtendVO == null){
			platformProfitExtendVO = new PlatformProfitExtendVO();
		}
		//设置总收益
		businessCustromVO.setBusinessAmount(platformProfitExtendVO.getBusinessTotalAmount().add(platformProfitExtendVO.getBusinessUsedAmount()));
		//设置提现收益
		businessCustromVO.setBusinessUsedAmount(platformProfitExtendVO.getBusinessUsedAmount());
		return businessCustromVO;
	}

}
