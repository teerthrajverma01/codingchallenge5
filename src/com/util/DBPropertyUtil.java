package com.util;

import java.io.FileInputStream;
import java.util.Properties;

public class DBPropertyUtil {

	public static Properties getConnection(String propertyFileName) throws Exception{
		
		
		FileInputStream fis = new FileInputStream(propertyFileName);
		
		Properties props =new Properties();
		
		props.load(fis);
		return props;
		
	}

}
