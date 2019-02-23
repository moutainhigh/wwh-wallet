package com.wwh.pay.weixin.controller;

import java.math.BigDecimal;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wwh.pay.weixin.util.CommonUtil;
import com.wwh.pay.weixin.util.WeiXinPayConfigUtil;
import com.wwh.pay.weixin.util.WeiXinUtils;
import com.wwh.service.IPayService;
import com.wwh.vo.PayDetailVO;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/mweixin")
public class MWeiXinController {

	private static Logger logger = LogManager.getLogger(MWeiXinController.class);

	@Autowired
	private IPayService payService;

	// 给微信授权支付服务 获取openId
	@RequestMapping(value = "/mweixinpay/{payAmountType}/{paySeq}", method = RequestMethod.GET)
	public String userAuth(@PathVariable String payAmountType, @PathVariable String paySeq, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("进入手机版微信支付授权接口,payAmountType={},paySeq={}", payAmountType, paySeq);
		try {
			PayDetailVO payDetailVO = payService.getPayDetailByPayAmountTypeAndPaySeq(payAmountType, paySeq);
			if (null == payDetailVO) {
				logger.info("无此订单");
				return "无此订单";
			}
			// 授权后要跳转的链接
			String backUri = WeiXinPayConfigUtil.getBaseUrl() + "/mweixin/toPay";
			backUri = backUri + "?orderId=" + payDetailVO.getPaySeq() + "&totalFee=" + payDetailVO.getAmount()
					+ "diskType=" + payDetailVO.getPayOrderType();
			// URLEncoder.encode 后可以在backUri 的url里面获取传递的所有参数
			backUri = URLEncoder.encode(backUri);
			// scope 参数视各自需求而定，这里用scope=snsapi_base
			// 不弹出授权页面直接授权目的只获取统一支付接口的openid
			String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" + "appid="
					+ WeiXinPayConfigUtil.getAppid() + "&redirect_uri=" + backUri
					+ "&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
			System.out.println("url:" + url);
			response.sendRedirect(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/toPay")
	public String toPay(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		logger.info("进入手机端微信支付接口");
		try {
			String orderId = request.getParameter("orderId");
			String totalFeeStr = request.getParameter("totalFee");
			String diskType = request.getParameter("diskType");
			Float totalFee = 0.0f;
			if (StringUtils.isNotBlank(totalFeeStr)) {
				totalFee = new Float(totalFeeStr);
			}
			// 网页授权后获取传递的参数
			String userId = request.getParameter("userId");
			String code = request.getParameter("code");
			logger.info("获取所有的参数： orderId={},totalFee={},userId={},code={}", orderId, totalFee, userId, code);

			// 获取统一下单需要的openid
			String openId = "";
			String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WeiXinPayConfigUtil.getAppid()
					+ "&secret=" + "&code=" + code + "&grant_type=authorization_code";
			System.out.println("URL:" + URL);
			JSONObject jsonObject = CommonUtil.httpsRequest(URL, "get", null);
			if (null != jsonObject) {
				openId = jsonObject.getString("openid");
				logger.info("获取openId={}", openId);
			}
			PayDetailVO payDetailVO = payService.getPayDetailByPayAmountTypeAndPaySeq(diskType, orderId);
			if (null == payDetailVO) {
				return "订单为空";
			}
			// 随机数
			// String nonce_str = UUID.randomUUID().toString().replaceAll("-",
			// "");
			// 商品描述
			// String body = payDetailVO.getPaySeq();
			// 商户订单号
			String out_trade_no = payDetailVO.getPaySeq();
			// 订单生成的机器 IP
			// String spbill_create_ip = request.getRemoteAddr();
			// 总金额
			// TODO
			// Integer total_fee = Math.round(totalFee * 100);

			BigDecimal amount = payDetailVO.getAmount();
			// 生成订单
			String orderInfo = WeiXinUtils.createOrderInfo2(out_trade_no, diskType, amount, openId);
			// 调统一下单API
			String code_url = WeiXinUtils.httpOrder(orderInfo);
			return "/jsapi";
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}
}
