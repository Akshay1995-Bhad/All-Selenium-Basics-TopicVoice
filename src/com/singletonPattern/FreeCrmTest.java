package com.singletonPattern;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCrmTest {

	@BeforeMethod
	public void setUp() {
		TestBase.initialization();
	
	}
	@Test(priority=1)
	public void verifyFreeCrmTitleTest() {
		String title=TestBase.driver.getTitle();
		System.out.println("page title is "+title);
		Assert.assertEquals(title,Constants.loginPageTitle);
	}
	@Test(priority=2)
	public void verifyImage() {
		Assert.assertEquals(TestBase.driver.findElement(By.className("brand-name")).isDisplayed(),true);
	}
	@AfterMethod
	public void tearDown() {
		TestBase.quit();
	}
}
