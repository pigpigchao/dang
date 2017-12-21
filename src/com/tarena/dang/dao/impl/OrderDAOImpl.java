package com.tarena.dang.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;
import com.tarena.dang.dao.OrderDAO;
import com.tarena.dang.entity.CartItem;
import com.tarena.dang.entity.Order;
import com.tarena.dang.entity.Product;
import com.tarena.dang.util.DBUtil;

public class OrderDAOImpl implements OrderDAO{

	public int  save(Order order) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into d_order");
		sql.append("(user_id,status,order_time,order_desc,total_price,receive_name,");
		sql.append("full_address ,postal_code,mobile,phone) ");
		sql.append("values(?,?,?,?,?,?,?,?,?,?)");
		PreparedStatement stmt = DBUtil.getConnection().prepareStatement(
				sql.toString(), Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, order.getUserId());
		stmt.setInt(2, order.getStatus());
		stmt.setLong(3, order.getOrderTime());
		stmt.setString(4, order.getOrderDesc());
		stmt.setDouble(5, order.getTotalPrice());
		stmt.setString(6, order.getReceiveName());
		stmt.setString(7, order.getFullAddress());
		stmt.setString(8, order.getPostalCode());
		stmt.setString(9, order.getMobile());
		stmt.setString(10, order.getPhone());
		stmt.executeUpdate();
		ResultSet rs=stmt.getGeneratedKeys();
		int id=0;
		if(rs.next()){
			id=rs.getInt(1);
		}
		return id;
	}

	public void insertItem(int orderId, CartItem item)
			throws Exception {
		Product p=item.getProduct();
		StringBuffer sql=new StringBuffer();
		sql.append("insert into d_item ");
		sql.append("(order_id,product_id,product_name,dang_price,product_num,amount) ");
		sql.append("value(?,?,?,?,?,?)");
		PreparedStatement stmt = DBUtil.getConnection().prepareStatement(
				sql.toString());
		stmt.setInt(1, orderId);
		stmt.setInt(2, p.getId());
		stmt.setString(3, p.getProductName());
		stmt.setDouble(4, p.getDangPrice());
		stmt.setInt(5,item.getQty());
		stmt.setDouble(6, p.getDangPrice()*item.getQty());
		stmt.execute();
	}
	
}
