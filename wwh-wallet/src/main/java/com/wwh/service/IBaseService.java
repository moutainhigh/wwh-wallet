package com.wwh.service;

import com.wwh.common.PagedResult;
import com.wwh.vo.UserVO;

public interface IBaseService {
	
	PagedResult<UserVO> getPage(Integer currentPage,Integer pageSize);
}
