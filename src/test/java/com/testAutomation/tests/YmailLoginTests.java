package com.testAutomation.tests;

import com.testAutomation.pages.PasswordLoginPage;
import com.testAutomation.pages.UsrLoginPage;
import com.testAutomation.utils.PropertyUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

//@Listeners({ TestListener.class })
@Feature("Yahoo-Login:Yahoo Account Validation")
public class YmailLoginTests extends BaseTest {

    private UsrLoginPage usrLoginPage;
    private PasswordLoginPage passwordLoginPage;

    @Test(description = "Invalid Login Scenario with Invalid username", groups = {"Yahoo-Login",
            "regression", "ui"})
    @Description("Test Description: Login test with non-existing username")
    public void invalidUserTest() {
        usrLoginPage = new UsrLoginPage();
        assertThat(usrLoginPage.validateYmailUser(PropertyUtils.getProperty("inValidUserName").toString())).isTrue();
    }

    @Test(description = "Invalid Login Scenario with Invalid password.", groups = {
            "regression"})
    @Description("Test Description: Login test with valid username and wrong password.")
    public void inValidPasswordTest() {
        usrLoginPage = new UsrLoginPage();
        usrLoginPage.validateYmailUser(PropertyUtils.getProperty("validUserName").toString());
        passwordLoginPage = new PasswordLoginPage();
        assertThat(passwordLoginPage.validateYmailPasswordFail(PropertyUtils.getProperty("invalidPassword").toString())).isTrue();

    }
    @Test(description = "Valid Login Scenario with Valid credentials.", groups = {"Yahoo-Login",
            "sanity", "ui"})
    @Description("Test Description: Login test with valid username and valid password.")
    public void validPasswordTest() {
        usrLoginPage = new UsrLoginPage();
        usrLoginPage.validateYmailUser(PropertyUtils.getProperty("validUserName").toString());
        passwordLoginPage = new PasswordLoginPage();
        assertThat(passwordLoginPage.validateYmailPasswordSuccess(PropertyUtils.getProperty("validPassword").toString())).isTrue();
    }

}
