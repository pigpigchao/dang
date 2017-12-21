package com.tarena.dang.action.main;

import java.util.ArrayList;
import java.util.List;

import com.tarena.dang.dao.CategoryDAO;
import com.tarena.dang.dao.impl.CategoryDAOImpl;
import com.tarena.dang.entity.Category;

public class CategoryAction {
	//input 无
	//output
	private List<Category> cats=new ArrayList<Category>();//存小说，青春等大类别
	
	public List<Category> getCats() {
		return cats;
	}
	public void setCats(List<Category> cats) {
		this.cats = cats;
	}
	public String execute()throws Exception{
		//查询d-category，获取类别信息
		CategoryDAO catDao=new CategoryDAOImpl();
		List<Category> all=catDao.findAll();
		//将parenetId=1的大类别取出给cats
		cats=findByParent(all,1);
		//将其他子类别parentetId=2取出给cats中的subCats
		for(Category c:cats){
			List<Category> subCats=findByParent(all,c.getId());
			c.setSubCats(subCats);//将集合设置当前类别的subCats
		}
		return "success";
	}
	/**
	 * 按parentId作条件查找子类别集合
	 * @param all
	 * @param parentId
	 * @return
	 */
	public List<Category> findByParent(List<Category> all,int parentId){
		List<Category> list=new ArrayList<Category>();
		//循环所有类别对象,如果parentId等于查找值，将结果集放到list中
		for(Category c:all){
			if(c.getParentId()==parentId){
				list.add(c);
			}
		}
		return list;
	}
}
