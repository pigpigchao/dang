package com.tarena.dang.action.main;

import java.util.ArrayList;
import java.util.List;

import com.tarena.dang.dao.CategoryDAO;
import com.tarena.dang.dao.impl.CategoryDAOImpl;
import com.tarena.dang.entity.Category;

public class CategoryAction {
	//input ��
	//output
	private List<Category> cats=new ArrayList<Category>();//��С˵���ഺ�ȴ����
	
	public List<Category> getCats() {
		return cats;
	}
	public void setCats(List<Category> cats) {
		this.cats = cats;
	}
	public String execute()throws Exception{
		//��ѯd-category����ȡ�����Ϣ
		CategoryDAO catDao=new CategoryDAOImpl();
		List<Category> all=catDao.findAll();
		//��parenetId=1�Ĵ����ȡ����cats
		cats=findByParent(all,1);
		//�����������parentetId=2ȡ����cats�е�subCats
		for(Category c:cats){
			List<Category> subCats=findByParent(all,c.getId());
			c.setSubCats(subCats);//���������õ�ǰ����subCats
		}
		return "success";
	}
	/**
	 * ��parentId��������������𼯺�
	 * @param all
	 * @param parentId
	 * @return
	 */
	public List<Category> findByParent(List<Category> all,int parentId){
		List<Category> list=new ArrayList<Category>();
		//ѭ������������,���parentId���ڲ���ֵ����������ŵ�list��
		for(Category c:all){
			if(c.getParentId()==parentId){
				list.add(c);
			}
		}
		return list;
	}
}
