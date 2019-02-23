package com.wwh.controller;

import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.common.ResultMsg;
import com.wwh.enums.DatabaseType;
import com.wwh.service.IExternalService;
import com.wwh.util.DESUtils;
import com.wwh.util.ReturnConstant;
import com.wwh.util.StringUtils;
import com.wwh.vo.ExternalVO;
import com.wwh.vo.UserVO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * @ClassName: ExternalController
 * @Description: 对外接口调用
 * @author: ranle
 * @date: 2016年11月20日 下午3:21:40
 */
@RestController
public class ExternalController {

	private static Logger logger = LogManager.getLogger(ExternalController.class);

	@Autowired
	private IExternalService externalService;

	/**
	 * 
	 * @Title: relation
	 * @Description: 注册成功后调用接口（记录邀请和被邀请关系，以及计算邀请和被邀请者的积分收益）
	 * @param userVO
	 * @return
	 * @throws Exception
	 * @return: ResultMsg<Object>
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@RequestMapping(value = "/relation", method = RequestMethod.POST)
	public ResultMsg<Object> relation(HttpServletRequest request) throws Exception {
		logger.info("relation controller start");
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		JSONObject dataJson = JSONObject.fromObject(request.getParameter("data"));
		Iterator<String> it = dataJson.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = URLDecoder.decode(dataJson.getString(key));
			dataJson.put(key, value);
		}
		logger.info("relation JSONObject param[data]:" + dataJson);
		if (dataJson.isNullObject()) {
			return ResultMsg.returnMsg400();
		}
		ExternalVO externalVO = (ExternalVO) JSONObject.toBean(dataJson, ExternalVO.class);
		logger.info("relation controller start param[externalVO]:" + externalVO.toString());
		String memberId = URLDecoder.decode(request.getParameter("memberId"));
		logger.info("memberId:" + memberId);
		externalVO.setMemberId(memberId);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return externalService.relation(externalVO);
	}

	/**
	 * 
	 * @Title: relation
	 * @Description: 注册
	 * @param userVO
	 * @return
	 * @throws Exception
	 * @return: ResultMsg<Object>
	 */
	@RequestMapping(value = "/registerMember", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg<Object> registerMember(@RequestBody ExternalVO externalVO) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		logger.info("registerMember controller start");
		String mobilePhone = externalVO.getMobilePhone();
		String password = externalVO.getPassword();
		if (StringUtils.isEmpty(mobilePhone) || StringUtils.isEmpty(password)) {
			return ResultMsg.returnMsg400();
		}
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return externalService.registerMember(externalVO);
	}

