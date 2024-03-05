package com.shwetabh.docker;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitleinChrome {
    static WebDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        System.out.println("Running test in Docker");

        // Use WebDriverManager to setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Define capabilities for Chrome browser
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");

        // Set up the URL for Selenium Grid hub
        String gridUrl = "http://localhost:4444/wd/hub";

        // Create a RemoteWebDriver instance
        driver = new RemoteWebDriver(new URL(gridUrl), capabilities);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void aajtakSearch() throws InterruptedException {
        driver.navigate().to("https://www.aajtak.in/");
        System.out.println("Title of page is " + driver.getTitle());
        Thread.sleep(2000);
    }

    @AfterClass
    public void teardown() throws InterruptedException {
        if (driver != null) {
            driver.quit();
        }
        Thread.sleep(2000);
    }
}
