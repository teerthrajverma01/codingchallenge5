package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnUtil {
	/*
	 * static getDBConn():Connection Establish a connection to the database and return Connection reference
	*/
	
	

	public static Connection getConnection(String props) throws Exception {
	
		String[] properties=props.split(" ");	
		String Url=properties[3];
		String User=properties[0];
		String Password=properties[1];
		String Driver=properties[2];
			
		Class.forName(Driver);
		System.out.println("Driver is loaded");
		
		Connection con = DriverManager.getConnection(Url, User, Password);
		
		System.out.println("Connection established");
		
		return con;
		}
				
}
