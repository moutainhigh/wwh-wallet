package com.wwh.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwh.dao.ILogDao;
import com.wwh.service.ILogService;
import com.wwh.vo.SystemLogVO;

@Service
public class LogService implements ILogService {

	private SystemLogVO systemLogVO;
	
	@Autowired
	private ILogDao logDao;

	@Override
	public void writeLog(String methodName, Map<?, ?> paramMap, String methodRemark, Long userId) {
		systemLogVO = new SystemLogVO(userId);
		systemLogVO.setSystemMethodName(methodName);
		systemLogVO.setSystemParamName(paramMap);
		systemLogVO.setSystemRemark(methodRemark);
		logDao.addLog(systemLogVO);
	}
}
