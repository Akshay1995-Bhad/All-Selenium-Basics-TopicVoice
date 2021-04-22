package GoogleSearch;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotClassAutomationDemo {
public static void main(String[] args) throws AWTException, InterruptedException {
	Robot robot=new Robot();
	
	System.setProperty("webdriver.chrome.driver", "chromedriver (1).exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://demo.automationtesting.in/Register.html");
	driver.manage().window().maximize();
	Thread.sleep(10000);
	
	driver.findElement(By.id("imagesrc")).click();
	
	robot.setAutoDelay(2000);
	
	StringSelection stringselection=new StringSelection("G:\\ScreenShots\\validHighlightElement.png");
	
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,null);
	
	robot.setAutoDelay(2000);
	
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	
	robot.setAutoDelay(1000);
	
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
}}
