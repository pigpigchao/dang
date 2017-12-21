package com.tarena.dang.service.impl;

import java.util.List;

import com.tarena.dang.dao.AddressDAO;
import com.tarena.dang.dao.OrderDAO;
import com.tarena.dang.dao.impl.AddressDAOImpl;
import com.tarena.dang.dao.impl.OrderDAOImpl;
import com.tarena.dang.entity.Address;
import com.tarena.dang.entity.CartItem;
import com.tarena.dang.entity.Order;
import com.tarena.dang.service.OrderService;
import com.tarena.dang.util.Constant;

public class OrderServiceImpl implements OrderService{

	public void save(Address address) throws Exception {
		AddressDAO addressdao=new AddressDAOImpl();
		addressdao.save(address);
	}

	public int createOrder(Address a, Order order) throws Exception {
		order.setFullAddress(a.getFullAddress());
		order.setMobile(a.getMobile());
		order.setOrderDesc(order.toString());
		order.setOrderTime(System.currentTimeMillis());
		order.setPhone(a.getPhone());
		order.setPostalCode(a.getPostalCode());
		order.setReceiveName(a.getReceiveName());
		order.setStatus(Constant.WAIT_PAY);
		OrderDAO orderdao=new  OrderDAOImpl();
		int id=0;
		id=orderdao.save(order);
		return id;
	}

	public void createOrderItem(int orderId, List<CartItem> buyItem)
			throws Exception {
		OrderDAO orderdao=new  OrderDAOImpl();
		for(CartItem item:buyItem){
			orderdao.insertItem(orderId, item);
		}
	}
	
}
