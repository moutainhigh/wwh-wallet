package com.wwh.config;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

/**
 * druid数据源状态监控
 * 
 * @author pc
 *
 */
@WebServlet(urlPatterns = "/druid/*", initParams = {

		@WebInitParam(name = "allow", value = "192.168.1.72,127.0.0.1"), // IP白名单(没有配置或者为空，则允许所有访问)

		@WebInitParam(name = "deny", value = "192.168.1.73"), // IP黑名单
																// (存在共同时，deny优先于allow)

		@WebInitParam(name = "loginUsername", value = "Rl094rbeYEx6vW/YqHHU37Pzz3M1t96HpvEJ9T+g8taN015b+fTq0wicGEgC99T7nC0SCmgj+sfGXPifiZLHiQ=="), // 用户名

		@WebInitParam(name = "loginPassword", value = "Bt2qswNr54qISYgjT7rVCaHyYFmLtDWXI2Hp/FcDewZT8513Xss7O5GgAUVI3qfizuxQ8gO8GMsRBENaXrMprQ=="), // 密码

		@WebInitParam(name = "resetEnable", value = "false")// 禁用HTML页面上的“Reset
															// All”功能
})
public class DruidStatViewServlet extends StatViewServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1871290062495247432L;

}
