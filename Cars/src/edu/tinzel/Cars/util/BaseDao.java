package edu.tinzel.Cars.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/cars?characterEncoding=utf-8";
	private static final String UID="root";
	private static final String PWD="123";
	protected Connection getcon()throws Exception{
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL,UID,PWD);
	}
	protected void close(ResultSet rs,PreparedStatement ps,Connection con)throws Exception{
		if(rs!=null){
			rs.close();
		}
		if(ps!=null){
			ps.close();
		}
		if(con!=null){
			con.close();
		}
		rs=null;
		ps=null;
		con=null;
	}
}
