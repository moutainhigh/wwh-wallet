package com.wwh.dao;

import java.util.List;

import com.wwh.vo.PlatformInviteVO;

public interface IPlatformInviteDao {
	
	public PlatformInviteVO getByInviteUserId(Long id);
	
	public PlatformInviteVO getById(Long id);
	
	public PlatformInviteVO selectByPrimaryKey(Long id);
	
	public int updatePlatformInviteByInviteUserId(PlatformInviteVO platformInviteVO);
	
	public int updatePlatformInviteById(PlatformInviteVO platformInviteVO);
	
	public int insert(PlatformInviteVO platformInviteVO);
	
	public int insertBatch(List<PlatformInviteVO> records);
	/**
	 * 
	 * @Title: updatePlatformInviteByUserId 
	 * @Description: 有就更新,没有就插入
	 * @param platformInviteVO
	 * @return: void
	 */
	void updatePlatformInviteByUserId(PlatformInviteVO platformInviteVO);
}
