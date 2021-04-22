package com.selenium.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class userLisnk {
    public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("file:///C:/Users/Akshay/Downloads/software/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
    driver.manage().window().maximize();
    driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
    driver.findElement(By.id("password")).sendKeys("123456");
    driver.findElement(By.xpath("//button")).click();
    driver.findElement(By.xpath("//span[text()=\"     Useful Links\"]")).click();
	
	List<WebElement>srcList=driver.findElements(By.xpath("//td[1]"));
	List<WebElement> contentList=driver.findElements(By.xpath("//tr/td[2]"));
	for(int i=0;i<contentList.size();i++) {
		String srcNumber=contentList.get(i).getText();
		
		if(srcNumber.contains("Selenium") || srcNumber.contains("Courses")) {
			String idNum=srcList.get(i).getText();
			System.out.println("sr numbers are available with selenium or Java::"+idNum);
		}
	}
}}
