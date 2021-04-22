package com.naveenAutoLab.sessions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class ScreenShotTest extends Base {

	@BeforeMethod
	public void setUp() {
	initialization();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void loginTest() {
		Assert.assertEquals(false, true);
	}
	@Test
	public void searchTest() {
		Assert.assertEquals(false, true);
}
	@Test
	public void createDealsTest() {
		Assert.assertEquals(false, true);
}
	@Test
	public void createContactsTest() {
		Assert.assertEquals(false, true);
	}
	@Test
	public void HomePageTest() {
		Assert.assertEquals(false, true);
	}}