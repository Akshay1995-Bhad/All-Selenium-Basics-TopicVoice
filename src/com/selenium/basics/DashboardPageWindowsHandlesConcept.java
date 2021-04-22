package com.selenium.basics;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DashboardPageWindowsHandlesConcept {

	@Test
	public void DashBoardWindowHandles() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay/Downloads/software/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		String mainWindowIds = driver.getWindowHandle();
		System.out.println("print the windows of dashboard page::"+mainWindowIds);
		
		List<WebElement>links = driver.findElements(By.xpath("//a[text()=\"More info \"]"));
		for(WebElement Link : links) {
			Link.click();
			//5 windows are opened
		}
		Set<String> windowsIds = driver.getWindowHandles();
		//5 vlues in a set
		for(String id : windowsIds) {
			System.out.println("ids of a multiple windows:: "+id);
			driver.switchTo().window(id);
			System.out.println("URL of current page::"+driver.getCurrentUrl());
			driver.close();
		}
		}
	}

