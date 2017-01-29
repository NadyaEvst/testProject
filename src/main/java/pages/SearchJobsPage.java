package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

/**
 * Created by Надежда on 29.01.2017.
 */
public class SearchJobsPage extends AbstractPage {
    @FindBy(xpath = "//input[@id=\"keyword\"]")
    private WebElement keywordInput;
    @FindBy(xpath = "//div[@id = \"jLocInputHldr\"]")
    private WebElement locationSelect;
    @FindBy(xpath = "//*[@id = \"jSearchSubmit\"]")
    private WebElement searchButton;

    public SearchJobsPage(WebDriver driver){
        super(driver);
    }

    public void setKeyword(String keyword){
        keywordInput.sendKeys(keyword);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void selectLocation(String location){
        locationSelect.click();
        WebElement input = locationSelect.findElement(By.xpath(".//li[@class = \"search-field\"]/input"));
        waiter().until(ExpectedConditions.visibilityOf(input));
        input.sendKeys(location);
        input.sendKeys(Keys.ENTER);
    }

    public SearchResultsPage getSearchResults(){
        clickSearchButton();
        waitUntilSearchStops();
        return new SearchResultsPage(driver);
    }
}
