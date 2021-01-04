package com.testAutomation.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasswordLoginPage extends BasePage {

    private By passWordLocator = By.id("login-passwd");
    private By loginButtonLocator = By.id("login-signin");
    private By signInErrorLocator = By.className("error-msg");
    private By signInProfileLocator = By.id("header-profile-button");
    @Step("Enter Password")
    public Boolean insertPassword(String password) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(passWordLocator)).sendKeys(password);
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
    @Step("Validate Wrong Password Error Message")
    public Boolean checkLoginFail() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(signInErrorLocator)).isDisplayed();
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }
    @Step("Validate Valid Password Success")
    public Boolean checkLoginSuccess() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(signInProfileLocator)).isDisplayed();
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }
    public Boolean validateYmailPasswordFail(String password) {
        insertPassword(password);
        loginButtonClick();
        return checkLoginFail();
    }

    public Boolean validateYmailPasswordSuccess(String password) {
        insertPassword(password);
        loginButtonClick();
        return checkLoginSuccess();
    }

}
