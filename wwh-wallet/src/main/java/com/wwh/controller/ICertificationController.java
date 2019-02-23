package com.wwh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.common.ResultMsg;
import com.wwh.enums.DatabaseType;
import com.wwh.service.ICertificationService;
import com.wwh.util.CommonConstant;
import com.wwh.vo.AreaVO;
import com.wwh.vo.CityVO;
import com.wwh.vo.CountryVO;
import com.wwh.vo.ProvinceVO;
import com.wwh.vo.UserVO;

@Controller
@RequestMapping("/cretification")
public class ICertificationController {

	@Autowired
	private ICertificationService certificationService;

	@ResponseBody
	@RequestMapping(value = "/queryisidvalid", method = { RequestMethod.POST, RequestMethod.GET })
	public boolean queryIsIdValid(HttpSession session) {
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		return certificationService.queryIsIdValid(userVo.getUserId());
	}

	@ResponseBody
	@RequestMapping(value = "/countrylist", method = { RequestMethod.POST, RequestMethod.GET })
	public List<CountryVO> getCountryList() {
		return certificationService.getCountryList();
	}

	@ResponseBody
	@RequestMapping(value = "/provincelist/{countryCode}", method = { RequestMethod.POST, RequestMethod.GET })
	public List<ProvinceVO> getProvinceList(@PathVariable String countryCode) {
		return certificationService.getProvinceList(countryCode);
	}

	@ResponseBody
	@RequestMapping(value = "/citylist/{provinceCode}", method = { RequestMethod.POST, RequestMethod.GET })
	public List<CityVO> getCityList(@PathVariable String provinceCode) {
		return certificationService.getCityList(provinceCode);
	}

	@ResponseBody
	@RequestMapping(value = "/arealist/{cityCode}", method = { RequestMethod.POST, RequestMethod.GET })
	public List<AreaVO> getAreaList(@PathVariable String cityCode) {
		return certificationService.getAreaList(cityCode);
	}

	@ResponseBody
	@RequestMapping(value = "/updateuserinfo", method = { RequestMethod.POST, RequestMethod.GET })
	public ResultMsg<String> updateUserInfo(@RequestBody UserVO userVo, HttpSession session) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		return certificationService.updateUserInfoById(userVo);
	}

	@ResponseBody
	@RequestMapping(value = "/getphone", method = { RequestMethod.POST, RequestMethod.GET })
	public UserVO getUserInfo(HttpSession session) {
		Long userId = (Long) session.getAttribute(CommonConstant.WALLET_USER_ID);
		return certificationService.getPhoneByUserId(userId);
	}

}
