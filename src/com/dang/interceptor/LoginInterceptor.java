package com.dang.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	public String intercept(ActionInvocation invocation) throws Exception {
		//判断session中是否有登录信息
		Map<String,Object> session=
			invocation.getInvocationContext().getSession();
//		Map<String,Object> session=
//			ActionContext.getContext().getSession();
		if(session.get("user")==null){
			//未登录跳转到登录界面
			return "login";
		}else{
			//已经登录可以调用Action业务方法
			String resultCode=invocation.invoke();//调用了action和result 
			//拦截器 的后续操作
			return resultCode;
		}
	}

}
