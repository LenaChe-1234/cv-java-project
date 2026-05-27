package com.lena.automation.browser.local;

import com.google.common.collect.ImmutableMap;
<<<<<<< HEAD
import config.Config;
=======
>>>>>>> origin/main
import drivers.IBrowserConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

public class LocalFirefoxBrowser implements IBrowserConfig {

    @Override
    public WebDriver setupDriver() {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();

        if (Config.headless()) {
            options.addArguments("-headless");
        }

        return new FirefoxDriver(options);
    }

    @Override
    public Map<String, Object> parameters() {
        return ImmutableMap.of(
                "isBrowserstack", false,
                "browser", "firefox"
        );
    }
}