	/**
	 * 
	 * @Title: giveScore
	 * @Description: 用户注册实名认证后给用户和用户推荐人赠送积分
	 * @param request
	 * @return
	 * @throws Exception
	 * @return: ResultMsg<Object>
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@RequestMapping(value = "/givescore", method = RequestMethod.POST)
	public ResultMsg<Object> giveScore(HttpServletRequest request) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		logger.info("giveScore controller start");
		JSONObject dataJson = JSONObject.fromObject(request.getParameter("data"));
		Iterator<String> it = dataJson.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = URLDecoder.decode(dataJson.getString(key));
			dataJson.put(key, value);
		}
		logger.info("giveScore JSONObject param[data]:" + dataJson);
		if (dataJson.isNullObject()) {
			return ResultMsg.returnMsg400();
		}
		ExternalVO externalVO = (ExternalVO) JSONObject.toBean(dataJson, ExternalVO.class);
		String memberId = URLDecoder.decode(request.getParameter("memberId"));
		logger.info("memberId:" + memberId);
		externalVO.setMemberId(memberId);
		logger.info("giveScore controller start param[externalVO]:" + externalVO.toString());
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return externalService.giveScore(externalVO);
	}

	/**
	 * 
	 * @Title: getRemainScore
	 * @Description: 获取用户剩余积分
	 * @param orderVO
	 * @return
	 * @throws Exception
	 * @return: ResultMsg<Object>
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/getscore", method = RequestMethod.POST)
	public ResultMsg<Object> getRemainScore(HttpServletRequest request) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		String memberId = URLDecoder.decode(request.getParameter("memberId"));
		logger.info("getRemainScore controller start param[memberId]:" + memberId);
		if (StringUtils.isEmpty(memberId)) {
			return ResultMsg.returnMsg400();
		}
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return externalService.getRemainScore(memberId);
	}

	/**
	 * 
	 * @Title: returnScore
	 * @Description: 返还用户积分
	 * @param userId
	 * @param score
	 * @return
	 * @throws Exception
	 * @return: ResultMsg<Object>
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/returnscore", method = RequestMethod.POST)
	public ResultMsg<Object> returnScore(HttpServletRequest request) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		logger.info("returnScore controller start");
		JSONObject data = JSONObject.fromObject(request.getParameter("data"));
		logger.info("returnScore JSONObject param[data]:" + data);
		if (data.isNullObject()) {
			return ResultMsg.returnMsg400();
		}
		ExternalVO externalVO = (ExternalVO) JSONObject.toBean(data, ExternalVO.class);
		String memberId = URLDecoder.decode(request.getParameter("memberId"));
		logger.info("memberId:" + memberId);
		externalVO.setMemberId(memberId);
		logger.info("returnScore controller start param[externalVO]:" + externalVO.toString());
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return externalService.returnScore(externalVO);
	}

	/**
	 * 
	 * @Title: subScore
	 * @Description: 扣除积分
	 * @param userId
	 * @param score
	 * @return
	 * @throws Exception
	 * @return: ResultMsg<Object>
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@RequestMapping(value = "/subscore", method = RequestMethod.POST)
	public ResultMsg<Object> subScore(HttpServletRequest request) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		logger.info("subScore controller start");
		JSONObject dataJson = JSONObject.fromObject(request.getParameter("data"));
		Iterator<String> it = dataJson.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = URLDecoder.decode(dataJson.getString(key));
			dataJson.put(key, value);
		}
		logger.info("subScore JSONObject param[data]:" + dataJson);
		if (dataJson.isNullObject()) {
			return ResultMsg.returnMsg400();
		}
		JSONArray array = JSONArray.fromObject(dataJson.get("list"));
		List<ExternalVO> exList = (List<ExternalVO>) JSONArray.toCollection(array, ExternalVO.class);
		if (null == exList || exList.isEmpty()) {
			return ResultMsg.returnMsg400();
		}
		String memberId = URLDecoder.decode(request.getParameter("memberId"));
		logger.info("param[memberId]" + memberId);
		logger.info("subScore controller start param[exList]:" + exList.toString());
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return externalService.subScore(exList, memberId);
	}

	/**
	 * 
	 * @Title: bonus
	 * @Description: 商家交易的1%红利返还给推荐人
	 * @param orderVO
	 * @return
	 * @throws Exception
	 * @return: ResultMsg<Object>
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@RequestMapping(value = "/bonus", method = RequestMethod.POST)
	public ResultMsg<Object> bonus(HttpServletRequest request) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		logger.info("bonus controller start");
		JSONObject dataJson = JSONObject.fromObject(request.getParameter("data"));
		Iterator<String> it = dataJson.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = URLDecoder.decode(dataJson.getString(key));
			dataJson.put(key, value);
		}
		logger.info("bonus JSONObject param[data]:" + dataJson);
		if (dataJson.isNullObject()) {
			return ResultMsg.returnMsg400();
		}
		JSONArray array = JSONArray.fromObject(dataJson.get("list"));
		List<ExternalVO> exList = (List<ExternalVO>) JSONArray.toCollection(array, ExternalVO.class);
		if (null == exList || exList.isEmpty()) {
			return ResultMsg.returnMsg400();
		}
		String memberId = URLDecoder.decode(request.getParameter("memberId"));
		logger.info("param[memberId]" + memberId);
		logger.info("bonus controller start param[exList]:" + exList.toString());
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return externalService.bonus(exList, memberId);
	}

	/**
	 * 
	 * @Title: recordBusiness
	 * @Description: 记录商家和用户关系
	 * @param request
	 * @return
	 * @throws Exception
	 * @return: ResultMsg<Object>
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@RequestMapping(value = "/recordbusiness", method = RequestMethod.POST)
	public ResultMsg<Object> recordBusiness(HttpServletRequest request) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		logger.info("recordBusiness controller start");
		JSONObject dataJson = JSONObject.fromObject(request.getParameter("data"));
		Iterator<String> it = dataJson.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = URLDecoder.decode(dataJson.getString(key));
			dataJson.put(key, value);
		}
		logger.info("recordBusiness JSONObject param[data]:" + dataJson);
		if (dataJson.isNullObject()) {
			return ResultMsg.returnMsg400();
		}
		ExternalVO externalVO = (ExternalVO) JSONObject.toBean(dataJson, ExternalVO.class);
		logger.info("recordBusiness controller start param[externalVO]:" + externalVO.toString());

		String memberId = URLDecoder.decode(request.getParameter("memberId"));
		logger.info("param[memberId]:" + memberId);
		externalVO.setMemberId(memberId);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return externalService.recordBusiness(externalVO);
	}

	/**
	 * 
	 * @Title: returnAmount
	 * @Description: 用户消费推荐用户会获得相应的金币分润
	 * @param request
	 * @return
	 * @throws Exception
	 * @return: ResultMsg<Object>
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@RequestMapping(value = "/returnamount", method = RequestMethod.POST)
	public ResultMsg<Object> returnAmount(HttpServletRequest request) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		logger.info("returnAmount controller start");
		JSONObject dataJson = JSONObject.fromObject(request.getParameter("data"));
		Iterator<String> it = dataJson.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = URLDecoder.decode(dataJson.getString(key));
			dataJson.put(key, value);
		}
		logger.info("returnAmount JSONObject param[data]:" + dataJson);
		if (dataJson.isNullObject()) {
			return ResultMsg.returnMsg400();
		}
		JSONArray array = JSONArray.fromObject(dataJson.get("list"));
		List<ExternalVO> exList = (List<ExternalVO>) JSONArray.toCollection(array, ExternalVO.class);
		if (null == exList || exList.isEmpty()) {
			return ResultMsg.returnMsg400();
		}
		String memberId = URLDecoder.decode(request.getParameter("memberId"));
		logger.info("param[memberId]:" + memberId);
		logger.info("returnAmount controller start param[exList]:" + exList.toString());
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return externalService.returnAmount(exList, memberId);
	}

	@RequestMapping(value = "/modifyBasicUserInfo", method = RequestMethod.POST)
	public ResultMsg<Object> modifyBasicUserInfo(HttpServletRequest request) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		logger.info("modifyBasicUserInfo controller start");
		JSONObject dataJson = JSONObject.fromObject(request.getParameter("data"));
		Iterator<String> it = dataJson.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = DESUtils.getDecryptString(URLDecoder.decode(dataJson.getString(key)));
			dataJson.put(key, value);
		}
		logger.info("relation JSONObject param[data]:" + dataJson);
		if (dataJson.isNullObject()) {
			return ResultMsg.returnMsg400();
		}
		UserVO vo = (UserVO) JSONObject.toBean(dataJson, UserVO.class);
		int i = externalService.modifyMobilePhoneByUserId(vo);
		ResultMsg<Object> rs = new ResultMsg<Object>();
		if (i > 0) {
			rs.setReturnCode(ReturnConstant.RETURN_STATUS_SUCCESS);
			rs.setReturnMsg("信息修改成功");
		} else {
			rs.setReturnCode(ReturnConstant.RETURN_STATUS_FAIL);
			rs.setReturnMsg("信息修改失败");
		}
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return null;
	}
}
