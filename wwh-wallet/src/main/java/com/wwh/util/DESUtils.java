package com.wwh.util;

import java.io.Serializable;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * @ClassName: DESUtils
 * @Description: DES加密解密类
 * @author: ranletian
 * @date: 2016年10月28日 上午11:51:14
 */
public class DESUtils implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 序列ID
	 */
	private static final long serialVersionUID = 2659233338860663516L;

	private static Logger logger = LogManager.getLogger(DESUtils.class);

	private static Key key = null;

	private static String KEY_STR = "Vwhsc0818#_PE2LTHI6KJ";

	static {
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(KEY_STR.getBytes());
			generator.init(secureRandom);
			key = generator.generateKey();
			logger.info("key: " + key);
			generator = null;
		} catch (Exception e) {
			logger.error("key error: " + e);
		}
	}

	/**
	 * 
	 * @Title: getEncryptString
	 * @Description: 对字符串进行加密，返回BASE64的加密字符串
	 * @param str
	 * @return
	 * @return: String
	 */
	public static String getEncryptString(String str) throws Exception {
		try {
			BASE64Encoder base64Encoder = new BASE64Encoder();
			byte[] strBytes = str.getBytes("UTF-8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return base64Encoder.encode(encryptStrBytes);
		} catch (Exception e) {
			logger.error("getEncryptString error: " + e);
		}
		return null;
	}

	/**
	 * 
	 * @Title: getDecryptString
	 * @Description: 对BASE64加密字符串进行解密
	 * @param str
	 * @return
	 * @return: String
	 */
	public static String getDecryptString(String str) throws Exception {
		try {
			BASE64Decoder base64Decoder = new BASE64Decoder();
			byte[] strBytes = base64Decoder.decodeBuffer(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return new String(encryptStrBytes, "UTF-8");
		} catch (Exception e) {
			logger.error("getDecryptString error: " + e);
		}
		return null;
	}

	/**
	 * 
	 * @Title: main
	 * @Description: test
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) throws Exception {
		String name = "wwh";
		String password = "weiwohui0818#";
		String encryname = getEncryptString(name);
		String encrypassword = getEncryptString(password);
		System.out.println(encryname);
		System.out.println(encrypassword);
		System.out.println(getDecryptString(encryname));
		System.out.println(getDecryptString(encrypassword));
		
		
		System.out.println(getEncryptString("11111"));
		System.out.println(getEncryptString("123333"));
		System.out.println(getEncryptString("科技公司"));
		System.out.println(getEncryptString("INVITEREGISTER"));
		
		
	}
}
