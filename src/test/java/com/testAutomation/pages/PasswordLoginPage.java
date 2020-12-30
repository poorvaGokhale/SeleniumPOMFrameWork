package com.testAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordLoginPage {

    WebDriver driver;
    WebDriverWait wait ;

 //   By userName = By.id("login-username");
    By passWord = By.id("login-passwd");
    By loginButton = By.id("login-signin");
    By signInError = By.className("error-msg");
    By signInProfile = By.id("header-profile-button");



    public PasswordLoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }



    public void InsertPassword(String Password) {
        wait.until( ExpectedConditions.presenceOfElementLocated( passWord )).sendKeys ( Password );
        wait.until(ExpectedConditions.presenceOfElementLocated(loginButton)).click();

    }

    public Boolean CheckLoginFail(){

        Boolean fail =  wait.until(ExpectedConditions.presenceOfElementLocated(signInError)).isDisplayed ();
            return fail;
    }

    public Boolean CheckLoginSuccess(){

        Boolean success = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("header-profile-button"))).isDisplayed();
        return success;
    }

}
