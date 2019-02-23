package com.wwh.service;

import java.util.List;

import com.wwh.vo.DirectorConfigVO;
import com.wwh.vo.DiskProfitVO;
import com.wwh.vo.SingleProfitAmountConfigVO;

/**
 * 盘收益相关
 * @author asd
 * @version 1.0
 * @created 09-11月-2016 14:36:38
 */
public interface IDiskProfitService {

	/**
	 * 总监，可提现，储备金配置
	 */
	public List<DirectorConfigVO> getDirectorConfigList();

	/**
	 * 查找某人  某盘 的盘收益
	 * 
	 * @param diskType    盘类型
	 * @param useId    用户编号
	 * @param idCard
	 * @param diskStatus    枚举：本盘现在的状态， running , finished
	 */
	public List<DiskProfitVO> getDiskProfitByUserId(String diskType, Long useId, String idCard, String diskStatus);

	/**
	 * DiskTypeProfit  查询 wallet_disk_type_profit_t系统类型收益表
	 * 
	 * @param userId
	 */
	public int getDiskTypeProfitByUserId(Long userId);

	/**
	 * 盘收益，单笔配置
	 */
	public List<SingleProfitAmountConfigVO> getSingleProfitAmountConfigList();

}