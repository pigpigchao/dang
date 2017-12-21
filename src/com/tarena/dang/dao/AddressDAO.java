package com.tarena.dang.dao;

import java.util.List;

import com.tarena.dang.entity.Address;

public interface AddressDAO {
	public void save(Address address)throws Exception;
	public List<Address> findByUserId(int userId)throws Exception;
	public Address findById(int addressId)throws Exception;
}
