package com.testAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public void setWebDriver(WebDriver driver, WebDriverWait wait) {
        BasePage.driver = driver;
        BasePage.wait =wait;
    }
}
