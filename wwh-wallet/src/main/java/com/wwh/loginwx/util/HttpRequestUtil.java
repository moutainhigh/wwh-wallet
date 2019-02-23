package com.wwh.loginwx.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.sf.json.JSONObject;

public class HttpRequestUtil {
	private static Logger logger = LogManager.getLogger(HttpRequestUtil.class);
	private static String GET_METHOD = "GET";

	/**
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式
	 * @param str
	 *            提交的数据
	 * @return
	 */
	public static JSONObject httpRequestJSONObject(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		try {
			// 创建SSLContext对象
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式
			conn.setRequestMethod(requestMethod);

			if (GET_METHOD.equalsIgnoreCase(requestMethod)) {
				conn.connect();
			}

			if (null != outputStr) {
				OutputStream outputStream = conn.getOutputStream();
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (Exception e) {
			// e.printStackTrace();
			logger.info("请求异常: " + e.getMessage());
		}
		return jsonObject;
	}
	/**
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式
	 * @param str
	 *            提交的数据
	 * @return
	 */
	public static JSONObject httpUploadJSONObject(String requestUrl, String requestMethod, File file) {
		JSONObject jsonObject = null;
		try {
			// 创建SSLContext对象
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.setSSLSocketFactory(ssf);

			con.setDoOutput(true);
			con.setDoInput(true);
			con.setUseCaches(false);
			// 设置请求方式
			con.setRequestMethod(requestMethod);
			if (GET_METHOD.equalsIgnoreCase(requestMethod)) {
				con.connect();
			}
	        
	        // 设置请求头信息  
	        con.setRequestProperty("Connection", "Keep-Alive");  
	        con.setRequestProperty("Charset", "UTF-8");  
	        // 设置边界,这里的boundary是http协议里面的分割符，不懂的可惜百度(http 协议 boundary)，这里boundary 可以是任意的值(111,2222)都行  
	        String BOUNDARY = "----------" + System.currentTimeMillis();  
	        con.setRequestProperty("Content-Type",  
	                    "multipart/form-data; boundary=" + BOUNDARY);  
	        // 请求正文信息  
	        // 第一部分：  
	        StringBuilder outputStr = new StringBuilder();  
	        outputStr.append("--"); // 必须多两道线  
	        outputStr.append(BOUNDARY);  
	        outputStr.append("\r\n");  
	        
	        long filelength = file.length();  
	        String fileName=file.getName(); 
	        //这里是media参数相关的信息
	        outputStr.append("Content-Disposition: form-data;name=\"media\";filename=\""  
	                    + fileName + "\";filelength=\"" + filelength + "\" \r\n");  
	        outputStr.append("Content-Type:application/octet-stream\r\n\r\n");  
			
	        byte[] head = outputStr.toString().getBytes("utf-8");  
	        // 获得输出流  
	        OutputStream out = new DataOutputStream(con.getOutputStream());  
	        // 输出表头  
	        out.write(head);  
	        // 文件正文部分  
	        // 把文件已流文件的方式 推入到url中  
	        DataInputStream in = new DataInputStream(new FileInputStream(file));  
	        int bytes = 0;  
	        byte[] bufferOut = new byte[1024];  
	        while ((bytes = in.read(bufferOut)) != -1) {  
	              out.write(bufferOut, 0, bytes);  
	        }  
	        in.close();  
	        
	        // 结尾部分，这里结尾表示整体的参数的结尾，结尾要用"--"作为结束，这些都是http协议的规定  
	        byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线  
	        out.write(foot);  
	        out.flush();  
	        out.close();  

			// 从输入流读取返回内容
			InputStream inputStream = con.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			con.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (Exception e) {
			// e.printStackTrace();
			logger.info("请求异常: " + e.getMessage());
		}
		return jsonObject;
	}

}
