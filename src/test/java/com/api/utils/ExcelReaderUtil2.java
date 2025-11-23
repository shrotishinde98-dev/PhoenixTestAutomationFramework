package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dataproviders.api.bean.UserBean;
import com.poiji.bind.Poiji;
import com.pojo.user;

public class ExcelReaderUtil2 {
	
	private ExcelReaderUtil2(){
		
	}

	public static <T> Iterator<T> loadTestData(String xlsxFile,String sheetName, Class<T> clazz) {
	//apache ppoi  xml ,poiji 
		
		InputStream is =Thread.currentThread().getContextClassLoader().getResourceAsStream(xlsxFile);//"testData/PhoenixTestData.xlsx"
		   XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//focus on sheet
		XSSFSheet mySheet =   myWorkBook.getSheet(sheetName); //LoginTestData
		List<T> dataList=Poiji.fromExcel(mySheet, clazz);
		return dataList.iterator();
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//read the data from file and store in arraylist
		
		// read the data from file even index  changed and stored in ArrayList<cred>
		   
		  /* XSSFRow headerRows=mySheet.getRow(0);
		   int userNameIndex=-1;
		   int passwordIndex=-1;  //assume username password not available in the index position
		   
		   for (Cell  cell : headerRows) {
					if(cell.getStringCellValue().trim().equals("username")) {
						userNameIndex=cell.getColumnIndex();
					}
					if(cell.getStringCellValue().trim().equals("password")) {
						passwordIndex=cell.getColumnIndex();
					}
		
		   }

      System.out.println(passwordIndex+" "+userNameIndex);
      
      int lastRowIndex=mySheet.getLastRowNum();  //last row
      XSSFRow rowData;  
      user cred;
      //this loop data not fetched from header
      ArrayList<user> userList= new ArrayList<user>();
      for (int rowIndex = 1; rowIndex <= lastRowIndex; rowIndex++) {
 			  rowData=mySheet.getRow(rowIndex);
 			 cred = new user(rowData.getCell(userNameIndex).toString(),rowData.getCell(passwordIndex).toString());
 			userList.add(cred);
 }
    //  System.out.println(userList);
  return    userList.iterator();
	}*/

		   
	}
	}

