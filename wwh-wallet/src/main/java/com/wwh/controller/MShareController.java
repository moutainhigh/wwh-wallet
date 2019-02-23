package com.wwh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.service.IMShareService;
import com.wwh.vo.MShareVO;

@Controller
@RequestMapping("/m")
public class MShareController {

	@Autowired
	private IMShareService mShareService;

	@ResponseBody
	@RequestMapping(value = "/myshare/{userId}", method = { RequestMethod.GET, RequestMethod.POST })
	public MShareVO myshare(@PathVariable() Long userId) {
		return mShareService.getMshareInfo(userId);
	}
}
