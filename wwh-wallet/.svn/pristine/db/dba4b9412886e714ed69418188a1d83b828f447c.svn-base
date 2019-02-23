package com.wwh.dao;

import java.util.List;

import com.wwh.vo.DiskTypeProfitVO;

/**
 * 
 * @ClassName: IDiskTypeProfitDao
 * @Description: 系统类型收益表 wallet_disk_type_profit_t
 * @author: lilinxiang
 * @date: 2016年11月14日 上午1:10:17
 */
public interface IDiskTypeProfitDao {

	/**
	 * 
	 * @Title: selectDiskTypeProfitByDiskTypeProfit
	 * @Description: 查询该系统收益
	 * @param diskTypeProfitVO
	 * @return
	 * @return: List<DiskTypeProfitVO>
	 */
	public List<DiskTypeProfitVO> selectDiskTypeProfitByDiskTypeProfit(DiskTypeProfitVO diskTypeProfitVO);

	/**
	 * 
	 * @Title: insertDiskTypeProfit
	 * @Description: 新增系统收益
	 * @param diskTypeProfitVO
	 * @return
	 * @return: Integer
	 */
	public Integer insertDiskTypeProfit(DiskTypeProfitVO diskTypeProfitVO);

	/**
	 * 
	 * @Title: increaseDiskTypeProfit
	 * @Description: 累加系统收益
	 * @param diskTypeProfitVO
	 *            必须字段 userId, disk_type <br/>
	 *            <br/>
	 * @return
	 * @return: Integer
	 */
	public Integer increaseDiskTypeProfit(DiskTypeProfitVO diskTypeProfitVO);

	/**
	 * 
	 * @Title: updateDiskTypeProfitByUserId
	 * @Description: 更新用户系统类型收益表 如果没有该用户收益记录则新增记录,如果有则更新该记录
	 * @param diskTypeProfitVO
	 * @return: void
	 */
	public void updateDiskTypeProfitByUserId(DiskTypeProfitVO diskTypeProfitVO);
}
