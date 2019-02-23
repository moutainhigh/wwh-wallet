package com.wwh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwh.dao.IUnionPayDao;
import com.wwh.vo.BankCardVO;
import com.wwh.vo.WithdrawalLogVO;
import com.wwh.vo.WithdrawalVO;

@Service
public class UnionPayService {

	@Autowired
	private IUnionPayDao unionPayDao;

	/**
	 * 添加预备提现记录
	 * 
	 * @return
	 */
	public int addPrepareWithdrawsCash(WithdrawalVO withdrawalVO) {
		return unionPayDao.addPrepareWithdrawsCash(withdrawalVO);
	}

	/**
	 * 查询预备提现记录
	 * 
	 * @return
	 */
	public List<WithdrawalVO> queryPrepareWithdrawsCash(Map<String, Object> map) {
		return unionPayDao.queryPrepareWithdrawsCash(map);
	}

	public int queryPrepareWithdrawsCashCount(Map<String, Object> map) {
		return unionPayDao.queryPrepareWithdrawsCashCount(map);
	}

	/**
	 * 提现审核
	 * 
	 * @param map
	 * @return
	 */
	public int updateWithdrawsCash(Map<String, Object> map) {
		return unionPayDao.updateWithdrawsCash(map);
	}

	/**
	 * 添加操作日志
	 * 
	 * @return
	 */
	public int addFinanceDetailLog(WithdrawalLogVO withdrawalLogVO) {
		return unionPayDao.addFinanceDetailLog(withdrawalLogVO);
	}

	/**
	 * 查询操作日志
	 * 
	 * @return
	 */
	public List<WithdrawalLogVO> queryFinanceDetailLog(Map<String, Object> map) {
		return unionPayDao.queryFinanceDetailLog(map);
	}

	/**
	 * 添加银行卡
	 * 
	 * @param bankCardVO
	 * @return
	 */
	public int addBankCard(BankCardVO bankCardVO) {
		return unionPayDao.addBankCard(bankCardVO);
	}

	/**
	 * 绑定银行卡
	 * 
	 * @param bankCardVO
	 * @return
	 */
	public int addBindingBankCard(BankCardVO bankCardVO) {
		return unionPayDao.addBindingBankCard(bankCardVO);
	}

	/**
	 * 查询绑定银行卡
	 * 
	 * @param map
	 * @return
	 */
	public List<BankCardVO> queryBindingBankCard(Map<String, Object> map) {
		return unionPayDao.queryBindingBankCard(map);
	}

	/**
	 * 查询用户绑定的银行卡
	 * 
	 * @param userId
	 * @param bankCardName
	 * @return
	 */
	public BankCardVO queryBankCardInfo(Long userId, String bankCardName) {
		return unionPayDao.getBankCardInfo(userId, bankCardName);
	}
}
