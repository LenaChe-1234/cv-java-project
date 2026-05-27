package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private static final String PAGE_NAME = "Login";
    private static final String URL = "/#/login";

    private final SelenideElement emailField = $("#email");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $("#loginButton");

    @Override
    protected String getUrl() {
        return URL;
    }

    @Override
    protected String getPageName() {
        return PAGE_NAME;
    }

    @Step("Assert login page is opened")
    @Override
    public void assertIsOpened() {
        emailField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
    }

    @Step("Login as {user}")
    public void loginAs(String user, String pass) {
        emailField.setValue(user);
        passwordField.setValue(pass);
        loginButton.click();
    }
}