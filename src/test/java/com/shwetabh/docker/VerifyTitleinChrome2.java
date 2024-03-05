package com.shwetabh.docker;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitleinChrome2 {
    static WebDriver driver;

    @BeforeClass
    public void setup() {
        System.out.println("Running test in Docker");

        // Use WebDriverManager to setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait time for elements to be found
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void googleSearch() throws InterruptedException {
        // Navigate to Google homepage
        driver.get("https://www.google.co.in/?gfe_rd=cr&ei=_CgsVrfTDe_I8Aeg4qnACg&gws_rd=ssl");

        // Print the title of the page
        System.out.println("Title of page is " + driver.getTitle());

        // Wait for 2 seconds (optional)
        Thread.sleep(2000);
    }

    @AfterClass
    public void teardown() {
        // Close the browser window and quit the WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
}
