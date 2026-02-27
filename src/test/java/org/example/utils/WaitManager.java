package org.example.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitManager {
    WebDriver driver1;
    WebDriverWait wait;
    public final int DURATION = 10;

    public WaitManager(WebDriver wd) {
        this.driver1 = wd;
    }


    public void explicitWaitSendKeys(By locator) {
        wait = new WebDriverWait(driver1, Duration.ofSeconds(DURATION));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void explicitWaitClickable(By locator) {

        wait = new WebDriverWait(driver1, Duration.ofSeconds(DURATION));
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(locator));
        submit.click();
    }
    public void waitForVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(DURATION));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
