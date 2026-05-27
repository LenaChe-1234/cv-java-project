package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.AccountMenu;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TopBar {

    public final AccountMenu accountMenu = new AccountMenu();

    private final SelenideElement basketButton = $("#navbarBasket");

    @Step("Open login page")
    public LoginPage openLogin() {
        accountMenu.openLoginPage();
        return new LoginPage();
    }

    @Step("Open basket")
    public BasketPage openBasket() {
        basketButton.shouldBe(visible).click();
        return new BasketPage();
    }
}