package com.dang.action.user;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class ExitAction {
	public String execute(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "success";
	}
}
