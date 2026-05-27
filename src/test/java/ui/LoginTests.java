package ui;

<<<<<<< HEAD
import base.BaseUiTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

@Epic("UI")
@Feature("Auth")
class LoginTests extends BaseUiTest {

    @Test
    void userCanLogin() {
        pages.login.open();
        pages.login.loginAs("demo@juice-sh.op", "Demo123!");
        pages.topBar.accountMenu.assertUserLoggedIn("demo@juice-sh.op");
    }
}
=======
@Epic("UI")
@Feature("Auth")
class LoginTests extends BaseUiTest {
    @Test
    @Story("Valid login")
    void userCanLogin() {
        new LoginPage().open().loginAs("demo@juice-sh.op", "demo");
        new HomePage().assertUserLoggedIn("demo");
    }
}
>>>>>>> origin/main
