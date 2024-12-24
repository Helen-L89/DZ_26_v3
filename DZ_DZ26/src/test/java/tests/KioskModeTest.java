package tests;

import factory.DriverFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KioskModeTest {

    @Test
    public void testModalWindow() {
        WebDriver driver = DriverFactory.createDriver("kiosk");
        try {
            driver.get("https://otus.home.kartushin.su/training.html");

            // Нажать на "Открыть модальное окно"
            WebElement openModalButton = driver.findElement(By.id("openModalBtn"));
            openModalButton.click();

            // Проверить, что модальное окно открылось
            WebElement modalWindow = driver.findElement(By.id("myModal"));
            assertTrue(modalWindow.isDisplayed(), "Модальное окно не отображается");
        } finally {
            driver.quit();
        }
    }
}

