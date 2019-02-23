package com.wwh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.common.PagedResult;
import com.wwh.common.ResultMsg;
import com.wwh.enums.DatabaseType;
import com.wwh.service.IApplyWithdrawService;
import com.wwh.service.IBankService;
import com.wwh.vo.ApplyWithdrawVO;
import com.wwh.vo.BankVO;
import com.wwh.vo.SaveGoleWithdrawlVO;
import com.wwh.vo.WithdrawDetilVO;
import com.wwh.vo.WithdrawalVO;

@Controller
@RequestMapping("/withraw")
public class ApplyWithrawController {

	@Autowired
	private IApplyWithdrawService applyWithdrawService;

	@Autowired
	private IBankService bankService;

	@ResponseBody
	@RequestMapping("/getwithrawinfo")
	public ApplyWithdrawVO getApplyWithrawInfo(HttpServletRequest req) {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		long userId = Long.parseLong(req.getSession().getAttribute("CURRENT_USER").toString());
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return applyWithdrawService.getApplyWithrawInfo(userId);
	}

	@ResponseBody
	@RequestMapping("/insertwithrawinfo")
	public Integer insertApplyWithdrawDetilInfo(@RequestBody WithdrawalVO withdrawVo, HttpServletRequest req) {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		long userId = Long.parseLong(req.getSession().getAttribute("CURRENT_USER").toString());
		withdrawVo.setUserId(userId);
		withdrawVo.setCreatedBy(userId);
		withdrawVo.setLastUpdatedBy(userId);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return applyWithdrawService.insertApplyWithdrawDetilInfo(withdrawVo);
	}
	@ResponseBody
	@RequestMapping("/checkHaveRuninfo")
	public ResultMsg<Object> ctrlHaveRuninfo(HttpServletRequest req) {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		Long userId = Long.parseLong(req.getSession().getAttribute("CURRENT_USER").toString());
		ResultMsg<Object> resultMsg = applyWithdrawService.checkHaveRuninfo(userId);
		return resultMsg;
	}
	@ResponseBody
	@RequestMapping("/getwithrawdetail/{currentPage}/{pageSize}")
	public PagedResult<WithdrawDetilVO> getWithdrawDetil(@PathVariable Integer currentPage,
			@PathVariable Integer pageSize, HttpServletRequest req) {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		long userId = Long.parseLong(req.getSession().getAttribute("CURRENT_USER").toString());
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return applyWithdrawService.getWithdrawDetilInfo(userId, currentPage, pageSize);

	}

	@RequestMapping(value = "/towithdrawlhtml", method = { RequestMethod.POST, RequestMethod.GET })
	public String toWithdrawlHtml(SaveGoleWithdrawlVO saveGoldWithdrawl, Model model) {
		model.addAttribute("diskType", saveGoldWithdrawl.getDiskType());
		model.addAttribute("amount", saveGoldWithdrawl.getAmount());
		return "wallet/benifit/benifit-step1";
	}

	@ResponseBody
	@RequestMapping("/getbank")
	public List<BankVO> getBank() {
		return bankService.selectBankInfo();
	}

	@ResponseBody
	@RequestMapping("/validWithdrawalAmount")
	public ResultMsg<Object> validWithdrawalAmount(@RequestBody WithdrawalVO withdrawVo, HttpServletRequest req) {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		long userId = Long.parseLong(req.getSession().getAttribute("CURRENT_USER").toString());
		withdrawVo.setUserId(userId);
		ResultMsg<Object> resultMsg = applyWithdrawService.validWithdrawalAmount(withdrawVo);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return resultMsg;
	}

}
