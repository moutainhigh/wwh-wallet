package com.wwh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwh.dao.IUserDao;
import com.wwh.service.IUserService;
import com.wwh.vo.UserVO;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	/**
	 * 
	 * @Title: getUserReferenceIdByUserId
	 * @Description: 获取用户的推荐人ID(如果没有推荐人则为-999999)
	 * @param userId
	 * @return
	 * @return: Long
	 */
	@Override
	public Long getUserReferenceIdByUserId(Long userId) {
		return userDao.getUserReferenceIdByUserId(userId);
	}

	/**
	 * 获取用户角色
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public UserVO getUserRole(long userId) {
		return userDao.getUserRole(userId);
	}

	/**
	 * 获取角色权限
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getRolePrivilege(Map<String, Object> map) {
		return userDao.getRolePrivilege(map);
	}

	@Override
	public List<Map<String, Object>> queryUserIdByLogin(Map<String, Object> map) {
		return userDao.queryUserIdByLogin(map);
	}
	
	@Override
	public List<Map<String,Object>> getUserByCondition(String condition){
		return userDao.getUserByCondition(condition);
	}

	@Override
	public List<Map<String, Object>> checkMobilePhoneExsits(Map<String, Object> map) {
		return userDao.checkMobilePhoneExsits(map);
	}
}
