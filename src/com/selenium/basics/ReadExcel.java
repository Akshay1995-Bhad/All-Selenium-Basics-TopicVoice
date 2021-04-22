package com.selenium.basics;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel {

	public String readData(int rows,int cols)throws Exception{
		FileInputStream fis=new FileInputStream("LoginDataForJbk.xls");
		Workbook wb=Workbook.getWorkbook(fis);
		Sheet sh=wb.getSheet("login");
		return sh.getCell(rows, cols).getContents();
	}
	@Test
	public void loginUsingExcel()throws Exception{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay/Downloads/software/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys(readData(0,1));
        driver.findElement(By.id("password")).sendKeys(readData(1,1));
        driver.findElement(By.tagName("button")).click();
	}
	
	@Test
    public void test02() throws Exception {
		
		FileInputStream fis=new FileInputStream("LoginDataForJbk.xls");
		Workbook wb=Workbook.getWorkbook(fis);
		Sheet sh=wb.getSheet("login");
		int rows=sh.getRows();//no.of rows which having a data
		int cols=sh.getColumns();//no of cols which having a data
		System.out.println(rows+" "+cols);
		
		for(int i=1;i<rows;i++) {//loop for rows
			for(int j=0;j<cols;j++) {//loop for column
				
				Cell cell=sh.getCell(j, i);
				String data=cell.getContents();
				System.out.print(data+" ");
			}
			System.out.println();
		}	
	}
}
