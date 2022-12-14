package ui.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import ui.driver.SingletonWebDriver;
import ui.utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    @BeforeTest
    public void startTest() {
        SingletonWebDriver.getDriver();
    }

    @AfterTest
    public void finishTest() {
        SingletonWebDriver.closeDriver();
    }
}
