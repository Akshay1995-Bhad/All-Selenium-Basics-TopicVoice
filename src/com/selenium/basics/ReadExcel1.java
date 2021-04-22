package com.selenium.basics;

import java.io.FileInputStream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel1 {

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
		}}
	@Test
	public void loginUsingExcel()throws Exception{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/Akshay/Downloads/software/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys(readData("login",1,1));
		driver.findElement(By.tagName("button")).click();
	}
	@Test
	public void test02() throws Exception {
		int rows=sh.getRows();
		int cols=sh.getColumns();
		System.out.println(rows+" "+cols);
		
		for(int i=1;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				Cell cell=sh.getCell(j, i);
				String data=cell.getContents();
				System.out.print(data+"   ");
			}
			System.out.println();
		}
	}
	@Test
	public void loginWithExcel()throws Exception{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay/Downloads/software/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		readData("login",0,0);
		for(int i=1;i<sh.getRows();i++) {
		driver.findElement(By.id("email")).clear();	
		driver.findElement(By.id("email")).sendKeys(readData("login",0,i));
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(readData("login",1,i));
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(5000);
		
		if(driver.getTitle().equals("JavaByKiran | Dashboard"))
			driver.findElement(By.xpath("//a[text()='LOGOUT']")).click();
	}
}}
