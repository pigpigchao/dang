package com.dang.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBUtil {
	//����Դ���ӳض���
	private static DataSource dataSource=null;
	//��һ�������һ���̰߳�,�ܹ������̵߳Ĳ�����
	private static ThreadLocal<Connection> connLocal=new ThreadLocal<Connection>();
	static{
		Properties props=new Properties();
		try {
			//����db.properties�����ļ�
			props.load(DBUtil.class.getClassLoader()
					.getResourceAsStream("db.properties"));
			//����dbcp�������dataSource����
			dataSource=BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection()throws SQLException{
		//��ȡ�͵�ǰ�߳���ص�connection
		Connection conn=connLocal.get();
		if(conn==null||conn.isClosed()){//���û�л����Ѿ��ر�
			conn=dataSource.getConnection();//����µ�Connection
			connLocal.set(conn);
		}
		return conn;
	}
	public static void closeConnection(){
		//
		Connection conn=connLocal.get();
		//������̰߳󶨵�conn
		connLocal.set(null);//Ϊ��һ�ε���getConnectionҪ�½�
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
