package com.selenium.basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashBoardTest {

	WebDriver driver;
	@BeforeMethod
	public void LoginTitlePage() {
	System.setProperty("webdriver.chromedriver","chromedriver.exe");
    driver=new ChromeDriver();
    driver.get("file:///C:/Users/Akshay/Downloads/software/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
    WebElement uname=driver.findElement(By.id("email"));
    uname.sendKeys("kiran@gmail.com");
    WebElement pass=driver.findElement(By.id("password"));
    pass.sendKeys("123456");
    WebElement loginButon = driver.findElement(By.xpath("//button"));
    loginButon.click();
}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	/*
	 * @Test(priority = 1) public void LoginTest() { ArrayList<String>
	 * ExpectedNames=new ArrayList <String>(); ExpectedNames.add("Selenium");
	 * ExpectedNames.add("Java / J2EE"); ExpectedNames.add("Python");
	 * ExpectedNames.add("Php"); List<WebElement>
	 * course=driver.findElements(By.tagName("//h3"));
	 * ArrayList<String>actualNames=new ArrayList<String>(); for(WebElement
	 * element:course) { String text=element.getText(); actualNames.add(text);
	 * 
	 * Assert.assertEquals(actualNames, ExpectedNames); }
	 */
        @Test
        public void LoginPage() {	
        ArrayList<String> expectedElement=new ArrayList<String>();
        expectedElement.add("Kiran");
        expectedElement.add("Automation Testing");
        expectedElement.add("Software Development");
        expectedElement.add("Data Science");
        expectedElement.add("Web Development");
        List<WebElement> subcourse=driver.findElements(By.tagName("//p"));	
        ArrayList<String> actualElements=new ArrayList<String>();
        for(WebElement subelement:subcourse) {
        	String text1=subelement.getText();
        	actualElements.add(text1);
        }}}
        
	

