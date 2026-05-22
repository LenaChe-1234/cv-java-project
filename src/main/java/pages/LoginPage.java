package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "#email, input[type='email']")
    private WebElement email;

    @FindBy(css = "#password, input[type='password']")
    private WebElement password;

    @FindBy(css = "#loginButton, button#loginButton, button[type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage loginAs(String user, String pass) {
        email.clear();
        email.sendKeys(user);
        password.clear();
        password.sendKeys(pass);
        loginButton.click();
        return new HomePage(driver);
    }
}