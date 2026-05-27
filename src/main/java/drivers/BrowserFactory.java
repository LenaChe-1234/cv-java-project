package drivers;

import com.lena.automation.browser.browserstack.BrowserstackBrowserChrome;
import com.lena.automation.browser.browserstack.BrowserstackBrowserEdge;
import com.lena.automation.browser.browserstack.BrowserstackBrowserFirefox;
import com.lena.automation.browser.local.LocalChromeBrowser;
import com.lena.automation.browser.local.LocalEdgeBrowser;
import com.lena.automation.browser.local.LocalFirefoxBrowser;

public class BrowserFactory {

    public static IBrowserConfig getBrowser(String browser) {

        return switch (browser.toLowerCase()) {

            case "browserstack-chrome" ->
                    new BrowserstackBrowserChrome();

            case "browserstack-firefox" ->
                    new BrowserstackBrowserFirefox();

            case "browserstack-edge" ->
                    new BrowserstackBrowserEdge();

            case "chrome" ->
                    new LocalChromeBrowser();

            case "firefox" ->
                    new LocalFirefoxBrowser();

            case "edge" ->
                    new LocalEdgeBrowser();

            default ->
                    throw new IllegalArgumentException(
                            "Unknown browser: " + browser
                    );
        };
    }
}
