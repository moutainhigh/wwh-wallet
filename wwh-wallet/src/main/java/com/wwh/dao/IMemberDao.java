package com.wwh.dao;

import java.util.List;
import java.util.Map;

public interface IMemberDao {
	
	/**
	 * 获取会员
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> getMemberById(long memberId);
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public List<Map<String,Object>> getMemberByCondition(String condition);
}
