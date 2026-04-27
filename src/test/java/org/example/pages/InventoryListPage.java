package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryListPage {
    WebDriver driver;

//    By addToCartBtns = By.xpath("//button[text()='Add to cart']");
//    By removeBtns = By.xpath("//button[text()='Remove']");

    public InventoryListPage(WebDriver driver) {
        this.driver = driver;

    }

//    public boolean isPageLoaded() {
//        return driver.findElement(By.id("inventory_container")).isDisplayed();
//    }

    public int getBrokenImageCount() {
        List<WebElement> images = driver.findElements(By.cssSelector(".inventory_item_img img"));
        int count = 0;

        for (WebElement img : images) {
            String src = img.getAttribute("src");

            if (src.contains("404")) {
                count++;
            }
        }
        return count;
    }




}
