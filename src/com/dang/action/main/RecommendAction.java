package com.dang.action.main;

import java.util.ArrayList;
import java.util.List;

import com.dang.dao.ProductDAO;
import com.dang.dao.impl.ProductDAOImpl;
import com.dang.entity.Product;

public class RecommendAction {
	//input
	private int recommendNum=2;
	//output
	private List<Product> books=new ArrayList<Product>();
	
	public int getRecommendNum() {
		return recommendNum;
	}

	public void setRecommendNum(int recommendNum) {
		this.recommendNum = recommendNum;
	}

	public List<Product> getBooks() {
		return books;
	}

	public void setBooks(List<Product> books) {
		this.books = books;
	}
	public String execute()throws Exception{
		ProductDAO proDao=new ProductDAOImpl();
		books=proDao.findRecommend(recommendNum);
		return "success";
	}
}
