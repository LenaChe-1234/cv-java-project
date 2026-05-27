package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "button[aria-label='Show/hide account menu'], #navbarAccount")
    private WebElement accountMenu;

    @FindBy(css = "button[aria-label='Go to login page'], #navbarLoginButton")
    private WebElement loginLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open(String baseUrl) {
        driver.get(baseUrl + "/");
        try {
            WebElement close = driver.findElement(By.cssSelector(".close-dialog, button[aria-label='Close'], button[aria-label='dismiss']"));
            close.click();
        } catch (Exception ignore) {
        }
        return this;
    }

    public HomePage assertLoaded() {
        driver.findElement(By.cssSelector("app-root"));
        return this;
    }

    public LoginPage goToLogin() {
        accountMenu.click();
        loginLink.click();
        return new LoginPage(driver);
    }

    public ProductPage openFirstProduct() {
        driver.findElements(By.cssSelector("mat-card.mat-card, app-product mat-card")).get(0).click();
        return new ProductPage(driver);
    }
}