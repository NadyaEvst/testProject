package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class SearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//*[@id = \"jSearchSubmit\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@class = \"search_result_sentence\"]")
    private WebElement resultsNotification;

    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    public boolean isSearchResultsEmpty(){
        return driver.findElements(By.xpath("//div[contains(@id,\"job_list_\")]")).isEmpty();
    }

    public String getResultsNotification(){
        return resultsNotification.getText();
    }
}
