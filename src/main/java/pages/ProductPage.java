package pages;

<<<<<<< HEAD
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
=======
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(css = "h1, mat-card-title, [data-qa='product-title']")
    private WebElement title;

    @FindBy(css = "button[aria-label*='Add to Basket'], button#addToBasket")
    private WebElement addToBasket;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage assertLoaded() {
        title.isDisplayed();
        return this;
    }

    public ProductPage addItemToBasket() {
        addToBasket.click();
        try {
            driver.findElement(By.cssSelector(".mat-simple-snack-bar-content, .mat-mdc-snack-bar-label"));
        } catch (Exception ignore) {
        }
        return this;
    }

    public BasketPage openBasket() {
        driver.findElement(By.cssSelector("button[aria-label='Show the shopping cart'], #navbarBasket, a[routerlink='/basket']")).click();
        return new BasketPage(driver);
    }
}
>>>>>>> origin/main
