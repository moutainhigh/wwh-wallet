package com.wwh.dao;

import java.util.List;

import com.wwh.vo.AgentRegionVO;
import com.wwh.vo.AreaRelationVO;
import com.wwh.vo.AreaVO;
import com.wwh.vo.CityVO;
import com.wwh.vo.CountryVO;
import com.wwh.vo.ProvinceVO;
import com.wwh.vo.UserVO;

public interface ICertificationDao {
	/**
	 * 根据国家列表
	 * @param countryCode
	 * @return
	 */
	List<CountryVO> getCountryList();
	/**
	 * 查询省分列表
	 * @return
	 */
	List<ProvinceVO> getProvinceList(String CountryCode);
	/**
	 * 查询城市列表
	 * @return
	 */
	List<CityVO> getCityList(String provinceCode);
	/**
	 * 查询地区列表
	 * @return
	 */
	List<AreaVO> getAreaList(String cityCode);
	/**
	 * 查询用户实名认证结果
	 * @param userId
	 * @return
	 */
	String queryIsIdValid(Long userId);
	/**
	 * 查询用户的手机号
	 * @param userId
	 * @return
	 */
	UserVO getPhoneByUserId(Long userId);
	
	/**
	 * 更新用户地区关系表信息
	 * @param areaRelationVo
	 * @return
	 */
	Integer updateAreaRelationInfo(AreaRelationVO areaRelationVo);
	
	CityVO getCityByCityCode(String code);
	AreaVO getAreaByAreaCode(String code);
	ProvinceVO getProvinceByProvinceCode(String code);
	CountryVO getCountryByCountryCode(String code);

	AgentRegionVO getAgentByRegionCode(String code);
}
