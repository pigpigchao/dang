package com.tarena.dang.service;

import java.sql.SQLException;
import java.util.List;

import com.tarena.dang.entity.CartItem;

public interface CartService {
	//购买
	public void add(int id)throws SQLException;
	//删除
	public void delete(int id)throws SQLException;
	//恢复
	public void recovery(int id)throws SQLException;
	//变更数量
	public void update(int id,int pnum)throws SQLException;
	//查看确认购买
	public List<CartItem> getBuyPros()throws SQLException;
	//查看取消购买
	public List<CartItem> getDeletePros()throws SQLException;
	//统计确认购买
	public double cost()throws SQLException;
	//统计节省金额
	public double saveMoney()throws SQLException;
	//保存到Cookie
	public String store();
	//从cookie读取
	public void load(String content);
}
