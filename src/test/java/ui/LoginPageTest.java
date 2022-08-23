package ui;

import org.junit.Assert;
import org.junit.Test;
import ui.pageobjects.HomePage;

public class LoginPageTest extends BaseTest {

    @Test
    public void testLoginWithValidCredentials() {
        // GIVEN
        String userEmail = "testwetanos@gmail.com";
        String userPassword = "Password1";
        HomePage homePage = new HomePage()
                .openPage()
                .clickButtonLogin()

        // WHEN
                .typeEmail(userEmail)
                .typePassword(userPassword)
                .clickButtonSubmitLogin()
                .clickButtonAccountOptions();
        // THEN
        Assert.assertTrue(homePage.isTitleUserAccount());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
