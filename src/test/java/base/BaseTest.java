package base;

import io.qameta.allure.Step;

public abstract class BaseTest {
    @Step("{description}")
    protected void step(String description, Runnable action) {
        action.run();
    }
}
