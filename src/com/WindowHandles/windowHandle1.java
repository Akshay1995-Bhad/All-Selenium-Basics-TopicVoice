package com.WindowHandles;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class windowHandle1 {
WebDriver driver;
String name=null;
@BeforeSuite
public void setup() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--disable-notifications");
	driver=new ChromeDriver(option);
	driver.get("https://www.redbus.in/");
	driver.manage().window().maximize();
	Thread.sleep(5000);

	driver.findElement(By.id("i-icon-profile")).click();
	driver.findElement(By.xpath("//li[@id=\"signInLink\"]")).click();
	System.out.println("main window title:"+driver.getTitle());
	String mainWindow=driver.getWindowHandle();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.switchTo().frame(driver.findElement(By.className("modalFrame")));
	driver.findElement(By.xpath("//a[contains(text(),'Terms')]//preceding::div[text()='Facebook']")).click();	
	Set<String>set=driver.getWindowHandles();
	Iterator<String>itr=set.iterator();
	while(itr.hasNext()){
	String childWindow=itr.next();
	if(!mainWindow.equals(childWindow)) {
		name=childWindow;
	driver.switchTo().window(childWindow);
	driver.manage().window().maximize();
	System.out.println("login window title:  "+driver.getTitle());
	driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("akibhad295@gmail.com");
	driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("bhai@145");
	driver.findElement(By.xpath("//label[@id=\"loginbutton\"]")).click();
	}}
	 driver.switchTo().window(mainWindow);
	 driver.findElement(By.xpath("//i[@class='icon-close']")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//a[text()='Help']")).click();
	 Set<String> sets =driver.getWindowHandles();
	 System.out.println(sets.size());
	 Iterator<String> itr1= sets.iterator();
	 while(itr1.hasNext()){
	 String childWindow1=itr1.next();
	    // Compare whether the main windows is not equal to child window. If not equal, we will switch.
	 if(!mainWindow.equals(childWindow1)) {
		 driver.switchTo().window(childWindow1);
		 System.out.println("help window title:  "+driver.getTitle());		 
}
}}}
