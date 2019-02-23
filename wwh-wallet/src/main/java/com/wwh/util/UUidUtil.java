package com.wwh.util;

import java.util.UUID;

public class UUidUtil {
	public static String getId(){
		 return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
