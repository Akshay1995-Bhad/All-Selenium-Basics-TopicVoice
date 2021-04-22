package com.ExcelUtility.JBK;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
public class excelReader2 {

	 static FileInputStream fileInputStream=null;
	 static Workbook workbook=null;
	 static Sheet sheet=null;
	public static Sheet readWorkBook(String jxlfilePath,String sheetName)throws Exception{
		fileInputStream =new FileInputStream(jxlfilePath);
		workbook=Workbook.getWorkbook(fileInputStream);
		return sheet=workbook.getSheet(sheetName);
	}
    public ArrayList<String>readSpecificRow(String jxlfilePath,String sheetName,int row)throws Exception{
		excelReader2.readWorkBook(jxlfilePath, sheetName);
		ArrayList<String>rowData=new ArrayList<String>();
		int srn=sheet.getRows();
		int scn=sheet.getColumns();
		if(srn>row) {
			for(int i=0;i<srn;i++) {
				String data=sheet.getCell(i, row).getContents();
				rowData.add(data);
			}
		}else {
			System.out.println("Enter The Valid Row Number It Should be less than"+srn);
		}
		return rowData;
	}
  public static ArrayList<String>readSpacificColomn(String jxlfilePath,String sheetName,int column)throws Exception{
		excelReader2.readWorkBook(jxlfilePath, sheetName);
		ArrayList<String>columnData=new ArrayList<String>();
		int srn=sheet.getRows();
		int scn=sheet.getColumns();
		if(scn>column) {
			for(int i=0;i<srn;i++) {
				String data=sheet.getCell(column, i).getContents();
				columnData.add(data);
			}
			}else {
				System.out.println("Enter The Valid Column Number It should be less than"+scn);
			}
			return columnData;
		}	
	public String readCell(String jxlfilePath,String sheetName,int rowNumber,int columnNumber)throws Exception{
		excelReader2.readWorkBook(jxlfilePath, sheetName);
		int srn=sheet.getRows();
		int scn=sheet.getColumns();
		if(srn>rowNumber && scn>columnNumber && sheet.getCell(columnNumber, rowNumber).getContents().isEmpty()!=true) {
			String cellData=sheet.getCell(columnNumber, rowNumber).getContents();
			return cellData;
		}else {
			return "Enter Valid Cell Number or Location";
		}
	}
	public void readSheet(String jxlfilePath,String sheetName)throws Exception{
		excelReader2.readWorkBook(jxlfilePath, sheetName);
		ArrayList<String>nameOfSheet=new ArrayList<String>();
		int srn=sheet.getRows();
		int scn=sheet.getColumns();
		for(String sheetsName:workbook.getRangeNames()) {
			nameOfSheet.add(sheetName);
		}
		for(int i=0;i<workbook.getNumberOfSheets();i++) {
			if(sheetName.contains(nameOfSheet.get(i))) {
				for(int j=0;j<srn;j++) {
					for(int k=0;k<scn;k++) {
						String data=sheet.getCell(k, j).getContents();
						System.out.println(data+"\t");
						System.out.println();
					}
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		readSpacificColomn("LoginDataJBK.xls", "Sheet1", 3);
	}
	
	
	}
	

