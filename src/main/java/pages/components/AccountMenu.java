package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AccountMenu {

    private final SelenideElement accountMenuButton = $("#navbarAccount");
    private final SelenideElement loginPageButton = $("#navbarLoginButton");
    private final SelenideElement logoutButton = $("#navbarLogoutButton");
    private final SelenideElement userProfileButton = $("button[aria-label='Go to user profile']");

    @Step("Open account menu")
    public void open() {
        accountMenuButton.shouldBe(visible).click();
    }

    @Step("Open login page from account menu")
    public void openLoginPage() {
        open();
        loginPageButton.shouldBe(visible).click();
    }

    @Step("Assert user is logged in as {email}")
    public void assertUserLoggedIn(String email) {
        open();
        userProfileButton
                .shouldBe(visible)
                .shouldHave(text(email));
    }

    @Step("Logout")
    public void logout() {
        open();
        logoutButton.shouldBe(visible).click();
    }
}