package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PC2_MouseActions {
    
    WebDriver driver;
    
    @BeforeTest
    public void setup() {
        driver = PC1_Setup.setupBrowser();
        PC1_Setup.navigateToWebsite(driver);
    }
    
    @Test
    public void testDoubleClick() {
        WebElement heading = driver.findElement(By.xpath("//h1[contains(text(),'jQuery Context Menu Demo Gallery')]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(heading).perform();
        Assert.assertTrue(true, "Double click performed");
    }
    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    public static void performDoubleClick(WebDriver driver) {
        WebElement heading = driver.findElement(By.xpath("//h1[contains(text(),'jQuery Context Menu Demo Gallery')]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(heading).perform();
    }
    
    public static boolean performRightClick(WebDriver driver) {
        WebElement rightClickElement = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickElement).perform();
        
        WebElement contextMenu = driver.findElement(By.cssSelector(".context-menu-list"));
        return contextMenu.isDisplayed();
    }
}