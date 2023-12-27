package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnUtil {
	/*
	 * static getDBConn():Connection Establish a connection to the database and return Connection reference
	*/
	
	

	public static Connection getDBConnection(Properties props) throws Exception {
	
			
		String Url=props.getProperty("url")	;
		String User=props.getProperty("user")	;
		String Password=props.getProperty("password")	;
		String Driver=props.getProperty("driver")	;
			
		Class.forName(Driver);
		System.out.println("Driver is loaded");
		
		Connection con = DriverManager.getConnection(Url, User, Password);
		
		System.out.println("Connection established");
		
		return con;
		}
				
}
