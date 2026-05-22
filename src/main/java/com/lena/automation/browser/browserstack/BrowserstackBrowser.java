package com.lena.automation.browser.browserstack;

public class BrowserstackBrowser {

    public static String getBrowserstackURL() {

        String username = System.getenv("BROWSERSTACK_USERNAME");
        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");

        return String.format(
                "https://%s:%s@hub-cloud.browserstack.com/wd/hub",
                username,
                accessKey
        );
    }

    public static String getBuild() {
        return "UI Automation Build";
    }
}
