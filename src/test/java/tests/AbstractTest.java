package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.SearchJobsPage;

import java.util.concurrent.TimeUnit;

public class AbstractTest {
    protected WebDriver driver;
    final String BASE_URL = "https://akamaijobs.referrals.selectminds.com/";
    SearchJobsPage searchJobsPage;

    @BeforeMethod
    public void setUpDriver(){
        System.setProperty("webdriver.chrome.driver", "/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        searchJobsPage = new SearchJobsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
