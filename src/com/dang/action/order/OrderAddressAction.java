package com.dang.action.order;

import java.util.List;

import com.dang.action.BaseAction;
import com.dang.dao.AddressDAO;
import com.dang.dao.impl.AddressDAOImpl;
import com.dang.entity.Address;
import com.dang.entity.User;

public class OrderAddressAction extends BaseAction{
	//input
	private int addressId;
	//output
	private List<Address> addresses;
	private Address address;
	public String loadAddress()throws Exception{
		User user=(User)session.get("user");
		AddressDAO dao=new AddressDAOImpl();
		try {
			if(user!=null){

				addresses=dao.findByUserId(user.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String loadInfo()throws Exception{
		AddressDAO dao=new AddressDAOImpl();
		try {
			address=dao.findById(addressId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
