package com.dang.interceptor;
import com.dang.util.DBUtil;
/**
 * �������
 */
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TransactionInterceptor extends AbstractInterceptor{

	public String intercept(ActionInvocation invocation) throws Exception {
		boolean first=true;
		try{	
		//System.out.println("�����������");
		DBUtil.getConnection().setAutoCommit(false);
		String resultCode=invocation.invoke();//����action����
		if(first){//����һ��JSPʹ�ö��action,�ظ�����
		DBUtil.getConnection().commit();//�ύ����
		//System.out.println("�ύ����");
		first=false;
		}
		return resultCode;
	}catch(Exception e){
		e.printStackTrace();
		DBUtil.getConnection().rollback();
		//System.out.println("�ع�����");
		throw e;
	}finally{
		DBUtil.closeConnection();
		//System.out.println("�ر�����");
	}
	}
	
}
