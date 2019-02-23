package com.wwh.service;

import java.util.List;

import com.wwh.vo.AddWeixinVO;

public interface IAddWeixinService {
	/**
	 * 查询用户添加的微信号列表
	 * 
	 * @param userId
	 * @return
	 */
	List<AddWeixinVO> selectWeixin(Long userId);

	/**
	 * 新增用户微信信息
	 * 
	 * @param addWeixinVo
	 * @return
	 */
	Integer insertWeixinInfo(AddWeixinVO addWeixinVo);

}
