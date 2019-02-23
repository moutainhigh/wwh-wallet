package com.wwh.util;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 序列号生成工具
 * 
 * @ClassName: SeqUtils
 * @Description:
 * @author:
 * @date: 2016年11月6日 上午11:47:32
 */
public class SeqUtils implements Serializable {

	private static Logger logger = LogManager.getLogger(SeqUtils.class);

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -6062777103217626706L;

	public static String generateRechargeOrderSN() {
		try {
			Thread.sleep(2L);
		} catch (InterruptedException e) {
			logger.error("generateRechargeOrderSN error:" + e);
		}
		return "RCG" + System.currentTimeMillis();
	}

	public static String generateDiskOrderSN() {
		try {
			Thread.sleep(2L);
		} catch (InterruptedException e) {
			logger.error("generateDiskOrderSN error:" + e);
		}
		return new String("PIK" + System.currentTimeMillis());
	}

	public static String generateIdCardOrderSN() {
		try {
			Thread.sleep(2L);
		} catch (InterruptedException e) {
			logger.error("generateIdCardOrderSN error:" + e);
		}
		return "IDCARD" + System.currentTimeMillis();
	}

	public static String generateADMINIdCardOrderSN() {
		try {
			Thread.sleep(2L);
		} catch (InterruptedException e) {
			logger.error("generateADMINIdCardOrderSN error:" + e);
		}
		return "ADMIN1479286940772";
	}

	public static Long generateADMINUserIdOrderSN() {
		try {
			Thread.sleep(2L);
		} catch (InterruptedException e) {
			logger.error("generateADMINUserIdOrderSN error:" + e);
		}
		return 1479286940772L;
	}

	public static String generateWithdrawSEQ() {
		try {
			Thread.sleep(2L);
		} catch (InterruptedException e) {
			logger.error("generateWithdrawSEQ error:" + e);
		}
		return "RAW" + System.currentTimeMillis();
	}

	public static String generateIdCardSN() {
		try {
			Thread.sleep(2L);
		} catch (InterruptedException e) {
			logger.error("generateIdCardOrderSN error:" + e);
		}
		return "PID" + System.currentTimeMillis();
	}

	public static String generateAgentProfitDetailId() {
		try {
			Thread.sleep(2L);
		} catch (InterruptedException e) {
			logger.error("generateIdCardOrderSN error:" + e);
		}
		return "APPRO" + System.currentTimeMillis();
	}
}
