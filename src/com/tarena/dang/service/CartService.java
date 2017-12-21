package com.tarena.dang.service;

import java.sql.SQLException;
import java.util.List;

import com.tarena.dang.entity.CartItem;

public interface CartService {
	//����
	public void add(int id)throws SQLException;
	//ɾ��
	public void delete(int id)throws SQLException;
	//�ָ�
	public void recovery(int id)throws SQLException;
	//�������
	public void update(int id,int pnum)throws SQLException;
	//�鿴ȷ�Ϲ���
	public List<CartItem> getBuyPros()throws SQLException;
	//�鿴ȡ������
	public List<CartItem> getDeletePros()throws SQLException;
	//ͳ��ȷ�Ϲ���
	public double cost()throws SQLException;
	//ͳ�ƽ�ʡ���
	public double saveMoney()throws SQLException;
	//���浽Cookie
	public String store();
	//��cookie��ȡ
	public void load(String content);
}
