package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleSearchResultOnePage;
import page.GoogleSearchResultTwoPage;

import java.util.List;


public class GoogleSearchTest extends GoogleBaseTest {

    @Test
    public void googleSearchTest() {
        String searchTerm = "Selenium";
        Assert.assertTrue(googleSearchPage.isPageLoaded(), "Google search page is not displayed.");

        GoogleSearchResultOnePage googleSearchResultOnePage = googleSearchPage.search(searchTerm);
        Assert.assertTrue(googleSearchResultOnePage.isPageLoaded(),
                "Google search results page one is not loaded");
        Assert.assertEquals(googleSearchResultOnePage.getResultsCount(), 10,
                "Search results count is incorrect.");

        List<String> resultsList1 = googleSearchResultOnePage.getResultsList();
        for (String result : resultsList1) {
            Assert.assertTrue(result.contains(searchTerm),
                    "Searchterm "+searchTerm+" is missing in following result: \n" +result);
        }

        GoogleSearchResultTwoPage googleSearchResultTwoPage = googleSearchResultOnePage.clickOnSecondPage();
        Assert.assertTrue(googleSearchResultTwoPage.isPageLoaded(),
                "Google search results page two is not loaded");
        Assert.assertEquals(googleSearchResultTwoPage.getResultsCount(), 10,
                "Search results count is incorrect.");

        List<String> resultsList2 = googleSearchResultTwoPage.getResultsList();
        for (String result : resultsList2) {
            Assert.assertTrue(result.contains(searchTerm),
                    "Searchterm "+searchTerm+" is missing in following result: \n" +result);
        }

    }
}
