package com.abhayam.tests;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class CapturingScreenshots {
	
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("download.default_directory","C:\\Users\\Swamy.dandu\\Downloads\\testing");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Swamy.dandu\\Desktop\\java\\ChromeDriver\\chromedriver-win64\\chromedriver.exe"); 
		driver = new ChromeDriver(options);

	}
	
	@Test
    public void testFileDownload() throws InterruptedException {
        // Open the webpage that contains the download link
        driver.get("https://www.sample-videos.com/download-sample-text-file.php");

        // Click the download link (simulate clicking a download button)
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[3]/a")).click();

        // Wait for a few seconds to ensure the file is downloaded
        // This is just an example, you should use a better wait condition in real tests
        TimeUnit.SECONDS.sleep(5);

        // Verify if the file is downloaded (e.g., check if the file exists)
        File downloadedFile = new File("C:\\Users\\Swamy.dandu\\Downloads\\testingl");
        assert downloadedFile.exists() : "File was not downloaded!";
    }
	
	 @AfterMethod
	    public void tearDown() {
	        // Quit the driver
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	
	
	 
}
