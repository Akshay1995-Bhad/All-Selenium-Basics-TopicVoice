package com.selenium.basics;

import java.io.FileInputStream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class DataProviderOnAddUserPage {
	WebDriver driver;
	FileInputStream fis;
	Workbook wb;
	Sheet sh;

	@BeforeSuite
	public void before() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay/Downloads/software/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()=\"Users\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"Add User\"]")).click();
	}
	@Test(dataProvider = "addUserData")
	public void addUser(String username, String mobile, String email, String courses, String Gender, String state,
			String password) {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys(mobile);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("course")).clear();
		driver.findElement(By.id("course")).sendKeys(courses);
		String gender = Gender;
		
		if (gender.contains("Female")) {
			driver.findElement(By.id("Female")).click();
		} else
			driver.findElement(By.id("Male")).click();

		Select sel = new Select(driver.findElement(By.tagName("select")));
		sel.selectByVisibleText(state);

		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.xpath("//button")).click();
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	@DataProvider
	public Object[] addUserData() throws Exception {
		fis = new FileInputStream("LoginDataforJBK.xls");
		wb = Workbook.getWorkbook(fis);
		sh = wb.getSheet("addUser1user");
		String[][] dataArr = new String[sh.getRows()][sh.getColumns()];
		for (int i = 0; i < sh.getRows(); i++) {
			for (int j = 0; j < sh.getColumns(); j++) {
				String data = sh.getCell(j, i).getContents();
				dataArr[i][j] = data;
			}
		}
		return dataArr;
	}

}
