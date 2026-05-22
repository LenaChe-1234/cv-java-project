package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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

    @BeforeEach
    void setUpUi() {
        Configuration.baseUrl = Config.baseUrl();
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
    }

    @AfterEach
    void tearDownUi() {
        Selenide.closeWebDriver();
    }
}