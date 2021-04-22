package com.IFRAME;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RedBusTest1 {
	WebDriver driver;
    String name=null;	
       @Test
        public void redbus3() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//i[@id='i-icon-profile']")).click();
		driver.findElement(By.xpath("//li[@id='signInLink']")).click();
		System.out.println("main window title:  "+driver.getTitle());
		String mainWindow=driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.className("modalIframe")));
		driver.findElement(By.xpath("//a[contains(text(),'Terms')]//preceding::div[text()='Facebook']")).click();
		Set<String> set =driver.getWindowHandles();
			 // Using Iterator to iterate with in windows
	    Iterator<String> itr= set.iterator();
    	while(itr.hasNext()){
	    String childWindow=itr.next();
			    // Compare whether the main windows is not equal to child window. If not equal, we will switch.
	    if(!mainWindow.equals(childWindow)){
		name=childWindow;
			 driver.switchTo().window(childWindow);
			 driver.manage().window().maximize();
	         System.out.println("login window title:  "+driver.getTitle());
			 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mangeshvyahalkar@gmail.com");
			 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("asdfgh");
			 driver.findElement(By.xpath("//label[@id='loginbutton']")).click();
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
}		}		}			}
	

