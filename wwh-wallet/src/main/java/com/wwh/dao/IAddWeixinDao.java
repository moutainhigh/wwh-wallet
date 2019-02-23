package com.wwh.dao;

import java.util.List;

import com.wwh.vo.AddWeixinVO;

public interface IAddWeixinDao {
	/**
	 * 查询用户添加的微信号
	 * 
	 * @param userId
	 * @return
	 */
	public List<AddWeixinVO> queryWeixinInfo(Long userId);

	/**
	 * 新增用户微信信息
	 * 
	 * @param addWeixinVo
	 * @return
	 */
	public Integer insertWeixinNum(AddWeixinVO addWeixinVo);
}
