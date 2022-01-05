package ru.apolonov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CinemaTests extends TestBase {
    String siteUrl = "https://lm.skillbox.cc/qa_tester/module07/practice3/";

    @Test
    public void cinemaPositiveTest() {
        webDriver.navigate().to(siteUrl);
        webDriver.findElement(By.className("module_input_text")).sendKeys("Терминатор");
        webDriver.findElement(By.name("serials")).sendKeys("Война престолов");
        webDriver.findElement(By.id("save")).click();
        webDriver.findElement(By.id("two")).click();
        webDriver.findElement(By.id("save")).click();
        webDriver.findElement(By.id("ok")).click();
        var films = webDriver.findElement(By.id("best_films")).getText();
        Assertions.assertEquals("Терминатор", films);
        var serials = webDriver.findElement(By.id("best_serials")).getText();
        Assertions.assertEquals("Война престолов", serials);
    }

    @Test
    public void cinemaFullPositiveTest() {
        webDriver.navigate().to(siteUrl);
        webDriver.findElement(By.id("films")).sendKeys("Терминатор");
        webDriver.findElement(By.id("serials")).sendKeys("Война престолов");
        webDriver.findElement(By.id("save")).click();
        webDriver.findElement(By.id("two")).click();
        webDriver.findElement(By.className("fake-checkbox")).click();
        webDriver.findElement(By.id("save")).click();
        webDriver.findElement(By.id("ok")).click();
        var films = webDriver.findElement(By.id("best_films")).getText();
        Assertions.assertEquals("Терминатор", films);
        var serials = webDriver.findElement(By.id("best_serials")).getText();
        Assertions.assertEquals("Война престолов", serials);
        var language = webDriver.findElement(By.id("language")).getText();
        Assertions.assertEquals("С русскими субтитрами", language);

    }

    @Test
    public void cinemaEmptyTest() {
        webDriver.navigate().to(siteUrl);
        webDriver.findElement(By.id("two")).click();
        webDriver.findElement(By.id("save")).click();
        webDriver.findElement(By.id("ok")).click();
        var films = webDriver.findElement(By.id("best_films")).getText();
        Assertions.assertEquals("", films);
        var serials = webDriver.findElement(By.id("best_serials")).getText();
        Assertions.assertEquals("", serials);
        var language = webDriver.findElement(By.id("language")).getText();
        Assertions.assertEquals("", language);
        var age = webDriver.findElement(By.id("age")).getText();
        Assertions.assertEquals("", language);
    }
}
