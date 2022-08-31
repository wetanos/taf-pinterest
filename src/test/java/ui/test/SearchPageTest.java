package ui.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pageobjects.HomePage;
import ui.pageobjects.SearchPage;

public class SearchPageTest extends BaseTest{

    @Test
    public void testAddExistingPinToAccount() {
        // GIVEN
        String testInput = "memes";
        new HomePage().login();

        // WHEN
        SearchPage searchPage = new SearchPage()
                .fillOutSearchField(testInput);
        searchPage.clickRandomPin();
        String pinSrc = searchPage.getPinSrcValue();
        searchPage.clickButtonSavePin()
                .clickButtonHeaderProfile();

        // THEN
        Assert.assertTrue(searchPage.isPinSaved());
    }
}
