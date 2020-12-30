package com.testAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class UsrLoginPage {

    WebDriver driver;
    WebDriverWait wait ;

   By userName = By.id("login-username");
   By loginButton = By.id("login-signin");
   By signInError = By.className("error-msg");



    public UsrLoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }



    public void InsertUserName(String UserName) {
        wait.until( ExpectedConditions.presenceOfElementLocated( userName )).sendKeys ( UserName );
        wait.until(ExpectedConditions.presenceOfElementLocated(loginButton)).click();

    }

    public Boolean CheckUserNameSuccess(){

      Boolean fail =  wait.until(ExpectedConditions.presenceOfElementLocated(signInError)).isDisplayed ();
      return fail;
    }

}
