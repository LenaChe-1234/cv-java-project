package pages;

import static com.codeborne.selenide.Selenide.*;

public class TopBar {
    public LoginPage openLogin() {
        $("button[aria-label='Show/hide account menu'], #navbarAccount").click();
        $("button[aria-label='Go to login page'], #navbarLoginButton").click();
        return new LoginPage();
    }

    public BasketPage openBasket() {
        $("button[aria-label='Show the shopping cart'], #navbarBasket, a[routerlink='/basket']").click();
        return new BasketPage();
    }
}
