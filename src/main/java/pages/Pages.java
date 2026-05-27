package pages;

<<<<<<< HEAD
public final class Pages {

    private static volatile Pages instance;

    public final LoginPage login = new LoginPage();
    public final HomePage home = new HomePage();
    public final BasketPage basket = new BasketPage();
    public final ProductPage product = new ProductPage();

    public final TopBar topBar = new TopBar();

    private Pages() {
    }

    public static Pages getInstance() {
        Pages local = instance;

        if (local == null) {
            synchronized (Pages.class) {
                if (instance == null) {
                    instance = local = new Pages();
                }
            }
        }

        return local;
=======
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
>>>>>>> origin/main
    }
}