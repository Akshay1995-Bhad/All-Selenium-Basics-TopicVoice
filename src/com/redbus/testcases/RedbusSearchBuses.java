package com.redbus.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RedbusSearchBuses {

	@Test
	public void locationFill() throws Exception 
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);

		driver.findElement(By.id("src")).sendKeys("Pune");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//li[text()='Swargate, Pune']"))).click().perform();

		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Mumbai");
		act.moveToElement(driver.findElement(By.xpath("//li[text()='Thane West, Mumbai']"))).click().perform();


		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		Thread.sleep(5000);
		String date = driver.findElement(By.xpath("//td[@class='current day']")).getText();
		System.out.println(date);
		int value=Integer.parseInt(date);
		int reqDay=value+10;
		String val=String.valueOf(reqDay);
		driver.findElement(By.xpath("//td[@class='next']")).click();
		driver.findElement(By.xpath("//td[text()='" + val + "']")).click();

		driver.findElement(By.xpath("//button[@id='search_btn']")).click();;

	}
}
