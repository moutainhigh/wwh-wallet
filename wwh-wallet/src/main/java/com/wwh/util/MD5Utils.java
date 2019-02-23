package com.wwh.util;

import java.io.Serializable;
import java.security.MessageDigest;

public class MD5Utils implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 序列
	 */
	private static final long serialVersionUID = -117420236868569269L;
	private static final String sv = "0ploi98kmjuy76hnbgt54r8vcde62wsxzaq1";
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (StringUtils.isEmpty(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}
	
	/**
	 * MD5加密
	 * 
	 * @param data 待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeMD5(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("MD5");
		// 执行消息摘要
		return md.digest(data);
	}
	
	/**
	 * 用MD5算法进行加密(16位)
	 * @param strPW
	 * @return
	 */
	public static String encryptMD5(String strPW) {
		String strCrypt = hash(strPW);
		if(strCrypt.length() > 0) {
			strCrypt += sv;
			strCrypt = hash(strCrypt);
		}
		
		return strCrypt.substring(8,24);
	}
	
	/**
	 * MD5算法进行散列
	 * @param str
	 * @return
	 */
	public static String hash(String str) {
		String result = "";
		if (str == null || str.equals("")) { // 如果传入参数为空，则返回空字符串
			return result;
		}
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] data = str.getBytes();
			int l = data.length;
			for (int i = 0; i < l; i++)
				md.update(data[i]);
			byte[] digest = md.digest();
			
			result = ECByteUtils.byteArrayToHexString(digest);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}

		return result;		
	}

}
