package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;

public class ConfigManager {
    private static Properties p = new Properties();
    public static String path = "config/config.properties";
   private static String env;
    private ConfigManager() {
    	//constructor
    }
    
    static {
    
     env= System.getProperty("env","qa");
     env=env.toLowerCase().trim();
    	switch (env) {
      	case "dev" -> path="config/config.dev.properties";
     	case "qa" -> path="config/config.qa.properties";
     	case "uat" -> path="config/config.uat.properties";
      	default -> path="config/config.qa.properties";
    	}
    	

    //path
   InputStream Input=Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		if(Input == null) {
			throw new RuntimeException("file not found");
		}
     try {
		
			p.load(Input);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
	public static String getProperty(String key)  {
		// TODO Auto-generated method stub
	
	   return p.getProperty(key);
	
	}

}
