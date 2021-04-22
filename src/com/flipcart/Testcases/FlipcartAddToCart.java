package com.flipcart.Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FlipcartAddToCart {
	 WebDriver driver;
	/*@Test
	public void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(7000);
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		Action sendEsc = actions.sendKeys(Keys.ESCAPE).build();
		sendEsc.perform();
		
		driver.findElement(By.name("q")).sendKeys("Dell G3 core i7 10th gen laptop" + Keys.ENTER);
		String text = driver.getTitle();
		System.out.println(text);
		driver.findElement(By.xpath("(//div[text()=\"₹88,990\"])[1]")).click();
	}}*/
	
		
		//@Test
		@Test
		public void checkLogin()throws Exception
		{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		WebElement ele=driver.findElement(By.id("src"));
		//ele.clear();
		ele.sendKeys("pune");
		Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//li[@data-no='2']"))).click();


		WebElement to=driver.findElement(By.id("dest"));
		//to.clear();
		to.sendKeys("nagpur");
		act.moveToElement(driver.findElement(By.xpath("//li[@data-no='1']"))).click();




		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		Thread.sleep(5000);
		String date = driver.findElement(By.xpath("//td[@class='current day']")).getText();
		System.out.println(date);
		int value=Integer.parseInt(date);
		int reqDay=value+10;
		String val=String.valueOf(reqDay);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[@class='next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[text()='" + val +"']")).click();

		driver.findElement(By.id("search_btn")).click();

		//driver.findElement(By.xpath("//label[text()='FROM']")).click();    //sendKeys("Chandrapur");
		//driver.findElement(By.xpath("//label[text()='TO']")).sendKeys("Nagpur");
		//driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		}

		}