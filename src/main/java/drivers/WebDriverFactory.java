package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Config;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        return BrowserFactory.getBrowser(Config.browser()).setupDriver();
    }
}