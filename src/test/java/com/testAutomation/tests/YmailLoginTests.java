package com.testAutomation.tests;

import com.testAutomation.pages.PasswordLoginPage;
import com.testAutomation.pages.UsrLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class YmailLoginTests extends BaseTest{

    private UsrLoginPage usrLoginPage;
    private PasswordLoginPage passwdLoginPage;

    @Test
    public void invalidUserTest() {
        usrLoginPage = new UsrLoginPage(getDriver(), getWebDriverWait());
        assertThat(usrLoginPage.validateYmailUser(inValidUserName)).isTrue();
    }

    @Test
    public void inValidPasswordTest() {
        usrLoginPage = new UsrLoginPage(getDriver(), getWebDriverWait());
        usrLoginPage.validateYmailUser(validUserName);

        passwdLoginPage = new PasswordLoginPage(getDriver(), getWebDriverWait());
        assertThat(passwdLoginPage.validateYmailPasswordFail(invalidPasswd)).isTrue();
    }

    @Test
    public void validPasswordTest() {
        usrLoginPage = new UsrLoginPage(getDriver(), getWebDriverWait());
        usrLoginPage.validateYmailUser(validUserName);
        passwdLoginPage = new PasswordLoginPage(getDriver(), getWebDriverWait());
        assertThat(passwdLoginPage.validateYmailPasswordSuccess(validPasswd)).isTrue();
    }

}
