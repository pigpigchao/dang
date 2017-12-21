package com.dang.action.user;

import com.dang.action.BaseAction;
import com.dang.dao.UserDAO;
import com.dang.dao.impl.UserDAOImpl;
import com.dang.entity.User;
import com.dang.util.Constant;
import com.dang.util.EmailUtil;
import com.dang.util.VerifyUtil;

public class RegistAction extends BaseAction{
	//input
	private User user;
	//output
	private String code;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 注册处理
	 */
	public String execute()throws Exception{
		//生成验证码
		String uuid=VerifyUtil.createUUID();
		//把非表单项设置信息
		user.setUserIntegral(Constant.NORMAL);
		user.setIsEmailVerify("N");
		user.setEmailVerifyCode(uuid);
		user.setLastLoginTime(System.currentTimeMillis());
		user.setLastLoginIp(httpRequest.getRemoteAddr());
		//-------------------------------
		UserDAO userDao=new UserDAOImpl();
		userDao.save(user);
		session.put("user", user);
		//生成uuid-userId格式的验证码,发邮件
		code=uuid+"/"+user.getId()+"/";
		EmailUtil.send(user.getEmail(),code);
		
		return "verify";
	}
}
