package com.demo.csv;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

public class ReadCSVFile_MapToPOJO {

	public static void main(String[] args) throws IOException, CsvException {
		
		//read csv data
		
		InputStream is= Thread.currentThread().getContextClassLoader().getResourceAsStream("testData/LoginCred.csv");
		InputStreamReader isr = new InputStreamReader(is);
		 CSVReader  csvReader  = new CSVReader(isr); //csvreader constructorr
		 
		
		 //mapping csv to pojo
		 
	CsvToBean<UserBean>  csvTOBean = new CsvToBeanBuilder(csvReader)
	   .withType(UserBean.class)		
	   .withIgnoreEmptyLine(true)
	   .build();
	   
	    
	  List<UserBean> UserList =  csvTOBean.parse();
	 
	  System.out.println(UserList);
	   }
		
	
	

}
