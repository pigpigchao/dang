package com.dang.interceptor;
import com.dang.util.DBUtil;
/**
 * 事务管理
 */
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TransactionInterceptor extends AbstractInterceptor{

	public String intercept(ActionInvocation invocation) throws Exception {
		boolean first=true;
		try{	
		//System.out.println("开启事务控制");
		DBUtil.getConnection().setAutoCommit(false);
		String resultCode=invocation.invoke();//调用action方法
		if(first){//避免一个JSP使用多个action,重复调用
		DBUtil.getConnection().commit();//提交事务
		//System.out.println("提交事务");
		first=false;
		}
		return resultCode;
	}catch(Exception e){
		e.printStackTrace();
		DBUtil.getConnection().rollback();
		//System.out.println("回滚事务");
		throw e;
	}finally{
		DBUtil.closeConnection();
		//System.out.println("关闭连接");
	}
	}
	
}
