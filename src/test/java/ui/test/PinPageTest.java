package ui.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pageobjects.HomePage;
import ui.pageobjects.PinPage;
import ui.steps.LoginStep;

public class PinPageTest extends BaseTest {

    @Test
    public void testAddNewPin() {
        // GIVEN
        LoginStep.login();

        // WHEN
        PinPage pinPage = new PinPage()
                .clickButtonAddPin()
                        .clickButtonConfirmAddPin()
                                .uploadInputUploadPin()
                .fillOutTextAreaAddTitle("title")
                .clickButtonSavePin();

        // THEN
        Assert.assertTrue(pinPage.isTextSavedPin());
    }
}
