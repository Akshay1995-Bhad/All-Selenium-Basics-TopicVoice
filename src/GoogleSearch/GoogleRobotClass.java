package GoogleSearch;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GoogleRobotClass {
	@Test
	public void googleSearchRobot() throws InterruptedException, AWTException {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.google.com/");
	Thread.sleep(10000);
	WebElement p=driver.findElement(By.xpath("//img[@class=\"lnXdpd\"]"));
	Thread.sleep(5000);
	Robot robot=new Robot();
	robot.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(5000);
	robot.keyPress(KeyEvent.VK_ENTER);
	Actions act=new Actions(driver);
	act.moveToElement(p);
	act.pause(2000).perform();
	act.contextClick(p).perform();
	
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.delay(2000);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.delay(2000);
	int a=p.getLocation().getX();
	int y=p.getLocation().getY();
	robot.mouseMove(a, y);
	
	robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
	Thread.sleep(5000);
	
	robot.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(5000);	
}}
