package ru.apolonov;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SiteWelcomeTests {
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
    void allFieldsValidTest() {
        webDriver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        webDriver.findElement(By.name("name")).sendKeys("Petya");
        webDriver.findElement(By.name("email")).sendKeys("petya@mail.com");
        webDriver.findElement(By.name("phone")).sendKeys("+79100101234");
        webDriver.findElement(By.className("button")).click();
        var actualResult = webDriver.findElement(By.className("start-screen__res")).getText();
        var expectResult = "Здравствуйте, Petya.\n" +
                "На вашу почту (petya@mail.com) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79100101234.";
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void allFieldsEmptyTest() {
        webDriver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        webDriver.findElement(By.className("button")).click();
        var actualResult = webDriver.findElement(By.className("start-screen__res")).getText();
        var expectResult = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assertions.assertEquals(expectResult, actualResult, "Неверное сообщение");
    }

    @Test
    void nameEmptyTest() {
        webDriver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        webDriver.findElement(By.name("email")).sendKeys("petya@mail.com");
        webDriver.findElement(By.name("phone")).sendKeys("+79100101234");
        webDriver.findElement(By.className("button")).click();
        var actualResult = webDriver.findElement(By.className("start-screen__res")).getText();
        var expectResult = "Здравствуйте, .\n" +
                "На вашу почту (petya@mail.com) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79100101234.";
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void emailEmptyTest() {
        webDriver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        webDriver.findElement(By.name("name")).sendKeys("Petya");
        webDriver.findElement(By.name("phone")).sendKeys("+79100101234");
        webDriver.findElement(By.className("button")).click();
        var actualResult = webDriver.findElement(By.className("start-screen__res")).getText();
        var expectResult = "Здравствуйте, Petya.\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79100101234.";
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void phoneEmptyTest() {
        webDriver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        webDriver.findElement(By.name("name")).sendKeys("Petya");
        webDriver.findElement(By.name("email")).sendKeys("petya@mail.com");
        webDriver.findElement(By.className("button")).click();
        var actualResult = webDriver.findElement(By.className("start-screen__res")).getText();
        var expectResult = "Здравствуйте, Petya.\n" +
                "На вашу почту (petya@mail.com) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void onlineCinemaAllFieldsValidTest() {
        webDriver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        webDriver.findElement(By.id("name")).sendKeys("Petya");
        webDriver.findElement(By.id("email")).sendKeys("skillbox@test.ru");
        webDriver.findElement(By.id("password")).sendKeys("qwerty!123");
        webDriver.findElement(By.className("form-submit")).click();
        var popupActualResult = webDriver.findElement(By.id("swal2-title")).getText();
        var popupExpectedResult = "У вас новое письмо. Нажмите сюда, чтобы просмотреть.";
        Assertions.assertEquals(popupExpectedResult, popupActualResult);
        var actualResult = webDriver.findElement(By.className("form-result")).getText();
        var expectResult = "Вам на почту skillbox@test.ru отправлено письмо";
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    void onlineCinemaAllFieldsEmptyTest() {
        webDriver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        webDriver.findElement(By.className("form-submit")).click();
        var actualResult = webDriver.findElement(By.className("form-error")).getText();
        var expectResult = "Введите имя";
        Assertions.assertEquals(expectResult, actualResult);
    }


}
