package ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    String userEmail = "testwetanos@gmail.com";
    String userPassword = "rbhbkk25";
    String NAME = "Log in";

    @FindBy(xpath = "//div[@data-test-id='simple-login-button']/button")
    private WebElement buttonLogin;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//div[@data-test-id='registerFormSubmitButton']/button")
    private WebElement buttonSubmitLogin;

    @FindBy(xpath = "//div[@data-test-id='header-accounts-options-button']//button")
    private WebElement buttonAccountOptions;

    @FindBy(xpath = "//div[@id='HeaderAccountOptionsFlyout']")
    private WebElement menuUserAccount;

    @FindBy(xpath = "//span[@id='email-error']")
    private WebElement textEmailError;

    public HomePage clickButtonLogin() {
        buttonLogin.click();
        return this;
    }

    public HomePage typeEmail(String username) {
        waitForElementToBeClickable(inputEmail);
        inputEmail.sendKeys(username);
        return this;
    }

    public HomePage typePassword(String password) {
        waitForElementToBeClickable(inputPassword);
        inputPassword.sendKeys(password);
        return this;
    }

    public HomePage clickButtonSubmitLogin() {
        waitForElementToBeClickable(buttonSubmitLogin);
        buttonSubmitLogin.click();
        return this;
    }

    public HomePage clickButtonAccountOptions() {
        waitForElementToBeClickable(buttonAccountOptions);
        buttonAccountOptions.click();
        return this;
    }

    public boolean isTitleUserAccount() {
        String xpathTitleUserAccount = "//div[@id='HeaderAccountOptionsFlyout']//div[@title='" + TEST_USER_EMAIL + "']";
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathTitleUserAccount)));
        WebElement titleUserAccount = driver.findElement(By.xpath(xpathTitleUserAccount));
        return titleUserAccount.isDisplayed();
    }

    public HomePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public HomePage login() {
        openPage()
                .clickButtonLogin()
                .typeEmail(userEmail)
                .typePassword(userPassword)
                .clickButtonSubmitLogin();
        return this;
    }

    public String getTextEmailError() {
        return textEmailError.getText();
    }
}
