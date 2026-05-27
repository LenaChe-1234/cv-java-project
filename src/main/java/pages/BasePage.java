package pages;

<<<<<<< HEAD
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import pages.components.GlobalComponents;

public abstract class BasePage {

    protected final GlobalComponents global =
            new GlobalComponents();

    protected abstract String getUrl();

    protected abstract String getPageName();

    public abstract void assertIsOpened();

    @Step("Open page")
    public void open() {
        Selenide.open(getUrl());

        closeGlobalPopups();

        assertIsOpened();
    }

    protected void closeGlobalPopups() {
        global.welcomeBanner.closeIfPresent();
=======
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class BasePage {
    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
>>>>>>> origin/main
    }
}