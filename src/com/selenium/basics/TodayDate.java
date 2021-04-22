package com.selenium.basics;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TodayDate {

	/*
	 * SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");// to get required
	 * format of date Date d = new Date();// to get Todays date String curDate =
	 * sdf.format(d); System.out.println(curDate); String month =
	 * curDate.substring(0, 2);// 02 String day = curDate.substring(2, 4);// 10
	 * String year = curDate.substring(4);// 2021 System.out.println(day + " " +
	 * month + " " + year); int reqDay = Integer.parseInt(day) + 7;
	 * System.out.println(reqDay); int reqYear = Integer.parseInt(year) - 16;
	 * System.out.println(reqDay + " " + month + " " + reqYear); } }
	 */

	/*
	 * SimpleDateFormat sdf=new SimpleDateFormat("MMddyyyy"); Date d=new Date();
	 * String curDate = sdf.format(d); System.out.println(curDate); String month =
	 * curDate.substring(0,2); String day = curDate.substring(2,4); String year =
	 * curDate.substring(4); System.out.println(day +" " + month +" "+ year); int
	 * reqDay = Integer.parseInt(day) +7; System.out.println(reqDay); int reqYear =
	 * Integer.parseInt(year)-16; System.out.println(reqDay + " " + month + " " +
	 * reqYear); }}
	 */

	WebDriver driver;

	/*@Test
	public void FbTest() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/r.php");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
		Date d = new Date();
		String curDate = sdf.format(d);
		System.out.println(curDate);
		String month = curDate.substring(0, 2);
		String day = curDate.substring(2, 4);
		String year = curDate.substring(4);
		System.out.println(day + " " + month + " " + year);
		int reqDay = Integer.parseInt(day)+7;
		System.out.println(reqDay);
		int reqYear=Integer.parseInt(year)-16;
	    System.out.println(reqDay+" "+month+" "+reqYear);
	}
}
*/
	@Test
	public void fbDateFormat()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php");
		driver.manage().window().maximize();
		
		DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy");
		Date date=new Date();
		String today=dateformat.format(date);
		System.out.println(today);
		
		String daySel=today.substring(3, 5);
		System.out.println("Day "+daySel);
		String monthSel=today.substring(0, 2);
		System.out.println("Month "+monthSel);
		String yearSel=today.substring(6, today.length());
		System.out.println("Year "+yearSel);
		System.out.println(today);
		
		WebElement dateSelect=driver.findElement(By.id("day"));
		WebElement monthSelect=driver.findElement(By.id("month"));
		WebElement yearSelect=driver.findElement(By.id("year"));
	}}