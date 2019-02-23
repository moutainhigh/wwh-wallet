package com.wwh.dao;

import java.util.List;

import com.wwh.vo.WalletAmountVO;

public interface IWalletAmountDao {
	
	
	/**
	 * 
	 * @Title: increaseWalletAmountByUserIdSelective 
	 * @Description: 累加会员钱包
	 * @param walletAmountVO
	 * @return
	 * @return: Integer
	 */
	public Integer increaseWalletAmountByUserIdSelective(WalletAmountVO walletAmountVO);
	
	public WalletAmountVO getByUserId(Long id);
	
	public WalletAmountVO selectByPrimaryKey(Long id);
	
	/**
	 * 
	 * @Title: updateByUserIdSelective
	 * @Description: 修改用户钱包
	 * @param walletAmountVO
	 *            userId 不允许为空<br/>
	 * @return
	 * @return: Integer
	 */
	public Integer updateByUserIdSelective(WalletAmountVO walletAmountVO);
	
	public Long updateByPrimaryKeySelective(WalletAmountVO walletAmountVO);
	
	public Long insert(WalletAmountVO walletAmountVO);
	
	public Long insertBatch(List<WalletAmountVO> records);
 
}
