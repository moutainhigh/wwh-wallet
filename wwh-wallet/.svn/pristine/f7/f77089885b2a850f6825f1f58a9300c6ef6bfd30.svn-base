package com.wwh.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.common.WWHResultData;
import com.wwh.enums.DatabaseType;
import com.wwh.service.IBusinessService;
import com.wwh.util.CommonConstant;
import com.wwh.vo.BusinessCustromVO;
import com.wwh.vo.UserVO;

/**
 * 
 * @ClassName: BusinessProfitController
 * @Description: 招商分红controller
 * @author: YuZihao
 * @date: 2016年11月6日 下午12:29:56
 */
@Controller
@RequestMapping("/business")
public class BusinessProfitController {
	@Autowired
	private IBusinessService businessService;

	/**
	 * 
	 * @Title: toBusinessHtml
	 * @Description: 跳转到招商分红页面
	 * @return
	 * @return: String
	 */
	@RequestMapping("")
	public String toBusinessHtml() {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return "wallet/share/share-out-bonus";
	}

	/**
	 * 
	 * @Title: getBusinessCustrom
	 * @Description: 获取招商分红页面上的所有数据
	 * @param session
	 * @return
	 * @return: WWHResultData<BusinessCustromVO>
	 */
	@RequestMapping("/getalldetail")
	@ResponseBody
	public WWHResultData<BusinessCustromVO> getBusinessCustrom(HttpSession session) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		WWHResultData<BusinessCustromVO> wwhResultData = new WWHResultData<BusinessCustromVO>();
		wwhResultData.setData(businessService.getBusinessCustrom(userVo));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}
}
