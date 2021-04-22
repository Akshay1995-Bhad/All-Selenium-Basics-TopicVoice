package com.singletonPattern;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver=null;
	
	public static void initialization() {
		if(driver==null) {
			if(Constants.browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver=new ChromeDriver();
			}else if(Constants.browserName.equalsIgnoreCase("FF")) {
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                driver=new FirefoxDriver();
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constants.url);
	}
	public static void quit() {
		System.out.println("quiting the browser");
		driver.quit();
		driver=null;
	}
	public static void close() {
		System.out.println("clossing the browser");
		driver.close();
		driver=null;
	}
}
