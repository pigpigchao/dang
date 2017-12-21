package com.tarena.dang.action.user;

import com.tarena.dang.action.BaseAction;
import com.tarena.dang.dao.UserDAO;
import com.tarena.dang.dao.impl.UserDAOImpl;
import com.tarena.dang.entity.User;
import com.tarena.dang.util.Constant;
import com.tarena.dang.util.EmailUtil;
import com.tarena.dang.util.VerifyUtil;

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
	 * ע�ᴦ��
	 */
	public String execute()throws Exception{
		//������֤��
		String uuid=VerifyUtil.createUUID();
		//�ѷǱ���������Ϣ
		user.setUserIntegral(Constant.NORMAL);
		user.setIsEmailVerify("N");
		user.setEmailVerifyCode(uuid);
		user.setLastLoginTime(System.currentTimeMillis());
		user.setLastLoginIp(httpRequest.getRemoteAddr());
		//-------------------------------
		UserDAO userDao=new UserDAOImpl();
		userDao.save(user);
		session.put("user", user);
		//����uuid-userId��ʽ����֤��,���ʼ�
		code=uuid+"/"+user.getId()+"/";
		EmailUtil.send(user.getEmail(),code);
		
		return "verify";
	}
}
