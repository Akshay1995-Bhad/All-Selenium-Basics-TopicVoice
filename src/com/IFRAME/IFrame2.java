package com.IFRAME;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrame2 {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://demo.automationtesting.in/Alerts.html");
	driver.manage().window().maximize();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//a[text()=\"Alert with Textbox \"]")).click();
	//1st time click 
	driver.findElement(By.xpath("//button[text()=\"click the button to demonstrate the prompt box \"]")).click();
	driver.switchTo().alert().sendKeys("testing");
	driver.switchTo().alert().accept();
	String Exptext="Hello Automation Testing user How are you today";
	String ActString=driver.findElement(By.xpath("//button[text()=\"click the button to demonstrate the prompt box \"]")).getText();
	
	if(Exptext.equals(ActString)==true) {
		System.out.println("Test is passed");
	}
	//2nd time click
	//driver.findElement(By.xpath("//button[text()=\"click the button to demonstrate the prompt box \"]")).click();
   // driver.switchTo().alert().sendKeys(keysToSend);
}
}
