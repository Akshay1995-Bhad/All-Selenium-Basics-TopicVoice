package com.selenium.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelNotHandleWindowpopUpp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://html.com/input-type-file/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id=\"fileupload\"]")).sendKeys("C:\\Users\\Akshay\\eclipse-workspace\\Arrays\\src\\AA.java");
		driver.findElement(By.id("//input[@value=\"submit\"]")).click();
	}

}
