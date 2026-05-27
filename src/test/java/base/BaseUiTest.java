package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.Config;
import drivers.WebDriverFactory;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.Pages;

public abstract class BaseUiTest extends BaseTest {

    protected Pages pages;

    @BeforeEach
    void setUpUi() {
        Configuration.baseUrl = Config.baseUrl();
        Configuration.browser = WebDriverFactory.class.getName();
        Configuration.timeout = Config.timeoutMs();
        Configuration.browserSize = "1920x1080";

        Configuration.screenshots = true;
        Configuration.savePageSource = true;
        Configuration.reportsFolder = "target/selenide-reports";

        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
        );

        pages = Pages.getInstance();
    }

    @AfterEach
    void tearDownUi() {
        Selenide.closeWebDriver();
    }
}