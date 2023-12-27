package com.util;

import java.io.FileInputStream;
import java.util.Properties;

public class DBPropertyUtil {

	public static String getConnection(String propertyFileName) throws Exception{
		
		
		FileInputStream fis = new FileInputStream(propertyFileName);
		
		Properties props =new Properties();
		
		props.load(fis);
		String propstr=p1.getProperty("user")+" "+p1.getProperty("password")+" "+p1.getProperty("driver")+" "+p1.getProperty("url");
		return propstr;
		
		
	}

}
