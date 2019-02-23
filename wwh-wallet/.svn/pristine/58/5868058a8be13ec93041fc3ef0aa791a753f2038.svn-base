package com.wwh.pay.unionpay.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.wwh.pay.unionpay.sdk.SDKConfig;

/**
 * 重要：联调接入的时候请务必仔细阅读注释！！！
 * 
 * 功能：从应用的classpath下加载acp_sdk.properties属性文件并将该属性文件中的键值对赋值到SDKConfig类中 <br>
 * 
 */
@WebServlet(urlPatterns="/autoLoadServlet",loadOnStartup=0) 
public class AutoLoadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 8442487779715937475L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		SDKConfig.getConfig().loadPropertiesFromSrc();
		
		super.init();
	}
}
