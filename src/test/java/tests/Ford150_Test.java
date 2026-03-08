package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Home_TopPanel_Page;
import pages.SearchResults_Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class Ford150_Test extends  BaseUITest {

    Home_TopPanel_Page topPanel;
    SearchResults_Page searchResult;
    public static String FORD_150_SEARCH_TEXT = "Ford F-150";
    Logger logger = LogManager.getLogger(Ford150_Test.class.getName());

    @Test()
    public void input_Ford150_AndVerifyCount() {

        int expectedTotalCount = 510;
        topPanel = new Home_TopPanel_Page(driver);
        searchResult = new SearchResults_Page(driver);

        SoftAssert softAssert = new SoftAssert();
        topPanel.enterValueIntoSearchBox(FORD_150_SEARCH_TEXT);
        topPanel.clickSearchButton();
        softAssert.assertEquals(searchResult.parseSearchResultToExtractTotalNumber(), expectedTotalCount);
        List<WebElement> searchResultsList = searchResult.readSearchResultsLinks();
        validateResults_SoftAssert("Ford F-150", searchResult.base_readElementsAndReturnText(searchResultsList.get(0), 1),softAssert);
        validateResults_SoftAssert("Ford F-150", searchResult.base_readElementsAndReturnText(searchResultsList.get(1), 2),softAssert);
        softAssert.assertAll();
    }

}
