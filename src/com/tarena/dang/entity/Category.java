package com.tarena.dang.entity;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private int id;
	private int turn;
	private String enName;
	private String name;
	private String description;
	private int parentId;
	
	//追加属性,用于存储子类别
	private List<Category> subCats=new ArrayList<Category>();
	//追加属性 用于存储所包含的产品数量
	private int pnum;
	
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public List<Category> getSubCats() {
		return subCats;
	}
	public void setSubCats(List<Category> subCats) {
		this.subCats = subCats;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
}
