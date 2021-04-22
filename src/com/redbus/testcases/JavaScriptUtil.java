package com.redbus.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
public static void flash(WebElement element,WebDriver driver)  {	
	JavascriptExecutor js= ((JavascriptExecutor) driver);
	String bgcolor=element.getCssValue("backgroundColor");
	
	for(int i=0; i<500 ;i++) {
		changeColor("#fff",element,driver);
		changeColor(bgcolor,element,driver);
		
	}
}

public  static void changeColor(String color, WebElement element, WebDriver driver)  {

	JavascriptExecutor js=((JavascriptExecutor) driver);
	js.executeScript("arguments[0].style.backgroundColor = '" + color +"'",element);
	
	
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
		
}
public static void drawBorder(WebElement element,WebDriver driver) {
	JavascriptExecutor js=((JavascriptExecutor)driver);
	js.executeScript("arguments[0].style.border='3px solid red'", element);
	
}
public static String getTitleByJS(WebDriver driver) {
	JavascriptExecutor js=((JavascriptExecutor)driver);
	String Title = js.executeScript("return document.title;").toString();
	return Title;
}
public static void clickElementByJS(WebElement element,WebDriver driver) {
	JavascriptExecutor js=((JavascriptExecutor)driver);
	js.executeScript("arguments[0].click();", element);
}
public static void generateAlert(WebDriver driver, String message) {
	JavascriptExecutor js=((JavascriptExecutor)driver);
	js.executeScript("alert('" + message + "')");

}	
}


