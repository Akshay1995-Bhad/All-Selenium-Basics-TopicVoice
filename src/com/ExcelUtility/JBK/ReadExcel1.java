package com.ExcelUtility.JBK;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadExcel1 {
	@Test
	public static void ExcelSheet() throws Exception {
		

		String excelfilePath="operator.data.xls";
		FileInputStream fis=new FileInputStream(excelfilePath);
		
		Workbook wb= WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheetAt(0);
		
		int rows=sh.getLastRowNum();
		int cols=sh.getRow(1).getLastCellNum();
		
		for(int r=0;r<=rows;r++) {
			Row row1=sh.getRow(r);
			for(int c=0;c<cols;c++) {
				Cell cell=row1.getCell(c);
				if(cell.getCellType()==cell.CELL_TYPE_NUMERIC) {
					System.out.print(cell.getNumericCellValue());
				}else if(cell.getCellType()==cell.CELL_TYPE_STRING) {
					System.out.print(cell.getStringCellValue());
				}else if(cell.getCellType()==cell.CELL_TYPE_BOOLEAN) {
					System.out.print(cell.getBooleanCellValue());
					
					}
				System.out.print("   |   ");
				}
			System.out.println();
				}}}

