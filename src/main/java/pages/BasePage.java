package pages;

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
    }
}