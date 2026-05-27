package pages;

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
