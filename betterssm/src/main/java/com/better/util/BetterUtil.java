package com.better.util;

public final class BetterUtil {
	public static String[] split(String str){
		
		return null;
	}
	
	/**
	 * 判断一个字符串是否为空<br>
	 * 只有两种情况:1.str=null，2.str==""
	 * 
	 * @param str
	 * @return
	 */
	public static boolean notNull(String str){
		
		if(str != null && str.length() != 0){
			return true;
		}
		return false;
	}
}
