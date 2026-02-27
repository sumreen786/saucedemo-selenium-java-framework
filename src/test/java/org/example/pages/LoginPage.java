package org.example.pages;

import org.example.utils.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class LoginPage {

    WebDriver driver;
    WaitManager wait;

    By UserNameCred = By.xpath("//input[@placeholder='Username']");
    By UserPassCred = By.xpath("//input[@placeholder='Password']");
    By explicitClick = By.xpath("//input[@type='submit']");
    By errorMsg = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver1) {
        this.driver = driver1;
        this.wait = new WaitManager(driver1);
    }

    public void login(String user, String pass) {

        wait.explicitWaitSendKeys(UserNameCred);
        driver.findElement(UserNameCred).sendKeys(user);

        wait.explicitWaitSendKeys(UserPassCred);
        driver.findElement(UserPassCred).sendKeys(pass);

        wait.explicitWaitClickable(explicitClick);


    }
    public String getErrorMessage() {
        wait.waitForVisibility(errorMsg);
        return driver.findElement(errorMsg).getText();
    }
}
