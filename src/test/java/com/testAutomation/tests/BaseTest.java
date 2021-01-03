package com.testAutomation.tests;


import com.testAutomation.pages.PasswordLoginPage;
import com.testAutomation.pages.UsrLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private static Properties properties;
    static String inValidUserName ;
    static String invalidPassword ;
    static String validUserName ;
    static String validPassword ;
 // static String BROWSER_NAME;

    static void loadConfigPropertyFile(String propertyFileName) throws IOException {
        properties = new Properties();
        properties.load(ClassLoader.getSystemResource(propertyFileName).openStream());
        inValidUserName = properties.getProperty("inValidUserName");
        invalidPassword = properties.getProperty("invalidPassword");
        validUserName = properties.getProperty("validUserName");
        validPassword = properties.getProperty("validPassword");
        //      BROWSER_NAME = properties.getProperty("browser.name");

    }

    @BeforeTest
    public static void readPropertyFile() {
        try {
            loadConfigPropertyFile("config.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
