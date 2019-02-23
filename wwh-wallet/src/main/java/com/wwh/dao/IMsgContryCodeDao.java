package com.wwh.dao;

import java.util.List;

import com.wwh.vo.MsgContryCodeVO;

public interface IMsgContryCodeDao {
	/**
	 * 获取国家编号列表
	 * 
	 * @return
	 */
	public List<MsgContryCodeVO> getMsgContryCodeVO();
}
