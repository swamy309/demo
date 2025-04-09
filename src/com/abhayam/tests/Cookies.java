package com.abhayam.tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Cookies {
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swamy.dandu\\Desktop\\java\\ChromeDriver\\chromedriver-win64\\chromedriver.exe"); // ChromeDriver
		driver = new ChromeDriver();

	}

	@Test
	public void testAddAndGetCookie() {
		driver.get("https://www.example.com");
		Cookie cookie = new Cookie("user", "testUser");
		driver.manage().addCookie(cookie);
		driver.manage().deleteCookieNamed("user");
		Cookie deletedCookie = driver.manage().getCookieNamed("user");
		Assert.assertNull(deletedCookie, "Deleted user cookie");
	}

	@Test
	public void testDeleteAllCookies() {
		driver.get("https://www.example.com");

		// Create and add a cookie
		driver.manage().addCookie(new Cookie("user", "testUser"));

		driver.manage().deleteAllCookies();

		Assert.assertTrue(driver.manage().getCookies().isEmpty(), "All Cookies are deleted");

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
