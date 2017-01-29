package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    protected WebDriver driver;
    final int TIMEOUT = 10;

    public AbstractPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    protected WebDriverWait waiter() {
        return new WebDriverWait(driver, TIMEOUT);
    }

    public void waitUntilSearchStops(){
        waiter().until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class = \"spinner\"]/div"))));
    }
}
