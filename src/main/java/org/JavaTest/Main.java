package org.JavaTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

 class TestApelsin {
    static WebDriver driver;
    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Убедитесь, что путь правильный
        driver = new ChromeDriver();
        driver.get("https://www.dns-shop.ru/");
    }

    @Test
    public void testAddMostExpensiveSmartphone() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.linkText("Каталог")).click();
        driver.findElement(By.linkText("Смартфоны")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.sort-button")));

        driver.findElement(By.cssSelector("button.sort-button")).click();
        driver.findElement(By.xpath("//span[text()='Сначала дорогие']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'apple-iphone-16-pro-max-1024-gb-bezevyj')]")));
        driver.findElement(By.xpath("//a[contains(@href, 'apple-iphone-16-pro-max-1024-gb-bezevyj')]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.buy-button")));
        driver.findElement(By.cssSelector("button.buy-button")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}