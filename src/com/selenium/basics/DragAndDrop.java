package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

public static void main(String[] args) {
	System.setProperty("webdriver.chromedriver","chromedriver.exe");
    
    WebDriver driver=new ChromeDriver();
    
    driver.get("http://jqueryui.com/droppable/");
    
    driver.switchTo().frame(0);
    WebElement sourceElement=driver.findElement(By.xpath("//p[text()=\"Drag me to my target\"]"));
    
    
    WebElement targetElement=driver.findElement(By.xpath("//p[text()=\"Dropped!\"]"));
    
    Actions action=new Actions(driver);
    action.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();
}
		
//http://jqueryui.com/droppable/
	
   /* System.setProperty("webdriver.chromedriver","chromedriver.exe");
    
    WebDriver driver=new ChromeDriver();
    
    driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
    
    driver.manage().window().maximize();
    
    Actions action=new Actions(driver);
    
    WebElement rightClickButton = driver.findElement(By.cssSelector(".context-menu-one"));
    
    action.contextClick(rightClickButton).build().perform();
    
    WebElement copy=driver.findElement(By.cssSelector(".context-menu-icon-copy"));
    
    String copyText=copy.getText();
    System.out.println(copyText);*/
}