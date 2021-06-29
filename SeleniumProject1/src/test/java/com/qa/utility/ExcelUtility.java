package com.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
 public static FileInputStream fileLoc;
 public static XSSFWorkbook wBook;
 public static XSSFSheet wSheet;
 public static XSSFRow row;
 public static XSSFCell cell;
 
 //1.get the row Count
 public static int getRowCount(String xFile, String xSheet) throws IOException{
	 
	 fileLoc=new FileInputStream(xFile);
	 wBook=new XSSFWorkbook(fileLoc);
	 wSheet=wBook.getSheet(xSheet);
	 int rowCount=wSheet.getLastRowNum();
	 return rowCount;
 }
 //2.get the cell count of each row
public static int getcellCount(String xFile, String xSheet, int rowNum) throws IOException{
	 
	 fileLoc=new FileInputStream(xFile);
	 wBook=new XSSFWorkbook(fileLoc);
	 wSheet=wBook.getSheet(xSheet);
	 
	 row=wSheet.getRow(rowNum);
	 int cellCount=row.getLastCellNum();
      return cellCount;
      
 
}
//3. Read the data from each cell and return in string
public static String getcellData(String xFile, String xSheet, int rowNum, int cellNum) throws IOException{
	 
	 fileLoc=new FileInputStream(xFile);
	 wBook=new XSSFWorkbook(fileLoc);
	 wSheet=wBook.getSheet(xSheet);
	 
	 row=wSheet.getRow(rowNum);
	 cell=row.getCell(cellNum);
	 
	 DataFormatter formatter = new DataFormatter();
	 String cellData = formatter.formatCellValue(cell);
	 wBook.close();
	 fileLoc.close();
	 return cellData;
	 
   }
 
 
 
}
