package com.wwh.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.wwh.service.IAmountScoreService;

@Service
public class AmountScoreService implements IAmountScoreService {

	@Override
	public int increaseMyScoreInvite(BigDecimal increaseScore, Long inviteUserId, Long receiveUserId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer increaseMyScoreRegister(BigDecimal increaseScore, Long inviteUserId, Long receiveUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer useUpScore(Long userId, BigDecimal userUpScore) {
		// TODO Auto-generated method stub
		return null;
	}

}
