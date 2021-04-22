package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassMouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(1000);
		
        Actions action =new Actions(driver);
	    action.moveToElement(driver.findElement(By.className("Prime"))).build().perform();
	    //Thread.sleep(3000);
	   // driver.findElement(By.xpath("//option[contains(text(),\"Maharashtra\")]")).click();
	   // driver.findElement(By.xpath(""))    
	
	
	
	
	}

}
