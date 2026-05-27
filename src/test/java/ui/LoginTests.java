package ui;

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
