package com.testAutomation.tests;

import com.testAutomation.pages.PasswordLoginPage;
import com.testAutomation.pages.UsrLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ymailLoginTests {
    WebDriver driver;
    WebDriverWait wait;
    UsrLoginPage usrLoginPage;
    PasswordLoginPage passwdLoginPage;

    String InValidUserName = "invalid";
    String InvalidPasswd = "invalid@123";
    String ValidUserName = "aamod_00";
    String ValidPasswd = "Welcome@2020";

    @BeforeTest
    public void setTests(){
        driver = new ChromeDriver ();
        wait = new WebDriverWait ( driver, 20 );
        String webUlr = "https://login.yahoo.com/";
        driver.get(webUlr);
    }
    @AfterTest
    public void TearDownTests(){
        driver.close();
    }

    @Test
    public void InvalidUserTest(){
        usrLoginPage = new UsrLoginPage ( driver, wait );
        usrLoginPage.InsertUserName ( InValidUserName);
        assertThat( usrLoginPage.CheckUserNameSuccess ());

    }

    @Test
    public void InValidPasswordTest(){
        usrLoginPage = new UsrLoginPage ( driver, wait );
        usrLoginPage.InsertUserName ( ValidUserName);
        passwdLoginPage = new PasswordLoginPage ( driver, wait );
        passwdLoginPage.InsertPassword ( InvalidPasswd );
        assertThat( passwdLoginPage.CheckLoginFail ());
    }

    @Test
    public void ValidPasswordTest(){
        usrLoginPage = new UsrLoginPage ( driver, wait );
        usrLoginPage.InsertUserName ( ValidUserName);
        passwdLoginPage = new PasswordLoginPage ( driver, wait );
        passwdLoginPage.InsertPassword ( ValidPasswd );
        assertThat( passwdLoginPage.CheckLoginSuccess ());
    }

}
