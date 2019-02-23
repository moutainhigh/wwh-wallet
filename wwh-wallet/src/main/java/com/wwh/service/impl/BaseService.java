package com.wwh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.wwh.common.PagedResult;
import com.wwh.dao.IBaseDao;
import com.wwh.service.IBaseService;
import com.wwh.util.BeanUtils;
import com.wwh.vo.UserVO;

@Service
public class BaseService implements IBaseService {

	@Autowired
	private IBaseDao baseDao;

	@Override
	public PagedResult<UserVO> getPage(Integer currentPage, Integer pageSize) {
		currentPage = currentPage == null ? 1 : currentPage;
		pageSize = pageSize == null ? 10 : pageSize;
		// startPage是告诉拦截器说我要开始分页了
		PageHelper.startPage(currentPage, pageSize);
		return BeanUtils.toPagedResult(baseDao.getPage());
	}
}
