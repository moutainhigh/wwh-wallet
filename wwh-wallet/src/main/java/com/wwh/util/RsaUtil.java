package com.wwh.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * RSA处理
 * @author chivk
 *
 */
public class RsaUtil {
	static String ENCODE = "UTF-8";
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
	/**
	 * 用私钥因子priEx与模数mod对字符串src做签名
	 * 
	 * @param src
	 *            - 普通字符串
	 * @param pri
	 *            - 私钥base64字符串
	 * @return String - hex字符串
	 * @throws UnsupportedEncodingException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 */
	public static String sign(String src, String pri) throws Exception {
		// 将明文数据转为byte数组
		byte[] data = src.getBytes(ENCODE);
		RSAPrivateKey priKey = createRSAPrivateKey(pri);
		// 实例化Signature
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		// 初始化Signature
		signature.initSign(priKey);
		// 更新
		signature.update(data);
		byte[] signB = signature.sign();
		return StringUtil.byte2hex(signB);
	}
	/**
	 * 创建公钥对象
	 * 
	 * @param pubKey
	 *            - base64字符串
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws Exception
	 */
	public static RSAPublicKey createRSAPublicKey(String pubKey) throws NoSuchAlgorithmException,
			InvalidKeySpecException {
		byte[] keyBytes = Base64.decodeBase64(pubKey);
		StringUtil.byte2hex(keyBytes);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return (RSAPublicKey) keyFactory.generatePublic(keySpec);
	}
	/**
	 * 校验数字签名
	 * 
	 * @param signSrc
	 *            待校验数据普通字符串
	 * @param sign
	 *            数字签名(hex字符串)
	 * @param pub
	 *            公钥base64字符串
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 */
	public static boolean verify(String signSrc, String sign, String pub)
			throws Exception {
		// 将明文数据转为byte数组
		byte[] data = signSrc.getBytes("UTF-8");
		// 将签名数据转换为byte数组
		byte[] signByte = StringUtil.hex2byte(sign);
		// 产生公钥
		PublicKey pubKey = createRSAPublicKey(pub);
		// 实例化Signature
		Signature signature = Signature.getInstance("MD5withRSA");
		// 初始化Signature
		signature.initVerify(pubKey);
		// 更新
		signature.update(data);
		// 验证
		return signature.verify(signByte);
	}
	/**
	 * 创建公钥对象
	 * 
	 * @param pubKey
	 *            - base64字符串
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static RSAPrivateKey createRSAPrivateKey(String priKey) throws NoSuchAlgorithmException,
			InvalidKeySpecException {
		byte[] keyBytes = Base64.decodeBase64(priKey);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
	}
	
	/**
	 * 功能：MD5加密
	 * @param strSrc 加密的源字符串
	 * @return 加密串 长度32位(hex串)
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	public static String getMessageDigest(String strSrc) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = null;
		String strDes = null;
		final String ALGO_MD5 = "MD5";

		byte[] bt = strSrc.getBytes(ENCODE);
		md = MessageDigest.getInstance(ALGO_MD5);
		md.update(bt);
		strDes = StringUtil.byte2hex(md.digest());
		return strDes;
	}

	/**
	 * 将字节数组转为HEX字符串(16进制串)
	 * @param bts 要转换的字节数组
	 * @return 转换后的HEX串
	 */
	public static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}
}
