package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WelcomeBanner {

    private final SelenideElement banner = $("app-welcome-banner");
    private final SelenideElement closeButton = $("button[aria-label='Close Welcome Banner']");

    @Step("Close welcome banner if present")
    public void closeIfPresent() {
        try {
            closeButton
                    .shouldBe(visible, Duration.ofSeconds(2))
                    .click();

            banner.should(disappear, Duration.ofSeconds(3));

        } catch (NoSuchElementException | TimeoutException ignored) {
        }
    }
}