package com.wwh.loginwx.util;

import java.io.Writer;
import java.lang.reflect.Field;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONException;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.wwh.loginwx.config.WeixinConfig;
import com.wwh.loginwx.vo.AccessTokenVO;

import net.sf.json.JSONObject;

public class WeiXinUtil {
	private static Logger logger = LogManager.getLogger(WeiXinUtil.class);
	private static String GET_MENTHOD = "GET";
	/**
	 * 获取accessToken
	 * 
	 * @param appid
	 * @param appsecret
	 * @return
	 */
	public static AccessTokenVO getAccessToken(String appid, String appsecret) {
		AccessTokenVO accessToken = null;
		String requestUrl = WeixinConfig.access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		JSONObject jsonObject = HttpRequestUtil.httpRequestJSONObject(requestUrl, GET_MENTHOD, null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessTokenVO();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				logger.info("获取token失败 errcode:" + jsonObject.getInt("errcode") + ",errmsg:"
						+ jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}
	
	
	public static XStream createXstream() {  
        return new XStream(new XppDriver() {  
            @Override  
            public HierarchicalStreamWriter createWriter(Writer out) {  
                return new PrettyPrintWriter(out) {  
                    boolean cdata = false;  
                    Class<?> targetClass = null;  
  
                    @Override  
                    public void startNode(String name, @SuppressWarnings("rawtypes") Class clazz) {  
                        super.startNode(name, clazz);  
                        // 业务处理，对于用XStreamCDATA标记的Field，需要加上CDATA标签  
                        if (!name.equals("xml")) {  
                            cdata = needCDATA(targetClass, name);  
                        } else {  
                            targetClass = clazz;  
                        }  
                    }  
  
                    @Override  
                    protected void writeText(QuickWriter writer, String text) {  
                        if (cdata) {  
                            writer.write("<![CDATA[");  
                            writer.write(text);  
                            writer.write("]]>");  
                        } else {  
                            writer.write(text);  
                        }  
                    }  
                };  
            }  
        });  
    }  
  
    private static boolean needCDATA(Class<?> targetClass, String fieldAlias) {  
        boolean cdata = false;  
        // first, scan self  
        cdata = existsCDATA(targetClass, fieldAlias);  
        if (cdata)  
            return cdata;  
        // if cdata is false, scan supperClass until java.lang.Object  
        Class<?> superClass = targetClass.getSuperclass();  
        while (!superClass.equals(Object.class)) {  
            cdata = existsCDATA(superClass, fieldAlias);  
            if (cdata)  
                return cdata;  
            superClass = superClass.getClass().getSuperclass();  
        }  
        return false;  
    }  
  
    private static boolean existsCDATA(Class<?> clazz, String fieldAlias) {  
        if ("MediaId".equals(fieldAlias)) {  
            return true; // 特例添加 morning99  
        }  
        // scan fields  
        Field[] fields = clazz.getDeclaredFields();  
        for (Field field : fields) {  
            // 1. exists XStreamCDATA  
            if (field.getAnnotation(XStreamCDATA.class) != null) {  
                XStreamAlias xStreamAlias = field.getAnnotation(XStreamAlias.class);  
                // 2. exists XStreamAlias  
                if (null != xStreamAlias) {  
                    if (fieldAlias.equals(xStreamAlias.value()))// matched  
                        return true;  
                } else {// not exists XStreamAlias  
                    if (fieldAlias.equals(field.getName()))  
                        return true;  
                }  
            }  
        }  
        return false;  
    }  
}
