package com.wwh.dao;

import com.wwh.loginwx.vo.WXUserInfoVO;

public interface ILoginwxDao {
	/**
	 * 插入微信用户信息
	 * @param wxUserInfoVO
	 * @return
	 */
	public Long insertWXUserInfo(WXUserInfoVO wxUserInfoVO) ;
	/**
	 * 通过userId查询微信用户
	 * @param userId
	 * @return
	 */
	public WXUserInfoVO getWXUserInfoByUserId(Long userId);
	/**
	 * 通过unionId查询微信用户
	 * @param unionId
	 * @return
	 */
	public WXUserInfoVO getWXUserInfoByUnionId(String unionId);

	/**
	 * 更新微信表中的用户信息
	 * @param userId
	 * @param unionId
	 */
	public void updateWXUserInfo(WXUserInfoVO wxUserInfoVO); 
	/**
	 * 得到有效的公共接口使用token凭证（两个小时有效期）
	 */
	public String getValidTokenByUnionId(String unionId);
	/**
	 * 得到用户有效的媒体id(媒体id有效3天)
	 */
	public String getValidMediaIdByUnionId(String unionId);
}
