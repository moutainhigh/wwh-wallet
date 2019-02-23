package com.wwh.util;

import java.util.Arrays;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * 参数签名
 * @author wwh
 *
 */
public class SignUtil {
	private static final String PRIVATEKEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAOq30rck7L3FshHVYWJK59sTToGMAn7WfYdrFN60AmPPyiMcIFXe3ZAxf7SWNbaQOPUz/xYr+oAXUBK17bykS/E2+Xa74wdN2VNbc7cZIggAjP9tGN0qhYTclbtC3pchcU8TVccrlVUN2lzJDLBHhPBDBFXzsQx9Vwtm2qjf2GcrAgMBAAECgYEAsHnz4aXOpkTNRSFVbiz5tLsIbNjTS4CDs1ysvWFE5rzls45DNa0yk2bUKPhDfHdli99DbO02FDbzCo5lKE+zlEHaC/WTp6guEe7jj5dwMl3shBZmgITCTk1/MQ46gGRG4RRADbQT/Y7tENp/GF3y9oJyJ+LmHFvfdEjSuY1/QzECQQD6aKqYFO8wuhLhy1fTvjMwlzok0szT9wTp+l6E7Ct9+csvdwaYjJrGsr6kUv+6YUwieSJ41lVtGnRy1oXEQG2TAkEA7/V35kYG+FMwYq/DOrBNaomRQGJVAOLzGRoK2dkjAkpoUAfzk4TTQ0KdJJ3T6mzF/6IQY+1oFDD42kNKJklfCQJARiya0i/bsC4VKI3RuRcuRUm8E6G3oRcym1d8sYd10MH1/QFAKfQNU+23m1lfLR4jNe34iSCXpBGr3JrdtdfQXQJAXgWRkGHZ800tRU3XMlTIULlMd6zP38QNOsWwgMGK7SfYjZs//opp+Q3N4v4QfedXAZ4vy+fHAzpZF7SMBkpzeQJALlMaKKeqKvPr8abXSRjW8u6s8tHaHX6CRV/1fGDX1bkUByqdFMO5CqIHn7isK2dHXI42bJVz63/d2Aax3lTbkA==";
	private static final String PUBLICKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDqt9K3JOy9xbIR1WFiSufbE06BjAJ+1n2HaxTetAJjz8ojHCBV3t2QMX+0ljW2kDj1M/8WK/qAF1ASte28pEvxNvl2u+MHTdlTW3O3GSIIAIz/bRjdKoWE3JW7Qt6XIXFPE1XHK5VVDdpcyQywR4TwQwRV87EMfVcLZtqo39hnKwIDAQAB";
	
	/**
	 * RSA生成签名字符串
	 * @param signFields 哪些字段需要签名
	 * @param map  待签名数据
	 * @return
	 */
	public static String sign(String[] signFields,Map<String, Object> map) {
		String genSign = "";
		try {
			JSONObject param = (JSONObject) JSONObject.toJSON(map);
			// 生成签名原文
			String src = orgSignSrc(signFields, param);
			genSign = RsaUtil.sign(src, PRIVATEKEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return genSign;
	}
	
	/**
	 * 签名校验
	 * @param signFields  哪些字段需要签名
	 * @param map    待签名数据
	 * @param sign 已签名串
	 * @return
	 */
	public static boolean verify(String[] signFields,Map<String, Object> map, String sign) {
		boolean bool = false;
		try {
			JSONObject param = (JSONObject) JSONObject.toJSON(map);
			// 生成签名原文
			String signSrc = orgSignSrc(signFields, param);
			// 调用工具类验签
			bool = RsaUtil.verify(signSrc, sign, PUBLICKEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}
	
	/**
	 * 构建签名原文
	 * 
	 * @param signFilds
	 *            参数列表
	 * @param param
	 *            参数与值的jsonbject
	 * @return
	 */
	private static String orgSignSrc(String[] signFields, JSONObject param) {
		if (signFields != null) {
			Arrays.sort(signFields); // 对key按照 字典顺序排序
		}
		StringBuffer signSrc = new StringBuffer("");
		int i = 0;
		for (String field : signFields) {
			signSrc.append(field);
			signSrc.append("=");
			signSrc.append((StringUtil.isEmpty(param.getString(field)) ? ""
					: param.getString(field)));
			// 最后一个元素后面不加&
			if (i < (signFields.length - 1)) {
				signSrc.append("&");
			}
			i++;
		}
		return signSrc.toString();
	}
}
