package com.selenium.basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OperatorPage {
WebDriver driver;
	@BeforeSuite
	public void userTest() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/Akshay/Downloads/software/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()=\"Operators\"]")).click();
}
	@Test(priority=1)
	public void checkTitle() {
		String actualMsg = driver.getTitle();
		System.out.println("Check title of user page::"+actualMsg);
		String expectedMsg = "JavaByKiran | Operators";
		Assert.assertEquals(actualMsg, expectedMsg);
		}
	@Test(priority=2)
	public void GetOperatorInfo() {
		System.out.println("Information of All The User of JBK::");
		List<WebElement>tableRows = driver.findElements(By.xpath("//table[@class=\"table table-hover\"]//tr"));
		String columnFirst="//table[@class=\"table table-hover\"]//tr[";
		String columnLast="]//td";
		String column;
		List<WebElement> tableColumns;
		for(int i=1;i<tableRows.size();i++) {
			column=columnFirst+i+columnLast;
			tableColumns=driver.findElements(By.xpath(column));
			for(int j=1;j<tableColumns.size();j++) {
				System.out.print(tableColumns.get(j).getText()+"   ");
			}
			System.out.println();
		}}
	@Test(priority=3)
	public void GetOperatorHeader() {
		ArrayList<String>expectedheader=new ArrayList<String>();
		expectedheader.add("ID");
		expectedheader.add("Person");
		expectedheader.add("For");
		expectedheader.add("Prefered Way to Connect");
		expectedheader.add("Contact");
		expectedheader.add("Timings");
		ArrayList<String>actualheader=new ArrayList<String>();
		List<WebElement>header=driver.findElements(By.tagName("th"));
		for(WebElement element:header) {
			String text=element.getText();
			actualheader.add(text);
		}
		System.out.println(actualheader);
		System.out.println(expectedheader);
		Assert.assertEquals(actualheader, expectedheader);
	}
	@Test(priority=4)
	public void getOperatorsIds() {
		ArrayList<String> expectedIds=new ArrayList<String>();
		expectedIds.add("01");
		expectedIds.add("02");
		expectedIds.add("03");
		expectedIds.add("04");
		expectedIds.add("05");
		ArrayList<String>actualIds=new ArrayList<String>();
		List<WebElement>ids=driver.findElements(By.xpath("//table[@class=\"table table-hover\"]//tr/td[1]"));
		for(WebElement element:ids) {
			actualIds.add(element.getText());
		}
		System.out.println(expectedIds);
		System.out.println(actualIds);
		Assert.assertEquals(actualIds, expectedIds);
	}
     @Test(priority=5)
     public void getTotalPersons() {
    	 ArrayList<String>expectedPersons=new ArrayList<String>();
    	 expectedPersons.add("Kiran");
    	 expectedPersons.add("Neelam");
    	 expectedPersons.add("Seema");
    	 expectedPersons.add("Varsha");
    	 expectedPersons.add("Darshit");
    	 ArrayList<String>actualPersons=new ArrayList<String>();
    	 List<WebElement>Persons=driver.findElements(By.xpath("//table[@class=\"table table-hover\"]//tr/td[2]"));
    	 for(WebElement element:Persons) {
    		 actualPersons.add(element.getText());	 
    	 }
    	 System.out.println(expectedPersons);
    	 System.out.println(actualPersons);
    	 Assert.assertEquals(actualPersons, expectedPersons);
     }
     @Test(priority=6)
     public void getTotalworksfor() {
    	 ArrayList<String>expectedworks=new ArrayList<String>();
    	 expectedworks.add("Urgent Technical Help");
    	 expectedworks.add("Technical Discussion (Errors, Software, Technical Materials)");
    	 expectedworks.add("Administration (Fees, ID Card, Certificates, WhatsApp Group, Enquiry)");
    	 expectedworks.add("Enquiry(Course Details, Fees, Enquiry)");
    	 expectedworks.add("Technical Help");
    	 ArrayList<String>actualworks=new ArrayList<String>();
    	 List<WebElement>works=driver.findElements(By.xpath("//table[@class=\"table table-hover\"]//tr/td[3]"));
    	 for(WebElement element:works) {
    		 actualworks.add(element.getText());
    	 }
    	 System.out.println(expectedworks);
    	 System.out.println(actualworks);
    	 Assert.assertEquals(actualworks, expectedworks);
     }
     @Test(priority=7)
     public void getPrefarableWayToConnection() {
    	 ArrayList<String>expectedconnection=new ArrayList<String>();
    	 expectedconnection.add("Whats App Only");
    	 expectedconnection.add("Whats App Phone Call SMS eMail");
    	 expectedconnection.add("Whats App Phone Call SMS eMail");
    	 expectedconnection.add("Whats App Phone Call SMS eMail");
    	 expectedconnection.add("Whats App Only");
    	 ArrayList<String>actualconnection=new ArrayList<String>();
    	 List<WebElement>connection=driver.findElements(By.xpath("//table[@class=\"table table-hover\"]//tr/td[4]"));
    	 for(WebElement element:connection) {
    		 actualconnection.add(element.getText());
    	 }
    	 System.out.println(expectedconnection);
    	 System.out.println(actualconnection);
    	 Assert.assertEquals(actualconnection, expectedconnection);
     }
     @Test(priority=8)
     public void getContacts() {
    	 ArrayList<String>expectedcontacts=new ArrayList<String>();
    	 expectedcontacts.add("9552343698");
    	 expectedcontacts.add("7066885937");
    	 expectedcontacts.add("8888558802");
    	 expectedcontacts.add("8888809416");
    	 expectedcontacts.add("8866888662");
    	 ArrayList<String>actualcontacts=new ArrayList<String>();
    	 List<WebElement>contacts=driver.findElements(By.xpath("//table[@class=\"table table-hover\"]//tr/td[5]"));
    	 for(WebElement element:contacts) {
    		 actualcontacts.add(element.getText());
    	 }
    	 System.out.println(expectedcontacts);
    	 System.out.println(actualcontacts);
    	 Assert.assertEquals(actualcontacts, expectedcontacts);
     }
     @Test(priority=9)
     public void getTimings() {
    	 ArrayList<String>expectedTiming=new ArrayList<String>();
    	 expectedTiming.add("07:00 AM to 10:00 PM Monday-Sunday");
    	 expectedTiming.add("09:00 AM to 06:00 PM Monday-Saturday");
    	 expectedTiming.add("09:00 AM to 06:00 PM Monday-Saturday");
    	 expectedTiming.add("09:00 AM to 06:00 PM Monday to Friday and Sunday");
    	 expectedTiming.add("08:30 AM to 02:00 PM Saturday-Sunday");
    	 ArrayList<String>actualTiming=new ArrayList<String>();
    	 List<WebElement>Timing=driver.findElements(By.xpath("//table[@class=\"table table-hover\"]//tr/td[6]"));
    	 for(WebElement element:Timing) {
    		 actualTiming.add(element.getText());
    	 }
    	 System.out.println(expectedTiming);
    	 System.out.println(actualTiming);
    	 Assert.assertEquals(actualTiming, expectedTiming);
     }
     @Test(priority=10)
     public void getNOTE1() {
    	 ArrayList<String>expectedText=new ArrayList<String>();
    	 expectedText.add("Design for Selenium Automation Test");
    	 WebElement element=driver.findElement(By.xpath("//b[text()=\"Design for Selenium Automation Test\"]"));
    	 String actualText= element.getText();
    	 System.out.println(actualText);
    	 System.out.println(expectedText);
     }
     @Test(priority=11)
     public void getNOTE2() {
    	 ArrayList<String>expectedText=new ArrayList<String>();
    	 expectedText.add("Copyright © 2005-2019");
    	 WebElement element=driver.findElement(By.xpath("//strong[text()=\"Copyright © 2005-2019 \"]"));
    	 String actualtext=element.getText();
    	 System.out.println(actualtext);
    	 System.out.println(expectedText);
     }
     
    		 
	 @AfterSuite
     public void BrowserClose() {
     	driver.close();
     }
	}

	
	
	
