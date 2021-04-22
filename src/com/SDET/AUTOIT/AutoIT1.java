package com.SDET.AUTOIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoIT1 {
	@Test
	public static void main()throws Exception {
		Test();
	}
	public static void Test() throws Exception {
	System.setProperty("webdriver.chrome.driver", "G:\\mm\\Selenium_Basic_Practices\\chromedriver (1).exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://demo.guru99.com/test/upload/");
	driver.findElement(By.name("uploadfile_0")).click();
	Thread.sleep(5000);

	Runtime.getRuntime().exec("D:\\FileUploadScript.exe");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button")).click();
	driver.close();
}}
