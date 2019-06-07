package com.zoopla.property;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Property {
	
	public static FileInputStream fs;
	public static Properties pro;
	public static String readProperty(String Property) 
	{
		try {
			
			pro = new Properties();
			fs= new FileInputStream(new File("C:\\Users\\Aggrawals\\eclipse-workspace\\zoopla\\src\\main\\java\\com\\zoopla\\config\\config.properties"));
			pro.load(fs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pro.getProperty(Property);
		
	
		
	}

}
