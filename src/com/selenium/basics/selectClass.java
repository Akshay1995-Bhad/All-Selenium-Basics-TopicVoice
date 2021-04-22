package com.selenium.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class selectClass {
WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/r.php");
        Thread.sleep(5000);
	   /* WebElement uname=driver.findElement(By.id("email"));
		uname.sendKeys("kiran@gmail.com");
	    WebElement pass=driver.findElement(By.id("password"));
	    pass.sendKeys("123456");
        WebElement loginButon = driver.findElement(By.xpath("//button"));                                   
        loginButon.click();
        driver.findElement(By.xpath("//span[text()=\"Users\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"Add User\"]")).click();*/
       /* WebElement month=driver.findElement(By.xpath("//select[@id=\"month\"]"));
        Select sel = new Select(month);*/
        //sel.selectByVisibleText("Maharashtra");
        //sel.selectByIndex(2);
       /* List<WebElement>months=sel.getOptions();
        for(WebElement text:months) {
        	System.out.println(text.getText());*/
        
       /* WebElement year=driver.findElement(By.xpath("//select[@id=\"year\"]"));
        Select sel=new Select(year);
        List<WebElement>yearlist=sel.getOptions();
        for(WebElement nbrs:yearlist) {
        	System.out.println(nbrs.getText());
        */
        	WebElement day=driver.findElement(By.xpath("//select[@id=\"day\"]"));
        	Select sel2=new Select(day);
        	List<WebElement>daysList=sel2.getOptions();
        	for(WebElement value:daysList) {
        		System.out.println(value.getText());
        	}
        }
	   
	}
	


