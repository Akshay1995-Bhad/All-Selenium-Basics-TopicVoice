package GoogleSearch;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class searchGoogle {
@Test
public void search() throws InterruptedException {
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.in/");
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Thread.sleep(15000);
	driver.findElement(By.name("q")).sendKeys("Selenium");
	Thread.sleep(5000);
	
	List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li/following::div[@class='sbl1']"));
	
	System.out.println(list.size());
	
	for(int i=0;i<list.size();i++) {
		String listitem = list.get(i).getText();
		
		System.out.println(listitem);
		if(listitem.contains("selenium tutorial")) {
			list.get(i).click();
			break;
		}
	}
	
}


}
