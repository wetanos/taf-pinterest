package ui.steps;

import ui.pageobjects.HomePage;

public class LoginStep {
    public static HomePage login(){
        String userEmail = "testwetanos@gmail.com";
        String userPassword = "rbhbkk25";
        return new HomePage().openPage()
                .clickButtonLogin()
                .typeEmail(userEmail)
                .typePassword(userPassword)
                .clickButtonSubmitLogin();
    }
}
