package com.wwh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.common.WWHResultData;
import com.wwh.enums.DatabaseType;
import com.wwh.vo.MemberCareerCustromVO;
import com.wwh.vo.UserVO;

@Controller
@RequestMapping("/membercareer")
public class MemberCareerController {

	@RequestMapping("/membercareerdetail/{userId}")
	@ResponseBody
	public WWHResultData<MemberCareerCustromVO> getMemberCareerDetial(@PathVariable Long userId) {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVO = new UserVO();
		userVO.setUserId(userId);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return null;
	}
}
