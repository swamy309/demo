package com.abhayam.tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class waits {
	
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swamy.dandu\\Desktop\\java\\ChromeDriver\\chromedriver-win64\\chromedriver.exe"); 																																																			// ChromeDriver
		driver = new ChromeDriver();
		

	}
	
	 @Test
	    public void testExplicitWait() {
	        driver.get("https://www.example.com");

	        // Create an instance of WebDriverWait with a timeout of 10 seconds
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Wait until an element with id 'exampleElement' is visible on the page
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleElement")));

	        // Perform actions after the element is visible
	        element.click();  // Clicking the element once it is visible

	        // Assert the page title after the action
	        Assert.assertTrue(driver.getTitle().contains("Example Domain"));
	    }
	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
