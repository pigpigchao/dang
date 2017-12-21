package com.tarena.dang.action.cart;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.tarena.dang.action.BaseAction;
import com.tarena.dang.entity.User;
import com.tarena.dang.service.CartFactory;
import com.tarena.dang.service.CartService;
import com.tarena.dang.util.CookieUtil;

public class CartAction extends BaseAction{
	//input 
	private int id;
	//output
	private boolean ok=false;//¹ºÂò³É¹¦
	public String buy(){
		CartService cart=CartFactory.getCart(session);
		User user=(User)session.get("user");
		try {
			cart.add(id);
			if(user==null){	
				CookieUtil.addCookie("cart", cart.store(),
						ServletActionContext.getResponse());
			}else{
				CookieUtil.addCookie("cart"+user.getId(), cart.store(),
						ServletActionContext.getResponse());
			}
			ok=true;
		} catch (SQLException e){
			ok=false;
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
}
