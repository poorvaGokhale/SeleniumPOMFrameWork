package com.testAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By userName = By.id("login-username");
    private By passWord = By.id("login-passwd");
    private By loginButton = By.id("login-signin");
    private By signInError = By.className("error-msg");
    private By signInProfile = By.id("header-profile-button");


    public void insertUserName(String username) {
        wait.until(ExpectedConditions.presenceOfElementLocated(userName)).sendKeys(username);
    }
    public void loginButtonClick() {
    wait.until(ExpectedConditions.presenceOfElementLocated(loginButton)).click();
    }

    public void insertPassword(String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(passWord)).sendKeys(password);
    }

    public Boolean checkLoginFail() {
        Boolean fail = wait.until(ExpectedConditions.presenceOfElementLocated(signInError)).isDisplayed();
        return fail;
    }

    public Boolean checkLoginSuccess() {
        Boolean success = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("header-profile-button"))).isDisplayed();
        return success;
    }
    public void setDriver(WebDriver driver) {
         this.driver = driver;
    }
    public void setWebDriverWait(WebDriverWait wait) {
         this.wait = wait;
    }

}
