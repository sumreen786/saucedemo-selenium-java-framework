package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.InventoryListPage;
import org.example.pages.LoginPage;
import org.example.utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

//    @Test
//    public void validLoginTest() {
//        LoginPage login = new LoginPage(driver);
//        login.login("standard_user", "secret_sauce");
//        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
//    }
//
//    @Test
//    public void lockedLoginTest() {
//        LoginPage login = new LoginPage(driver);
//        login.login("locked_out_user", "secret_sauce");
//
//        String error = login.getErrorMessage();
//        Assert.assertTrue(error.contains("Sorry, this user has been locked out."));
//    }
//
//    @Test
//    public void problemLoginUserTest() {
//        LoginPage login = new LoginPage(driver);
//        login.login("problem_user", "secret_sauce");
//
//        InventoryListPage inventory = new InventoryListPage(driver);
//        int brokenImages = inventory.getBrokenImageCount();
//        System.out.println("Broken Images: " + brokenImages);
//
//        Assert.assertTrue(brokenImages > 0, "Excepted broken images are not found");
//    }
//
//    @Test
//    public void performanceGlitchUser() {
//        LoginPage login = new LoginPage(driver);
//        login.login("performance_glitch_user", "secret_sauce");
//
//        InventoryListPage inventoryListPage = new InventoryListPage(driver);
//        Assert.assertTrue(inventoryListPage.isPageLoaded());
//    }

    @DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {
        return ExcelUtils.getTestData();
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String type, String value) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

        // ✅ VERY IMPORTANT
        type = type.trim().toLowerCase();

        if (type.equals("success")) {

            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains(value));

        } else if (type.equals("error")) {

            String errorMsg = loginPage.getErrorMessage();
            Assert.assertTrue(errorMsg.contains(value));

        } else if (type.equals("image")) {

            InventoryListPage inventoryPage = new InventoryListPage(driver);
            int brokenImages = inventoryPage.getBrokenImageCount();

            Assert.assertTrue(brokenImages > 0);

        } else {
            throw new RuntimeException("Invalid type in Excel: " + type);
        }
    }
    }







