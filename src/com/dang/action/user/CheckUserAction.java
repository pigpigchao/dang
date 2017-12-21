package com.dang.action.user;

import java.sql.Date;

import com.dang.action.BaseAction;
import com.dang.dao.UserDAO;
import com.dang.dao.impl.UserDAOImpl;
import com.dang.entity.User;

public class CheckUserAction extends BaseAction{
	private String name;//” œ‰µÿ÷∑
	private String password;//√‹¬Î
	private String msg;
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute()throws Exception{
		UserDAO dao=new UserDAOImpl();
		user=dao.findByEmail(name);
		if(user==null){
			msg="∏√” œ‰ªπ√ª◊¢≤·";
			return "login";
		}else if(user.getPassword().equals(password)){
			session.put("user", user);
			if(user.getIsEmailVerify().equals("Y")){
				long loginTime=System.currentTimeMillis();
				String loginIp=httpRequest.getRemoteAddr();
				dao.updateLoginInfo(loginIp, loginTime, user.getEmail());
				return "main";
			}else {
				return "verify";
			}
		}else{
			msg="” œ‰ªÚ√‹¬Î¥ÌŒÛ";
			return "login";
		}
	}
}
