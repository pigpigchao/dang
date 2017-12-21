package com.tarena.dang.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	private static String DEFAULT_PATH="/dangdang";
	private static int DEFAULT_AGE=365*24*3600;
	
	public static void addCookie(String name,String value,
		HttpServletResponse response,int age) throws UnsupportedEncodingException{
		Cookie cookie=new Cookie(name,URLEncoder.encode(value,"utf-8"));
		cookie.setPath(DEFAULT_PATH);
		cookie.setMaxAge(age);
		response.addCookie(cookie);
	}
	public static void addCookie(String name,String value,
			HttpServletResponse response) throws UnsupportedEncodingException{
		addCookie(name,value,response,DEFAULT_AGE);
	}
	public static String findCookie(String name,
			HttpServletRequest request) throws UnsupportedEncodingException{
		String value=null;
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(int i=0;i<cookies.length;i++){
				Cookie curr=cookies[i];
				if(curr.getName().equals(name)){
					value=URLDecoder.decode(curr.getValue(),"utf-8");
				}
			}
		}
		
		return value;
	}
	public static void deleteCookie(String name,
			HttpServletResponse response){
		Cookie cookie=new Cookie(name,"");
		cookie.setMaxAge(0);
		cookie.setPath(DEFAULT_PATH);
		response.addCookie(cookie);
	}
}
