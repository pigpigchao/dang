package com.dang.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dang.dao.CategoryDAO;
import com.dang.entity.Category;
import com.dang.util.DBUtil;

public class CategoryDAOImpl implements CategoryDAO{

	public List<Category> findAll() throws Exception {
		List<Category> list=new ArrayList<Category>();
		String sql="select * from d_category order by turn";
		PreparedStatement prep=DBUtil.getConnection().prepareStatement(sql);
		ResultSet rs=prep.executeQuery();
		while(rs.next()){
			Category c=new Category();
			c.setDescription(rs.getString("description"));
			c.setTurn(rs.getInt("turn"));
			c.setId(rs.getInt("id"));
			c.setEnName(rs.getString("en_name"));
			c.setName(rs.getString("name"));
			c.setParentId(rs.getInt("parent_id"));
			list.add(c);
		}
		return list;
	}

	public List<Category> findByParentId(int pid) throws Exception {
		List<Category> list=new ArrayList<Category>();
		StringBuffer sql=new StringBuffer();
		sql.append("select  dc.*,count(dcp.product_id) as pnum ");
		sql.append("from d_category dc  ");
		sql.append("left outer join d_category_product dcp  ");
		sql.append("on (dc.id=dcp.cat_id) ");
		sql.append("where dc.parent_id=? ");
		sql.append("group by dc.id ");
		sql.append("order by dc.turn");
		
		PreparedStatement prep=DBUtil.getConnection().prepareStatement(sql.toString());
		prep.setInt(1, pid);
		ResultSet rs=prep.executeQuery();
		while(rs.next()){
			Category c=new Category();
			c.setDescription(rs.getString("description"));
			c.setId(rs.getInt("id"));
			c.setEnName(rs.getString("en_name"));
			c.setName(rs.getString("name"));
			c.setParentId(rs.getInt("parent_id"));
			c.setTurn(rs.getInt("turn"));
			c.setPnum(rs.getInt("pnum"));
			list.add(c);
		}
		return list;		
	}
}
