package com.selenium.basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestUserPage {
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
	driver.findElement(By.xpath("//span[text()=\"Users\"]")).click();
}	
	@Test(priority = 1)
	public void checkTitle() {
	String actualMsg = driver.getTitle();
	System.out.println("Check title of user page::"+actualMsg);
	String expectedMsg = "JavaByKiran | User";
	Assert.assertEquals(actualMsg, expectedMsg);
	}
	
	@Test(priority=2)
	public void getRows(){
	System.out.println("Information of All The User of JBK");
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
	
	@Test(priority = 3)
	public void verifyLogo() {
	System.out.println("Result Availability of Image");	
	WebElement logo = driver.findElement(By.xpath("//img"));
	boolean logoAvai = logo.isDisplayed();
	Assert.assertEquals(logoAvai, true);
	System.out.println(logoAvai);
	}
	
	@Test(priority=4)
	public void Headers() {
		System.out.println("Headers of UserPage::");
		ArrayList<String> expectedheader = new ArrayList<String>();
		expectedheader.add("#");
		expectedheader.add("Username");
		expectedheader.add("Email");
		expectedheader.add("Mobile");
		expectedheader.add("Course");
		expectedheader.add("Gender");
		expectedheader.add("State");
		expectedheader.add("Action");
		ArrayList<String> actualheader = new ArrayList<String>();
        List<WebElement>header = driver.findElements(By.tagName("th"));
        for(WebElement element : header) {
        	String text = element.getText();
        	actualheader.add(text);
        }
        System.out.println(actualheader);
        System.out.println(expectedheader);
        Assert.assertEquals(actualheader, expectedheader);
       /* for(int i=1;i<actualheader.size();i++) {
        	Assert.assertEquals(actualheader.get(i), expectedheader.get(i));*/
        }
        
        @Test(priority=5)
        public void verifyUsername() {
        	ArrayList<String> actualUserName = new ArrayList<String>();
        	List<WebElement> username = driver.findElements(By.xpath("//table[@class=\"table table-hover\"]//tr/td[2]"));
        	for(WebElement element : username) {
            	String text = element.getText();
        		actualUserName.add(text);
        	}
        		System.out.println("Total number of user "+ actualUserName);
        		System.out.println("User List Getting Data " +actualUserName);
        	}
        
        
        @Test(priority=6)
        public void verifyingMobile() {
        	ArrayList<String> actualmobilenumber = new ArrayList<String>();
        	List<WebElement> mobilenumber = driver.findElements(By.xpath("//table[@class=\"table table-hover\"]//tr/td[4]"));
        	for(WebElement element : mobilenumber) {
        		actualmobilenumber.add(element.getText());
        	}
        	System.out.println("Total number of Mobile "+ actualmobilenumber );
        	System.out.println("Mobile number Available at user Data "+actualmobilenumber);
        
        
        if(mobilenumber.size()==4) {
        	System.out.println("Email size match with"+actualmobilenumber);
        }else {
        	System.out.println("Email size not match with"+actualmobilenumber.size());
        }
        String a = "9898989898";
        if(actualmobilenumber.contains(a)) {
        	System.out.println("user mobile contains the number "+a);
        }else {
        	System.out.println("users mobile not contains the number "+a);
        }}
        
        @Test(priority=7)
        public void verifyingCourses() {
        	ArrayList<String>actualcourses = new ArrayList<String>();
        	List<WebElement>courses=driver.findElements(By.xpath("//table[@class=\"table table-hover\"]//tr/td[5]"));
        	for(WebElement element:courses) {
        		actualcourses.add(element.getText());
        	}
            System.out.println("Actual courses available in user data "+actualcourses);        	
        }
        @Test(priority=8)
        public void verifyingGender() {
        	ArrayList<String> actualgender = new ArrayList<String>();
        	List<WebElement>genderList = driver.findElements(By.xpath("//table[@class=\"table table-hover\"]//tr/td[6]"));
        	for(WebElement element : genderList) {
        		actualgender.add(element.getText());
        }
        	System.out.println("Actual size of Gender column is "+actualgender);
        }
        
        @Test(priority=9)
        public void verifingState() {
        	ArrayList<String> actualstate = new ArrayList<String>();
        	List<WebElement>stateList = driver.findElements(By.xpath("//table[@class=\"table table-hover\"]//tr/td[7]"));
        	for(WebElement element : stateList) {
        		actualstate.add(element.getText());
        	}
        	System.out.println("Actual size of state column is "+actualstate);
        	
        }
        @Test(priority=10)
        public void verifingActions() {
        	ArrayList<String>actualaction = new ArrayList<String>();
        	List<WebElement>actionList = driver.findElements(By.xpath("//table[@class=\"table table-hover\"]//tr/td[8]"));
        	for(WebElement element : actionList) {
        		actualaction.add(element.getText());
        	}
        	System.out.println("Actual size of Action column is "+actualaction);
        }
        @Test(priority=11)
        public void AlertHandles() throws InterruptedException {
        	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[2]/td[8]/a/span")).click();
        	String alertMassage = driver.switchTo().alert().getText();
        	System.out.println("Print the massage of alert::"+alertMassage);
        	Thread.sleep(5000);
        	Alert al=driver.switchTo().alert();
        	al.accept();
        }
        @Test(priority=12)
        public void AlertHandles1() {
       	driver.findElement(By.xpath("//*[@id=\"tr_2\"]/td[8]/a/span")).click();;
        String alertMassage = driver.switchTo().alert().getText();
        System.out.println("Print the massage of alert::"+alertMassage);
       	Alert al1=driver.switchTo().alert();
       	al1.dismiss();
        }
        @Test(priority=13)
        public void windowsHandleUser() {
        	String userWindowId=driver.getWindowHandle();
        	System.out.println("Print the userWindow of userPage>>>"+userWindowId);
        	String URLuser=driver.getCurrentUrl();
        	System.out.println("print the userURL of userPage>>>"+URLuser);
        }
        
        @AfterSuite
        public void BrowserClose() {
        	driver.close();
        }
        @Test(priority=14)
        public void userState1() {
        	System.out.println("State of sagar candidate :");
        	List<WebElement>cols=driver.findElements(By.xpath("//td[7]"));
        	for(int i=0;i<cols.size();i++) {
        		String text=cols.get(i).getText();
        	
        		if(text.contains("Punjab")) {
        			System.out.println(text);
        			}}}
       
        @Test(priority=15)
        public void userstate() {
        System.out.println("List of all the state belong the users : ");
        List<WebElement>cols1=driver.findElements(By.xpath("//td[7]"));
        for(int i=0;i<cols1.size();i++) {
        	String text1=cols1.get(i).getText();
        	System.out.println(text1);
        }}
        
        @Test(priority=16)
        public void getSingleUser() {
        	System.out.println("All information of Sagar:");
        	List<WebElement>sagarInfo=driver.findElements(By.xpath("//tr[2]"));
        	for(int i=0;i<sagarInfo.size();i++) {
        		String text3=sagarInfo.get(i).getText();
        		System.out.println(text3);
        		
        		if(text3.contains("Maharashtra")) {
        			System.out.println(text3);
        		}
        	}
        
        
        
        }
        }
        	
        

	
    	
	
    
	
	
	


