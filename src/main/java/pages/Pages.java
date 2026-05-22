package pages;

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
    }
}