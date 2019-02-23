package com.wwh.pay.zhifubao.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 */
public class AlipayConfig {

	// 合作身份者ID，签约账号，
	public static String partner = "2088521107385475";

	// 收款支付宝账号，
	public static String seller_id = "2088521107385475";

	// MD5密钥，安全检验码
	public static String key = "sk0eb62fey2qfa3x40sz17b66feysuie";

	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	// 15t16d1704.iok.la
	public static String notify_url = "http://15t16d1704.iok.la:54321/wwh-wallet/alipay/alipaynotify";

	// 测试环境
	// public static String notify_url =
	// "http://tvip.vwhsc.com/alipay/alipaynotify";

	// 生产环境
	// public static String notify_url =
	// "http://120.24.40.80:8080/wwh-wallet/alipay/alipaynotify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问

	// 我们支付新开窗口 不用跳转
	public static String return_url = "http://tvip.vwhsc.com";
	// 给手机移动端的链接
	public static String mobile_return_url = "tmobile.vwhsc.com";

	// 生产环境
	// public static String return_url =
	// "http://120.24.40.80:8080/wwh-wallet/index";

	// public static String return_url = "";

	// 签名方式
	public static String sign_type = "MD5";

	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "C:\\";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	// 支付类型 ，无需修改
	public static String payment_type = "1";

	// 调用的接口名，无需修改
	public static String service = "create_direct_pay_by_user";

	// 防钓鱼时间戳 若要使用请调用类文件submit中的query_timestamp函数
	public static String anti_phishing_key = "";

	// 客户端的IP地址 非局域网的外网IP地址，如：221.0.0.1
	public static String exter_invoke_ip = "";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

}
