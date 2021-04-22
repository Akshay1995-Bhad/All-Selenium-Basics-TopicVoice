package com.selenium.basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class myShopPrime {

	WebDriver driver;

	@BeforeMethod
	public void openBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://myshopprime.com/suhas.dhanorkar1");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class=\"focus:outline-none border-0 p-2\"]")).click();
		driver.findElement(By.xpath("//p[text()=\"Categories\"]")).click();
	}

	@Test(priority = 1)
	public void checkTitle() {
		String actualTitle = driver.getTitle();
		System.out.println("check title of webPage::" + actualTitle);
		String expectedTitle = "MyShopPrime";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test(priority = 2)
	public void checkShopByTopCategories() {
		driver.findElement(By.xpath("//a[@style='border-color: rgb(218, 225, 227);']"));
        List<WebElement> list = driver.findElements(By.xpath("//a[@class=\"block rounded border border-solid border-gray-300 text-xs p-2 mr-2 mb-2\"]"));
        for(WebElement element:list) {
        	String text=element.getText();
        	System.out.println(text);
        if(text.contains("Kitchen Tools")) {
        	System.out.println(element.getText());
        	Assert.assertEquals("Kitchen Tools",element.getText());
            break;
        }}
	}
	@Test(priority=3)
	public void checkElement() {
		WebElement element=driver.findElement(By.xpath("//div[text()=\"Women\"]"));
		String text=element.getText();
		System.out.println(text);
	}
	@AfterMethod
    public void BrowserClose() {
    	driver.close();
    }	
}
