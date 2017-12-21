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
	private int cid;//��ǰ���ID
	private int pid;//cid�ĸ�id
	private int cturn;
	private int orderBy;
	//private int pnum;
	//output
	private String cname;//��ǰ�������� 
	private List<Category> cats;//�����ʾ���
	private List<Product> pros;//�Ҳ�ͼ����ʾ
	private int totalnum;//����Ʒ�����ĺϼ�
	private int page=1;//��ʾ�ڼ�ҳĬ�ϵ�һҳ
	//����ע��
	private int size=3;//ÿҳ��ʾ3����¼
	private int maxPage=1;//Ĭ�����ҳ����Ϊ1
	
	public String execute()throws Exception{
		//�������������,��ѯcats,pros������Ϣ
		//����pid��ѯcats��Ϣ
		CategoryDAO catDao=new CategoryDAOImpl();
		cats=catDao.findByParentId(pid);
		//ͳ��cats����и���Ԫ�ص�pnumֵ
		 
		for(Category c:cats){
			totalnum+=c.getPnum();
		}
		cname=cats.get(cturn-1).getName();
		//pname=cats.get().getName();
		//����cid��ѯpros������Ϣ
		ProductDAO proDao=new ProductDAOImpl();
		
		pros=proDao.findByCatId(cid, page, size,orderBy);
		
		int num=proDao.findByCatId(cid);
		
		//num=pnum;
		if(num%size==0){
			maxPage=num/size;
		}else{
			maxPage=num/size+1;
		}
		
		return "success";//���ص�book_list.jsp��
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
