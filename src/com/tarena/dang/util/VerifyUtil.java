package com.tarena.dang.util;

import java.util.UUID;

public class VerifyUtil {
	public static String createUUID(){
		//生成唯一的字符编码
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}
}
