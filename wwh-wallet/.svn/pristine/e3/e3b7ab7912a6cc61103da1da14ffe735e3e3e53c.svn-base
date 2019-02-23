package com.wwh.service;

import java.util.List;

import com.wwh.common.ResultMsg;
import com.wwh.vo.AreaVO;
import com.wwh.vo.CityVO;
import com.wwh.vo.CountryVO;
import com.wwh.vo.ProvinceVO;
import com.wwh.vo.UserVO;

public interface ICertificationService {
	/**
	 * 查询用户是否实名认证
	 * 
	 * @param userId
	 * @return
	 */
	boolean queryIsIdValid(Long userId);

	/**
	 * 根据国家列表
	 * 
	 * @param countryCode
	 * @return
	 */
	List<CountryVO> getCountryList();

	/**
	 * 查询省分列表
	 * 
	 * @return
	 */
	List<ProvinceVO> getProvinceList(String CountryCode);

	/**
	 * 查询城市列表
	 * 
	 * @return
	 */
	List<CityVO> getCityList(String provinceCode);

	/**
	 * 查询地区列表
	 * 
	 * @return
	 */
	List<AreaVO> getAreaList(String cityCode);

	/**
	 * 更新用户信息
	 * 
	 * @param userVo
	 * @return
	 */
	ResultMsg<String> updateUserInfoById(UserVO userVo) throws Exception;

	/**
	 * 获取用户的手机号
	 * 
	 * @param userId
	 * @return
	 */
	UserVO getPhoneByUserId(Long userId);
}
