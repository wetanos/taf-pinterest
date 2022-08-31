package ui.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pageobjects.HomePage;

public class LoginPageTest extends BaseTest {

    @Test
    public void testLoginWithValidCredentials() {
        // GIVEN
        String userEmail = "testwetanos@gmail.com";
        String userPassword = "rbhbkk25";
        HomePage homePage = new HomePage()
                .openPage()
                .clickButtonLogin()
        // WHEN
                .typeEmail(userEmail)
                .typePassword(userPassword)
                .clickButtonSubmitLogin()
        // THEN
                .clickButtonAccountOptions();
        Assert.assertTrue(homePage.isTitleUserAccount());
    }

    @Test
    public void testLoginWithEmptyEmailField() {
        // GIVEN
        String expectedError = "You missed a bit! Don't forget to add your email address.";
        HomePage homePage = new HomePage()
                .openPage()
                .clickButtonLogin()
        // WHEN
                .clickButtonSubmitLogin();
        // THEN
        Assert.assertEquals(homePage.getTextEmailFieldError(), expectedError);
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        // GIVEN
        String userEmail = "mailinator@mailinator.com";
        String userPassword = "password";
        String expectedError = "The password you entered is incorrect.";
        HomePage homePage = new HomePage()
                .openPage()
                .clickButtonLogin()
                // WHEN
                .typeEmail(userEmail)
                .typePassword(userPassword)
                .clickButtonSubmitLogin();
                // THEN
        Assert.assertEquals(homePage.getTextPasswordFieldError(), expectedError);
    }
}
