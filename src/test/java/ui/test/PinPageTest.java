package ui.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pageobjects.PinPage;
import ui.steps.LoginStep;

public class PinPageTest extends BaseTest {

    @Test
    public void testAddNewPin() {
        // GIVEN
        LoginStep.login();
        String pinTitle = "Title";

        // WHEN
        PinPage pinPage = new PinPage()
                .clickButtonAddPin()
                .clickButtonConfirmAddPin()
                .uploadInputUploadPin()
                .fillOutTextAreaAddTitle(pinTitle)
                .clickButtonSavePin();

        // THEN
        Assert.assertTrue(pinPage.isTextSavedPin());
    }
}
