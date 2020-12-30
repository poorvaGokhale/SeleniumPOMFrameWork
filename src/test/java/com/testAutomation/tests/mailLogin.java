package com.testAutomation.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import static org.junit.Assert.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

public class mailLogin {
    WebDriver driver = new ChromeDriver ();
    String webUlr = "https://login.yahoo.com/";
    String invalidUserName = "Poorva";
    String invalidPasswd = "invalid@123";
    String validUserName = "aamod_00";
    String validPasswd = "Welcom@2020";
    WebDriverWait wait = new WebDriverWait ( driver, 20 );
/*    ChromeOptions options = new ChromeOptions();
    options.addArgument("--allow-running-insecure-content");
    options.addArgument("--disable-web-security");
*/

    @Test
    public void InvalidPasswd(){
        //Valid Username  Invalid Passwd
        driver.get(webUlr);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-username"))).sendKeys(validUserName);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-signin"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-passwd"))).sendKeys(invalidPasswd);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-signin"))).click();
        assertThat(wait.until(ExpectedConditions.presenceOfElementLocated(By.className("error-msg"))).isDisplayed()).isTrue();
        driver.close();

    }
}
