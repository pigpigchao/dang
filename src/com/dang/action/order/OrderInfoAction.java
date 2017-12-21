package com.dang.action.order;

import java.util.List;

import com.dang.action.BaseAction;
import com.dang.entity.CartItem;
import com.dang.service.CartFactory;
import com.dang.service.CartService;

public class OrderInfoAction extends BaseAction{
	//input
	//output
	private List<CartItem> buyItem;
	private double total;
	public String execute() throws Exception{
		CartService cart=CartFactory.getCart(session);
		buyItem=cart.getBuyPros();
		total=cart.cost();
		return "success";
		
	}
	
	public List<CartItem> getBuyItem() {
		return buyItem;
	}
	public void setBuyItem(List<CartItem> buyItem) {
		this.buyItem = buyItem;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
