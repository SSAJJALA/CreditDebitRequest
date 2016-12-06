package com.cdmr.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by student on 11/27/16.
 */
public class CreateCDMRScript {
    public static WebDriver driver;

    @BeforeClass
    public static void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "/home/student/Documents/EnterpriseRepos/CreditDebitRequest/CreditDebitRequest/lib/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

    @Test
    public void testCreateCDMR() throws InterruptedException {
        //login to the cdmr app
        driver.findElement(By.name("j_username")).sendKeys("VYU6026");
        driver.findElement(By.name("j_password")).sendKeys("Stoney@2016");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        Thread.sleep(5000);

        //click on create cdmr link on index (main menu) page
        driver.findElement(By.linkText("Create Credit Debit Memo Request")).click();
        Thread.sleep(5000);

        //Submit the new CDMR request from create CDMR form
        driver.findElement(By.id("customer")).sendKeys("1000");
        driver.findElement(By.id("btn_retCust")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("Invoice")).sendKeys("2345");
        driver.findElement(By.id("btn_retInv")).click();
        Thread.sleep(5000);

        //driver.findElement(By.xpath("//table[@id='datatable1']/tbody/tr/td[contains(text(),'COAT STAND')]/pre‌​ceding-sibling::td/i‌​nput[@class='selInv']")).click();

        //Grab the invoice table
        WebElement datatable1 = driver.findElement(By.id("datatable1")).findElement(By.tagName("tbody"));

        // Now get all the TR elements from the table
        List<WebElement> allInvRows = datatable1.findElements(By.tagName("tr"));

        // And iterate over them, getting the cells
        for (WebElement rowInv : allInvRows) {
            List<WebElement> cellsInv = rowInv.findElements(By.tagName("td"));
            cellsInv.get(0).click();
            break;

        }

        Thread.sleep(4000);

        // Grab the adj table
        WebElement datatable2 = driver.findElement(By.id("datatable2")).findElement(By.tagName("tbody"));

        // Now get all the TR elements from the table
        List<WebElement> allRows = datatable2.findElements(By.tagName("tr"));

        // And iterate over them, getting the cells
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            cells.get(3).findElement(By.id("adjQty")).sendKeys("1");
            Select rc = new Select(cells.get(4).findElement(By.id("reasonCode")));
            rc.selectByValue("1-Defective");

            Select cd = new Select(cells.get(9).findElement(By.id("creditDebit")));
            cd.selectByValue("Credit");

        }

        Thread.sleep(2000);

        //Calculate
        driver.findElement(By.id("btn_calculate")).click();
        Thread.sleep(3000);

        //Submit
        driver.findElement(By.id("btn_submit")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("btn_message")).click();
        Thread.sleep(1000);


        //click on request search link on index (main menu) page
        driver.findElement(By.linkText("Requests Search")).click();
        Thread.sleep(2000);

        //Search for a requisition
        Select dropdown = new Select(driver.findElement(By.id("SearchOption")));
        dropdown.selectByVisibleText("All");
        Thread.sleep(500);

        driver.findElement(By.id("btn_search")).click();
        Thread.sleep(2000);





    }
}
