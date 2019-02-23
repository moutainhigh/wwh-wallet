package com.wwh.loginwx.req;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wwh.loginwx.util.LoginwxUtil;
import com.wwh.loginwx.util.MyX509TrustManager;
import com.wwh.loginwx.vo.WXUserInfoVO;
import com.wwh.loginwx.vo.WXUserTokenVO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LoginwxRequest {
	private static Logger logger = LogManager.getLogger(LoginwxRequest.class);
	/**
	 * 发送请求得到json返回对象
	 * @param requestUrl
	 * @param requestMethod
	 * @param outputStr
	 * @return
	 */
	private static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		logger.info("微型登陆===>开始请求：requestUrl={}",requestUrl );
        JSONObject jsonObject = null;
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);

            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
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
        } catch (ConnectException ce) {
        	logger.error("连接超时：{}", ce);
        } catch (Exception e) {
        	logger.error("https请求异常：{}", e);
        }
        return jsonObject;
    }
	/**
	 * 开始授权
	 * @param accessToken
	 * @param openId
	 * @return
	 */
	public static String getWXAuthorizeUrl( String backUrl,String scope,String state) {
			logger.info("微信登陆===>开始授权");
	        // 拼接请求地址
	        String requestUrl = LoginwxUtil.conBaseUrl;
	        requestUrl = requestUrl.replace("APPID", LoginwxUtil.appId).replace("REDIRECTURL", backUrl).replace("SCOPE", scope)
	        .replace("STATE", state);
	        LoginwxUtil.urlEncodeUTF8(requestUrl);
	        return requestUrl;
	    }
	/**
	 * 获取授权凭证
	 * @param code
	 * @param openId
	 * @return
	 */
	public static WXUserTokenVO getWXUserToken(String code) {
			logger.info("微信登陆===>获取授权凭证");
			WXUserTokenVO wxUserTokenInfo = null;
	        // 拼接请求地址
	        String requestUrl =LoginwxUtil.tokenBaseUrl;
	        requestUrl = requestUrl.replace("APPID", LoginwxUtil.appId).replace("SECRET", LoginwxUtil.secret).replace("CODE", code);
	        LoginwxUtil.urlEncodeUTF8(requestUrl);
	        // 通过网页授权获取用户信息
	        JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);

	        if (null != jsonObject) {
	            try {
	            	wxUserTokenInfo = new WXUserTokenVO();
	            	wxUserTokenInfo.setAccessToken(jsonObject.getString("access_token"));
	            	wxUserTokenInfo.setExpiresIn(jsonObject.getInt("expires_in"));
	            	wxUserTokenInfo.setRefreshToken(jsonObject.getString("refresh_token"));
	            	wxUserTokenInfo.setOpenId(jsonObject.getString("openid"));
	            	wxUserTokenInfo.setScope(jsonObject.getString("scope"));
	            } catch (Exception e) {
	            	wxUserTokenInfo = null;
	                int errorCode = jsonObject.getInt("errcode");
	                String errorMsg = jsonObject.getString("errmsg");
	                logger.error("获取授权凭证失败 errcode:{} errmsg:{}", errorCode, errorMsg);
	            }
	        }
	        return wxUserTokenInfo;
	    }
	/**
	 * 获取用户信息
	 * @param accessToken
	 * @param openId
	 * @return
	 */
	 public static WXUserInfoVO getWXUserInfo(String accessToken, String openId) {
		 	logger.info("微信登陆===>获取用户信息");
		   	WXUserInfoVO wxUserInfo = null;
	        // 拼接请求地址
	        String requestUrl = LoginwxUtil.userInfoUrl;
	        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
	        // 通过网页授权获取用户信息
	        JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);

	        if (null != jsonObject) {
	            try {
	            	wxUserInfo = new WXUserInfoVO();
	            	// 用户在微信平台所有应用的唯一标示
	            	wxUserInfo.setUnionId(jsonObject.getString("unionid"));
	                // 用户的标识
	            	wxUserInfo.setOpenId(jsonObject.getString("openid"));
	                // 昵称
	            	wxUserInfo.setNickName(jsonObject.getString("nickname"));
	                // 性别（1是男性，2是女性，0是未知）
	            	wxUserInfo.setSex(jsonObject.getInt("sex"));
	                // 用户所在国家
	            	wxUserInfo.setCountry(jsonObject.getString("country"));
	                // 用户所在省份
	            	wxUserInfo.setProvince(jsonObject.getString("province"));
	                // 用户所在城市
	            	wxUserInfo.setCity(jsonObject.getString("city"));
	                // 用户头像
	            	wxUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
	                // 用户特权信息
	            	wxUserInfo.setPrivilege(StringUtils.strip(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class).toString(),"[]"));
	            } catch (Exception e) {
	            	wxUserInfo = null;
	                int errorCode = jsonObject.getInt("errcode");
	                String errorMsg = jsonObject.getString("errmsg");
	                logger.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
	            }
	        }
	        return wxUserInfo;
	  }
}
