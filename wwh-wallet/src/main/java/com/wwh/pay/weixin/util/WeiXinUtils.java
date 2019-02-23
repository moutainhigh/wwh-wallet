package com.wwh.pay.weixin.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.wwh.pay.weixin.req.UnifiedOrderRequest;
import com.wwh.pay.weixin.resp.UnifiedOrderRespose;
import com.wwh.util.MD5Utils;
import com.wwh.util.MatrixToImageWriter;

public class WeiXinUtils implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 700276234934156783L;

	private static Logger logger = LogManager.getLogger(WeiXinUtils.class);

	/**
	 * 
	 * @param code_url
	 * @param width
	 * @param height
	 * @param format
	 *            图片格式
	 * @param response
	 */
	public static void urlToImages(String code_url, int width, int height, String format,
			HttpServletResponse response) {
		try {
			Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			BitMatrix bitMatrix = new MultiFormatWriter().encode(code_url, BarcodeFormat.QR_CODE, width, height, hints);

			OutputStream out = null;
			out = response.getOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, format, out);

			out.flush();
			out.close();
		} catch (Exception e) {

		}
	}

	/**
	 * 调统一下单API
	 * 
	 * @param orderInfo
	 * @return
	 */
	public static String httpOrder(String orderInfo) {
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			// 加入数据
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			BufferedOutputStream buffOutStr = new BufferedOutputStream(conn.getOutputStream());
			buffOutStr.write(orderInfo.getBytes());
			buffOutStr.flush();
			buffOutStr.close();

			// 获取输入流
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = null;
			StringBuffer sb = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

			XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));// 说明3(见文末)
			// 将请求返回的内容通过xStream转换为UnifiedOrderRespose对象
			xStream.alias("xml", UnifiedOrderRespose.class);
			UnifiedOrderRespose unifiedOrderRespose = (UnifiedOrderRespose) xStream.fromXML(sb.toString());

			logger.info("预支付微信服务端参数返回" + unifiedOrderRespose);
			// 根据微信文档return_code 和result_code都为SUCCESS的时候才会返回code_url
			// <span style="color:#ff0000;"><strong>说明4(见文末)</strong></span>
			if (null != unifiedOrderRespose && "SUCCESS".equals(unifiedOrderRespose.getReturn_code())
					&& "SUCCESS".equals(unifiedOrderRespose.getResult_code())) {
				return unifiedOrderRespose.getCode_url();
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成订单
	 * 
	 * @param orderId
	 * @return
	 */
	public static String createOrderInfo(String orderId, BigDecimal amount) {

		// 保存在我的数据库中 一条单记录

		// 生成订单对象
		UnifiedOrderRequest unifiedOrderRequest = new UnifiedOrderRequest();
		unifiedOrderRequest.setAppid(WeiXinPayConfigUtil.getAppid());// 公众账号ID
		unifiedOrderRequest.setMch_id(WeiXinPayConfigUtil.getMchid());// 商户号
		unifiedOrderRequest.setNonce_str(makeUUID());// 随机字符串 <span
														// style="color:#ff0000;"><strong>说明2(见文末)</strong></span>
		unifiedOrderRequest.setBody("weiwowushangping");// 商品描述
		unifiedOrderRequest.setOut_trade_no(orderId);// 商户订单号
		if (null != amount) {
			unifiedOrderRequest.setTotal_fee("" + (int) (amount.doubleValue() * 100)); // 金额需要扩大100倍:1代表支付时是0.01
		}

		unifiedOrderRequest.setSpbill_create_ip(WeiXinUtils.localIp());// 终端IP
		unifiedOrderRequest.setNotify_url(WeiXinPayConfigUtil.NOTIFY_URL);// 通知地址
		unifiedOrderRequest.setTrade_type("NATIVE");// JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付

		unifiedOrderRequest.setSign(WeiXinUtils.createSign(unifiedOrderRequest));// 签名<span
																					// style="color:#ff0000;"><strong>说明5(见文末，签名方法一并给出)</strong></span>

		// 将订单对象转为xml格式
		XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_"))); // <span
																							// style="color:#ff0000;"><strong>说明3(见文末)</strong></span>

		xStream.alias("xml", UnifiedOrderRequest.class);// 根元素名需要是xml

		return xStream.toXML(unifiedOrderRequest);
	}

	/**
	 * 生成订单
	 * 
	 * @param orderId
	 * @return
	 */
	public static String createOrderInfo(String orderId, String payAmountType, BigDecimal amount) {

		// 保存在我的数据库中 一条单记录

		// 生成订单对象
		UnifiedOrderRequest unifiedOrderRequest = new UnifiedOrderRequest();
		unifiedOrderRequest.setAppid(WeiXinPayConfigUtil.getAppid());// 公众账号ID
		unifiedOrderRequest.setMch_id(WeiXinPayConfigUtil.getMchid());// 商户号
		// !!!!!充值类型 带入随机串，用于返回
		unifiedOrderRequest.setNonce_str(makeUUID() + payAmountType);// 随机字符串
		unifiedOrderRequest.setBody("唯沃惠商城");// 商品描述
		unifiedOrderRequest.setOut_trade_no(orderId);// 商户订单号
		if (null != amount) {
			unifiedOrderRequest.setTotal_fee("" + (int) (amount.doubleValue() * 100)); // 金额需要扩大100倍:1代表支付时是0.01
		}

		unifiedOrderRequest.setSpbill_create_ip(WeiXinUtils.localIp());// 终端IP
		unifiedOrderRequest.setNotify_url(WeiXinPayConfigUtil.NOTIFY_URL);// 通知地址
		unifiedOrderRequest.setTrade_type("NATIVE");// JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付

		unifiedOrderRequest.setSign(WeiXinUtils.createSign(unifiedOrderRequest));// 签名<span
		// style="color:#ff0000;"><strong>说明5(见文末，签名方法一并给出)</strong></span>

		// 将订单对象转为xml格式
		XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_"))); // <span
		// style="color:#ff0000;"><strong>说明3(见文末)</strong></span>

		xStream.alias("xml", UnifiedOrderRequest.class);// 根元素名需要是xml

		return xStream.toXML(unifiedOrderRequest);
	}

	/**
	 * 生成订单
	 * 
	 * @param orderId
	 * @return
	 */
	public static String createOrderInfo2(String orderId, String payAmountType, BigDecimal amount, String openId) {
		// 保存在我的数据库中 一条单记录
		// 生成订单对象
		UnifiedOrderRequest unifiedOrderRequest = new UnifiedOrderRequest();
		unifiedOrderRequest.setAppid(WeiXinPayConfigUtil.getAppid());// 公众账号ID
		unifiedOrderRequest.setMch_id(WeiXinPayConfigUtil.getMchid());// 商户号
		unifiedOrderRequest.setOpenId(openId);
		// !!!!!充值类型 带入随机串，用于返回
		unifiedOrderRequest.setNonce_str(makeUUID() + payAmountType);// 随机字符串
		unifiedOrderRequest.setBody("唯沃惠商城");// 商品描述

		unifiedOrderRequest.setOut_trade_no(orderId);// 商户订单号
		if (null != amount) {
			unifiedOrderRequest.setTotal_fee("" + (int) (amount.doubleValue() * 100)); // 金额需要扩大100倍:1代表支付时是0.01
		}

		unifiedOrderRequest.setSpbill_create_ip(WeiXinUtils.localIp());// 终端IP
		unifiedOrderRequest.setNotify_url(WeiXinPayConfigUtil.NOTIFY_URL);// 通知地址
		unifiedOrderRequest.setTrade_type(WeiXinPayConfigUtil.trade_type);// JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付
		unifiedOrderRequest.setSign(WeiXinUtils.createSign(unifiedOrderRequest));// 签名<span
		// 将订单对象转为xml格式
		XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_"))); // <span
		xStream.alias("xml", UnifiedOrderRequest.class);// 根元素名需要是xml
		return xStream.toXML(unifiedOrderRequest);
	}

	/**
	 * 生成签名
	 * 
	 * @param appid_value
	 * @param mch_id_value
	 * @param productId
	 * @param nonce_str_value
	 * @param trade_type
	 * @param notify_url
	 * @param spbill_create_ip
	 * @param total_fee
	 * @param out_trade_no
	 * @return
	 */
	public static String createSign(UnifiedOrderRequest unifiedOrderRequest) {
		// 根据规则创建可排序的map集合
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", unifiedOrderRequest.getAppid());
		packageParams.put("body", unifiedOrderRequest.getBody());
		packageParams.put("mch_id", unifiedOrderRequest.getMch_id());
		packageParams.put("nonce_str", unifiedOrderRequest.getNonce_str());
		packageParams.put("notify_url", unifiedOrderRequest.getNotify_url());
		packageParams.put("out_trade_no", unifiedOrderRequest.getOut_trade_no());
		packageParams.put("spbill_create_ip", unifiedOrderRequest.getSpbill_create_ip());
		packageParams.put("trade_type", unifiedOrderRequest.getTrade_type());
		packageParams.put("total_fee", unifiedOrderRequest.getTotal_fee());

		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();// 字典序
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			// 为空不参与签名、参数名区分大小写
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		// 第二步拼接key，key设置路径：微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
		sb.append("key=" + WeiXinPayConfigUtil.getKey());
		String sign = MD5Utils.MD5Encode(sb.toString(), "utf-8").toUpperCase();// MD5加密
		return sign;
	}

	@SuppressWarnings("rawtypes")
	public static String localIp() {
		String ip = null;
		Enumeration allNetInterfaces;
		try {
			allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				List<InterfaceAddress> InterfaceAddress = netInterface.getInterfaceAddresses();
				for (InterfaceAddress add : InterfaceAddress) {
					InetAddress Ip = add.getAddress();
					if (Ip != null && Ip instanceof Inet4Address) {
						ip = Ip.getHostAddress();
					}
				}
			}
		} catch (SocketException e) {
			logger.warn("获取本机Ip失败:异常信息:" + e.getMessage());
		}
		return ip;
	}

	/**
	 * 创建UUID
	 * 
	 * @return
	 */
	public static synchronized String makeUUID() {
		StringBuffer s = new StringBuffer(WeiXinUtils.getCurrTime());
		return s.append((new Random().nextInt(900) + 100)).toString();
	}

	/**
	 * 获取当前时间 yyyyMMddHHmmss
	 * 
	 * @return String
	 */
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}

}
