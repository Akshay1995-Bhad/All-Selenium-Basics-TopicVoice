package com.selenium.basics;

import java.io.FileInputStream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class DpWithJxl {
	WebDriver driver;
	FileInputStream fis;
	Workbook wb;
	Sheet sh;
 
	@Test(dataProvider = "loginData")
    public void logintest(String uname, String pass) {
	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("file:///C:/Users/Akshay/Downloads/software/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	  driver.manage().window().maximize();
      driver.findElement(By.id("email")).sendKeys(uname);
      driver.findElement(By.id("password")).sendKeys(pass);
      driver.findElement(By.xpath("//button")).click();
  }
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("file:///C:/Users/Akshay/Downloads/software/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	      driver.manage().window().maximize();
	      driver.findElement(By.partialLinkText("Register")).click();	
	}
  @Test(dataProvider="addUserdata")
  public void addUser(String name,String mobile,String email,String pass) {
	  driver.findElement(By.id("name")).clear();
      driver.findElement(By.id("name")).sendKeys(name);
	  driver.findElement(By.id("mobile")).clear();
      driver.findElement(By.id("mobile")).sendKeys(mobile);
	  driver.findElement(By.id("email")).clear();
      driver.findElement(By.id("email")).sendKeys(email);
	  driver.findElement(By.id("password")).clear();
      driver.findElement(By.id("password")).sendKeys(pass);
      driver.findElement(By.tagName("button")).click();
      Alert al = driver.switchTo().alert();
      al.accept();
  }
  @DataProvider
  public Object[]addUserdata()throws Exception{
	 
	  fis=new FileInputStream("LoginDataforJBK.xls");
	  wb=Workbook.getWorkbook(fis);
	  sh=wb.getSheet("addUser");
	  String [][] dataArr=new String[sh.getRows()][sh.getColumns()];
	  
	  for(int i=0;i<sh.getRows();i++) {
		  for(int j=0;j<sh.getColumns();j++) {
			  String data=sh.getCell(j, i).getContents();
			  dataArr[i][j]=data;
		  }
	  }
	  return dataArr;
  }

  @DataProvider
  public Object[][] loginData() {
    return new Object[][] {
      new Object[] { "kiran@gmail.com", "123456" },
      new Object[] { "mangesh@gmail.com", "abcdef" },
      new Object[] { "akshay@gmail.com", "12ddh" },

    };
  }
}
