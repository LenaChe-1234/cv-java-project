package com.lena.automation.browser.local;

import com.google.common.collect.ImmutableMap;
import com.lena.automation.browser.IBrowserConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class LocalChromeBrowser implements IBrowserConfig {

    @Override
    public WebDriver setupDriver() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");

        return new ChromeDriver(options);
    }

    @Override
    public Map<String, Object> parameters() {
        return ImmutableMap.of(
                "isBrowserstack", false,
                "browser", "chrome"
        );
    }
}
