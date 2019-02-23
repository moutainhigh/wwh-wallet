package com.wwh.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import com.wwh.pay.message.text.service.impl.MessageJTDServiceImpl;

public class GetPropertiesUtil {
	public static String  getValue(String key,String properties) {
		InputStream in = null;
		try {
			Properties props = new Properties();
			in = new BufferedInputStream(new FileInputStream(
					(getPath() + properties)));
			props.load(in);
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if (null != in){
				try {
					in.close();
					in = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public static Properties  getAll(String properties) {
		InputStream in = null;
		try {
			Properties props = new Properties();
			in = new BufferedInputStream(new FileInputStream(
					(getPath() + properties)));
			props.load(in);
			return props;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if (null != in){
				try {
					in.close();
					in = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	private static  String getPath() throws UnsupportedEncodingException {
		String configPath = MessageJTDServiceImpl.class.getClassLoader().getResource("").getPath();
		return java.net.URLDecoder.decode(configPath, "utf-8");
	}
}
