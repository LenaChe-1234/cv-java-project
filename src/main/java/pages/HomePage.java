package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage extends BasePage {

    private static final String PAGE_NAME = "Home";
    private static final String URL = "/";

    private final SelenideElement appRoot = $("app-root");

    private final SelenideElement closeDialogButton =
            $(".close-dialog, button[aria-label='Close'], button[aria-label='dismiss']");

    private final ElementsCollection productCards =
            $$("mat-card.mat-card, app-product mat-card");

    @Override
    protected String getUrl() {
        return URL;
    }

    @Override
    protected String getPageName() {
        return PAGE_NAME;
    }

    @Step("Assert home page is opened")
    @Override
    public void assertIsOpened() {
        appRoot.shouldBe(visible);
    }

    @Step("Close dialogs if present")
    public void closePopupsIfPresent() {
        if (closeDialogButton.exists()) {
            closeDialogButton.click();
        }
    }

    @Step("Open first product")
    public void openFirstProduct() {
        productCards.shouldHave(sizeGreaterThan(0));
        productCards.first().click();
    }
}
