package com.SDET.jsExecuter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {
public static void main(String[] args) throws IOException  {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://www.twoplugs.com/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	//flashing element
	WebElement joinfree=driver.findElement(By.xpath("(//a[@class=\"btn green\"])[1]"));
	
	//JavaScriptUtil.flash(joinfree, driver);
	//JavaScriptUtil.drawBorder(joinfree, driver);
	
	//File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	//File trg=new File("G:\\mm\\"
	//		+ "Selenium_Basic_Practices\\screenshots/"+"failshot__"+".jpg");			
	//FileUtils.copyFile(src, trg);
	
	//Capture title of the page 
	//System.out.println(driver.getTitle());
	String title =JavaScriptUtil.getTitleByJS(driver);
	System.out.println(title);
	
	WebElement loginBtn=driver.findElement(By.xpath("(//span[text()=\"LOG in\"])[1]"));
    //loginBtn.click();
    
	JavaScriptUtil.clickElementByJS(loginBtn, driver);
    
	//generate alert

	JavaScriptUtil.generateAlert(driver, "you have to generate alert");
}}
