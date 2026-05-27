package pages;

<<<<<<< HEAD
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
=======
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public BasketPage assertLoaded() {
        driver.findElement(By.cssSelector("h1, [data-qa='basket-title'], mat-card-title"));
        return this;
    }

    public void assertHasItems() {
        List<WebElement> items = driver.findElements(By.cssSelector("#basket .mat-row, mat-row[data-qa='basket-item'], mat-table .mat-row"));
        if (items.isEmpty()) {
            throw new AssertionError("Basket is empty");
        }
    }

    public BasketPage removeFirstItem() {
        WebElement firstRow = driver.findElements(By.cssSelector("#basket .mat-row, mat-table .mat-row")).get(0);
        firstRow.findElement(By.cssSelector("button[aria-label*='Remove'], button[aria-label*='Delete'], .mat-icon-button")).click();
        return this;
    }

    public BasketPage assertEmpty() { // Soft check via presence of “empty” notification/snackbar
        List<WebElement> hints = driver.findElements(By.cssSelector(".notification, .mat-simple-snack-bar-content, [data-qa='basket-empty']"));
        boolean anyEmptyMsg = hints.stream().anyMatch(e -> {
            String t = e.getText();
            return t != null && t.toLowerCase().matches(".(empty|no items).");
        });
        if (!anyEmptyMsg) {
            throw new AssertionError("Basket is not empty");
        }
        return this;
    }

    public BasketPage proceedToCheckout() {
        driver.findElement(By.cssSelector("button[aria-label*='Checkout'], button#checkoutButton, button[routerlink='/address/select']")).click();
        return this;
    }
}
>>>>>>> origin/main
