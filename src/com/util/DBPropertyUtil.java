package com.util;

import java.io.FileInputStream;
import java.util.Properties;

public class DBPropertyUtil {

	public static String getPropertyString(String propertyFileName) throws Exception{
		
		
		FileInputStream fis = new FileInputStream(propertyFileName);
		
		Properties props =new Properties();
		
		props.load(fis);
		String propstr=props.getProperty("user")+" "+props.getProperty("password")+" "+props.getProperty("driver")+" "+props.getProperty("url");
		return propstr;
		
		
	}

}
