package com.dang.entity;

public class Address {
	private int id;
	private int userId;
	private String receiveName;
	private String fullAddress;
	private String postalCode;
	private String mobile;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean equals(Address add){
		if(add==null){
			return false;
		}if(this==add){
			return true;
		}if(add instanceof Address){
			Address a=(Address)add;
			return this.receiveName.equals(a.getReceiveName())&&
			this.fullAddress.equals(a.getFullAddress())&&
			this.postalCode.equals(a.getPostalCode())&&
			this.phone.equals(a.getPhone())&&
			this.mobile.equals(a.getMobile());
		}return false;
	}
	
}
