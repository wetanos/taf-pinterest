package ui.pageobjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.driver.SingletonWebDriver;

public class BasePage {
    protected WebDriver driver;
    protected final String BASE_URL = "https://www.pinterest.com/";
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected final String TEST_USER_EMAIL = "testwetanos@gmail.com";
    protected final String TEST_USER_PASSWORD = "Password1";

    protected BasePage() {
        driver = SingletonWebDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    protected boolean waitForElementToBeNotVisible(WebElement webElement) {
        boolean isWebElementNotVisible = false;
        try {
            isWebElementNotVisible = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                    .invisibilityOf(webElement));
        } catch (TimeoutException e) {
            isWebElementNotVisible = true;
        }
        return isWebElementNotVisible;
    }

    protected WebElement waitForElementToBeClickable(WebElement webElement) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement waitForVisibilityOfElement(WebElement webElement) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .visibilityOf(webElement));
    }
}
