package com.dang.action.main;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.dang.dao.CategoryDAO;
import com.dang.dao.ProductDAO;
import com.dang.dao.impl.CategoryDAOImpl;
import com.dang.dao.impl.ProductDAOImpl;
import com.dang.entity.Category;
import com.dang.entity.Product;

public class BookListAction {
	//input
	private int cid;//当前类别ID
	private int pid;//cid的父id
	private int cturn;
	private int orderBy;
	//private int pnum;
	//output
	private String cname;//当前类别的名字 
	private List<Category> cats;//左侧显示类别
	private List<Product> pros;//右侧图书显示
	private int totalnum;//类别产品数量的合计
	private int page=1;//显示第几页默认第一页
	//属性注入
	private int size=3;//每页显示3条记录
	private int maxPage=1;//默认最大页面数为1
	
	public String execute()throws Exception{
		//根据请求传入参数,查询cats,pros集合信息
		//利用pid查询cats信息
		CategoryDAO catDao=new CategoryDAOImpl();
		cats=catDao.findByParentId(pid);
		//统计cats类别中各个元素的pnum值
		 
		for(Category c:cats){
			totalnum+=c.getPnum();
		}
		cname=cats.get(cturn-1).getName();
		//pname=cats.get().getName();
		//利用cid查询pros集合信息
		ProductDAO proDao=new ProductDAOImpl();
		
		pros=proDao.findByCatId(cid, page, size,orderBy);
		
		int num=proDao.findByCatId(cid);
		
		//num=pnum;
		if(num%size==0){
			maxPage=num/size;
		}else{
			maxPage=num/size+1;
		}
		
		return "success";//返回到book_list.jsp中
	}
	
	public int getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}

	public int getTotalnum() {
		return totalnum;
	}
	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public List<Category> getCats() {
		return cats;
	}
	public void setCats(List<Category> cats) {
		this.cats = cats;
	}
	public List<Product> getPros() {
		return pros;
	}
	public void setPros(List<Product> pros) {
		this.pros = pros;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
	public String getCname() {
		return cname;
	}
	
	public int getCturn() {
		return cturn;
	}
	public void setCturn(int cturn) {
		this.cturn = cturn;
	}
	public void setCname(String cname) {
		try {
			cname = new String(cname.getBytes("iso8599-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.cname = cname;
	}

	
	//	public int getPnum() {
//		return pnum;
//	}
//	public void setPnum(int pnum) {
//		this.pnum = pnum;
//	}
}
