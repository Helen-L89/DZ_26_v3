package tests;

import factory.DriverFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeadlessModeTest {

    @Test
    public void testInputField() {
        WebDriver driver = DriverFactory.createDriver("headless");
        try {
            driver.get("https://otus.home.kartushin.su/training.html");

            // Найти поле ввода и ввести текст
            WebElement inputField = driver.findElement(By.id("textInput"));
            inputField.sendKeys("ОТУС");

            // Проверка текста
            assertEquals("ОТУС", inputField.getAttribute("value"), "Текст не соответствует ожидаемому");
        } finally {
            driver.quit();
        }
    }
}

