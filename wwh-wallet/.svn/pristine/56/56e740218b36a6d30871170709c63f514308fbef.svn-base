package com.wwh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwh.dao.IAddWeixinDao;
import com.wwh.service.IAddWeixinService;
import com.wwh.vo.AddWeixinVO;

@Service
public class AddWeixinService implements IAddWeixinService {

	@Autowired
	private IAddWeixinDao addWeixinDao;

	/**
	 * 查询用户添加的微信列表
	 */
	@Override
	public List<AddWeixinVO> selectWeixin(Long userId) {
		return addWeixinDao.queryWeixinInfo(userId);
	}

	/**
	 * 新增用户微信信息
	 */
	@Override
	public Integer insertWeixinInfo(AddWeixinVO addWeixinVo) {
		return addWeixinDao.insertWeixinNum(addWeixinVo);
	}

}
