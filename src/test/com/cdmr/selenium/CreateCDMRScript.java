package com.cdmr.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by student on 11/27/16.
 */
public class CreateCDMRScript {
    public static WebDriver driver;

    @BeforeClass
    public static void openBrowser() {
        //System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/toCreate");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

    @Test
    public void testCreateCDMR() throws InterruptedException {
        driver.findElement(By.name("j_username")).sendKeys("VYU6026");
        driver.findElement(By.name("j_password")).sendKeys("Stoney@2016");
        Thread.sleep(5000);

        driver.findElement(By.id("customer")).sendKeys("1000");
        driver.findElement(By.id("btn_retCust")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("Invoice")).sendKeys("2345");
        driver.findElement(By.id("btn_retInv")).click();
        Thread.sleep(5000);
    }
}
