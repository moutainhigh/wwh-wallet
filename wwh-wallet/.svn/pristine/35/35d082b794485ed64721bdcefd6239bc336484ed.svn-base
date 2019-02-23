package com.wwh.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 * @ClassName: DateUtils
 * @Description: 日期处理相关工具类
 * @author: ranletain
 * @date: 2016年10月22日 下午5:50:32
 */
public class DateUtils implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 序列ID
	 */
	private static final long serialVersionUID = -4772747912457441667L;

	public static final String DATE_JFP_STR = "yyyyMM";

	public static final String DATE_FULL_STR = "yyyy-MM-dd HH:mm:ss";

	public static final String DATE_SMALL_STR = "yyyy-MM-dd";

	public static final String DATE_KEY_STR = "yyMMddHHmmss";

	/**
	 * 
	 * @Title: parse
	 * @Description: 使用预设格式提取字符串日期
	 * @param strDate
	 * @return
	 * @return: Date
	 */
	public static Date parse(String strDate) {
		return parse(strDate, DATE_FULL_STR);
	}

	/**
	 * 
	 * @Title: parse
	 * @Description: 使用用户格式提取字符串日期
	 * @param strDate
	 * @param pattern
	 * @return
	 * @return: Date
	 */
	public static Date parse(String strDate, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @Title: compareDateWithNow
	 * @Description: 两个时间比较
	 * @param date1
	 * @return
	 * @return: int
	 */
	public static int compareDateWithNow(Date date1) {
		Date date2 = new Date();
		int rnum = date1.compareTo(date2);
		return rnum;
	}

	/**
	 * 
	 * @Title: compareDateWithNow
	 * @Description: 两个时间比较(时间戳比较)
	 * @param date1
	 * @return
	 * @return: int
	 */
	public static int compareDateWithNow(long date1) {
		long date2 = dateToUnixTimestamp();
		if (date1 > date2) {
			return 1;
		} else if (date1 < date2) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @Title: getNowTime
	 * @Description: 获取系统当前时间
	 * @return
	 * @return: String
	 */
	public static String getNowTime() {
		SimpleDateFormat df = new SimpleDateFormat(DATE_FULL_STR);
		return df.format(new Date());
	}

	/**
	 * 
	 * @Title: getNowTime
	 * @Description: 获取系统当前时间
	 * @param type
	 * @return
	 * @return: String
	 */
	public static String getNowTime(String type) {
		SimpleDateFormat df = new SimpleDateFormat(type);
		return df.format(new Date());
	}

	/**
	 * 
	 * @Title: getJFPTime
	 * @Description: 获取系统当前计费期
	 * @return
	 * @return: String
	 */
	public static String getJFPTime() {
		SimpleDateFormat df = new SimpleDateFormat(DATE_JFP_STR);
		return df.format(new Date());
	}

	/**
	 * 
	 * @Title: convertDateToStr
	 * @Description: Date转String
	 * @param pattern
	 * @return
	 * @return: String
	 */
	public static String convertDateToStr(String pattern) {
		Date date = new Date();
		if (null == pattern) {
			return null;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(date);
		}
	}

	/**
	 * 
	 * @Title: convertStrToDate
	 * @Description: String转Date
	 * @param strDate
	 * @param pattern
	 * @return
	 * @throws ParseException
	 * @return: Date
	 */
	public static Date convertStrToDate(String strDate, String pattern) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = simpleDateFormat.parse(strDate);
		long lngTime = date.getTime();
		return new Date(lngTime);
	}

	/**
	 * 
	 * @Title: dateToUnixTimestamp
	 * @Description: 将指定的日期转换成Unix时间戳
	 * @param date
	 * @return
	 * @return: long
	 */
	public static long dateToUnixTimestamp(String date) {
		long timestamp = 0;
		try {
			timestamp = new SimpleDateFormat(DATE_FULL_STR).parse(date).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timestamp;
	}

	/**
	 * 
	 * @Title: dateToUnixTimestamp
	 * @Description: 将指定的日期转换成Unix时间戳
	 * @param date
	 * @param dateFormat
	 * @return
	 * @return: long
	 */
	public static long dateToUnixTimestamp(String date, String dateFormat) {
		long timestamp = 0;
		try {
			timestamp = new SimpleDateFormat(dateFormat).parse(date).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timestamp;
	}

	/**
	 * 
	 * @Title: dateToUnixTimestamp
	 * @Description: 将当前日期转换成Unix时间戳
	 * @return
	 * @return: long
	 */
	public static long dateToUnixTimestamp() {
		long timestamp = new Date().getTime();
		return timestamp;
	}

	/**
	 * 
	 * @Title: unixTimestampToDate
	 * @Description: 将Unix时间戳转换成日期
	 * @param timestamp
	 * @return
	 * @return: String
	 */
	public static String unixTimestampToDate(long timestamp) {
		SimpleDateFormat sd = new SimpleDateFormat(DATE_FULL_STR);
		sd.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return sd.format(new Date(timestamp));
	}

	/**
	 * 
	 * @Title: getYear_Month
	 * @Description: 返回yyyymm
	 * @param aDate
	 * @return
	 * @return: String
	 */
	public static final String getYear_Month(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat("yyyyMM");
			returnValue = df.format(aDate);
		}
		return (returnValue);
	}

	/**
	 * 
	 * @Title: getYear
	 * @Description: 返回当前年
	 * @return
	 * @return: String
	 */
	public static String getYear() {
		Calendar calendar = Calendar.getInstance();
		return String.valueOf(calendar.get(1));
	}

	/**
	 * 
	 * @Title: getMonth
	 * @Description: 返回当前月
	 * @return
	 * @return: String
	 */
	public static String getMonth() {
		Calendar calendar = Calendar.getInstance();
		String temp = String.valueOf(calendar.get(2) + 1);
		if (temp.length() < 2)
			temp = "0" + temp;
		return temp;
	}
}
