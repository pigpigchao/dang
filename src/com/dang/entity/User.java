package com.dang.entity;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * d_user��
 * @author soft02
 *
 */
public class User implements Serializable{
	private int id;
	private String email;
	private String nickname;
	private String password;
	private int userIntegral;//�û��ȼ�
	private String isEmailVerify;
	private String emailVerifyCode;
	private long lastLoginTime;//�����ݿ���ʾ��ʱ����һ��intֵ��ת��getFormatLastLoginTime()
	private String lastLoginIp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserIntegral() {
		return userIntegral;
	}
	public void setUserIntegral(int userIntegral) {
		this.userIntegral = userIntegral;
	}
	public String getIsEmailVerify() {
		return isEmailVerify;
	}
	public void setIsEmailVerify(String isEmailVerify) {
		this.isEmailVerify = isEmailVerify;
	}
	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}
	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}
	
	public long getLastLoginTime() {
		return lastLoginTime;
	}
	public String getFormatLastLoginTime() {
		Date date=new Date(lastLoginTime);
		date.setTime(lastLoginTime);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
		return sdf.format(date); 
	}
	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	
}
