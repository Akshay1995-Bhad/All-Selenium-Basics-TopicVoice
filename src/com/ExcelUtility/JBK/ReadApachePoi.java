package com.ExcelUtility.JBK;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadApachePoi {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/Testdata.xlsx");
		System.out.println("File path as: "+System.getProperty("user.dir")+"/Testdata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("data");
		int row = sh.getLastRowNum();
		int col=sh.getPhysicalNumberOfRows();
		System.out.println(row +"   "+col);
		
		for(int i=0;i<=row-1;i++) {//rows
			for(int j=0;j<col;j++) {//cols
				XSSFCell cell=sh.getRow(j).getCell(i);
				System.out.println(cell.getStringCellValue());
				if(cell.getCellType()==cell.CELL_TYPE_STRING) {
					System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
				}else {
					System.out.println(sh.getRow(i).getCell(j).getNumericCellValue());
				}
				
			}
			System.out.println();
		}
		
	}
}
