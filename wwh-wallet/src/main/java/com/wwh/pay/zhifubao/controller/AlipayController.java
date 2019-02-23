package com.wwh.pay.zhifubao.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.enums.PayStatusEnum;
import com.wwh.pay.zhifubao.config.AlipayConfig;
import com.wwh.pay.zhifubao.util.AlipayNotify;
import com.wwh.pay.zhifubao.util.AlipaySubmit;
import com.wwh.service.IPayService;
import com.wwh.vo.PayDetailVO;

@Controller
@RequestMapping("/alipay")
public class AlipayController {
	private static Logger logger = LogManager.getLogger(AlipayController.class);

	@Autowired
	private IPayService payService;

	/**
	 * 封装支付所需订单参数
	 * 
	 * @Title: alipay
	 * @Description: TODO
	 * @param orderId
	 * @param orderName
	 * @param totalfee
	 * @param body
	 * @return
	 * @return: Object
	 * @throws IOException
	 * @throws DocumentException
	 * @throws MalformedURLException
	 */
	@ResponseBody
	@RequestMapping("/alipaypay")
	public Object alipay(String orderId, String orderName, String totalfee, String payAmountType, String requestType)
			throws MalformedURLException, Exception, DocumentException, IOException {
		logger.info("支付宝支付方法：orderId={},orderName={},totalfee={},payAmountType={},requestType={}", orderId, orderName,
				totalfee, payAmountType, requestType);
		// 根据支付的盘类型和订单id查询相应盘表的订单信息
		PayDetailVO payDetailVO = payService.getPayDetailByPayAmountTypeAndPaySeq(payAmountType, orderId);
		if (payDetailVO == null || PayStatusEnum.PAYSUCCESSED.name().equals(payDetailVO.getPayStatus())) {
			logger.info("无此订单或该订单已支付");
			return null;
		}

		String orderName1 = new String(orderName.getBytes("ISO-8859-1"), "UTF-8");
		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		// String timeStamp = AlipaySubmit.query_timestamp();
		sParaTemp.put("service", AlipayConfig.service);
		sParaTemp.put("partner", AlipayConfig.partner);
		sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("sign_type", "MD5");
		sParaTemp.put("notify_url", AlipayConfig.notify_url);
		if ("mobile".equals(requestType)) {
			sParaTemp.put("return_url", AlipayConfig.mobile_return_url);
		} else {
			sParaTemp.put("return_url", AlipayConfig.return_url);
		}
		sParaTemp.put("payment_type", "1");
		sParaTemp.put("seller_id", AlipayConfig.seller_id);
		sParaTemp.put("out_trade_no", orderId); // 订单号
		sParaTemp.put("subject", orderName1); // 订单名称
		sParaTemp.put("total_fee", payDetailVO.getAmount() + ""); // 订单费用
		sParaTemp.put("body", payAmountType); // body本身应该存储商品描述 此处保存的是盘类型
		// sParaTemp.put("anti_phishing_key", timeStamp);
		sParaTemp.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "get", "确认");
		logger.info("支付宝支付,返回的订单信息sHtmlText={}", sHtmlText);
		return sHtmlText.toString();
	}

	@ResponseBody
	@RequestMapping("/alipaynotify")
	public void alipayNotify(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception {
		logger.info("支付宝回调方法：alipay_notify");
		// 获取支付宝POST过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = iter.next();
			String[] values = requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");0
			params.put(name, valueStr);
		}
		String out_trade_no = request.getParameter("out_trade_no"); // 我们平台订单号
		String trade_status = request.getParameter("trade_status"); // 支付包返回的交易状态
		String body = request.getParameter("body"); // body 中存放的是盘类型
		String trade_no = request.getParameter("trade_no"); // 支付宝订单号

		logger.info("支付宝返回的参数信息,out_trade_no={},trade_no={},trade_status={}", out_trade_no, body, trade_status,
				trade_no);
		// 防止多次回调 如果
		PayDetailVO payDetailVO = payService.getPayDetailByPayAmountTypeAndPaySeq(body, out_trade_no);
		if (payDetailVO != null && null != payDetailVO.getPayStatus()
				&& !PayStatusEnum.PAYSUCCESSED.name().equals(payDetailVO.getPayStatus())) {

			if (AlipayNotify.verify(params)) {
				if (trade_status.equals("TRADE_SUCCESS")) {// 交易成功
					String payAmountType = request.getParameter("body");
					// 更新支付状态
					PayDetailVO payDetailvo = payService.updatePrePaySuccess(payAmountType, out_trade_no, trade_no);

					if (null == payDetailvo) {
						logger.info(
								"微信支付成功后， 本地服务修改数据 为成功状态失败 ，payAmountType" + payAmountType + ",paySeq" + out_trade_no);
					} else {
						payService.updatePrePaySuccessAndDoNext(payAmountType, payDetailVO.getIdCard(), payDetailVO);
						logger.info(" 支付宝逻辑执行完毕,锅甩出去了...............");
					}
					response.getWriter().write("success");

				}
			} else {
				if (PayStatusEnum.PAYPREED.name().equals(payDetailVO.getPayStatus())) {
					logger.info("订单未支付成功！类型  payAmountType:" + body + " 订单号paySeq:" + out_trade_no);
				} else {
					logger.info("无此订单号！类型  payAmountType:" + body + " 订单号paySeq:" + out_trade_no);
				}
				response.getWriter().write("fail");
			}
		}
	}

	/*
	 * public static void main(String[] args) throws MalformedURLException,
	 * DocumentException, IOException { String orderId="123468"; String
	 * orderName="订单一"; String totalfee="0.01"; String
	 * payAmountType="317246463482174"; Object str =
	 * alipay(orderId,orderName,totalfee,payAmountType); }
	 */
}
