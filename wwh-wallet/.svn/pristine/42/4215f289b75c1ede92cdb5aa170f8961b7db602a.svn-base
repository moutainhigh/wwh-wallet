package com.wwh.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @ClassName: StringUtils
 * @Description: 字符工具类
 * @author: ranletain
 * @date: 2016年10月24日 下午1:40:45
 */
public class StringUtils implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 序列ID
	 */
	private static final long serialVersionUID = 1012229330579865930L;

	// 过滤通过页面表单提交的字符
	private static String[][] FilterChars = { { "<", "&lt;" }, { ">", "&gt;" }, { " ", "&nbsp;" }, { "\"", "&quot;" }, { "&", "&amp;" },
			{ "/", "&#47;" }, { "0\\", "&#92;" }, { "\n", "<br>" } };

	// 过滤通过javascript脚本处理并提交的字符
	private static String[][] FilterScriptChars = { { "\n", "\'+\'\\n\'+\'" }, { "\r", " " }, { "\\", "\'+\'\\\\\'+\'" },
			{ "\'", "\'+\'\\\'\'+\'" } };

	/**
	 * 
	 * @Title: isEmpty
	 * @Description: 验证字符串是否为空
	 * @param param
	 * @return
	 * @return: boolean
	 */
	public static boolean isEmpty(String param) {
		return null == param || param.trim().length() < 1;
	}

	/**
	 * 
	 * @Title: isLongEmpty
	 * @Description: 验证Long类型是否为空
	 * @param param
	 * @return
	 * @return: boolean
	 */
	public static boolean isLongEmpty(Long param) {
		return null == param;
	}

	/**
	 * 
	 * @Title: isObjEmpty
	 * @Description: 验证对象是否为空
	 * @param obj
	 * @return
	 * @return: boolean
	 */
	public static boolean isObjEmpty(Object obj) {
		return null == obj || "null" == obj;
	}

	/**
	 * 
	 * @Title: getCharnum
	 * @Description: 得到字符串中某个字符的个数
	 * @param str
	 * @param c
	 * @return
	 * @return: int
	 */
	public static final int getCharnum(String str, char c) {
		int num = 0;
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (c == chars[i]) {
				num++;
			}
		}
		return num;
	}

	/**
	 * 
	 * @Title: split
	 * @Description: 按长度分割字符串
	 * @param content
	 * @param len
	 * @return
	 * @return: String[]
	 */
	public static String[] split(String content, int len) {
		if (content == null || content.equals("")) {
			return null;
		}
		int len2 = content.length();
		if (len2 <= len) {
			return new String[] { content };
		} else {
			int i = len2 / len + 1;
			String[] strA = new String[i];
			int j = 0;
			int begin = 0;
			int end = 0;
			while (j < i) {
				begin = j * len;
				end = (j + 1) * len;
				if (end > len2)
					end = len2;
				strA[j] = content.substring(begin, end);
				j = j + 1;
			}
			return strA;
		}
	}

	/**
	 * 
	 * @Title: emailFormat
	 * @Description: 邮箱格式化
	 * @param email
	 * @return
	 * @return: boolean
	 */
	public static boolean emailFormat(String email) {
		boolean tag = true;
		final String pattern1 = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		final Pattern pattern = Pattern.compile(pattern1);
		final Matcher mat = pattern.matcher(email);
		if (!mat.find()) {
			tag = false;
		}
		return tag;
	}

	/**
	 * 
	 * @Title: isEmail
	 * @Description: 验证是不是email
	 * @param email
	 * @return
	 * @return: boolean
	 */
	public static boolean isEmail(String email) {
		boolean retval = false;
		String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(email);
		retval = matcher.matches();
		return retval;
	}

	/**
	 * 
	 * @Title: htmlEncode
	 * @Description: 修改敏感字符编码
	 * @param value
	 * @return
	 * @return: String
	 */
	public static String htmlEncode(String value) {
		String re[][] = { { "<", "&lt;" }, { ">", "&gt;" }, { "\"", "&quot;" }, { "\\′", "&acute;" }, { "&", "&amp;" } };
		for (int i = 0; i < 4; i++) {
			value = value.replaceAll(re[i][0], re[i][1]);
		}
		return value;
	}

	/**
	 * 
	 * @Title: sql_inj
	 * @Description: 防SQL注入
	 * @param str
	 * @return
	 * @return: boolean
	 */
	public static boolean sql_inj(String str) {
		String inj_str = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";
		String inj_stra[] = inj_str.split("|");
		for (int i = 0; i < inj_stra.length; i++) {
			if (str.indexOf(inj_stra[i]) >= 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @Title: numberDecimal
	 * @Description: 数据转换
	 * @param d
	 * @param i
	 * @return
	 * @return: double
	 */
	public static double numberDecimal(double d, int i) {
		BigDecimal b = new BigDecimal(d);
		BigDecimal bd1 = b.setScale(i, BigDecimal.ROUND_HALF_UP);
		d = bd1.doubleValue();
		return d;
	}

	/**
	 * 
	 * @Title: stringFilter
	 * @Description: 过滤字符串里的的特殊字符
	 * @param str
	 * @return
	 * @return: String
	 */
	public static String stringFilter(String str) {
		String[] str_arr = stringSpilit(str, "");
		for (int i = 0; i < str_arr.length; i++) {
			for (int j = 0; j < FilterChars.length; j++) {
				if (FilterChars[j][0].equals(str_arr[i]))
					str_arr[i] = FilterChars[j][1];
			}
		}
		return (stringConnect(str_arr, "")).trim();
	}

	/**
	 * 
	 * @Title: stringFilterScriptChar
	 * @Description: 过滤脚本中的特殊字符（包括回车符(\n)和换行符(\r)）
	 * @param str
	 * @return
	 * @return: String
	 */
	public static String stringFilterScriptChar(String str) {
		String[] str_arr = stringSpilit(str, "");
		for (int i = 0; i < str_arr.length; i++) {
			for (int j = 0; j < FilterScriptChars.length; j++) {
				if (FilterScriptChars[j][0].equals(str_arr[i]))
					str_arr[i] = FilterScriptChars[j][1];
			}
		}
		return (stringConnect(str_arr, "")).trim();
	}

	/**
	 * 
	 * @Title: stringSpilit
	 * @Description: 分割字符串
	 * @param str
	 * @param spilit_sign
	 * @return
	 * @return: String[]
	 */
	public static String[] stringSpilit(String str, String spilit_sign) {
		String[] spilit_string = str.split(spilit_sign);
		if (spilit_string[0].equals("")) {
			String[] new_string = new String[spilit_string.length - 1];
			for (int i = 1; i < spilit_string.length; i++)
				new_string[i - 1] = spilit_string[i];
			return new_string;
		} else
			return spilit_string;
	}

	/**
	 * 
	 * @Title: stringConnect
	 * @Description: 用特殊的字符连接字符串
	 * @param strings
	 * @param spilit_sign
	 * @return
	 * @return: String
	 */
	public static String stringConnect(String[] strings, String spilit_sign) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < strings.length; i++) {
			str.append(strings[i]);
			str.append(spilit_sign);
		}
		return str.toString();
	}
}
