package com.selenium.basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown {
static WebDriver driver;
public static void main(String[] args) {
	

	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get("https://www.facebook.com/r.php");
	String month_xpath="//select[@id=\"month\"]//option";
    selectDropDownValue(month_xpath, "May");
   /* WebElement day=driver.findElement(By.id("day"));
    WebElement month=driver.findElement(By.id("month"));
    WebElement year=driver.findElement(By.id("year"));
    /*Select select=new Select(day);
    select.selectByIndex(10);
    System.out.println(select.isMultiple());
    
    List<WebElement>listDays=select.getOptions();
    System.out.println(listDays.size());
    int TotalDays=listDays.size()-1;
    System.out.println("total days are: "+TotalDays);
    
    for(int i=0;i<listDays.size();i++) {
    	String lol=listDays.get(i).getText();
    	System.out.println(lol);
    	if(lol.equals("15")) {
    		listDays.get(i).click();
    		break;
    	}*/
}
public static void selectDropDownValue(String xpathValue,String value) {
	
    List <WebElement> monthList=driver.findElements(By.xpath("xpathValue"));
    System.out.println(monthList.size());
    
    for(int i=0;i<monthList.size();i++){
    	System.out.println(monthList.get(i).getText());
    	if(monthList.get(i).getText().equals(value)) {
    		monthList.get(i).click();
    		break;
    	}}    	}
    	
}
 /* //  selectValueFromDropDown(day, "10");
    //selectValueFromDropDown(month, "May");
    //selectValueFromDropDown(year, "1995");
	
	  Select select=new Select(day); select.selectByVisibleText("2");
	  
	  Select select1=new Select(month); select1.selectByVisibleText("3");
	  
	  Select select2=new Select(year); select2.selectByVisibleText("1995");
	 
	
	  String dob="10-May-1995"; String dobArr[]=dob.split("-");
	  
	  selectValueFromDropDown(day, dobArr[0]); selectValueFromDropDown(month,
	  dobArr[1]); selectValueFromDropDown(year, dobArr[2]); } public static void
	  selectValueFromDropDown(WebElement element,String value) { Select select=new
	  Select(element); select.selectByVisibleText(value);
	 


*/