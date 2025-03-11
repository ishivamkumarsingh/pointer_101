package com.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PC1_Setup {
    
    WebDriver driver;
    
    @BeforeTest
    public void setup() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test
    public void navigateAndValidateTitle() {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("jQuery contextMenu"), "Page title validation failed");
    }
    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    public static WebDriver setupBrowser() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    
    public static void navigateToWebsite(WebDriver driver) {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
    }
    
    public static boolean validatePageTitle(WebDriver driver) {
        String pageTitle = driver.getTitle();
        return pageTitle.contains("jQuery contextMenu");
    }
}