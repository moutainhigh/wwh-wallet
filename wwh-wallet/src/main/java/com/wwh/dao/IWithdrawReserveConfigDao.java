package com.wwh.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwh.vo.ApplyWithdrawVO;
import com.wwh.vo.CountWithdrawalsVO;
import com.wwh.vo.DirectorConfigVO;
import com.wwh.vo.WithdrawDetilVO;
import com.wwh.vo.WithdrawalVO;

/**
 * 
 * @ClassName: IDirectorWithdrawReserveConfigDao
 * @Description: wallet_director_withdraw_reserve_config_t 总监可提现、储备金的配置表
 * @author: lilinxiang
 * @date: 2016年11月9日 下午4:23:07
 */
public interface IWithdrawReserveConfigDao {

	/**
	 * 
	 * @Title: getAllConfig
	 * @Description:查询所有总监可提现、储备金的配置表
	 * @return
	 * @return: List<SingleProfitAmountConfigVO>
	 */
	public List<DirectorConfigVO> getAllConfig();

	/**
	 * 
	 * @Title: updateWithdrawReserveConfig
	 * @Description: 修改总监可提现、储备金的配置
	 * @param config
	 * @return
	 * @return: Integer
	 */
	public Integer updateWithdrawReserveConfig(DirectorConfigVO config);

	/**
	 * 
	 * @Title: insertWithdrawReserveConfig
	 * @Description: 新增总监可提现、储备金的配置
	 * @param config
	 * @return
	 * @return: Integer
	 */
	public Integer insertWithdrawReserveConfig(DirectorConfigVO config);

	/**
	 * 查询申请提现相关信息
	 * 
	 * @param userId
	 * @return
	 */
	public ApplyWithdrawVO getApplyWithrawInfo(Long userId);

	/**
	 * 插入提现申请详情记录
	 * 
	 * @param withdrawVo
	 * @return
	 */
	public Integer insertApplyWithdrawDetilInfo(WithdrawalVO withdrawVo);

	/**
	 * 获取提现记录
	 * 
	 * @param userId
	 * @return
	 */
	public List<WithdrawDetilVO> getWithdrawDetilInfo(Long userId);

	/**
	 * 统计提现记录信息
	 * 
	 * @param userId
	 * @return
	 */
	public CountWithdrawalsVO countWithdrawals(Long userId);

	/**
	 * 查询用户的正在提现中的储备金金额
	 * 
	 * @param userId
	 * @param diskType
	 * @return
	 */
	public BigDecimal getTotalSaveGoldAmount(@Param("userId") Long userId, @Param("diskType") String diskType);
	/**
	 * 查询用户是否还存在处理中的体现申请
	 * 
	 * @param userId
	 * @param diskType
	 * @return
	 */
	public Long checkHaveRuninfo(@Param("userId") Long userId);
}
