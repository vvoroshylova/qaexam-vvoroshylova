package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.String;

public class GoogleSearchPage extends GoogleBasePage {

    @FindBy(id ="lst-ib")
    private WebElement searchField;

    public GoogleSearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
@Override
    public boolean isPageLoaded() {
    waitUntilElementIsClickable(searchField, 40);
    return searchField.isDisplayed();
    }

    public GoogleSearchResultOnePage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return new GoogleSearchResultOnePage (webDriver);
    }

}