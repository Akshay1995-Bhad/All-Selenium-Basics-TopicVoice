package com.IRCTC;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class IRCTCtest1 {

	@Test
	public void Test01() throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifiaction");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();
		/*
		 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_TAB);
		 */
		driver.findElement(By.xpath("//input[@class=\"ng-tns-c58-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted\"]")).sendKeys("Pune");

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()=\"PUNE JN - PUNE\"]"))).click().perform();

		driver.findElement(By.xpath("//input[@class=\"ng-tns-c58-9 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted\"]")).sendKeys("Nagpur");
		action.moveToElement(driver.findElement(By.xpath("//span[text()=\"NAGPUR - NGP\"]"))).click().perform();
        
		Select dropClass=new Select(driver.findElement(By.name("//li[@aria-label=\"Sleeper (SL)\"]")));
		dropClass.selectByVisibleText("Sleeper(SL)");

		/*String date=driver.findElement(By.xpath("")).getText();
		System.out.println(date);
		int value =Integer.parseInt(date);
		driver.findElement(By.xpath("//button")).click();
		*/
		/*driver.findElement(By.xpath("//input[@id=\"onward_cal\"]")).click();
		Thread.sleep(5000);*/
		

	}
}
