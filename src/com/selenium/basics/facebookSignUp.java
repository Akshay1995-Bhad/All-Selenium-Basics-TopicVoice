package com.selenium.basics;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class facebookSignUp {
	WebDriver driver;
	FileInputStream fis;
	Workbook wb;
	Sheet sh;

	@BeforeSuite
	public void before() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test(dataProvider = "addUserData")
	public void addUser(String firstname, String lastname, String email, String password, String Gender) {
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys(firstname);
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys(lastname);
		driver.findElement(By.id("reg_email__")).clear();
		driver.findElement(By.id("reg_email__")).sendKeys(email);
		driver.findElement(By.id("password_step_input")).clear();
		driver.findElement(By.id("password_step_input")).sendKeys(password);
		String gender = Gender;

		if (gender.contains("Female")) {
			driver.findElement(By.id("//label[text()='Female']")).click();
		} else
			driver.findElement(By.id("//label[text()='Male']")).click();

		driver.findElement(By.xpath("//button")).click();

	}

	@DataProvider
	public Object[] addUserData() throws Exception {
		fis = new FileInputStream("LoginDataforJBK.xls");
		wb = Workbook.getWorkbook(fis);
		sh = wb.getSheet("SignUpFb");
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
