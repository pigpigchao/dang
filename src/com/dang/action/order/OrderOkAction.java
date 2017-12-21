package com.dang.action.order;

import org.apache.struts2.ServletActionContext;

import com.dang.action.BaseAction;
import com.dang.dao.AddressDAO;
import com.dang.dao.impl.AddressDAOImpl;
import com.dang.entity.Address;
import com.dang.entity.Order;
import com.dang.entity.User;
import com.dang.service.CartFactory;
import com.dang.service.CartService;
import com.dang.service.OrderService;
import com.dang.service.impl.OrderServiceImpl;
import com.dang.util.CookieUtil;

public class OrderOkAction extends BaseAction{
	//input
	private int addressId;
	private Address address;
	//output
	private Order order=new Order();
	private double total;
	
	public String execute() throws Exception{
		CartService cart=CartFactory.getCart(session);
		if(cart.getBuyPros().size()==0){
			return "main";
		}
		User user=(User)session.get("user");
		OrderService service=new OrderServiceImpl();
		address.setUserId(user.getId());
		AddressDAO adao=new AddressDAOImpl();
		try {
			total=cart.cost();
			Address add=adao.findById(addressId);
			if(add==null||!address.equals(add)){
			service.save(address);
			}else{
				System.out.println("地址已经存在");
			}
			order.setUserId(user.getId());
			order.setTotalPrice(total);
			int orderId=service.createOrder(address, order);
			order.setId(orderId);  
			service.createOrderItem(orderId, cart.getBuyPros());
			//清空
			CookieUtil.deleteCookie("cart"+user.getId(), ServletActionContext.getResponse());
			session.put("cart",	null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
