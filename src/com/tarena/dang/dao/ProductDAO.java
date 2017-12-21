package com.tarena.dang.dao;

import java.sql.SQLException;
import java.util.List;

import com.tarena.dang.entity.Product;

public interface ProductDAO {
	public List<Product> findNew() throws Exception;
	public List<Product> findByCatId(int cid,int page,int size,int orderBy)throws Exception;

	public int findByCatId(int cid)throws Exception;
	public List<Product> findRecommend(int num)throws Exception;
	public List<Product> findHot()throws  Exception;
	public Product findById(int id)throws SQLException;
}
