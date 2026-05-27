package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
<<<<<<< HEAD
import com.codeborne.selenide.logevents.SelenideLogger;
import config.Config;
import drivers.WebDriverFactory;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.Pages;

public abstract class BaseUiTest extends BaseTest {

    protected Pages pages;
=======
import config.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.BasketPage;

public abstract class BaseUiTest extends BaseTest {
    protected HomePage home;
    protected LoginPage login;
    protected ProductPage product;
    protected BasketPage basket;
>>>>>>> origin/main

    @BeforeEach
    void setUpUi() {
        Configuration.baseUrl = Config.baseUrl();
<<<<<<< HEAD
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
=======
        Configuration.browser = Config.browser();
        Configuration.headless = Config.headless();
        Configuration.timeout = Config.timeoutMs();
        Configuration.pageLoadTimeout = Config.timeoutMs() * 2;
        Configuration.browserSize = "1920x1080";
        String remote = Config.remoteUrl();
        if (remote != null && !remote.isBlank()) {
            Configuration.remote = remote;
        }
        home = new HomePage();
        login = new LoginPage();
        product = new ProductPage();
        basket = new BasketPage();
>>>>>>> origin/main
    }

    @AfterEach
    void tearDownUi() {
        Selenide.closeWebDriver();
    }
}