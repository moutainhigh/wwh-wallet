package com.wwh.dao;

import java.util.List;
import java.util.Map;

import com.wwh.vo.UserTokenVO;

public interface IUserTokenDao {
	
	/**
	 * 添加用户token
	 * @return
	 */
	public int addUserToken(UserTokenVO userTokenVO);
	
	/**
	 * 查询
	 * @return
	 */
	public List<UserTokenVO> queryUserTokenByUserId(long userId);
	
	/**
	 * 验证token
	 * @param userId
	 * @return
	 */
	public int verifyUserToken(Map<String,Object> map);
}
