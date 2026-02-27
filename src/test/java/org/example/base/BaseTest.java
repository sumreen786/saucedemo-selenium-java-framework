package org.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        //Creates a remote browser session on Selenium Grid.
        ChromeOptions chromeOptions=new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://192.168.1.4:4444"),chromeOptions );
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    /*
  I created a BaseTest class to handle common test setup and teardown logic.
I declared a class-level variable WebDriver driver so that all test classes extending BaseTest can use the same browser instance.
In the setUp() method annotated with @BeforeClass, I initialize the browser using RemoteWebDriver to create a remote browser session on Selenium Grid. This allows tests to run on a remote machine or in parallel on different browsers.
I pass ChromeOptions and the Grid Hub URL to connect to the Selenium Grid.
After initializing the driver, I maximize the browser window and navigate to the application URL.
In the tearDown() method annotated with @AfterClass, I quit the browser session to properly close the driver after all test methods have completed.
     */
}
