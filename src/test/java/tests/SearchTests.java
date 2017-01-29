package tests;

import org.testng.annotations.Test;
import pages.SearchResultsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Feature:     Logged out customer is able to search for a job
 * Scenario:    Search for a job matching given criteria
 */
public class SearchTests extends AbstractTest {
    @Test(description = "Given        Customer is on 'http://akamaijobs.referrals.selectminds.com/\n" +
                        "When         Customer specifies job title : Test\n" +
                        "And          Location : Krakow, Poland\n" +
                        "And          clicks on 'Search'\n" +
                        "Then         Any job offers are found")
    public void positiveSearchTest(){
        searchJobsPage.setKeyword("Test");
        searchJobsPage.selectLocation("Krakow, Poland");
        SearchResultsPage searchResultsPage = searchJobsPage.getSearchResults();
        assertThat("Search results are not empty", !searchResultsPage.isSearchResultsEmpty());
    }

    @Test(description = "Given      Customer is on 'http://akamaijobs.referrals.selectminds.com/'\n" +
                        "When       Customer specifies job title : XXX\n" +
                        "And        clicks on 'Search'\n" +
                        "Then       Notification about no offers found is displayed")
    public void negativeSearchTest(){
        String keyword = "XXX";
        String expectedNotification = "Your search matching keyword(s) "+keyword+" did not return any job results.";
        searchJobsPage.setKeyword(keyword);
        SearchResultsPage searchResultsPage = searchJobsPage.getSearchResults();
        assertThat("Notification is displayed", searchResultsPage.getResultsNotification(),equalTo(expectedNotification));
    }

}
