package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.lang.String;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultOnePage extends GoogleBasePage {

    WebElement resultsCounter;

    @FindBy(xpath ="//div[@class='srg']/div[@class='g']")
    List<WebElement> searchResults;

    @FindBy(xpath ="//a[@aria-label='Page 2']")
    private WebElement secondPageLink;


    public GoogleSearchResultOnePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    //@Override
    public boolean isPageLoaded() {
        waitUntilElementIsClickable(secondPageLink,60);
        return secondPageLink.isDisplayed();
    }

    public int getResultsCount() {
        return searchResults.size();
    }

    public List<String> getResultsList() {
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResult:searchResults){
            ((JavascriptExecutor)webDriver).executeScript(
                    "arguments[0].scrollIntoView();", searchResult);

            String searchResultText = searchResult.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }



    public GoogleSearchResultTwoPage clickOnSecondPage() {
        secondPageLink.click();
        return new GoogleSearchResultTwoPage (webDriver);
    }
}



