package com.database;

import java.sql.SQLException;

public class DemRunner {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DatabaseManagerOLD.createConnection();
	long startTime=System.currentTimeMillis();
    for (int i = 1; i<=5; i++) {
    	DatabaseManagerOLD.createConnection();
        DatabaseManagerOLD.createConnection();
        DatabaseManagerOLD.createConnection();
	}
  long endTime = System.currentTimeMillis();
  System.out.println("Duration"+(endTime-startTime)+"ms");
	}

}
