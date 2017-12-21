package com.tarena.dang.dao;

import com.tarena.dang.entity.User;

public interface UserDAO {
	public void save(User user)throws Exception;
	public User  findByEmail(String email)throws Exception;
	public void updateVerifyInfo(int id)throws Exception;
	public void updateLoginInfo(String ip,long time,String email)throws Exception;
}
