package com.tarena.dang.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dang.dao.ProductDAO;
import com.tarena.dang.entity.Book;
import com.tarena.dang.entity.Product;
import com.tarena.dang.util.DBUtil;

public class ProductDAOImpl implements ProductDAO{

	public List<Product> findNew() throws Exception {
		List<Product> list=new ArrayList<Product>();
		String sql="select * from d_product where has_deleted=0 " +
				"order by add_time desc limit 0,8";
		PreparedStatement prep=DBUtil.getConnection().prepareStatement(sql);
		ResultSet rs=prep.executeQuery();
		while(rs.next()){
			Product p=new Product();
			p.setId(rs.getInt("id"));
			p.setProductName(rs.getString("product_name"));
			p.setDescription(rs.getString("description"));
			p.setAddTime(rs.getLong("add_time"));
			p.setDangPrice(rs.getDouble("dang_price"));
			p.setFixedPrice(rs.getDouble("fixed_price"));
			p.setKeywords(rs.getString("keywords"));
			p.setHasdDeleted(rs.getInt("has_deleted"));
			p.setProductPic(rs.getString("product_pic"));
			list.add(p);
			
		}
		
		return list;
	}

	
	
	public List<Product> findByCatId(int cid, int page, int size,int orderBy)
			throws Exception {
			List<Product> list=new ArrayList<Product>();
			StringBuffer sql=new StringBuffer();
			String order=null;
			if(orderBy==0){
				order="order by add_time desc	";
			}else if(orderBy==1){
				order="order by add_time asc	";
			}else if(orderBy==2){
				order="order by dang_price desc	";
			}else if(orderBy==3){
				order="order by dang_price asc	";
			}
			sql.append("select 	dp.*,db.* ");
			sql.append("from d_category_product dcp "); 
			sql.append("join d_product dp on(dcp.product_id=dp.id) ");
			sql.append("join d_book db on(dp.id=db.id) ");
			sql.append("where dcp.cat_id=? ");
			sql.append(order);
			sql.append("limit ?,?");
			PreparedStatement prep=DBUtil.getConnection().prepareStatement(sql.toString());
			prep.setInt(1, cid);
			prep.setInt(2, (page-1)*size);
			prep.setInt(3, size);
			ResultSet rs=prep.executeQuery();
			while(rs.next()){
				Book b=new Book();
				b.setId(rs.getInt("id"));
				b.setProductName(rs.getString("product_name"));
				b.setDescription(rs.getString("description"));
				b.setAddTime(rs.getLong("add_time"));
				b.setDangPrice(rs.getDouble("dang_price"));
				b.setFixedPrice(rs.getDouble("fixed_price"));
				b.setKeywords(rs.getString("keywords"));
				b.setHasdDeleted(rs.getInt("has_deleted"));
				b.setProductPic(rs.getString("product_pic"));
				b.setAuthor(rs.getString("author"));
				b.setPublishing(rs.getString("publishing"));
				b.setPublishTime(rs.getLong("publish_time"));
				b.setWordNumber(rs.getString("which_edtion"));
				b.setTotalPage(rs.getString("total_page"));
				b.setPrintTime(rs.getInt("print_time"));
				b.setPrintNumner(rs.getString("print_number"));
				b.setIsbn(rs.getString("isbn"));
				b.setAuthorSummary(rs.getString("author_summary"));
				b.setCatalogue(rs.getString("catalogue"));
				list.add(b);
			}
			return list;
			}

	public int findByCatId(int cid) throws Exception {
		int num=0;
		StringBuffer sql=new StringBuffer();
		sql.append("select  count(dcp.product_id) as pnum ");
		sql.append("from d_category dc  ");
		sql.append("left outer join d_category_product dcp  ");
		sql.append("on (dc.id=dcp.cat_id) ");
		sql.append("where dcp.cat_id=? ");
		sql.append("group by dc.id ");
		sql.append("order by dc.turn");
		PreparedStatement prep=DBUtil.getConnection().prepareStatement(sql.toString());
		prep.setInt(1, cid);
		ResultSet rs=prep.executeQuery();
		if(rs.next()){
			num=rs.getInt(1);
		}
		return num;
	}

