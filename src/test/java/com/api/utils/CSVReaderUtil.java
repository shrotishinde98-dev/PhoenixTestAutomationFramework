package com.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.dataproviders.api.bean.UserBean;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVReaderUtil {

//constructor private ,static method
	
	//read csv file and mapped csv to bean
	
	private CSVReaderUtil() {
		
		//no one can craete object oc csv util outside class
	}
	public static <T> Iterator<T> loadCSV(String pathOFCSVFile,Class<T>  bean){
		InputStream is = Thread.currentThread().getContextClassLoader().getSystemResourceAsStream(pathOFCSVFile);
		InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvReader =   new CSVReader(isr);
	
		CsvToBean  csvToBean= new CsvToBeanBuilder(csvReader)
				.withType(bean)      //UserBean.class
				.withIgnoreEmptyLine(true)
				.build();
		
		List<T>  list = csvToBean.parse();  //	List<UserBean> 
	return	list.iterator();
		//System.out.println(userList.get(1));
		
		

	}
}
