package com.lena.automation.browser.browserstack;

import com.google.common.collect.ImmutableMap;
import drivers.IBrowserConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class BrowserstackBrowserFirefox implements IBrowserConfig {

    @Override
    public WebDriver setupDriver() {

        FirefoxOptions options = new FirefoxOptions();

        options.setCapability("browserstack.debug", true);
        options.setCapability("project", "cv-java-project");
        options.setCapability("build", BrowserstackBrowser.getBuild());

        options.setCapability("os", "Windows");
        options.setCapability("os_version", "11");

        options.setCapability("browserName", "Firefox");
        options.setCapability("browserVersion", "latest");

        try {
            return new RemoteWebDriver(
                    new URL(BrowserstackBrowser.getBrowserstackURL()),
                    options
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, Object> parameters() {
        return ImmutableMap.of(
                "isBrowserstack", true,
                "browser", "firefox"
        );
    }
}
