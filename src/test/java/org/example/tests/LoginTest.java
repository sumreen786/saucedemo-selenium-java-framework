package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void lockedLoginTest() {
        LoginPage login = new LoginPage(driver);
        login.login("locked_out_user", "secret_sauce");

        String error = login.getErrorMessage();
        Assert.assertTrue(error.contains("Sorry, this user has been locked out."));
    }
}
