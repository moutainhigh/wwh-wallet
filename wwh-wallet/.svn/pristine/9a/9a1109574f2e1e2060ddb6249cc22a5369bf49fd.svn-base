package com.wwh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwh.dao.IBankDao;
import com.wwh.service.IBankService;
import com.wwh.vo.BankVO;

@Service
public class BankService implements IBankService{
	
	@Autowired
	private IBankDao bankDao;
	
	/**
	 * 查询银行列表信息
	 */
	@Override
	public List<BankVO> selectBankInfo() {
		return bankDao.queryBankInfo();
	}

}
