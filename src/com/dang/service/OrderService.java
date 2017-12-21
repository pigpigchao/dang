package com.dang.service;

import java.util.List;

import com.dang.entity.Address;
import com.dang.entity.CartItem;
import com.dang.entity.Order;

public interface OrderService {
	public void save(Address address)throws Exception;
	public int createOrder(Address address,Order order)throws Exception;
	public void createOrderItem(int orderId,List<CartItem> buyItem)throws Exception;

}
