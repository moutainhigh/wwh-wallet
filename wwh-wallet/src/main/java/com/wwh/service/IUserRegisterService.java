package com.wwh.service;
 

/**
 * 用户注册相关接口
 * @author Administrator
 * @version 1.0
 * @created 24-十月-2016 14:49:58
 */
public interface IUserRegisterService {

	/**
	 *  参数验证， 业务验证;
	 *	 记录邀请人,记录总邀请人;
	 * 为邀请人加积分 ,为接受人加积分, 修改邀请人、接受人总积分;
	 * 
	 * @param receiveUserId    接受人
	 * @param inviteUserId    邀请人
	 * @param language
	 * @param operatorId
	 */
	public boolean register (Long receiveUserId, Long inviteUserId, String language, Long operatorId) throws Exception;

	

}