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

import com.wwh.common.ResultMsg;
import com.wwh.service.IAddWeixinService;
import com.wwh.util.CommonConstant;
import com.wwh.vo.AddWeixinVO;

@Controller
@RequestMapping("/addweixin")
public class AddWeixinController {
	@Autowired
	private IAddWeixinService addWeixinService;

	@ResponseBody
	@RequestMapping("/queryweixin/{userId}")
	public List<AddWeixinVO> selectWeixinInfo(@PathVariable Long userId) {
		return addWeixinService.selectWeixin(userId);
	}

	@ResponseBody
	@RequestMapping(value = "/insertweixin", method = { RequestMethod.POST, RequestMethod.GET })
	public ResultMsg<String> insertWeixinfo(@RequestBody AddWeixinVO addWeixinVo, HttpSession session) {
		Long userId = (Long) session.getAttribute(CommonConstant.WALLET_USER_ID);
		ResultMsg<String> resultMsg = new ResultMsg<String>();
		resultMsg.setReturnCode("200");
		resultMsg.setReturnMsg("success");
		addWeixinVo.setLastUpdatedBy(userId);
		addWeixinVo.setCreatedBy(userId);
		addWeixinVo.setUserId(userId);
		Integer result = addWeixinService.insertWeixinInfo(addWeixinVo);
		if (null != result && result < 1) {
			resultMsg.setReturnCode("404");
			resultMsg.setReturnMsg("fail");
		}
		return resultMsg;
	}

}
