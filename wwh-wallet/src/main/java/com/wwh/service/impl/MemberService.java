package com.wwh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.dao.IMemberDao;
import com.wwh.enums.DatabaseType;
import com.wwh.service.IMemberService;

@Service
public class MemberService implements IMemberService {

	@Autowired
	private IMemberDao memberDao;

	@Override
	public synchronized List<Map<String, Object>> getMemberById(long memberId) {
		DatabaseContextHolder.setDatabaseType(DatabaseType.mallDataSource);
		List<Map<String, Object>> list = memberDao.getMemberById(memberId);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return list;
	}
	
	@Override
	public synchronized List<Map<String,Object>> getMemberByCondition(String condition){
		DatabaseContextHolder.setDatabaseType(DatabaseType.mallDataSource);
		List<Map<String, Object>> list = memberDao.getMemberByCondition(condition);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return list;
	}
}
