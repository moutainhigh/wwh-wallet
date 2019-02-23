package com.wwh.util;

public final class SecurityUtil {
	private SecurityUtil() {
	}

	/**
	 * 默认算法密钥
	 */
	//private static final byte[] ENCRYPT_KEY = { -81, 0, 105, 7, -32, 26, -49, 88 };

	public static final String CHARSET = "UTF-8";
	
	/**
	 * SHA加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static final String encryptSHA(String data) {
		try {
			return encryptBASE64(SHAUtils.encodeSHA256(data.getBytes(CHARSET)));
		} catch (Exception e) {
			throw new RuntimeException("加密错误，错误信息：", e);
		}
	}
	
	/**
	 * 基于MD5算法的单向加密
	 * 
	 * @param strSrc 明文
	 * @return 返回密文
	 */
	public static final String encryptMd5(String strSrc) {
		String outString = null;
		try {
			outString = encryptBASE64(MD5Utils.encodeMD5(strSrc.getBytes(CHARSET)));
		} catch (Exception e) {
			throw new RuntimeException("加密错误，错误信息：", e);
		}
		return outString;
	}

	/**
	 * BASE64编码
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static final String encryptBASE64(byte[] key) {
		try {
			return new BASE64Encoder().encode(key);
		} catch (Exception e) {
			throw new RuntimeException("加密错误，错误信息：", e);
		}
	}
}	