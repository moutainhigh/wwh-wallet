package com.wwh.service;

import java.util.List;

import com.wwh.vo.BankVO;

public interface IBankService {
	/**
	 * 查询银行列表信息
	 * @return
	 */
	List<BankVO> selectBankInfo();

}
