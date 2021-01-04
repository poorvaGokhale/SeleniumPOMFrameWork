package com.testAutomation.tests;

import com.testAutomation.pages.BasePage;
import com.testAutomation.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import java.io.IOException;
import java.util.Properties;
public class BaseTest {
    private static WebDriver driver;

    private static WebDriverWait wait;
    protected static BasePage basePage;
    private static Properties properties;

    @BeforeTest
    public static void readPropertyFile() {
        try {
            PropertyUtils.loadConfigPropertyFile("config.properties");
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
        basePage = new BasePage();
        basePage.setWebDriver(driver,wait);
    }

    @AfterMethod
    public void tearDownTests() {
        driver.close();
    }

}
