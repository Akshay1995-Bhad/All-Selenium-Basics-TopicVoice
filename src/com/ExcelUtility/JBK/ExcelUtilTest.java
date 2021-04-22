package com.ExcelUtility.JBK;

public class ExcelUtilTest {

	public static void main(String[] args) {

		Xls_Reader reader=new Xls_Reader("operator.data.xls");
		String sheetName="Sheet1";
		
		System.out.println(reader.getCellData(sheetName, 4, 3));
		
		String data=reader.getCellData(sheetName, 0, 2);
		System.out.println(data);
		
		
	}

}
