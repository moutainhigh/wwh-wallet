package com.wwh.service;

import com.wwh.vo.BusinessCustromVO;
import com.wwh.vo.UserVO;

/**
 * 
 * @ClassName: IBusinessService 
 * @Description: 招商分红service
 * @author: YuZihao
 * @date: 2016年11月6日 下午1:55:55
 */
public interface IBusinessService {

	/**
	 * 
	 * @Title: getBusinessCustrom 
	 * @Description: 获取招商分红页面所有的数据
	 * @param userVo
	 * @return
	 * @return: BusinessCustromVO
	 */
	BusinessCustromVO getBusinessCustrom(UserVO userVo);
}
