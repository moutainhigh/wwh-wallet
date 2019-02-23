package com.wwh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwh.dao.IUserTokenDao;
import com.wwh.service.IUserTokenService;
import com.wwh.vo.UserTokenVO;

@Service
public class UserTokenService implements IUserTokenService{

	@Autowired
	private IUserTokenDao userTokenDao;
	
	@Override
	public int addUserToken(UserTokenVO userTokenVO) {
		return userTokenDao.addUserToken(userTokenVO);
	}

	@Override
	public List<UserTokenVO> queryUserTokenByUserId(long userId) {
		return userTokenDao.queryUserTokenByUserId(userId);
	}

	@Override
	public int verifyUserToken(Map<String, Object> map) {
		return userTokenDao.verifyUserToken(map);
	}
}
