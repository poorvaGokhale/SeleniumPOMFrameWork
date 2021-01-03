package com.testAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordLoginPage  extends BasePage{

 /*   private WebDriver driver;
    private WebDriverWait wait;

    //   By userName = By.id("login-username");
    private By passWord = By.id("login-passwd");
    private By loginButton = By.id("login-signin");
    private By signInError = By.className("error-msg");
    private By signInProfile = By.id("header-profile-button");

*/
    public PasswordLoginPage (WebDriver driver, WebDriverWait wait) {
        setDriver(driver);
        setWebDriverWait(wait);
    }

    public Boolean validateYmailPasswordFail(String password){
        super.insertPassword(password);
        super.loginButtonClick();
        return super.checkLoginFail();
    }

    public Boolean validateYmailPasswordSuccess(String password){
        super.insertPassword(password);
        super.loginButtonClick();
        return super.checkLoginSuccess();
    }

}
