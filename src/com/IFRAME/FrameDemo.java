package com.IFRAME;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrameDemo {

	@Test
	public void FRame() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		//alert with OK link
		driver.findElement(By.xpath("(//a[@class=\"analystic\"])[1]")).click();
	    //alert with OK button
		driver.findElement(By.xpath("(//button)[2]")).click();
		//switch to alert Box
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[text()=\"Alert with OK & Cancel \"]")).click();
		
		driver.findElement(By.xpath("(//button)[2]")).click();
		String ExpTextOk="You pressed Ok";
		String ExpTextCansal="You Pressed Cansal";
		
		driver.switchTo().alert().accept();
		
		//String ActText=driver.findElement(By.xpath("//p[text()=\"You pressed Ok\"]")).getText();
		/*if(ExpTextOk.equals(ActText)==true) {
			System.out.println("test is passed");*/
		/*}
		driver.switchTo().alert().dismiss();
		if(ExpTextCansal.equals(ActText)==true) {
			System.out.println("test is Passed");*/
		}
	}

