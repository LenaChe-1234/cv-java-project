package com.lena.automation.browser.browserstack;

import com.google.common.collect.ImmutableMap;
import com.lena.automation.browser.IBrowserConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class BrowserstackBrowserChrome implements IBrowserConfig {

    @Override
    public WebDriver setupDriver() {

        ChromeOptions options = new ChromeOptions();

        options.setCapability("browserstack.debug", true);
        options.setCapability("project", "cv-java-project");
        options.setCapability("build", BrowserstackBrowser.getBuild());

        options.setCapability("os", "Windows");
        options.setCapability("os_version", "11");

        options.setCapability("browserName", "Chrome");
        options.setCapability("browserVersion", "latest");

        options.setCapability("resolution", "1920x1080");

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
                "browser", "chrome"
        );
    }
}
