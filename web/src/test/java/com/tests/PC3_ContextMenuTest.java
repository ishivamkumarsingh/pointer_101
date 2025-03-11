package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PC3_ContextMenuTest {
    
    WebDriver driver;
    
    @BeforeTest
    public void setup() {
        driver = PC1_Setup.setupBrowser();
    }
    
    @Test
    public void testContextMenu() {
        PC1_Setup.navigateToWebsite(driver);
        
        boolean isTitleValid = PC1_Setup.validatePageTitle(driver);
        Assert.assertTrue(isTitleValid, "Page title validation failed");
        
        PC2_MouseActions.performDoubleClick(driver);
        
        boolean isContextMenuDisplayed = PC2_MouseActions.performRightClick(driver);
        Assert.assertTrue(isContextMenuDisplayed, "Context menu is not displayed");
    }
    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}