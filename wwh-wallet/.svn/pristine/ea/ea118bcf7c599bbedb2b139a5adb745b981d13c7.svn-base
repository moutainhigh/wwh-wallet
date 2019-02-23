package com.wwh.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.common.WWHResultData;
import com.wwh.enums.DatabaseType;
import com.wwh.service.ISaveGoldService;
import com.wwh.util.CommonConstant;
import com.wwh.vo.SaveGoldCustromVO;
import com.wwh.vo.UserVO;

/**
 * 
 * @ClassName: SaveGoldController
 * @Description: 储备金页面controller
 * @author: YuZihao
 * @date: 2016年11月6日 下午1:06:31
 */
@Controller
@RequestMapping("/savegold")
public class SaveGoldController {
	@Autowired
	private ISaveGoldService saveGoldService;

	/**
	 * 
	 * @Title: toSaveGoldHtml
	 * @Description: 跳转到储备金
	 * @return
	 * @return: String
	 */
	@RequestMapping("")
	public String toSaveGoldHtml() {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return "wallet/reserve/reserve";
	}

	/**
	 * 
	 * @Title: getTest
	 * @Description: 储备金页面所有玩意
	 * @param session
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @return: WWHResultData<SaveGoldCustromVO>
	 */
	@RequestMapping("/savegoldcustromlist/{diskType}/{currentPage}/{pageSize}")
	@ResponseBody
	public WWHResultData<SaveGoldCustromVO> getTest(@PathVariable Integer currentPage, @PathVariable String diskType,
			@PathVariable Integer pageSize, HttpSession session) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		WWHResultData<SaveGoldCustromVO> wwhResultData = new WWHResultData<>();
		wwhResultData.setData(saveGoldService.getProfitExtendVO(userVo, diskType, currentPage, pageSize));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

	/**
	 * 
	 * @Title: getTest
	 * @Description: 储备金页面所有玩意
	 * @param session
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @return: WWHResultData<SaveGoldCustromVO>
	 */
	@RequestMapping("/savegoldcustromlist/{currentPage}/{pageSize}")
	@ResponseBody
	public WWHResultData<SaveGoldCustromVO> getTest(@PathVariable Integer currentPage, @PathVariable Integer pageSize,
			HttpSession session) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		WWHResultData<SaveGoldCustromVO> wwhResultData = new WWHResultData<>();
		wwhResultData.setData(saveGoldService.getProfitExtendVO(userVo, currentPage, pageSize));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

}
