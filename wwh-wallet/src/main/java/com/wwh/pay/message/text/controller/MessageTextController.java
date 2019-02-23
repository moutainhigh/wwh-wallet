package com.wwh.pay.message.text.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.common.ResultMsg;
import com.wwh.pay.message.text.service.impl.MessageJTDServiceImpl;
import com.wwh.service.IMsgService;
import com.wwh.util.ReturnConstant;

/**
 * 短信发送
 * 
 * @author wwh
 *
 */
@Controller
@RequestMapping("/msg")
public class MessageTextController {
	private static Logger logger = LogManager.getLogger(MessageTextController.class);

	@Autowired
	private MessageJTDServiceImpl messageJTDServiceImpl;

	@Autowired
	private IMsgService msgService;

	/**
	 * 短信发送
	 * 
	 * @param tel
	 * @param msgType
	 *            1注册2登陆3充值4提现
	 * @return
	 */
	@RequestMapping(value = "/sendMsg", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg<Object> sendMsg(HttpServletRequest req, String stateno, String tel, String msgType) {
		stateno = stateno == null || "".equals(stateno) ? "0086" : stateno;
		if (tel == null || "".equals(tel)) {
			return ResultMsg.returnMsg400();
		}
		ResultMsg<Object> rs = new ResultMsg<Object>();
		String msgCode = String.valueOf(Math.floor(Math.random() * 900000 + 100000));
		msgCode = msgCode.substring(0, msgCode.lastIndexOf("."));
		String msgContent = "您的验证码是：" + msgCode + "【唯沃惠】";
		Object userObj = req.getSession().getAttribute("CURRENT_USER");
		long userId = Long.parseLong(tel);
		if (userObj != null) {
			userId = Long.parseLong(userObj.toString());
		}
		int flag = messageJTDServiceImpl.sendMsgState(stateno, tel, msgContent);
		if (flag == 0) {
			rs.setReturnMsg("短信发送成功");
			rs.setReturnCode(ReturnConstant.RETURN_STATUS_SUCCESS);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userId", userId);
			map.put("msgCode", msgCode);
			map.put("msgContent", msgContent);
			map.put("tel", stateno + "-" + tel);
			map.put("msgType", msgType);
			map.put("createdBy", userId);
			map.put("lastUpdatedBy", userId);
			msgService.addMsg(map);
			logger.info("用户：" + userId + "短信发送成功");
		} else {
			rs.setReturnMsg("短信发送失败");
			rs.setReturnCode(ReturnConstant.RETURN_STATUS_FAIL);
		}
		return rs;
	}

	/**
	 * 验证短信
	 * 
	 * @param msgCode
	 * @return
	 */
	@RequestMapping(value = "/verifyMsg", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg<Object> verifyMsg(HttpServletRequest req, String msgCode, String tel) {
		if (msgCode == null || "".equals(msgCode) || tel == null || "".equals(tel)) {
			ResultMsg.returnMsg400();
		}
		ResultMsg<Object> rs = new ResultMsg<Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Object userObj = req.getSession().getAttribute("CURRENT_USER");
		long userId = Long.parseLong(tel);
		if (userObj != null) {
			userId = Long.parseLong(userObj.toString());
		}
		map.put("userId", userId);
		map.put("msgCode", Long.parseLong(msgCode));
		List<Map<String, Object>> list = msgService.queryMsgInfoByCondition(map);
		if (list.size() > 0) {
			rs.setReturnMsg("短信验证成功");
			rs.setReturnCode(ReturnConstant.RETURN_STATUS_SUCCESS);
			msgService.modifyMsg(map);
		} else {
			rs.setReturnMsg("短信验证失败");
			rs.setReturnCode(ReturnConstant.RETURN_STATUS_FAIL);
		}
		return rs;
	}

}
