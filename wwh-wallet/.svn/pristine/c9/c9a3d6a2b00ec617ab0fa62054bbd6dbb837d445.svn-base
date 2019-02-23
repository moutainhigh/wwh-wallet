package com.wwh.pay.message.text.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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

@Controller
@RequestMapping("/ttmsg")
public class MessageController {
	private static Logger logger = LogManager.getLogger(MessageController.class);
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
	public ResultMsg<Object> sendMsg(HttpServletRequest req, String code, String tel, String msgType) {
		logger.info("进入发送短信方法:code={},tel={},msgType={}", code, tel, msgType);
		ResultMsg<Object> resultMsg = new ResultMsg<Object>();
		// 连接超时及读取超时设置
		System.setProperty("sun.net.client.defaultConnectTimeout", "30000"); // 连接超时：30秒
		System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时：30秒

		// 新建一个StringBuffer链接
		StringBuffer buffer = new StringBuffer();
		String encode = getString("encode");
		String username = getString("user_name"); // 用户名
		String password_md5 = getString("pass_word"); //
		String apikey = getString("apikey"); // apikey秘钥（请登录 http://m.5c.com.cn
		StringBuilder mobile = new StringBuilder();
		mobile.append(code);
		mobile.append(tel);
		Object userObj = req.getSession().getAttribute("CURRENT_USER");
		long userId = Long.parseLong(tel);
		if (userObj != null) {
			userId = Long.parseLong(userObj.toString());
		}
		// 生成新的验证码
		String msgCode = String.valueOf(Math.floor(Math.random() * 900000 + 100000));
		msgCode = msgCode.substring(0, msgCode.lastIndexOf("."));
		// 查询前一条验证码 如果前一条验证码还是激活状态的话就发送同一条验证码
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("userId", userId);
		map2.put("tel", code + "-" + tel);
		double minite = 10;
		List<Map<String, Object>> mapReuslt = msgService.getMsgInfo(map2);
		if (null != mapReuslt && mapReuslt.size() > 0) {
			Map<String, Object> result = mapReuslt.get(0);
			minite = Double.parseDouble(result.get("minute").toString());
			if (minite <= 5) {
				msgCode = result.get("msgCode").toString();
			} else {
				map2.put("msgCode", Long.parseLong(result.get("msgCode").toString()));
				msgService.modifyMsg(map2);
			}
		}
		// 要发送的短信内容，特别注意：签名必须设置，网页验证码应用需要加添加【图形识别码】。
		String content = "您好，您的验证码是：" + msgCode + "【唯沃惠】";

		try {
			String contentUrlEncode = URLEncoder.encode(content, encode); // 对短信内容做Urlencode编码操作。注意：如
			// 把发送链接存入buffer中，如连接超时，可能是您服务器不支持域名解析，请将下面连接中的：【m.5c.com.cn】修改为IP：【115.28.23.78】
			buffer.append("http://m.5c.com.cn/api/send/index.php?username=" + username + "&password_md5=" + password_md5
					+ "&mobile=" + mobile + "&apikey=" + apikey + "&content=" + contentUrlEncode + "&encode=" + encode);
			// System.out.println(buffer); //调试功能，输入完整的请求URL地址
			// 把buffer链接存入新建的URL中
			URL url = new URL(buffer.toString());
			// 打开URL链接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// 使用POST方式发送
			connection.setRequestMethod("POST");
			// 使用长链接方式
			connection.setRequestProperty("Connection", "Keep-Alive");
			// 发送短信内容
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			// 获取返回值
			String result = reader.readLine();
			// 输出result内容，查看返回值，成功为success，错误为error，详见该文档起始注释
			if (result.indexOf("success") > -1 && minite > 5) {
				resultMsg.setReturnMsg("短信发送成功");
				resultMsg.setReturnCode(ReturnConstant.RETURN_STATUS_SUCCESS);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("userId", userId);
				map.put("msgCode", msgCode);
				map.put("msgContent", content);
				map.put("tel", code + "-" + tel);
				map.put("msgType", msgType);
				map.put("createdBy", userId);
				map.put("lastUpdatedBy", userId);
				map.put("result", result);
				msgService.addMsg(map);
				logger.info("用户：" + userId + "短信发送成功");
			} else {
				resultMsg.setReturnMsg("短信发送失败");
				resultMsg.setReturnCode(ReturnConstant.RETURN_STATUS_FAIL);
			}
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMsg;
	}

	/**
	 * 验证短信
	 * 
	 * @param msgCode
	 * @return
	 */
	@RequestMapping(value = "/verifyMsg", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg<Object> verifyMsg(HttpServletRequest req, String code, String msgCode, String tel) {
		ResultMsg<Object> rs = new ResultMsg<Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Object userObj = req.getSession().getAttribute("CURRENT_USER");
		long userId = Long.parseLong(tel);
		if (userObj != null) {
			userId = Long.parseLong(userObj.toString());
		}
		map.put("userId", userId);
		map.put("tel", code + "-" + tel);
		// 根据用户id查询用户最后一条发送成功的短信
		List<Map<String, Object>> list = msgService.getMsgInfo(map);
		if (null != list && list.size() > 0) {
			Map<String, Object> mapObject = list.get(0);
			String msgCode2 = mapObject.get("msgCode").toString();
			if (msgCode.equals(msgCode2)) {
				rs.setReturnMsg("短信验证成功");
				rs.setReturnCode(ReturnConstant.RETURN_STATUS_SUCCESS);
				// msgService.modifyMsg(map);
			} else {
				rs.setReturnMsg("短信验证失败");
				rs.setReturnCode(ReturnConstant.RETURN_STATUS_FAIL);
			}
		}
		return rs;
	}

	// 读取配置文件的路径
	public String getPath() throws UnsupportedEncodingException {
		String configPath = MessageJTDServiceImpl.class.getClassLoader().getResource("").getPath();
		return java.net.URLDecoder.decode(configPath, "utf-8");
	}

	// 根据key获取配置文件重value值
	public String getString(String key) {
		InputStream in = null;
		try {
			Properties props = new Properties();
			in = new BufferedInputStream(new FileInputStream((getPath() + "message.properties")));
			props.load(in);
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
					in = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}

/*
 * username 用户名 password_md5 密码 mobile 手机号 apikey apikey秘钥 content 短信内容
 * startTime UNIX时间戳，不写为立刻发送，http://tool.chinaz.com/Tools/unixtime.aspx
 * （UNIX时间戳网站）
 * 
 * success:msgid 提交成功。 error:msgid 提交失败 error:Missing username 用户名为空
 * error:Missing password 密码为空 error:Missing apikey APIKEY为空 error:Missing
 * recipient 手机号码为空 error:Missing message content 短信内容为空 error:Account is
 * blocked 帐号被禁用 error:Unrecognized encoding 编码未能识别 error:APIKEY or password_md5
 * error APIKEY或密码错误 error:Unauthorized IP address 未授权 IP 地址 error:Account
 * balance is insufficient 余额不足
 */

/**
 * 乱码问题处理： 1、GBK编码提交的 首先urlencode短信内容（content），然后在API请求时，带入encode=gbk
 * 
 * 2、UTF-8编码的
 * 
 * 将content 做urlencode编码后，带入encode=utf8或utf-8
 * http://m.5c.com.cn/api/send/index.php?username=XXX&password_md5=XXX&apikey=XXX&mobile=XXX&content=%E4%BD%A0%E5%A5%BD%E6%89%8D%E6%94%B6%E7%9B%8A%E9%9F%A6&encode=utf8
 * 
 * 示例
 */
