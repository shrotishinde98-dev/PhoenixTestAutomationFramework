package com.demo.csv;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadcsvFile {

	public static void main(String[] args) throws IOException, CsvException {
		
		//read csv data
		
		InputStream is= Thread.currentThread().getContextClassLoader().getResourceAsStream("testData/LoginCred.csv");
		InputStreamReader isr = new InputStreamReader(is);
		 CSVReader  csvReader  = new CSVReader(isr); //csvreader constructorr
		 
		 List<String[]> dataList=csvReader.readAll();
		 
		 for( String[] dataArray :dataList) {
			System.out.println(dataArray[0]);
			System.out.println(dataArray[1]);
		}
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
       //read csv file in java
		
	/*	File csvfile =new File("C:\\Users\\shind\\OneDrive\\Desktop\\sdet\\java module\\PhoenixTestAutoFramework\\src\\main\\resources\\testData\\LoginCred.csv");
		FileReader fr = new FileReader(csvfile);
		CSVReader csvReader =new CSVReader(fr);
		
		List<String[]> dataList =csvReader.readAll();
		
		for(String[] dataArray:dataList) {
			for(String data:dataArray) {
				System.out.print(data+" ");
			}
			System.out.println(" ");
			
		}*/
	}
	

}
