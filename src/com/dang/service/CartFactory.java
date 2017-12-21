package com.dang.service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dang.entity.User;
import com.dang.service.impl.CartServiceImpl;
import com.dang.util.CookieUtil;

public class CartFactory {
	//一个session返回一个cartService
	public static CartService getCart(Map<String,Object> session){
		CartService cart=(CartService)session.get("cart");
		User user=(User)session.get("user");
		if(cart==null){
			cart=new CartServiceImpl();
			try {
				if(user==null){	
					cart.load(CookieUtil.findCookie("cart", ServletActionContext.getRequest()));
				}else{
					cart.load(CookieUtil.findCookie("cart"+user.getId(), ServletActionContext.getRequest()));	
				}
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			session.put("cart", cart);
			
		}
		return cart;
	}
}
