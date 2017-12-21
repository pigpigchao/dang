package com.dang.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBUtil1 {
	//������ݿ����ӳ�
	private static DataSource dataSource=null;
	private static ThreadLocal<Connection> connLocal=new ThreadLocal<Connection>();
	static{
		Properties props=new Properties();
		try {
			props.load(DBUtil1.class.getClassLoader()
					.getResourceAsStream("db.properties"));
			dataSource=BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection()throws Exception{
		//��ȡ�͵�ǰ�߳���ص�Connection
		Connection conn=connLocal.get();
		if(conn==null||conn.isClosed()){
			conn=dataSource.getConnection();
			connLocal.set(conn);
		}
		return conn;
	}
	public static void closeConnection(){
		Connection conn=connLocal.get();
		connLocal.set(null);
			try {
				if(conn!=null){
				conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
}
