package com.redbus.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RedbusProoject {
WebDriver driver;
@Test
public void openBrowser() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.redbus.in/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	Thread.sleep(15000);

	driver.findElement(By.xpath("//input[@id=\"src\"]")).click();
	driver.findElement(By.xpath("//input[@id=\"src\"]")).sendKeys("Swargate, Pune");
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//li[@data-id=\"67159\"]")).click();
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//input[@id=\"dest\"]")).click();
	driver.findElement(By.xpath("//input[@id=\"dest\"]")).sendKeys("Nagpur (All Locations)");
	Thread.sleep(5000);
    driver.findElement(By.xpath("//li[@data-id=\"624\"]")).click();
    Thread.sleep(5000);
    
    driver.findElement(By.xpath("(//button)[1]")).click();
    
    driver.findElement(By.xpath("//label[text()=\"Date\"]")).click();
    Thread.sleep(5000);
    
    String date = "10-Oct 2018";
    String splitter[]=date.split("-");
    String month_year=splitter[1];
    String day=splitter[0];
    System.out.println(month_year);
    System.out.println(day);
    
    selectDate(month_year,day);
    Thread.sleep(2000);
    driver.findElement(By.xpath(".//*[@id='search_btn']")).click();
}

public void selectDate(String monthyear,String Selectday) throws InterruptedException {
	List<WebElement> elements=driver.findElements(By.xpath("//td[@class=\"monthTitle\"]"));
	for(int i=0;i<elements.size();i++) {
		System.out.println(elements.get(i).getText());
		
		if(elements.get(i).getText().equals(monthyear)) {
			List<WebElement>days=driver.findElements(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));
			for(WebElement d:days) {
				System.out.println(d.getText());
				if(d.getText().equals(Selectday)) {
					d.click();
					Thread.sleep(10000);
					return;
				}
			}
		}
		driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[3]")).click();
		selectDate(monthyear,Selectday);
	}
	
}


}
	

