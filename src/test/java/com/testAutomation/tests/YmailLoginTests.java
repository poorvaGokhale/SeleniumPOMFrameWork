package com.testAutomation.tests;

import com.testAutomation.pages.PasswordLoginPage;
import com.testAutomation.pages.UsrLoginPage;
import io.qameta.allure.Description;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class YmailLoginTests extends BaseTest{

    private UsrLoginPage usrLoginPage;
    private PasswordLoginPage passwordLoginPage;

    @Test
    public void invalidUserTest() {
        usrLoginPage = new UsrLoginPage(getDriver(), getWebDriverWait());
        assertThat(usrLoginPage.validateYmailUser(inValidUserName)).isTrue();
    }

    @Test
            //(description=”Invalid Login Scenario with wrong username and password.”)
 //   @Description(“Test Description: Login test with wrong username and wrong password.”)
    public void inValidPasswordTest() {
        usrLoginPage = new UsrLoginPage(getDriver(), getWebDriverWait());
        usrLoginPage.validateYmailUser(validUserName);
        passwordLoginPage = new PasswordLoginPage(getDriver(), getWebDriverWait());
        assertThat(passwordLoginPage.validateYmailPasswordFail(invalidPassword)).isTrue();
    }

    @Test
    public void validPasswordTest() {
        usrLoginPage = new UsrLoginPage(getDriver(), getWebDriverWait());
        usrLoginPage.validateYmailUser(validUserName);
        passwordLoginPage = new PasswordLoginPage(getDriver(), getWebDriverWait());
        assertThat(passwordLoginPage.validateYmailPasswordSuccess(validPassword)).isTrue();
    }

}
