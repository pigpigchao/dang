package com.tarena.dang.action.cart;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.tarena.dang.action.BaseAction;
import com.tarena.dang.entity.CartItem;
import com.tarena.dang.entity.User;
import com.tarena.dang.service.CartFactory;
import com.tarena.dang.service.CartService;
import com.tarena.dang.util.CookieUtil;

public class CartListAction extends BaseAction{
	private int id;
	private int uid=-1;
	private List<CartItem> buyItem;
	private List<CartItem> delItem;
	private int num;
	private double total;
	private double saveMoney;

	public String list()throws Exception{
		CartService cart=CartFactory.getCart(session);
		
		buyItem=cart.getBuyPros();
		delItem=cart.getDeletePros();
		total=cart.cost();
		saveMoney=cart.saveMoney();
		return "success";
	}
	
//	public String dellist()throws Exception{
//		CartService cart=CartFactory.getCart(session);
//		delItem=cart.getDeletePros();
//		return "success";
//	}
//	
	public String delete()throws Exception{
		CartService cart=CartFactory.getCart(session);
		cart.delete(id);
		User user=(User)session.get("user");
		if(user==null){	
			CookieUtil.addCookie("cart", cart.store(),
					ServletActionContext.getResponse());
		}else{
			CookieUtil.addCookie("cart"+user.getId(), cart.store(),
					ServletActionContext.getResponse());
		}

		return "success";
	}	

	public String update()throws Exception{
		CartService cart=CartFactory.getCart(session);

		cart.update(id, num);
		User user=(User)session.get("user");
		if(user==null){	
			CookieUtil.addCookie("cart", cart.store(),
					ServletActionContext.getResponse());
		}else{
			CookieUtil.addCookie("cart"+user.getId(), cart.store(),
					ServletActionContext.getResponse());
		}

		return "success";
	}
	 
	public String recovery()throws Exception{
		CartService cart=CartFactory.getCart(session);

		cart.recovery(id);
		User user=(User)session.get("user");
		if(user==null){	
			CookieUtil.addCookie("cart", cart.store(),
					ServletActionContext.getResponse());
		}else{
			CookieUtil.addCookie("cart"+user.getId(), cart.store(),
					ServletActionContext.getResponse());
		}

		return "success";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<CartItem> getBuyItem() {
		return buyItem;
	}
	public void setBuyItem(List<CartItem> buyItem) {
		this.buyItem = buyItem;
	}
	public List<CartItem> getDelItem() {
		return delItem;
	}
	public void setDelItem(List<CartItem> delItem) {
		this.delItem = delItem;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getSaveMoney() {
		return saveMoney;
	}
	public void setSaveMoney(double saveMoney) {
		this.saveMoney = saveMoney;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
}
