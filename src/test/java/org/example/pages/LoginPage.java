package org.example.pages;

import org.example.utils.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    WaitManager wait;

    By usernameField = By.xpath("//input[@placeholder='Username']");
    By passwordField = By.xpath("//input[@placeholder='Password']");
    By loginButton = By.xpath("//input[@type='submit']");
    By errorMsg = By.cssSelector("[data-test='error']");


    public LoginPage(WebDriver driver1) {
        this.driver = driver1;
        this.wait = new WaitManager(driver1);
    }

//    public boolean isDisplayed() {
//        return driver.findElement(By.className("inventory_container")).isDisplayed();
//    }

    public void login(String user, String pass) {

        wait.explicitWaitSendKeys(usernameField);
        driver.findElement(usernameField).sendKeys(user);

        wait.explicitWaitSendKeys(passwordField);
        driver.findElement(passwordField).sendKeys(pass);


        wait.waitForClickable(loginButton).click();
    }

    public String getLockedErrorMessage() {
        wait.waitForVisibility(errorMsg);
        return driver.findElement(errorMsg).getText();
    }

//    public String getErrorMessageForInvallidCred() {
//        wait.waitForVisibility(invalidCred);
//        return driver.findElement(invalidCred).getText();
//    }

}


