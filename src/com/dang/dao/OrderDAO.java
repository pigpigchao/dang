package com.dang.dao;

import com.dang.entity.CartItem;
import com.dang.entity.Order;

public interface OrderDAO {
	public int  save(Order order)throws Exception;
	public void insertItem(int orderId,CartItem item)throws Exception;
}
