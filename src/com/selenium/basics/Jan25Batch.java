package com.selenium.basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Jan25Batch {

	WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Akshay/Downloads/software/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	@Test(priority = 1)
	public void verifyLogo() {
		WebElement logo = driver.findElement(By.xpath("//img"));
		boolean logoAvai = logo.isDisplayed();
		Assert.assertEquals(logoAvai, true);
	}

	@Test(priority = 2)
	public void VerifyCourses() {
		WebElement uname = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		// WebElement uname1=driver.findElement(By.id("email"));
		uname.sendKeys("kiran@gmail.com");
		WebElement pass = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		// WebElement pass1=driver.findElement(By.id("password"));
		pass.sendKeys("123456");

		WebElement button = driver.findElement(By.xpath("//button"));
		button.click();

		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Selenium");
		expData.add("Java / J2EE");
		expData.add("Python");
		expData.add("Php");
		System.out.println("print expected data::  " + expData);

		List<WebElement> listOfCourses = driver.findElements(By.tagName("h3"));
		ArrayList<String> actCourses = new ArrayList<String>();

		for (WebElement courseName : listOfCourses) {
			actCourses.add(courseName.getText());
		}
		System.out.println("print actual list of element::   " + actCourses);

		Assert.assertEquals(actCourses, expData);
	}

	@Test(priority = 3)
	public void VefifyDept() {
		WebElement uname = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		// WebElement uname1=driver.findElement(By.id("email"));
		uname.sendKeys("kiran@gmail.com");
		WebElement pass = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		// WebElement pass1=driver.findElement(By.id("password"));
		pass.sendKeys("123456");

		WebElement button = driver.findElement(By.xpath("//button"));
		button.click();

		ArrayList<String> expectCourse = new ArrayList<String>();
		expectCourse.add("Automation Testing");
		expectCourse.add("Software Development");
		expectCourse.add("Data Science");
		expectCourse.add("Web Development");

		System.out.println("print expected courses data:: " + expectCourse);

		List<WebElement> ListCourses = driver.findElements(By.tagName("//following::p[text()]"));
		ArrayList<String> actualCourses = new ArrayList<String>();

		for (WebElement courseNamed : ListCourses) {
			actualCourses.add(courseNamed.getText());

			System.out.println("print actual List of courses::  " + expectCourse);

			Assert.assertEquals(actualCourses, expectCourse);
		}
		
		}
		
		
	}









