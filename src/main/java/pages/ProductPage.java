package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage extends BasePage {

    private static final String PAGE_NAME = "Product";
    private static final String URL = "/#/search";

    private final SelenideElement productCard = $("mat-card, app-product mat-card");
    private final SelenideElement addToBasketButton = $("button[aria-label*='Add to Basket']");

    @Override
    protected String getUrl() {
        return URL;
    }

    @Override
    protected String getPageName() {
        return PAGE_NAME;
    }

    @Step("Assert product page is opened")
    @Override
    public void assertIsOpened() {
        productCard.shouldBe(visible);
    }

    @Step("Add product to basket")
    public void addToBasket() {
        addToBasketButton
                .shouldBe(visible, enabled)
                .click();
    }
}

