package com.tarena.dang.action;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class BaseAction implements SessionAware,ServletRequestAware{
	
	protected HttpServletRequest httpRequest;
	protected Map<String,Object> session;
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public void setServletRequest(HttpServletRequest arg0) {
		this.httpRequest=arg0;
	}
	
}
