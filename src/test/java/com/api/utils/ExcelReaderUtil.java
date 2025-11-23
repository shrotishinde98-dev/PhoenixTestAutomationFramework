package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUtil {

	public static void main(String[] args) throws IOException {
	//apache ppoi  xml
		
		InputStream is =Thread.currentThread().getContextClassLoader().getResourceAsStream("testData/PhoenixTestData.xlsx");
		   XSSFWorkbook myWorkBook = new XSSFWorkbook(is);
		XSSFSheet mySheet =   myWorkBook.getSheet("LoginTestData");
		XSSFRow myRow;
		XSSFCell myCell;
		
		int lastRowIndex=mySheet.getLastRowNum();//get last row index
		XSSFRow rowHeader=mySheet.getRow(0);
		int lastIndexOfCol=rowHeader.getLastCellNum()-1; //last index of column
		
		
for (int rowIndex = 0; rowIndex <= lastRowIndex; rowIndex++) {
   for (int colIndex = 0; colIndex <=lastIndexOfCol; colIndex++) {
	   myRow=  mySheet.getRow(rowIndex);
	   myCell=myRow.getCell(colIndex);
	   System.out.print(myCell+" ");
	
}
   
	System.out.println(" ");
}


	}

		   

	}

