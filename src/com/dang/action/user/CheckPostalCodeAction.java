package com.dang.action.user;

import com.dang.action.BaseAction;
import com.dang.dao.UserDAO;
import com.dang.dao.impl.UserDAOImpl;
import com.dang.entity.User;

public class CheckPostalCodeAction extends BaseAction{
	private String code;
	private String email;
	private User user;
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String execute()throws Exception{
		String[] codes=code.split("/");
		UserDAO userdao=new UserDAOImpl();
			user=userdao.findByEmail(email);
			if(user.getEmailVerifyCode().equals(codes[0])&&
					user.getId()==Integer.parseInt(codes[1])){
				userdao.updateVerifyInfo(user.getId());
				return "success";
			}else if(user.getEmailVerifyCode()==null){
				msg="邮箱验证码不能为空";
				session.put("msg", msg);
				return "fail";
			}
			else{
				msg="邮箱验证码错误";
				session.put("msg", msg);
				return "fail";
			}
	}
}
