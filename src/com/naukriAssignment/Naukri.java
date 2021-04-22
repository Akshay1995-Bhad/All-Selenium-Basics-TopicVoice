package com.naukriAssignment;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Naukri {
	WebDriver driver;

	@BeforeMethod
	public void openBrowser() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://www.naukri.com/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Skills, Designations, Companies']")).sendKeys("Java developer");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Locations…']")).sendKeys("Pune");
		driver.findElement(By.xpath("//button[text()='Search']")).click();
	}

	@Test
	public void filter() throws Exception {
		/*
		 * driver.findElement(By.xpath("//input[@placeholder='Select']")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//a[@data-id='filter-freshness_7']")).click();
		 * Thread.sleep(5000);
		 */

		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//span[text()='Later']")))).click();
        Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@title='Pune']")).click();
        Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@title='3-6 Lakhs']")).click();
		// driver.findElement(By.xpath("//span[text()='3']")).click();
		String parent = driver.getWindowHandle();
		for(String wins: driver.getWindowHandles()) {
			driver.switchTo().window(wins);
			if(!driver.getTitle().contains("Developer"))
				driver.close();
		}
		driver.switchTo().window(parent);
		Thread.sleep(10000);
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		wait1.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(".")))).click();
				
		Set<String> child = driver.getWindowHandles();
		System.out.println(child.size());
		for (String id : child) {
			if (!id.equals(parent)) {
				driver.switchTo().window(id);
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				driver.close();
			}
		}
	}
}

