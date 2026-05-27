package ui;

import base.BaseUiTest;
import org.junit.jupiter.api.Test;

class BasketTests extends BaseUiTest {

    @Test
    void addProductToBasket_flow() {
        pages.home.open();

        pages.topBar.openLogin();
        pages.login.loginAs("demo@juice-sh.op", "Dem≠o123!");

        pages.home.openFirstProduct();
        pages.product.assertIsOpened();
        pages.product.addToBasket();

        pages.topBar.openBasket();
        pages.basket.assertIsOpened();
        pages.basket.assertHasItems();
    }
}