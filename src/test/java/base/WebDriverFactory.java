package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class WebDriverFactory {
    private WebDriverFactory() {
    }

    public static WebDriver create() {
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--disable-dev-shm-usage", "--no-sandbox");
        if (Boolean.parseBoolean(System.getenv().getOrDefault("HEADLESS", "true"))) {
            opts.addArguments("--headless=new");
        }
        return new ChromeDriver(opts);
    }
}