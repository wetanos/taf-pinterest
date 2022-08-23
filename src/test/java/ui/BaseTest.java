package ui;

import org.junit.After;
import ui.webdriver.SingletonWebDriver;

public class BaseTest {
    @After
    public void finishTest() {
        SingletonWebDriver.closeDriver();
    }
}
