package com.wwh.util;

import java.io.Serializable;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * 
 * @ClassName: AESUtils
 * @Description: AES对称算法加密
 * @author: ranle
 * @date: 2016年11月9日 下午3:40:28
 */
public class AESUtils implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 序列
	 */
	private static final long serialVersionUID = -2700578165887977853L;

	private static Cipher cipher;

	private static final String KEY_ALGORITHM = "AES";

	private static final String CIPHER_ALGORITHM_ECB = "AES/ECB/PKCS5Padding";

	private static SecretKey secretKey;

	/**
	 * 
	 * @Title: ECBEncrypt
	 * @Description: 使用AES 算法 加密，默认模式 AES/ECB/PKCS5Padding
	 * @param str
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	public static String ECBEncrypt(String str) throws Exception {
		cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
		// KeyGenerator 生成aes算法密钥
		secretKey = KeyGenerator.getInstance(KEY_ALGORITHM).generateKey();
		// 使用加密模式初始化 密钥
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		// 按单部分操作加密或解密数据，或者结束一个多部分操作
		byte[] encrypt = cipher.doFinal(str.getBytes());
		return Arrays.toString(encrypt);
	}

	public static String ECBDecrypt(String str) throws Exception {
		cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
		// KeyGenerator 生成aes算法密钥
		secretKey = KeyGenerator.getInstance(KEY_ALGORITHM).generateKey();
		// 使用加密模式初始化 密钥
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		// 按单部分操作加密或解密数据，或者结束一个多部分操作
		byte[] encrypt = cipher.doFinal(str.getBytes());

		// 使用解密模式初始化 密钥
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decrypt = cipher.doFinal(encrypt);
		return new String(decrypt);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(ECBEncrypt("wwh"));
		System.out.println(ECBDecrypt("wwh"));
	}
}
