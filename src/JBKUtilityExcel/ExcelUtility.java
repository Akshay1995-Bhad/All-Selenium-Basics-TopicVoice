package JBKUtilityExcel;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelUtility {
	WebDriver driver;
	FileInputStream fis=null;
	XSSFWorkbook wb=null;
	
							
	public Sheet getSheet(String fileName, String sheetName)throws Exception {
		fis=new FileInputStream(fileName);
		wb=new XSSFWorkbook(fis);
		return wb.getSheet(sheetName);		
	}
	
	public void perform(String methodName) {
		
		switch (methodName) {
		
		
		case "launchUrl":
			
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("file:///C:/Users/Akshay/Downloads/software/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");

			driver.manage().window().maximize();
			break;
			
		case "typeUsername":	
			
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			break;
			
		case "typePassword":	
			
			driver.findElement(By.id("password")).sendKeys("123456");
			break;
			
		case "clickLogin":
			driver.findElement(By.xpath("//button")).click();
			break;
		
		case "clickUser":
			driver.findElement(By.xpath("//span[text()='Users']")).click();
			break;
			
		case "clickAddUser":
			driver.findElement(By.xpath("//button[text()='Add User']")).click();
			break;
		}
	}
}
