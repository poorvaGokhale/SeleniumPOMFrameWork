package com.testAutomation.tests;

import com.testAutomation.pages.PasswordLoginPage;
import com.testAutomation.pages.UsrLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;


     String inValidUserName = "invalid";
     String invalidPasswd = "invalid@123";
     String validUserName = "aamod_00";
     String validPasswd = "Welcome@2020";

    @BeforeMethod
    public void setTests() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        String webUlr = "https://login.yahoo.com/";
        driver.get(webUlr);
    }

    @AfterMethod
    public void tearDownTests() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }
    public WebDriverWait getWebDriverWait() {
        return wait;
    }

}
