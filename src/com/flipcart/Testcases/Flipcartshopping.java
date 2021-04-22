package com.flipcart.Testcases;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Flipcartshopping {
	WebDriver driver;

	@BeforeMethod
	public void openBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver", "G:\\mm\\Selenium_Basic_Practices\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(15000);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions actions = new  Actions(driver);
		
        Action sendEsc=actions.sendKeys(Keys.ESCAPE).build();
        sendEsc.perform();
	}    
	@Test
    public void VerifyTitle(){
		System.out.println("Title of the page is : "+driver.getTitle());
		Assert.assertEquals("Online Shopping Site for Mobiles,Fashion,Books,Electronics,Home Appliances & More @ Flipkart",driver.getTitle());
	}
	@Test
	public void searchProduct() throws Exception{
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("Dell G3 core i7 10th gen laptop");
		System.out.println("searching..for Dell G3 core i7 10th gen");
		driver.findElement(By.xpath("//button")).click();
		Thread.sleep(3000);
		boolean visible = driver.findElement(By.linkText("DELL G3 Core i7 10th Gen - (16 GB/1 TB HDD/256 GB SSD/W...")).isDisplayed();
	}
	@Test
	public void allProducts(){
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("Dell G3 core i7 10th gen laptop");
		driver.findElement(By.xpath("//button")).click();
		List<WebElement> laptop=driver.findElements(By.xpath("//div[@class='CXW8mj']"));
		System.out.println("No of Dell laptop: "+laptop.size());
	}
	@Test
	public void checkTitle(){
		driver.findElement(By.name("q")).sendKeys("Dell G3 core i7 10th gen laptop" + Keys.ENTER);	
		String text = driver.getTitle();	
		System.out.println(text);
		Assert.assertEquals("Online Shopping Site for Mobiles,Fashion,Books,Electronics,Home Appliances & More @ Flipkart",text);
	}
	@Test
	public void checkURLOFProduct(){
		driver.findElement(By.name("q")).sendKeys("Dell G3 core i7 10th gen laptop" + Keys.ENTER);	
		System.out.println("searching for Dell laptop");
		driver.findElement(By.xpath("//a[@title=\"DELL G3 Core i7 10th Gen - (16 GB/512 GB SSD/Windows 10 Home/6 GB Graphics/NVIDIA GeForce GTX 1660 Ti/120 Hz) G3 3500 Gaming Laptop\"]")).click();
		Assert.assertEquals("https://www.flipkart.com/search?q=Dell%20G3%20core%20i7%2010th%20gen%20laptop&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=off&as=off",driver.getCurrentUrl());	
	}
	@Test
	public void Adding_Laptops_cart() throws Exception{
		driver.findElement(By.name("q")).sendKeys("Dell G3 core i7 10th gen laptop" + Keys.ENTER);	
		String text = driver.getTitle();	
		System.out.println(text);
		driver.findElement(By.xpath("//a[@title=\"DELL G3 Core i7 10th Gen - (16 GB/512 GB SSD/Windows 10 Home/6 GB Graphics/NVIDIA GeForce GTX 1660 Ti/120 Hz) G3 3500 Gaming Laptop\"]")).click();	
		Thread.sleep(5000);
		Set<String> h=driver.getWindowHandles();
		System.out.println(h);
		for(String string:h){
			driver.switchTo().window(string);
		}
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click(); //add to cart
	}
	@Test
	public void checkURLofproduct()
	{
		System.out.println("URL of the page is : "+driver.getCurrentUrl());
		Assert.assertEquals("https://www.flipkart.com/",driver.getCurrentUrl());
	}
	@Test
	public void checkallPlaceOrderofProduct() throws Exception{
		driver.findElement(By.name("q")).sendKeys("Dell G3 core i7 10th gen laptop" + Keys.ENTER);	
		String text = driver.getTitle();	
		System.out.println(text);
		driver.findElement(By.xpath("//a[@title=\"DELL G3 Core i7 10th Gen - (16 GB/512 GB SSD/Windows 10 Home/6 GB Graphics/NVIDIA GeForce GTX 1660 Ti/120 Hz) G3 3500 Gaming Laptop\"]")).click();	
		Thread.sleep(5000);
		Set<String> h=driver.getWindowHandles();
		System.out.println(h);
		for(String string:h){
			driver.switchTo().window(string);
		}
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click(); //add to cart
		driver.findElement(By.xpath("//span[text()='Place Order']")).click();  //place order
		
	}
	@Test
	public void Buy_The_Product_Now_laptop() throws Exception{
		driver.findElement(By.name("q")).sendKeys("Dell G3 core i7 10th gen laptop" + Keys.ENTER);	
		String text = driver.getTitle();	
		System.out.println(text);
		driver.findElement(By.xpath("//a[@title=\"DELL G3 Core i7 10th Gen - (16 GB/512 GB SSD/Windows 10 Home/6 GB Graphics/NVIDIA GeForce GTX 1660 Ti/120 Hz) G3 3500 Gaming Laptop\"]")).click();	
		Thread.sleep(5000);
		Set<String> h=driver.getWindowHandles();
		System.out.println(h);
		for(String string:h){
			driver.switchTo().window(string);
		}
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")).click(); //buy now
	}
	@Test
	public void verify_myCart() throws Exception{
		driver.findElement(By.xpath("//span[text()='Cart']")).click();
		Assert.assertEquals("https://www.flipkart.com/viewcart?otracker=Cart_Icon_Click",driver.getCurrentUrl());
	}
	/*@BeforeMethod
	public void closeBrowser() {
	        	driver.close();
	        }*/
	

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
		/*driver.findElement(By.name("q")).sendKeys("Dell G3 core i7 10th gen laptop" + Keys.ENTER);
		String text = driver.getTitle();
		System.out.println(text);
		driver.findElement(By.xpath("//a[@title=\"DELL G3 Core i7 10th Gen - (16 GB/512 GB SSD/Windows 10 Home/6 GB Graphics/NVIDIA GeForce GTX 1660 Ti/120 Hz) G3 3500 Gaming Laptop\"]")).click();
		Thread.sleep(5000);
		Set<String>h=driver.getWindowHandles();
		System.out.println(h);
		for(String string:h) {
			driver.switchTo().window(string);
		}
		//JavascriptExecutor js =(JavascriptExecutor)driver;
		driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"Place Order\"]")).click();
		
		//js.executeScript("arguments[0].click()", checkbox);
*/
	
}
