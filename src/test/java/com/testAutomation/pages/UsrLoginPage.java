package com.testAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class UsrLoginPage extends BasePage{

    public UsrLoginPage (WebDriver driver, WebDriverWait wait) {
        setDriver(driver);
        setWebDriverWait(wait);
    }

    public Boolean validateYmailUser(String userName){
        super.insertUserName(userName);
        super.loginButtonClick();
        return super.checkLoginFail();
    }
}
