package com.testAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordLoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //   By userName = By.id("login-username");
    private By passWord = By.id("login-passwd");
    private By loginButton = By.id("login-signin");
    private By signInError = By.className("error-msg");
    private By signInProfile = By.id("header-profile-button");


    public PasswordLoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void insertPassword(String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(passWord)).sendKeys(password);
        wait.until(ExpectedConditions.presenceOfElementLocated(loginButton)).click();

    }

    public Boolean checkLoginFail() {
        Boolean fail = false;
        fail = wait.until(ExpectedConditions.presenceOfElementLocated(signInError)).isDisplayed();
        return fail;
    }

    public Boolean checkLoginSuccess() {
        Boolean success = true;
        success = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("header-profile-button"))).isDisplayed();
        return success;
    }

}
