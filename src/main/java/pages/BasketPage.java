package pages;

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
