package com.dang.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	public String intercept(ActionInvocation invocation) throws Exception {
		//�ж�session���Ƿ��е�¼��Ϣ
		Map<String,Object> session=
			invocation.getInvocationContext().getSession();
//		Map<String,Object> session=
//			ActionContext.getContext().getSession();
		if(session.get("user")==null){
			//δ��¼��ת����¼����
			return "login";
		}else{
			//�Ѿ���¼���Ե���Actionҵ�񷽷�
			String resultCode=invocation.invoke();//������action��result 
			//������ �ĺ�������
			return resultCode;
		}
	}

}
