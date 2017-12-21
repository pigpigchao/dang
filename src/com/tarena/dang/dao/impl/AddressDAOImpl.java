package com.tarena.dang.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dang.dao.AddressDAO;
import com.tarena.dang.entity.Address;
import com.tarena.dang.util.DBUtil;

public class AddressDAOImpl implements AddressDAO{

	public void save(Address address) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into d_receive_address");
		sql.append("(user_id,receive_name,full_address,postal_code,mobile,phone)");
		sql.append("values(?,?,?,?,?,?)");
		PreparedStatement stmt = DBUtil.getConnection().prepareStatement(sql.toString());
		stmt.setInt(1, address.getUserId());
		stmt.setString(2, address.getReceiveName());
		stmt.setString(3, address.getFullAddress());
		stmt.setString(4, address.getPostalCode());
		stmt.setString(5, address.getMobile());
		stmt.setString(6, address.getPhone());
		stmt.executeUpdate();
	}

	public Address findById(int addressId) throws Exception {
		Address a=null;
		String sql="select * from d_receive_address where id=?";
		PreparedStatement stmt=DBUtil.getConnection().prepareStatement(sql);
		stmt.setInt(1, addressId);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			a=new Address();
			a.setId(rs.getInt("id"));
			a.setUserId(rs.getInt("user_id"));
			a.setReceiveName(rs.getString("receive_name"));
			a.setFullAddress(rs.getString("full_address"));
			a.setPhone(rs.getString("phone"));
			a.setMobile(rs.getString("mobile"));
			a.setPostalCode(rs.getString("postal_code"));
		}
		return a;
	}

	public List<Address> findByUserId(int userId) throws Exception {
		List<Address> list = new ArrayList<Address>();
		String sql = "select * from d_receive_address where user_id=?";
		PreparedStatement stmt = DBUtil.getConnection().prepareStatement(sql);
		stmt.setInt(1, userId);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			Address a = new Address();
			a.setId(rs.getInt("id"));
			a.setUserId(rs.getInt("user_id"));
			a.setReceiveName(rs.getString("receive_name"));
			a.setFullAddress(rs.getString("full_address"));
			a.setPhone(rs.getString("phone"));
			a.setMobile(rs.getString("mobile"));
			a.setPostalCode(rs.getString("postal_code"));
			list.add(a);
		}
		return list;
		
	}
	
}
