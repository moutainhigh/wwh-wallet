package com.wwh.pay.malipay.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.controller.BaseController;
import com.wwh.enums.PayStatusEnum;
import com.wwh.pay.malipay.config.AlipayConfig;
import com.wwh.pay.malipay.util.AlipayNotify;
import com.wwh.pay.malipay.util.AlipaySubmit;
import com.wwh.service.IPayService;
import com.wwh.vo.PayDetailVO;

@Controller
@RequestMapping("/malipay")
public class MobileAlipayController extends BaseController {
	private static Logger logger = LogManager.getLogger(MobileAlipayController.class);

	@Autowired
	private IPayService payService;

	@ResponseBody
	@RequestMapping("/malipaypay")
	public Object malipay(String orderId, String orderName, String totalfee, String showUrl, String payAmountType)
			throws Exception {
		logger.info("进入手机支付支付宝方法：orderId={},orderName={},totalfee={},payAmountType={}", orderId, orderName, totalfee,
				payAmountType);

		// 根据支付的盘类型和订单id查询相应盘表的订单信息 验证用户待支付订单是否存在
		PayDetailVO payDetailVO = payService.getPayDetailByPayAmountTypeAndPaySeq(payAmountType, orderId);
		if (payDetailVO == null || PayStatusEnum.PAYSUCCESSED.name().equals(payDetailVO.getPayStatus())) {
			logger.info("无此订单或该订单已支付");
			return null;
		}
		// 商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = new String(payDetailVO.getPaySeq().getBytes("ISO-8859-1"), "UTF-8");

		// 订单名称，必填
		String subject = new String(orderName.getBytes("ISO-8859-1"), "UTF-8");

		// 付款金额，必填
		String total_fee = new String(payDetailVO.getAmount().toString().getBytes("ISO-8859-1"), "UTF-8");

		// 收银台页面上，商品展示的超链接，必填
		String show_url = new String(showUrl.getBytes("ISO-8859-1"), "UTF-8");

		// 商品描述，可空
		String body = new String(payAmountType.getBytes("ISO-8859-1"), "UTF-8");

		//////////////////////////////////////////////////////////////////////////////////

		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", AlipayConfig.service);
		sParaTemp.put("partner", AlipayConfig.partner);
		sParaTemp.put("seller_id", AlipayConfig.seller_id);
		sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", AlipayConfig.payment_type);
		sParaTemp.put("notify_url", AlipayConfig.notify_url);
		sParaTemp.put("return_url", AlipayConfig.return_url);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", total_fee);
		sParaTemp.put("show_url", show_url);
		sParaTemp.put("app_pay", "Y");// 启用此参数可唤起钱包APP支付。
		sParaTemp.put("body", body);
		sParaTemp.put("diskType", body);
		// 其他业务参数根据在线开发文档，添加参数.文档地址:https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.2Z6TSk&treeId=60&articleId=103693&docType=1
		// 如sParaTemp.put("参数名","参数值");

		// 建立请求
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "get", "确认");
		logger.info("支付宝支付,返回的订单信息sHtmlText={}", sHtmlText);
		// out.println(sHtmlText);
		return sHtmlText.toString();
	}

	@ResponseBody
	@RequestMapping("/malipaynotify")
	public void mAlipayNotify(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception {
		// 获取支付宝GET过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		// 商户订单号
		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
		// 支付宝交易号
		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
		// 交易状态
		String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
		// 盘类型
		String diskType = new String(request.getParameter("diskType").getBytes("ISO-8859-1"), "UTF-8");
		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		// 计算得出通知验证结果
		logger.info("支付宝返回的参数信息,out_trade_no={},trade_no={},trade_status={},diskType", out_trade_no, trade_status,
				trade_no, diskType);
		PayDetailVO payDetailVO = payService.getPayDetailByPayAmountTypeAndPaySeq(diskType, out_trade_no);
		if (payDetailVO != null && null != payDetailVO.getPayStatus()
				&& !PayStatusEnum.PAYSUCCESSED.name().equals(payDetailVO.getPayStatus())) {
			if (AlipayNotify.verify(params)) {
				if (trade_status.equals("TRADE_SUCCESS")) {// 交易成功
					// 更新支付状态
					PayDetailVO payDetailvo = payService.updatePrePaySuccess(diskType, out_trade_no, trade_no);
					if (null == payDetailvo) {
						logger.info("支付宝支付，修改订单状态失败 ，diskType" + diskType + ",paySeq" + out_trade_no);
					} else {
						payService.updatePrePaySuccessAndDoNext(diskType, payDetailVO.getIdCard(), payDetailVO);
						logger.info(" 支付宝逻辑执行完毕,锅甩出去了...............");
					}
					response.getWriter().write("success");
				}
			} else {
				if (PayStatusEnum.PAYPREED.name().equals(payDetailVO.getPayStatus())) {
					logger.info("订单未支付成功！类型  payAmountType:" + diskType + " 订单号paySeq:" + out_trade_no);
				} else {
					logger.info("无此订单号！类型  payAmountType:" + diskType + " 订单号paySeq:" + out_trade_no);
				}
				response.getWriter().write("fail");
			}
		}
	}
}
