package com.wwh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.common.WWHResultData;
import com.wwh.enums.DatabaseType;
import com.wwh.service.IDiskService;
import com.wwh.util.CommonConstant;
import com.wwh.vo.DiskCustromVO;
import com.wwh.vo.ProfitExtendVO;
import com.wwh.vo.UserVO;

/**
 * 首页controller
 * 
 * @ClassName: DiskController
 * @Description: TODO
 * @author: yuzih
 * @date: 2016年10月25日 上午10:12:06
 */
@Controller
@RequestMapping("/disk")
public class DiskController {

	@Autowired
	private IDiskService diskService;

	/**
	 * 
	 * 
	 * @Title: showDiskItemByType
	 * @Description: 获取某个系统的最新收益记录
	 * @param type
	 *            TIYAN,HUIMIN,FUMIN,XINGMIN,根据这个来判断
	 * @return
	 * @return: WWHResultData<List<ProfitCustomVO>>
	 */
	@RequestMapping("/diskitem/{diskType}")
	@ResponseBody
	public WWHResultData<List<ProfitExtendVO>> getDiskItemByType(@PathVariable String diskType) {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		WWHResultData<List<ProfitExtendVO>> wwhResultData = new WWHResultData<List<ProfitExtendVO>>();
		List<ProfitExtendVO> wpdcs = diskService.getItemByDiskType(diskType, 5);
		wwhResultData.setData(wpdcs);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

	/**
	 * 
	 * 
	 * @Title: getDiskAll
	 * @Description: 公开的盘总信息
	 * @return
	 * @return: WWHResultData<DiskCustromVO>
	 */
	@RequestMapping("/diskall")
	@ResponseBody
	public WWHResultData<DiskCustromVO> getDiskAll() {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		WWHResultData<DiskCustromVO> wwhResultData = new WWHResultData<>();
		wwhResultData.setData(diskService.getDiskAll());
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

	/**
	 * 
	 * @Title: getUserDiskAll
	 * @Description: 登录用户的首页展示数据
	 * @param session
	 * @return
	 * @return: WWHResultData<DiskCustromVO>
	 */
	@RequestMapping("/userdiskall")
	@ResponseBody
	public WWHResultData<DiskCustromVO> getUserDiskAll(HttpSession session) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		UserVO userVo = new UserVO();
		userVo.setUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		WWHResultData<DiskCustromVO> wwhResultData = new WWHResultData<>();
		wwhResultData.setData(diskService.getUserDetail(userVo));
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

}
