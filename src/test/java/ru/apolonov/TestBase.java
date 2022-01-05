package ru.apolonov;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    static WebDriver webDriver;

    @BeforeAll
    static void setupBefore() {
        //System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @AfterAll
    static void tearDown() {
        webDriver.quit();
    }
}
