package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo1 {

	public static void main(String[] args) {
		  System.setProperty("webdriver.chromedriver","C://chromedriver.exe");
          
          WebDriver driver=new ChromeDriver();
          
          driver.get("file:///C:/Users/Akshay/Downloads/software/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
          
          WebElement uname=driver.findElement(By.id("email"));
          
          uname.sendKeys("kiran@gamil.com");
          
          WebElement pass=driver.findElement(By.id("password"));
          
          pass.sendKeys("123456");
          
          WebElement loginButon = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));
          
          loginButon.click();
	}

}
