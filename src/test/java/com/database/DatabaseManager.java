package com.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.api.utils.ConfigManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseManager {
	
	private static final  String DB_URL = ConfigManager.getProperty("DB_URL");
	private static final  String DB_USER_NAME = ConfigManager.getProperty("DB_USER_NAME");
	private static final  String DB_PASSWORD = ConfigManager.getProperty("DB_PASSWORD");
	private static final  String HIKARI_CP_POOL = ConfigManager.getProperty("HIKARI_CP_POOL");
	private  static HikariConfig hikariConfig;
	private volatile static HikariDataSource  hikariDataSource;
	
	private static  Connection conn;//all update happen to this connection variable
	
	private DatabaseManager() {
		
		
	}
	
	
	private static void instanciatePool() throws SQLException{
		if (hikariDataSource == null) {// first check all parallel thread to enter
			synchronized (DatabaseManager.class) { // only one

				if (hikariDataSource == null) { // only only one connection request -singeloton pattern
					
					HikariConfig  hikariConfig = new HikariConfig();
					 
					hikariConfig.setJdbcUrl(DB_URL);
					hikariConfig.setUsername(DB_USER_NAME);
					hikariConfig.setPassword(DB_PASSWORD);
					hikariConfig.setMaximumPoolSize(Integer.parseInt(ConfigManager.getProperty("MAXIMUM_POOL_SIZE")));
					hikariConfig.setMinimumIdle(Integer.parseInt(ConfigManager.getProperty("MINIMUM_IDLE_COUNT")));
					hikariConfig.setConnectionTimeout(Integer.parseInt(ConfigManager.getProperty("MAXIMUM_POOL_SIZE"))*1000);// 10sec
					hikariConfig.setIdleTimeout(Integer.parseInt(ConfigManager.getProperty("IDLE_TIMEOUT_SEC"))*1000);
					hikariConfig.setMaxLifetime(Integer.parseInt(ConfigManager.getProperty("MAX_LIFE_TIME_IN_MINS"))*60*1000);// 30 min each 30*60*1000
					hikariConfig.setPoolName(HIKARI_CP_POOL);
					
					hikariDataSource = new HikariDataSource(hikariConfig);

				}
			}
		}
	}

	public  static Connection getConnection() throws SQLException{
		Connection connection = null;
		if (hikariDataSource == null) {
			instanciatePool();// Automatic Initalization of Hikari Database
		} 
		else if (hikariDataSource.isClosed()) {
			throw new SQLException("HIKARI DATA SOURCE IS CLOSED");
		}
		connection = hikariDataSource.getConnection();
		return connection;
		
		
	}
	
	
}
