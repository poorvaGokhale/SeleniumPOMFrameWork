package com.testAutomation.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UsrLoginPage extends BasePage {

    private By userNameLocator = By.id("login-username");
    private By loginButtonLocator = By.id("login-signin");
    private By signInErrorLocator = By.className("error-msg");

    @Step("Enter Username")
    public Boolean insertUserName(String username) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(userNameLocator)).sendKeys(username);
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }
    @Step("Click Login-SignIn button")
    public Boolean loginButtonClick() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(loginButtonLocator)).click();
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }
    @Step("Validate Wrong User Error Message")
    public Boolean checkLoginFail() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(signInErrorLocator)).isDisplayed();
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public Boolean validateYmailUser(String userName) {
        insertUserName(userName);
        loginButtonClick();
        return checkLoginFail();
    }
}
