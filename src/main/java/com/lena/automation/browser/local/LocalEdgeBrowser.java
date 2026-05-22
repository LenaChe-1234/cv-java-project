package com.lena.automation.browser.local;

import com.google.common.collect.ImmutableMap;
import drivers.IBrowserConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Map;

public class LocalEdgeBrowser implements IBrowserConfig {

    @Override
    public WebDriver setupDriver() {

        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();

        return new EdgeDriver(options);
    }

    @Override
    public Map<String, Object> parameters() {
        return ImmutableMap.of(
                "isBrowserstack", false,
                "browser", "edge"
        );
    }
}
