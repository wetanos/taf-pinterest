package ui.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pageobjects.HomePage;
import ui.pageobjects.PinPage;

public class PinPageTest extends BaseTest {

    @Test
    public void testAddNewPin() {
        // GIVEN
        new HomePage().login();

        // WHEN
        PinPage pinPage = new PinPage()
                .clickButtonAddPin()
                        .clickButtonConfirmAddPin()
                                .uploadInputUploadPin()
                .fillOutTextAreaAddTitle("title")
                .clickButtonSavePin();

        // THEN
        Assert.assertTrue(pinPage.isTextSavedPin());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
