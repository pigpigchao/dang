package com.dang.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dang.dao.ProductDAO;
import com.dang.dao.impl.ProductDAOImpl;
import com.dang.entity.CartItem;
import com.dang.entity.Product;
import com.dang.service.CartService;

public class CartServiceImpl implements CartService{
	private List<CartItem> items=new ArrayList<CartItem>();

	public void add(int id) throws SQLException {
		//�ж��Ƿ���
		
		for(CartItem item:items){
			if(item.getProduct().getId()==id){
				//�ѹ���������1
				if(item.isBuy()){
					int qty=item.getQty()+1;
					item.setQty(qty);
				}else{
					item.setQty(1);
					item.setBuy(true);
				}
				return;
			}
		}
			//δ�������CartItem
			CartItem item =new CartItem();
			ProductDAO proDao=new ProductDAOImpl();
			Product pro=proDao.findById(id);
			item.setProduct(pro);
			item.setBuy(true);
			item.setQty(1);
			items.add(item);
	}
	public double saveMoney()throws SQLException{
		double sm=0;
		for(CartItem item:items){
			if(item.isBuy()){
				sm+=(item.getProduct().getFixedPrice()-
				item.getProduct().getDangPrice())*item.getQty();
			}
		}
		return sm;
	}
	public double cost() throws SQLException {
		//ͳ��ȷ�Ϲ�����Ʒ���ܼ۸�
		double totalPrice= 0;
		for(CartItem item:items){
			if(item.isBuy()){
				totalPrice+=item.getProduct().getDangPrice()*item.getQty();
			}
		}
		return totalPrice;
	}

	public void delete(int id) throws SQLException {
		//cartItem��buy��������Ϊfalse
		for(CartItem item:items){
			if(item.getProduct().getId()==id){
				item.setBuy(false);
			}
		}
			
	}

	public List<CartItem> getDeletePros() throws SQLException {
		// items������buy����Ϊfalse�ķ���
		List<CartItem> list=new ArrayList<CartItem>();
		for(CartItem item:items){
			if(!item.isBuy()){
				list.add(item);
			}
		}
		return list;
	}

	public List<CartItem> getBuyPros() throws SQLException {
		//items������buy����Ϊture�ķ���
		List<CartItem> list=new ArrayList<CartItem>();
		for(CartItem item:items){
			if(item.isBuy()){
				list.add(item);
			}
		}
		return list;
	}

	public void recovery(int id) throws SQLException {
		// ��CartItem��Ӧ��buy��������Ϊtrue
		for(CartItem item:items){
			if(item.getProduct().getId()==id){
				item.setBuy(true);
			}
		}
		
	}

	public void update(int id, int pnum) throws SQLException {
		// ��CartItem��Ӧ��qty��������Ϊpnum
		for(CartItem item:items){
			if(item.getProduct().getId()==id){
				item.setQty(pnum);
			}
		}
		
	}
	public String store() {
		StringBuffer sb=new StringBuffer();
		if(items.size()==0){
			sb.append("0");
		}else{
			for(int i=0;i<items.size();i++){
				CartItem curr=items.get(i);
				sb.append(curr.getProduct().getId()+","+curr.getQty()+";");
			}
			}
		if(sb.length()>1){
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
	public void load(String content) {
		if(content==null||content=="0"){
			return ;
		}
		String[]  pcs=content.split(";");
		for(int i=0;i<pcs.length;i++){
			String pc=pcs[i];
			String[] strs=pc.split(",");
			int id=Integer.parseInt(strs[0]);
			int qty=Integer.parseInt(strs[1]);
			ProductDAO dao=new  ProductDAOImpl();
			try{
				Product p=dao.findById(id);
				CartItem item=new CartItem();
				item.setProduct(p);
				item.setQty(qty);
				items.add(item);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
}
