package com.wwh.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.enums.DatabaseType;
import com.wwh.service.IMemberService;

@Controller
@RequestMapping("/*")
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private IMemberService memberService;

	/**
	 * 
	 * @Title: page
	 * @Description: 首页，页面初始化
	 * @param session
	 * @return
	 * @return: String
	 */
	@RequestMapping("/")
	public String toInd(HttpServletRequest request) throws Exception {
		logger.info("/************************进入");
		return "wallet/index";
	}

	@RequestMapping("/index")
	public String toIndex(HttpServletRequest request) throws Exception {
		Object obj = request.getSession().getAttribute("CURRENT_USER");
		if (obj != null) {
			request.setAttribute("userId", obj.toString());
			logger.info("/index************************userId=" + obj.toString());
		} else {
			request.setAttribute("userId", "nologin");
		}
		logger.info("/index************************进入");
		return "wallet/index";
	}

	@RequestMapping("/getuserinfo/{memberId}")
	@ResponseBody
	public List<Map<String, Object>> getMemberById(@PathVariable long memberId) {
		List<Map<String, Object>> list = memberService.getMemberById(memberId);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return list;
	}
}
