package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Home_TopPanel_Page;
import pages.SearchResults_Page;

public class Chevy_Test extends BaseUITest{

    Home_TopPanel_Page topPanel;
    SearchResults_Page searchResult;
    public static String CHEVY_COLORADO_SEARCH_TEXT = "Chevrolet Colodrado";

    @Test()
    public void input_ChevyColorado_AndVerifyCount() {
        int expectedTotalCount = 0;
        topPanel = new Home_TopPanel_Page(driver);
        searchResult = new SearchResults_Page(driver);
        topPanel.enterValueIntoSearchBox(CHEVY_COLORADO_SEARCH_TEXT);
        topPanel.clickSearchButton();
        Assert.assertEquals(searchResult.parseSearchResultToExtractTotalNumber(), expectedTotalCount);
        Assert.assertTrue(searchResult.readSearchResultsLinks().size()==0, " There are no results for search text "+ CHEVY_COLORADO_SEARCH_TEXT);
    }
}
