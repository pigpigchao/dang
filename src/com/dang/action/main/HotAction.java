package com.dang.action.main;

import java.util.List;

import com.dang.dao.ProductDAO;
import com.dang.dao.impl.ProductDAOImpl;
import com.dang.entity.Product;

public class HotAction {
	//input
	//output
	private List<Product> pros;

	public List<Product> getPros() {
		return pros;
	}

	public void setPros(List<Product> pros) {
		this.pros = pros;
	}
	public String execute()throws Exception{
		ProductDAO proDao=new ProductDAOImpl();
		pros=proDao.findHot();
		return "success";
	}
}
