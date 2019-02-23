package com.wwh.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.common.WWHResultData;
import com.wwh.enums.DatabaseType;
import com.wwh.vo.UserRechargeVO;

@Controller
public class RechargeController {
	private static Logger logger = LogManager.getLogger(RegisterController.class);
	// @Autowired
	// private IUserRegisterService userRegisterService;

	@RequestMapping(value = "/userrecharge", method = RequestMethod.POST)
	@ResponseBody
	public WWHResultData<Boolean> register(@RequestBody UserRechargeVO userRechargeVO) throws Exception {
		logger.info("register POST START");
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		WWHResultData<Boolean> wwhResultData = new WWHResultData<>();
		//
		// if (null == registerVO) {
		// wwhResultData.setMsg("");
		// wwhResultData.setStatus("");
		// wwhResultData.setData(null);
		// return wwhResultData;
		// }
		//
		// Boolean
		// flag=userRegisterService.register(registerVO.getReceiveUserId(),
		// registerVO.getInviteUserId(),
		// registerVO.getLanguage(), registerVO.getOperatorId());
		//
		// wwhResultData.setData(flag);

		logger.info("register  POST END");
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}
}
