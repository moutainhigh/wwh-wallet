package com.wwh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwh.vo.DiskProfitVO;
import com.wwh.vo.DiskTypeProfitVO;
import com.wwh.vo.ProfitDetailVO;

/**
 * 
 * @ClassName: IWalletProfitDetailDao
 * @Description: 钱包收益详情 wallet_profit_detail_tiyan_t 体验收益详情表
 * @author: lilinxiang
 * @date: 2016年11月10日 下午4:10:45
 */
public interface IWalletProfitDetailDao {

	/**
	 * 
	 * @Title: increasePlatformProfitByUserIdSelective
	 * @Description: 累加平台总收益表
	 * @param diskTypeProfitVO
	 * @return
	 * @return: Integer
	 */
	public Integer increasePlatformProfitByUserIdSelective(DiskTypeProfitVO diskTypeProfitVO);

	/**
	 * 
	 * @Title: increaseDiskTypeProfitBySelective
	 * @Description: 累加某人某类盘的收益金额 ;<br/>
	 *               可用于 累加 某人 在某系统盘中的 disk_profit_amount 收益<br/>
	 * @param diskTypeProfitVO
	 *            必须字段 user_id , disk_type <br/>
	 *            <br/>
	 *            <br/>
	 *            <br/>
	 * @return
	 * @return: Integer
	 */
	public Integer increaseDiskTypeProfitBySelective(DiskTypeProfitVO diskTypeProfitVO);

	/**
	 * 
	 * @Title: insertDiskTypeProfit
	 * @Description: 新增系统类型收益表
	 * @param diskTypeProfitVO
	 * @return
	 * @return: Integer
	 */
	public Integer insertDiskTypeProfit(DiskTypeProfitVO diskTypeProfitVO);

	/**
	 * 
	 * @Title: updateDiskProfitByDiskSeqAndUserIdSelective
	 * @Description: 修改某人在某盘的收益情况; 储备金,可提现，累加增加
	 * @param diskProfitVO
	 * @return
	 * @return: Integer
	 */
	public Integer updateDiskProfitByDiskSeqAndUserIdSelective(DiskProfitVO diskProfitVO);

	/**
	 * 
	 * @Title: selectDiskProfitByDiskProfit
	 * @Description: 查询盘总收益表记录 wallet_disk_profit_t
	 * @param records
	 * @return
	 * @return: List<DiskProfitVO>
	 */
	public List<DiskProfitVO> selectDiskProfitByDiskProfit(DiskProfitVO diskProfitVO);

	/**
	 * 
	 * @Title: insertDiskProfit
	 * @Description: 新增盘总收益表记录 wallet_disk_profit_t
	 * @param records
	 * @return
	 * @return: Integer
	 */
	public Integer insertDiskProfit(DiskProfitVO diskProfitVO);

	/**
	 * 
	 * @Title: increaseDiskProfit
	 * @Description: 累加盘总收益表记录 wallet_disk_profit_t <br/>
	 *               可用于 累加 withdrawals_amount save_amount<br/>
	 *               <br/>
	 * @param diskProfitVO
	 *            必须字段 user_id ,disk_seq ,disk_type,id_card ,<br/>
	 * @return
	 * @return: Integer
	 */
	public Integer increaseDiskProfit(DiskProfitVO diskProfitVO);

	/**
	 * 
	 * @Title: insertBatchProfitDetail
	 * @Description: 批量插入收益详情
	 * @param diskType
	 * @param records
	 * @return
	 * @return: Integer
	 */
	public Integer insertBatchProfitDetail(@Param("diskType") String diskType,
			@Param("records") List<ProfitDetailVO> records);

	/**
	 * 
	 * @Title: insertProfitDetail
	 * @Description: 插入收益详情
	 * @param profitDetailVO
	 * @return
	 * @return: Integer
	 */
	public Integer insertProfitDetail(ProfitDetailVO profitDetailVO);

	/**
	 * 修改盘收益表的盘运行状态 (所有人)
	 * 
	 * @Title: updateDiskStatus
	 * @Description: 修改盘收益表的盘运行状态 (所有人)
	 * @param diskSeq
	 *            盘号
	 * @param diskStatus
	 *            要修改的盘状态
	 * @return: void
	 */
	public void updateDiskStatus(@Param("diskSeq") String diskSeq, @Param("diskStatus") String diskStatus,@Param("diskCounter") Integer diskCounter);
	
	public DiskProfitVO getDiskProfitByIdCard(String idCard);

}
