package com.abhayam.page;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	 // Page elements
    private By usernameField = By.xpath("/html/body/app-root/app-login/div/div/div[2]/div[2]/div/div/form/div[1]/input");
    private By passwordField = By.xpath("//*[@id=\"passwordText\"]");
    private By loginButton = By.xpath("/html/body/app-root/app-login/div/div/div[2]/div[2]/div/div/form/div[3]/button");

//    // Constructor
//    public LoginPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
//    }
//    
    
    // Actions (methods)
    public void enterUsername(String username) {
        WebElement usernameElement = driver.findElement(usernameField);
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
    	WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }
}
