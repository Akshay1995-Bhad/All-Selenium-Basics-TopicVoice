package com.selenium.basics;

import java.io.FileInputStream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel2 {
	FileInputStream fis=null;
	Workbook wb=null;
	Sheet sh=null;
	public String readData(String sheet,int row,int col) throws Exception{
		fis=new FileInputStream("LoginDataForJBK.xls");
		wb=Workbook.getWorkbook(fis);
		sh=wb.getSheet(sheet);
		return sh.getCell(row, col).getContents();
	}
	@Test
	public void addUser() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay/Downloads/software/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Register")).click();
		
		readData("addUser",0,0);
		for(int i=1;i<sh.getRows();i++) {
		driver.findElement(By.id("name")).clear();	
		driver.findElement(By.id("name")).sendKeys(readData("addUser",0,i));
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys(readData("addUser",1,i));
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(readData("addUser",2,i));
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(readData("addUser",3,i));
		
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(5000);
		Alert al=driver.switchTo().alert();
		al.accept();
	
			
		}
		
	
}}
