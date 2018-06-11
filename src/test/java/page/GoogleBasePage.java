package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class GoogleBasePage {

    protected WebDriver webDriver;
    /**
     * Constructor of BasePage
     * @param webDriver - webDriver instance
     */
    public GoogleBasePage(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    /** Method get current url
     * @return - webDriver
     */
    public String getCurrentUrl(){
        return  webDriver.getCurrentUrl();
    }

       public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }


    abstract boolean isPageLoaded();

}