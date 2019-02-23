package com.wwh.dao;

import com.github.pagehelper.Page;
import com.wwh.vo.UserVO;

public interface IBaseDao {

	public Page<UserVO> getPage();
}
