package com.wwh.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.common.WWHResultData;
import com.wwh.enums.DatabaseType;
import com.wwh.service.IUserRegisterService;
import com.wwh.util.ReturnConstant;
import com.wwh.vo.RegisterVO;

/**
 * @ClassName: UserRegisterController
 * @Description: 电商注册调用接口类
 * @author: lilinxiang
 * @date: 2016年10月24日 上午11:49:13
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

	private static Logger logger = LogManager.getLogger(RegisterController.class);

	@Autowired
	private IUserRegisterService userRegisterService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public WWHResultData<Boolean> register(@RequestBody RegisterVO registerVO) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		logger.info("register post start: " + registerVO);
		WWHResultData<Boolean> wwhResultData = new WWHResultData<>();
		if (null == registerVO) {
			wwhResultData.setCode(ReturnConstant.RETURN_CODE_400);
			wwhResultData.setMsg(ReturnConstant.RETURN_MSG_400);
			// wwhResultData.setStatus(ReturnConstant.RETURN_STATUS_FAIL);
			wwhResultData.setData(null);
			return wwhResultData;
		}

		Boolean flag = userRegisterService.register(registerVO.getReceiveUserId(), registerVO.getInviteUserId(),
				registerVO.getLanguage(), registerVO.getOperatorId());

		wwhResultData.setData(flag);

		logger.info("register post end");
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}
}
