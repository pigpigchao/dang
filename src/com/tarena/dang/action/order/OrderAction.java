package com.tarena.dang.action.order;

import java.util.List;

import com.tarena.dang.action.BaseAction;
import com.tarena.dang.dao.AddressDAO;
import com.tarena.dang.dao.impl.AddressDAOImpl;
import com.tarena.dang.entity.Address;
import com.tarena.dang.entity.CartItem;
import com.tarena.dang.entity.Order;
import com.tarena.dang.entity.User;
import com.tarena.dang.service.CartFactory;
import com.tarena.dang.service.CartService;
import com.tarena.dang.service.OrderService;
import com.tarena.dang.service.impl.OrderServiceImpl;

public class OrderAction extends BaseAction{
	//input
	private Address address;
	private int id;
	//output
	private List<CartItem> buyItem;
	private double total;
	private Order order=new Order();
	private List<Address> addresses;
	
	public String show()throws Exception{
		CartService cart=CartFactory.getCart(session);
		buyItem=cart.getBuyPros();
		total=cart.cost();
		return "success";
	}
	public String createOrder()throws Exception{
		try{
			CartService cart = CartFactory.getCart(session);
			buyItem=cart.getBuyPros();
			total=cart.cost();
			User user=(User)session.get("user");
			OrderService service=new OrderServiceImpl();
			address.setUserId(user.getId());
			order.setUserId(user.getId());
			order.setTotalPrice(total);
			
			service.save(address);
			
			
			int orderId=service.createOrder(address, order);
			order.setId(orderId);  
			service.createOrderItem(orderId, buyItem);
			
			session.put("cart",	null);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "success";
	}
	public String loadAddress()throws Exception{
		User user=(User)session.get("user");
		AddressDAO dao=new AddressDAOImpl();
		addresses=dao.findByUserId(user.getId());
		return "success";
	}
	public String loadInfo()throws Exception{
		AddressDAO dao=new AddressDAOImpl();
		address=dao.findById(id);
		return "success";
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public int getId() {
		return id;
	}
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	
	
	
}
