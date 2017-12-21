package com.tarena.dang.action.main;

import java.sql.SQLException;

import com.tarena.dang.dao.ProductDAO;
import com.tarena.dang.dao.impl.ProductDAOImpl;
import com.tarena.dang.entity.Product;

public class ShowBookAction {
	//input
	private int id;
	//output
	private Product product;
	public String execute(){
		ProductDAO dao=new  ProductDAOImpl();
		try {
			product=dao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	
}
