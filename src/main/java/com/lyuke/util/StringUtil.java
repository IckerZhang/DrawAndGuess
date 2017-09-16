package com.lyuke.util;

import java.util.Random;
import java.util.UUID;

/**
 * @author Lyuke
 * @Date 2017-03-26 05:04
 */
public class StringUtil {
	/**
	 * 生成UUID作为唯一标识符
	 * 
	 * @return String
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replace("-", "");
	}

	/**
	 * 生成8位数字ID作为游客id
	 * 
	 * @return String
	 */
	public static String getTouristID() {
		StringBuffer str = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			str.append(random.nextInt(10));
		}
		return str.toString();
	}
}
