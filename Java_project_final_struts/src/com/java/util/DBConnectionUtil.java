package com.java.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionUtil {

	private  static final String URL="jdbc:oracle:thin:@localhost:1521:orclrohit";
	private static final String USERNAME="system";
	private static final String PASSWORD ="rohit";
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getconnection()
	{
			Connection conn=null;
			try {
				 conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return conn;
	}
	public static void closeconnection(Connection conn)
	{
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
	public static void closestatement(Statement stmt)
	{
		if(stmt!=null)
		{
			try {
				stmt.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
	public static void closeresultset(ResultSet rs)
	{
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
}
