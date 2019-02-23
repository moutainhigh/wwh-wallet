package com.wwh.service;

import java.util.List;
import java.util.Map;

import com.wwh.vo.UserVO;

public interface IUserService {

	/**
	 * 
	 * @Title: getUserReferenceIdByUserId
	 * @Description: 获取用户的推荐人ID(如果没有推荐人则为-999999)
	 * @param userId
	 * @return
	 * @return: Long
	 */
	public Long getUserReferenceIdByUserId(Long userId);

	/**
	 * 获取用户角色
	 * 
	 * @param userId
	 * @return
	 */
	public UserVO getUserRole(long userId);

	/**
	 * 获取角色权限
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getRolePrivilege(Map<String, Object> map);

	public List<Map<String, Object>> queryUserIdByLogin(Map<String, Object> map);
	
	public List<Map<String,Object>> getUserByCondition(String condition);
	
	public List<Map<String,Object>> checkMobilePhoneExsits(Map<String,Object> map);

}
