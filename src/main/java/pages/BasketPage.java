package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketPage extends BasePage {

    private static final String PAGE_NAME = "Basket";
    private static final String URL = "/#/basket";

    private final SelenideElement basketTitle =
            $("h1, [data-qa='basket-title'], mat-card-title");

    private final ElementsCollection basketItems =
            $$("#basket .mat-row, mat-row[data-qa='basket-item'], mat-table .mat-row");

    private final SelenideElement checkoutButton =
            $("button[aria-label*='Checkout'], button#checkoutButton, button[routerlink='/address/select']");

    private final ElementsCollection emptyBasketHints =
            $$(".notification, .mat-simple-snack-bar-content, [data-qa='basket-empty']");

    private static final String REMOVE_ITEM_BUTTON_CSS =
            "button[aria-label*='Remove'], button[aria-label*='Delete'], .mat-icon-button";

    @Override
    protected String getUrl() {
        return URL;
    }

    @Override
    protected String getPageName() {
        return PAGE_NAME;
    }

    @Step("Assert basket page is opened")
    @Override
    public void assertIsOpened() {
        basketTitle.shouldBe(visible);
    }

    @Step("Assert basket has items")
    public void assertHasItems() {
        basketItems
                .filter(visible)
                .shouldHave(sizeGreaterThan(0));
    }

    @Step("Remove first item from basket")
    public void removeFirstItem() {
        basketItems
                .filter(visible)
                .shouldHave(sizeGreaterThan(0))
                .first()
                .find(REMOVE_ITEM_BUTTON_CSS)
                .shouldBe(visible)
                .click();
    }

    @Step("Assert basket is empty")
    public void assertEmpty() {
        emptyBasketHints
                .findBy(visible)
                .shouldHave(matchText("(?i).*(empty|no items).*"));
    }

    @Step("Proceed to checkout")
    public void proceedToCheckout() {
        checkoutButton
                .shouldBe(visible, enabled)
                .click();
    }
}