package com.dang.action.user;

import com.dang.dao.UserDAO;
import com.dang.dao.impl.UserDAOImpl;
import com.dang.entity.User;

public class CheckemailAction {
	private boolean ok=false;
	private String email;
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String execute()throws Exception{
		UserDAO dao=new UserDAOImpl();
		User user= dao.findByEmail(email);
		if(user==null){
			ok=true;
		}else{
			ok=false;
		}
		return "success";
	}
}
