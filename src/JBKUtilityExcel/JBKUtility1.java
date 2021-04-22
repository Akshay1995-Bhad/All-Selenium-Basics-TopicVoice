package JBKUtilityExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;

public class JBKUtility1 {
	@Test
	public void test01() throws Exception{
		
		ExcelUtility file= new ExcelUtility();
		
		Sheet sheet=file.getSheet("ExcelJBK.xlsx", "Login");
		
		int rows=sheet.getPhysicalNumberOfRows();
		
		for(int i=1; i<rows;i++) {
			
		Cell cell=	sheet.getRow(i).getCell(0);
		System.out.println("Executing action of keyword: "+cell.getStringCellValue());
		file.perform(cell.getStringCellValue());
		
		}
}}
