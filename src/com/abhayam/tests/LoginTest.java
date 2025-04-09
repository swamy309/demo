package com.abhayam.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.abhayam.page.LoginPage;
@Listeners(com.abhayam.utils.myListener.class)
public class LoginTest {
	
	private WebDriver driver;
    private LoginPage loginPage;
    
    @BeforeMethod
    public void setUp() {
        // Set up WebDriver
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\Swamy.dandu\\Desktop\\java\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");  // Automatically manages ChromeDriver
        driver = new ChromeDriver();
        driver.get("https://abhayam.ap.gov.in:9999/login"); // Change this URL to your application's login page
        loginPage = new LoginPage();
    }
    
    @Test
    public void testLogin()   {
        // Perform login action
        loginPage.enterUsername("rtaadmin2");
        loginPage.enterPassword("admin");
        loginPage.clickLoginButton();
     // Verify login success
        String expectedUrl = "https://abhayam.ap.gov.in:9999/main/dashboard"; // Replace with the expected URL after login
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed!");
        
    }
    
    
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
