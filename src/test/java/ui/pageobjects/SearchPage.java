package ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends BasePage{

    Actions actions = new Actions(driver);
    int randomIndex;
    String srcText;

    @FindBy(xpath = "//input[@name='searchBoxInput']")
    private WebElement inputSearch;

    @FindBy(xpath = "//div[@data-test-id='pin']")
    private List<WebElement> pins;

    @FindBy(xpath = "//div[@data-test-id='closeup-body-image-container']//img | //div[@data-test-id='story-pin-closeup-page']//video")
    private WebElement videoOrImgOfPin;

    @FindBy(xpath = "//div[@data-test-id='PinBetterSaveButton']")
    private WebElement buttonSavePin;

    @FindBy(xpath = "//div[@data-test-id='header-profile']")
    private WebElement buttonHeaderAccount;

    public SearchPage fillOutSearchField(String input) {
        waitForElementToBeClickable(inputSearch);
        inputSearch.click();
        inputSearch.sendKeys(input);
        inputSearch.sendKeys(Keys.ENTER);
        return this;
    }
    public String getPinSrcValue() {
        srcText = videoOrImgOfPin.getAttribute("src");
        return videoOrImgOfPin.getAttribute("src");
    }

    public boolean isPinSaved() {
        String xpathSrc = "//*[@src='" + srcText + "']";
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathSrc)));
        WebElement srcOfSavedPin = driver.findElement(By.xpath(xpathSrc));
        return srcOfSavedPin.isDisplayed();
    }

    public SearchPage clickRandomPin() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .visibilityOfAllElements(pins));
        randomIndex = new java.util.Random().nextInt(pins.size());
        pins.get(randomIndex).click();
        return this;
    }

    public SearchPage clickButtonHeaderProfile() {
        buttonHeaderAccount.click();
        return this;
    }

    public SearchPage clickButtonSavePin() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buttonSavePin.click();
        return this;
    }
}
