package com.naeenAutoLab.session2;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadProp {

	public static void main(String[] args) throws Exception {
		
	WebDriver driver=null;
		
	Properties prop = new Properties();
	FileInputStream ip = new FileInputStream("G:\\mm\\Selenium_Basic_Practices\\src\\com\\naeenAutoLab\\session2\\config.properties");
	prop.load(ip);
	
	System.out.println(prop.getProperty("browser"));
	String browserName=prop.getProperty("browser");
	
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver= new ChromeDriver();	
	}else if(browserName.equals("GG")) {
		driver=new InternetExplorerDriver();
	}else {
		System.out.println("no browser values is given");
	}
	driver.get(prop.getProperty("url"));
	
	//driver.findElement(By.className(prop.getProperty("fb_logo _8ilh img"))).isDisplayed();
	
	driver.findElement(By.name(prop.getProperty("email_name"))).sendKeys(prop.getProperty("email"));
	driver.findElement(By.name(prop.getProperty("pass_name"))).sendKeys(prop.getProperty("pass"));
	
	driver.findElement(By.xpath(prop.getProperty("loginBtn_xpath"))).click();
}}
