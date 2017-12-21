package com.tarena.dang.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Statement;
import com.tarena.dang.dao.UserDAO;
import com.tarena.dang.entity.User;
import com.tarena.dang.util.DBUtil;

public class UserDAOImpl implements UserDAO{

	public void save(User user) throws Exception {
		String sql="insert into d_user" +
				"(email,nickname,password,user_integral,is_email_verify,email_verify_code," +
				"last_login_time,last_login_ip) values(?,?,?,?,?,?,?,?)";
		PreparedStatement prep=DBUtil.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		prep.setString(1, user.getEmail());
		prep.setString(2, user.getNickname());
		prep.setString(3, user.getPassword());
		prep.setInt(4, user.getUserIntegral());
		prep.setString(5,user.getIsEmailVerify());
		prep.setString(6, user.getEmailVerifyCode());
		prep.setLong(7, user.getLastLoginTime());
		prep.setString(8, user.getLastLoginIp());
		prep.executeUpdate();
		//获得自增长的id
		ResultSet rs=prep.getGeneratedKeys();
		rs.next();
		int id=rs.getInt(1);
		user.setId(id);
		//不写关闭conn,放到拦截器中
	}

	public User findByEmail(String email) throws Exception {
		String sql="select * from d_user where email=?";
		PreparedStatement prep=DBUtil.getConnection().prepareStatement(sql);
		prep.setString(1, email);
		ResultSet rs=prep.executeQuery();
		User user=null;
		if(rs.next()){
			user=new User();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setNickname(rs.getString("nickname"));
			user.setEmailVerifyCode(rs.getString("email_verify_code"));
			user.setIsEmailVerify(rs.getString("is_email_verify"));
			user.setLastLoginIp(rs.getString("last_login_ip"));
			user.setLastLoginTime(rs.getLong("last_login_time"));
			user.setUserIntegral(rs.getInt("user_integral"));
			user.setPassword(rs.getString("password"));
		}
		return user;
	}
	public void updateVerifyInfo(int id) throws Exception{
		String sql="update d_user set is_email_verify='Y' where id=? ";
		PreparedStatement prep=DBUtil.getConnection().prepareStatement(sql);
		prep.setInt(1,id);
		prep.executeUpdate();
	}

	public void updateLoginInfo(String ip, long time,String email) throws Exception {
		String sql="update d_user set last_login_ip=?,last_login_time=? where email=?";
		PreparedStatement prep=DBUtil.getConnection().prepareStatement(sql);
		prep.setString(1, ip);
		prep.setLong(2, time);
		prep.setString(3, email);
		prep.executeUpdate();
		
	}
	
}
