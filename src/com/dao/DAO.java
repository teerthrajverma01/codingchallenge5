package com.dao;

import java.sql.Connection;
import java.util.Properties;

import com.util.DBConnUtil;
import com.util.DBPropertyUtil;

public class DAO {

	public static Connection con;
	
	public static void connect()  {
		try {
		Properties props = DBPropertyUtil.getConnection("src/com/util/DB.properties");
		con = DBConnUtil.getDBConnection(props);	
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
