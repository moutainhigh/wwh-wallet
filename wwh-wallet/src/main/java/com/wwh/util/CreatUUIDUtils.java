package com.wwh.util;

import java.io.Serializable;
import java.util.UUID;

/**
 * 
 * @ClassName: CreatUUIDUtils
 * @Description: 创建唯一标识
 * @author: lilinxiang
 * @date: 2016年10月26日 下午4:39:07
 */
public class CreatUUIDUtils implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 序列ID
	 */
	private static final long serialVersionUID = -6289248194424141105L;

	private CreatUUIDUtils() {

	}

	public static String creatUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String creatDiskUUID() {
		return "DISK" + UUID.randomUUID().toString().replace("-", "");
	}

	public static String creatPayUUID() {
		return "PAY" + UUID.randomUUID().toString().replace("-", "");
	}
}
