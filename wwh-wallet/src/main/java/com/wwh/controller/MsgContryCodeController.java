package com.wwh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.service.IMsgContryCodeService;
import com.wwh.vo.MsgContryCodeVO;

@Controller
@RequestMapping("/msg")
public class MsgContryCodeController {
	@Autowired
	private IMsgContryCodeService msgContryCodeService;

	@ResponseBody
	@RequestMapping("/contrycode")
	public List<MsgContryCodeVO> selectWeixinInfo() {
		return msgContryCodeService.getMsgContryCodeList();
	}

}
