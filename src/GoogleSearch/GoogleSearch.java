package GoogleSearch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com/");
		WebElement p=driver.findElement(By.name("q"));
		p.sendKeys("Selenium Java");
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul")));
		p.submit();
		driver.close();
	}

}
