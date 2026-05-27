package ui;

import drivers.BrowserFactory;
import drivers.IBrowserConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class GoogleTest {

    @Test
    void googleTest() {
        IBrowserConfig browser = BrowserFactory.getBrowser("chrome");
        WebDriver driver = browser.setupDriver();

        driver.get("https://www.google.com");

        Assertions.assertTrue(Objects.requireNonNull(driver.getTitle()).contains("Google"));

        driver.quit();
    }

}
