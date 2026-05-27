package pages;

import org.openqa.selenium.WebDriver;

public class Pages {
    private final WebDriver driver;

    public Pages(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage home() {
        return new HomePage(driver);
    }

    public LoginPage login() {
        return new LoginPage(driver);
    }

    public ProductPage product() {
        return new ProductPage(driver);
    }

    public BasketPage basket() {
        return new BasketPage(driver);
    }
}