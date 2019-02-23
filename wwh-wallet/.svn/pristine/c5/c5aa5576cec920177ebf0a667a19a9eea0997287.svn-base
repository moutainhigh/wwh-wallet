package com.wwh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wwh.common.PagedResult;
import com.wwh.service.IBaseService;
import com.wwh.util.CommonConstant;
import com.wwh.vo.UserVO;

@Controller
public class BaseController {

	@Autowired
	private IBaseService baseService;

	// 获取保存在Session中的用户对象
	protected UserVO getSessionUser(HttpServletRequest request) {
		return (UserVO) request.getSession().getAttribute(CommonConstant.WALLET_USER_ID);
	}

	// 将用户对象保存到Session中
	protected void setSessionUser(HttpServletRequest request, UserVO userVO) {
		request.getSession().setAttribute(CommonConstant.WALLET_USER_ID, userVO);
	}

	// 获取基于应用程序的url绝对路径
	public final String getAppbaseUrl(HttpServletRequest request, String url) {
		Assert.hasLength(url, "url不能为空");
		Assert.isTrue(url.startsWith("/"), "必须以/打头");
		return request.getContextPath() + url;
	}

	@RequestMapping("/getpage/{currentPage}/{pageSize}")
	public PagedResult<UserVO> getMemberById(@PathVariable Integer currentPage, @PathVariable Integer pageSize) {
		return baseService.getPage(currentPage, pageSize);
	}

	@RequestMapping("/applywithdrawl")
	public String toIndex(HttpServletRequest request) throws Exception {
		request.setAttribute("diskType", "no");
		request.setAttribute("amount", "0.00");
		return "wallet/benifit/benifit-step1";
	}

	@RequestMapping("/choose")
	public String chooseSystem(HttpServletRequest request, @RequestParam String amount) throws Exception {
		request.setAttribute("amount", amount);
		return "wallet/charge/charge-step1";
	}

	@RequestMapping("/wenxinpay")
	public String wenxinpay(HttpServletRequest request) throws Exception {
		request.setAttribute("diskType", "no");
		request.setAttribute("amount", "0.00");
		return "wallet/charge/charge-step4";
	}

	@RequestMapping("/postion")
	public String postion(HttpServletRequest request, @RequestParam String diskType) throws Exception {
		request.setAttribute("diskType", diskType);
		return "wallet/bonus/mb-myposition2";
	}

	@RequestMapping("/bankcard")
	public String addBankCard() throws Exception {
		return "wallet/benifit/benifit-step3";
	}

	@RequestMapping("/chargedetail")
	public String chargeDetail() throws Exception {
		return "wallet/benifit/benifit-step2";
	}
}
