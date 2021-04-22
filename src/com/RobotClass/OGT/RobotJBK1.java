package com.RobotClass.OGT;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RobotJBK1 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/Akshay/Downloads/software/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
        driver.manage().window().maximize();
        WebElement logo=driver.findElement(By.xpath("//img"));
        Thread.sleep(5000);
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(5000);
        
        robot.keyPress(KeyEvent.VK_ENTER);
        Actions act=new Actions(driver);
        act.moveToElement(logo);
        act.pause(2000).perform();
        act.contextClick(logo).perform();
        
        robot.keyPress(KeyEvent.VK_DOWN);
        
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(2000);
        int a=logo.getLocation().getX();
        int y=logo.getLocation().getY();
        robot.mouseMove(a, y);
        
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(5000);
        
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        
	}
}
