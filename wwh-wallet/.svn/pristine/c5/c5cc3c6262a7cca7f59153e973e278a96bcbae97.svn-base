package com.wwh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwh.dao.IRegisterScoreAwardConfigDao;
import com.wwh.service.IRegisterScoreAwardConfigService;
import com.wwh.vo.RegisterScoreAwardConfigVO;

@Service
public class RegisterScoreAwardConfigService implements IRegisterScoreAwardConfigService {
	@Autowired
	private IRegisterScoreAwardConfigDao registerScoreAwardConfigDao;
	
	@Override
	public Double getCurrentPlatformScoreAward() {
		Double dou = registerScoreAwardConfigDao.getCurrentPlatformScoreAward();
		return dou;
	}

	@Override
	public Integer updateRegisterScoreAwardConfig(RegisterScoreAwardConfigVO registerScoreAwardConfig) {	
		return registerScoreAwardConfigDao.updateRegisterScoreAwardConfig(registerScoreAwardConfig);
	}

	@Override
	public Integer insertRegisterScoreAwardConfig(RegisterScoreAwardConfigVO registerScoreAwardConfig) {
		return registerScoreAwardConfigDao.insert(registerScoreAwardConfig);
	}

	@Override
	public RegisterScoreAwardConfigVO selectRegisterScoreAwardConfig() {
		
		return registerScoreAwardConfigDao.getReisterScorAwardConfigInfo();
	}
}
