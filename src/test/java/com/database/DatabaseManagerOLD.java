package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.api.utils.ConfigManager;

public class DatabaseManagerOLD {
	
	
	private static final  String DB_URL = ConfigManager.getProperty("DB_URL");
	private static final  String DB_USER_NAME = ConfigManager.getProperty("DB_USER_NAME");
	private static final  String DB_PASSWORD = ConfigManager.getProperty("DB_PASSWORD");
	private volatile static  Connection conn;//all update happen to this connection variable
	
	private DatabaseManagerOLD() {
		
	}
	
public  static void createConnection() throws SQLException {
	if(conn == null) {//first check all parallel thread to enter 
		synchronized (DatabaseManagerOLD.class) {   //only one
			
		
	if(conn == null) { //only only one connection request -singeloton pattern
	 conn=DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
	 }
	System.out.println(conn);
		}
}
	}
}