	public List<Product> findRecommend(int num) throws Exception {
		List<Product> list=new ArrayList<Product>();
		String sql="select * from d_book db join d_product dp on(db.id=dp.id) order by rand() limit 0,?";
		PreparedStatement prep=DBUtil.getConnection().prepareStatement(sql);
		prep.setInt(1, num);
		ResultSet rs=prep.executeQuery();
		while(rs.next()){
			Book b=new Book();
			b.setId(rs.getInt("id"));
			b.setProductName(rs.getString("product_name"));
			b.setDescription(rs.getString("description"));
			b.setAddTime(rs.getLong("add_time"));
			b.setDangPrice(rs.getDouble("dang_price"));
			b.setFixedPrice(rs.getDouble("fixed_price"));
			b.setKeywords(rs.getString("keywords"));
			b.setHasdDeleted(rs.getInt("has_deleted"));
			b.setProductPic(rs.getString("product_pic"));
			b.setAuthor(rs.getString("author"));
			b.setPublishing(rs.getString("publishing"));
			b.setPublishTime(rs.getLong("publish_time"));
			b.setWordNumber(rs.getString("which_edtion"));
			b.setTotalPage(rs.getString("total_page"));
			b.setPrintTime(rs.getInt("print_time"));
			b.setPrintNumner(rs.getString("print_number"));
			b.setIsbn(rs.getString("isbn"));
			b.setAuthorSummary(rs.getString("author_summary"));
			b.setCatalogue(rs.getString("catalogue"));
			list.add(b);
		}
		return list;
	}

	public List<Product> findHot() throws Exception {
		List<Product> list=new ArrayList<Product>();
		StringBuffer sql=new StringBuffer();
		sql.append("select dp.*  ");
		sql.append("from d_item di  ");
		sql.append("join d_product dp on(di.product_id=dp.id) ");
		sql.append("group by product_id  ");
		sql.append("order by sum(di.product_num) desc ");
		sql.append("limit 0,8");
		PreparedStatement prep=DBUtil.getConnection().prepareStatement(sql.toString());
		ResultSet rs=prep.executeQuery();
		while(rs.next()){
			Book b=new Book();
			b.setId(rs.getInt("id"));
			b.setProductName(rs.getString("product_name"));
			b.setDescription(rs.getString("description"));
			b.setAddTime(rs.getLong("add_time"));
			b.setDangPrice(rs.getDouble("dang_price"));
			b.setFixedPrice(rs.getDouble("fixed_price"));
			b.setKeywords(rs.getString("keywords"));
			b.setHasdDeleted(rs.getInt("has_deleted"));
			b.setProductPic(rs.getString("product_pic"));
			list.add(b);
		}
		return list;
	}

	public Product findById(int id) throws SQLException {
		Book b=null;
		String sql="select * from d_book db join d_product dp on(db.id=dp.id) where db.id=?";
		PreparedStatement prep=DBUtil.getConnection().prepareStatement(sql);
		prep.setInt(1, id);
		ResultSet rs=prep.executeQuery();
		while(rs.next()){
			b=new Book();
			b.setId(rs.getInt("id"));
			b.setProductName(rs.getString("product_name"));
			b.setDescription(rs.getString("description"));
			b.setAddTime(rs.getLong("add_time"));
			b.setDangPrice(rs.getDouble("dang_price"));
			b.setFixedPrice(rs.getDouble("fixed_price"));
			b.setKeywords(rs.getString("keywords"));
			b.setHasdDeleted(rs.getInt("has_deleted"));
			b.setProductPic(rs.getString("product_pic"));
			b.setAuthor(rs.getString("author"));
			b.setPublishing(rs.getString("publishing"));
			b.setPublishTime(rs.getLong("publish_time"));
			b.setWordNumber(rs.getString("which_edtion"));
			b.setTotalPage(rs.getString("total_page"));
			b.setPrintTime(rs.getInt("print_time"));
			b.setPrintNumner(rs.getString("print_number"));
			b.setIsbn(rs.getString("isbn"));
			b.setAuthorSummary(rs.getString("author_summary"));
			b.setCatalogue(rs.getString("catalogue"));
		}
		
		return b;
	}
}
