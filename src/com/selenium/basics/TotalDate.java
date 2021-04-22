package com.selenium.basics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TotalDate {
WebDriver driver;

		@Test
		public void fBopen(){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		    driver=new ChromeDriver();
		    driver.get("https://www.facebook.com/r.php");
		    driver.manage().window().maximize();
		     
		    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		    Date date=new Date();
		    System.out.println(sdf.format(date));
		    
		    Calendar c = Calendar.getInstance();
		    c.setTime(new Date());
		    
		    c.add(Calendar.DAY_OF_MONTH,16);
		    String output=sdf.format(c.getTime());
		    c.add(Calendar.MONTH, 8);
		    String output1=sdf.format(c.getTime());
		    c.add(Calendar.YEAR,-16);
		    String output2=sdf.format(c.getTime());
		    
		    Select selDate=new Select(driver.findElement(By.id("day")));
		    selDate.selectByValue(output.substring(0, 2));
		    Select selMonth=new Select(driver.findElement(By.id("month")));
		    selMonth.selectByValue(output1.substring(3, 5));
		    Select selYear=new Select(driver.findElement(By.id("year")));
		    selYear.selectByValue(output2.substring(6));
		    
		    System.out.println(c.getTime());
		}}
