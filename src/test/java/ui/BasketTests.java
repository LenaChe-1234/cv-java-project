package ui;

import base.BaseUiTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

class BasketTests extends BaseUiTest {

    @Test
    void addProductToBasket_flow() {
        new HomePage().open().assertLoaded()
                .goToLogin();

        new LoginPage()
                .loginAs("demo@juice-sh.op", "demo");

        new HomePage()
                .openFirstProduct()
                .assertLoaded()
                .addItemToBasket()
                .openBasket()
                .assertLoaded()
                .assertHasItems();
    }
}
