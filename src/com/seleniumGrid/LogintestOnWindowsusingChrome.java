package com.seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LogintestOnWindowsusingChrome {
    WebDriver driver;
	@Test(priority=1)
	void setup() throws Exception {
		String nodeURL=" http://192.168.43.195:5555/wd/hub";
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new RemoteWebDriver(new URL(nodeURL),cap);
	}
	@Test(priority=2)
	void login() {
		driver.get("file:///C:/Users/Akshay/Downloads/software/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		String text=driver.getTitle();
		System.out.println(text);
		if(text.contains("JavaByKiran | Dashboard")) {
			System.out.println("Test passed");
		}else {
			System.out.println("Test Failed");
		}
		driver.close();
	}
}
