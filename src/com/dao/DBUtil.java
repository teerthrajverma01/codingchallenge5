package com.dao;

import java.sql.Connection;
import java.util.Properties;

import com.util.DBConnUtil;
import com.util.DBPropertyUtil;

public class DBUtil {

	public static Connection con=null;
	
	public static Connection getDBConn()  {
		try {
		String propstr= DBPropertyUtil.getPropertyString("src/com/util/DB.properties");
		con = DBConnUtil.getDBConnection(propstr);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
}
