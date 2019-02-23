package com.wwh.service;

import com.wwh.common.PagedResult;
import com.wwh.common.ResultMsg;
import com.wwh.vo.ApplyWithdrawVO;
import com.wwh.vo.WithdrawDetilVO;
import com.wwh.vo.WithdrawalVO;

public interface IApplyWithdrawService {

	/**
	 * 根据用户id查询用户提现相关信息
	 * 
	 * @param userId
	 * @return
	 */
	ApplyWithdrawVO getApplyWithrawInfo(Long userId);

	/**
	 * 插入用户提现申请相关信息
	 * 
	 * @param withdrawVo
	 * @return
	 */
	Integer insertApplyWithdrawDetilInfo(WithdrawalVO withdrawVo);

	/**
	 * 查询提现申请记录
	 * 
	 * @param userId
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PagedResult<WithdrawDetilVO> getWithdrawDetilInfo(Long userId, Integer currentPage, Integer pageSize);

	/**
	 * 校验体验信息
	 * 
	 * @param withdrawVo
	 * @return
	 */
	ResultMsg<Object> validWithdrawalAmount(WithdrawalVO withdrawVo);
	/**
	 * 校验是否还有在处理的体现申请
	 * 
	 * @param withdrawVo
	 * @return
	 */
	ResultMsg<Object> checkHaveRuninfo(Long userId);
}
