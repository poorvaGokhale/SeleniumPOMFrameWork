package com.testAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class UsrLoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By userName = By.id("login-username");
    private By loginButton = By.id("login-signin");
    private By signInError = By.className("error-msg");

    public UsrLoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void insertUserName(String userName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(this.userName)).sendKeys(userName);
        wait.until(ExpectedConditions.presenceOfElementLocated(loginButton)).click();
    }

    public Boolean checkUserNameSuccess() {
        Boolean fail = false;
        fail = wait.until(ExpectedConditions.presenceOfElementLocated(signInError)).isDisplayed();
        return fail;
    }

}
