package com.selenium.basics;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.bcel.classfile.Utility;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelsheetDATA {

	static  FileInputStream fileInputStream;
    static Workbook workbook;
    static Sheet sheet;
  //  "DataExcelSheet.xls"
    static  public Sheet readSheet(String jxlfilePath,String sheetName) throws Exception {
 	   fileInputStream = new FileInputStream(jxlfilePath);
 	   workbook = Workbook.getWorkbook(fileInputStream);
 	   return sheet =workbook.getSheet(sheetName);  
 	   
    }
    
  static  public ArrayList<String> readWholeRow(String sheetName,int row) throws Exception {
    	   fileInputStream = new FileInputStream("operator.data.xls");
   		   workbook = Workbook.getWorkbook(fileInputStream);
   		   sheet =workbook.getSheet(sheetName);
   		   ArrayList<String> rowData = new ArrayList<String>();
   		   for (int i = 0; i < sheet.getColumns(); i++) {
			String data =sheet.getCell(i, row).getContents();
			rowData.add(data);
		}
   		 return rowData;
	}	
  static  public ArrayList<String> readWholeRow1(String sheetName,int row) throws Exception {
 	 Cell[] cell = sheet.getRow(row);
 	 ArrayList<String> rowData = new ArrayList<String>();
 	 for (Cell cell2 : cell) {
 		 rowData.add(cell2.getContents());      		 
 	 }
		return rowData;
  }
}
