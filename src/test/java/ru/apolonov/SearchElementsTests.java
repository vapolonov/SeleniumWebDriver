package ru.apolonov;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchElementsTests {
    private WebDriver webDriver;

    @BeforeEach
    public void setupBefore() {
        //System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void searchLocatorsTest() {
        webDriver.navigate().to("https://lm.skillbox.cc/qa_tester/module05/practice1/");
        var emailElement = webDriver.findElement(By.className("form-input"));
        var passwordElement = webDriver.findElement(By.id("password"));
        var passwordConfirmElement = webDriver.findElement(By.name("confirm_password"));
    }

    @Test
    public void searchLocatorsBookShopTest() {
        webDriver.navigate().to("http://qajava.skillbox.ru/");
        webDriver.findElement(By.id("footer")).findElement(By.linkText("Обратная связь"));
        webDriver.findElement(By.linkText("Предзаказы"));
        var firstButton = webDriver.findElement(By.className("book-add")).getText();
        Assertions.assertEquals("В КОРЗИНУ", firstButton);
        var basketCount = webDriver.findElement(By.id("cart_count")).getText();
        Assertions.assertEquals("0", basketCount);
        var menuBooks = webDriver.findElement(By.id("genres")).getText();
        Assertions.assertEquals("Книги", menuBooks);
        var search = webDriver.findElement(By.id("search-input")).getAttribute("placeholder");
        Assertions.assertEquals("Поиск по магазину...", search);
    }

    @Test
    public void countElementsTest() {
        webDriver.navigate().to("http://qajava.skillbox.ru/");
        var countElements = webDriver.findElements(By.className("book-info")).size();
        Assertions.assertEquals(15, countElements);
    }

    @Test
    public void siteShoesPositiveTest() {
        webDriver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        webDriver.findElement(By.name("check")).sendKeys("42");
        webDriver.findElement(By.id("check-size-button")).click();
        var actualResult = webDriver.findElement(By.className("error")).getText();
        Assertions.assertEquals("В нашем магазине есть обувь вашего размера", actualResult);
    }

    @Test
    public void siteShoesNegativeTest() {
        webDriver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        webDriver.findElement(By.name("check")).sendKeys("45");
        webDriver.findElement(By.id("check-size-button")).click();
        var actualResult = webDriver.findElement(By.id("size-error")).getText();
        Assertions.assertEquals("В нашем магазине нет обуви вашего размера", actualResult);
    }
}
