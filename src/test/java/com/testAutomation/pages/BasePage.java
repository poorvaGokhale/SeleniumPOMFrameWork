package com.testAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By userNameLocator = By.id("login-username");
    private By passWordLocator = By.id("login-passwd");
    private By loginButtonLocator = By.id("login-signin");
    private By signInErrorLocator = By.className("error-msg");
    private By signInProfileLocator = By.id("header-profile-button");


    public Boolean insertUserName(String username) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(userNameLocator)).sendKeys(username);
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }
    public Boolean loginButtonClick() {
        try{
    wait.until(ExpectedConditions.presenceOfElementLocated(loginButtonLocator)).click();
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public Boolean insertPassword(String password) {
        try{
        wait.until(ExpectedConditions.presenceOfElementLocated(passWordLocator)).sendKeys(password);
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public Boolean checkLoginFail() {
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(signInErrorLocator)).isDisplayed();
    } catch (TimeoutException ex) {
        return false;
    }
        return true;
    }

    public Boolean checkLoginSuccess() {
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(signInProfileLocator)).isDisplayed();
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public void setDriver(WebDriver driver) {
         this.driver = driver;
    }
    public void setWebDriverWait(WebDriverWait wait) {
         this.wait = wait;
    }

}
