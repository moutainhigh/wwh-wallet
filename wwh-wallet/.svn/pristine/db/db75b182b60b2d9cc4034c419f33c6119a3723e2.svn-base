package com.wwh.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wwh.vo.BankCardVO;
import com.wwh.vo.WithdrawalLogVO;
import com.wwh.vo.WithdrawalVO;

/**
 * 提现充值
 * 
 * @author wwh
 *
 */
public interface IUnionPayDao {
	/**
	 * 添加预备提现记录
	 * 
	 * @return
	 */
	public int addPrepareWithdrawsCash(WithdrawalVO withdrawalVO);

	/**
	 * 查询预备提现记录
	 * 
	 * @return
	 */
	public List<WithdrawalVO> queryPrepareWithdrawsCash(Map<String, Object> map);

	/**
	 * 查询预备提现记录总记录
	 * 
	 * @param map
	 * @return
	 */
	public int queryPrepareWithdrawsCashCount(Map<String, Object> map);

	/**
	 * 提现审核
	 * 
	 * @param map
	 * @return
	 */
	public int updateWithdrawsCash(Map<String, Object> map);

	/**
	 * 添加操作日志
	 * 
	 * @return
	 */
	public int addFinanceDetailLog(WithdrawalLogVO withdrawalLogVO);

	/**
	 * 查询操作日志
	 * 
	 * @return
	 */
	public List<WithdrawalLogVO> queryFinanceDetailLog(Map<String, Object> map);

	/**
	 * 添加银行卡
	 * 
	 * @param bankCardVO
	 * @return
	 */
	public int addBankCard(BankCardVO bankCardVO);

	/**
	 * 绑定银行卡
	 * 
	 * @param bankCardVO
	 * @return
	 */
	public int addBindingBankCard(BankCardVO bankCardVO);

	/**
	 * 查询绑定银行卡
	 * 
	 * @param map
	 * @return
	 */
	public List<BankCardVO> queryBindingBankCard(Map<String, Object> map);

	/**
	 * 查询用户绑定的银行卡信息
	 * 
	 * @param userId
	 * @param bankCardName
	 * @return
	 */
	public BankCardVO getBankCardInfo(@Param("userId") Long userId, @Param("bankCardName") String bankCardName);
}
