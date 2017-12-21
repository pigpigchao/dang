package com.tarena.dang.action.main;

import java.util.ArrayList;
import java.util.List;

import com.tarena.dang.dao.ProductDAO;
import com.tarena.dang.dao.impl.ProductDAOImpl;
import com.tarena.dang.entity.Product;

public class NewAction {
	//input
	//output
	private List<Product> pros=new ArrayList<Product>();
	public List<Product> getPros() {
		return pros;
	}
	public void setPros(List<Product> pros) {
		this.pros = pros;
	}
	public String execute()throws Exception{
		ProductDAO proDao=new ProductDAOImpl();
		pros=proDao.findNew();
		return "success";
	}
}
