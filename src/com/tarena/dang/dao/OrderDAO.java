package com.tarena.dang.dao;

import com.tarena.dang.entity.CartItem;
import com.tarena.dang.entity.Order;

public interface OrderDAO {
	public int  save(Order order)throws Exception;
	public void insertItem(int orderId,CartItem item)throws Exception;
}
