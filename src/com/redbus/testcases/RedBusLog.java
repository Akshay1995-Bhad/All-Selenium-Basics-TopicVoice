package com.redbus.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RedBusLog {

	@Test
	public void locationFill() throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifiaction");
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver(option);
		
		driver.manage().window().maximize();
		driver.get("http://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(15000);
		
		driver.findElement(By.id("src")).sendKeys("Swargate, Pune");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//li[text()=\"Swargate, Pune\"]"))).click().perform();
		
		driver.findElement(By.xpath("//input[@id=\"dest\"]")).sendKeys("Nagpur (All Locations)");
		action.moveToElement(driver.findElement(By.xpath("//li[text()=\"Nagpur (All Locations)\"]"))).click().perform();
		
		driver.findElement(By.xpath("//input[@id=\"onward_cal\"]")).click();
		Thread.sleep(5000);
		
		String date=driver.findElement(By.xpath("//td[@class=\"current day\"]")).getText();
		System.out.println(date);
		int value =Integer.parseInt(date);
		int reqDay=value+10;
		String val=String.valueOf(reqDay);
		
		driver.findElement(By.xpath("//td[@class=\"next\"]")).click();
		driver.findElement(By.xpath("//td[text()=\"16\"]")).click();
		
		driver.findElement(By.xpath("//button")).click();
		Thread.sleep(5000);
		
		List<WebElement>listbus=driver.findElements(By.xpath("//div[@class=\"clearfix row-one\"]"));
		for(WebElement element:listbus) {
			String text=element.getText();
			
			System.out.print(text);
		}
		JavascriptExecutor jsExecutor=((JavascriptExecutor)driver);
		jsExecutor.executeScript("document.getElementById(\"redBus Bus Hire\").setAttribute('style','border:2px solid red; background:black');");
		Thread.sleep(5000);
	}
}
