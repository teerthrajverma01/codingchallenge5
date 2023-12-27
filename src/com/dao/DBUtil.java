package com.dao;

import java.sql.Connection;
import java.util.Properties;

import com.util.DBConnUtil;
import com.util.DBPropertyUtil;

public class DBUtil {

	public static Connection con=null;
	
	public static Connection connect()  {
		try {
		Properties props = DBPropertyUtil.getConnection("src/com/util/DB.properties");
		con = DBConnUtil.getDBConnection(props);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
}
