package ui.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PinPage extends BasePage {

    @FindBy(xpath = "//div[@data-test-id='addPinButton']")
    private WebElement buttonAddPin;

    @FindBy(xpath = "//div[@id='header-create-dropdown-item-1']")
    private WebElement buttonConfirmAddPin;

    @FindBy(xpath = "//input[@aria-label='File upload']")
    private WebElement inputUploadPin;

    @FindBy(xpath = "//textarea[@placeholder='Add your title']")
    private WebElement textAreaAddTitle;

    @FindBy(xpath = "//div[@data-test-id='editor-with-mentions']//div[@class='public-DraftEditorPlaceholder-inner']")
    private WebElement inputAddDescription;

    @FindBy(xpath = "//button[@data-test-id='board-dropdown-save-button']")
    private WebElement buttonSavePin;

    @FindBy(xpath = "//div[@aria-label='Your saved Pin.']//h2")
    private WebElement textSavedPin;


    public PinPage clickButtonAddPin() {
        waitForElementToBeClickable(buttonAddPin);
        buttonAddPin.click();
        return this;
    }

    public PinPage clickButtonConfirmAddPin() {
        buttonConfirmAddPin.click();
        return this;
    }

    public PinPage uploadInputUploadPin() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputUploadPin.sendKeys("/Users/kirillvasilenko/Downloads/FpgCWgOvTXM.jpeg");
        return this;
    }

    public PinPage fillOutTextAreaAddTitle(String input) {
        textAreaAddTitle.sendKeys(input);
        return this;
    }

    public PinPage fillOutInputAddDescription(String input) {

        inputAddDescription.sendKeys(input);
        return this;
    }

    public PinPage clickButtonSavePin() {
        buttonSavePin.click();
        return this;
    }

    public boolean isTextSavedPin() {
        waitForVisibilityOfElement(textSavedPin);
        return textSavedPin.isDisplayed();
    }
}
