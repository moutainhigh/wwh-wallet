package com.wwh.dao;

import java.util.List;

import com.wwh.vo.PlatformInviteDetailVO;

public interface IPlatformInviteDetailDao {

	public double updatePlatformInviteDetailById(PlatformInviteDetailVO platformInviteDetailVO);

	public int insert(PlatformInviteDetailVO platformInviteDetailVO);

	public int insertBatch(List<PlatformInviteDetailVO> records);

	/**
	 * 
	 * @Title: getPlatformInviteDetailVOByUserId 
	 * @Description: 获取某个用户的被邀请记录
	 * @param userId
	 * @return
	 * @return: PlatformInviteDetailVO
	 */
	PlatformInviteDetailVO getPlatformInviteDetailVOByUserId(Long userId);
	
	/**
	 * 
	 * @Title: updatePlatformInviteDetailToY 
	 * @Description: 修改某个用户的被邀请记录为Y
	 * @param userId
	 * @return: void
	 */
	void updatePlatformInviteDetailToY(Long userId);
}
