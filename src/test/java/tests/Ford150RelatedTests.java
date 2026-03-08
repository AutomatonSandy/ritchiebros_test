package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class Ford150RelatedTests extends  BaseUITest {

    @Test
    public void input_Ford150_AndVerifyCount() {
        String FORD_150_SEARCH_TEXT = "Ford F-150";
        SoftAssert softAssert = new SoftAssert();
        pages.getTopPanelPage().enterValueIntoSearchBox(FORD_150_SEARCH_TEXT);
        pages.getTopPanelPage().clickSearchButton();
        int totalNumberOfResults =pages.getSearchResultsPage().parseSearchResultToExtractTotalNumber();
        System.out.println("The total number of results returned is "+totalNumberOfResults+" The search text is "+ FORD_150_SEARCH_TEXT);
        List<WebElement> searchResultsList = pages.getSearchResultsPage().readSearchResultsLinks();
        validateResults_SoftAssert("Ford F-150", pages.getSearchResultsPage().base_readElementsAndReturnText(searchResultsList.get(0), 1),softAssert);
        validateResults_SoftAssert("Ford F-150", pages.getSearchResultsPage().base_readElementsAndReturnText(searchResultsList.get(1), 2),softAssert);
        softAssert.assertAll();
    }

    @Test
    public void inputF_150AndVerifyCountWithFilter(){
        String MINIMUM_YEAR = "2010";
        String F_150_SEARCH_TEXT = "F-150";
        pages.getTopPanelPage().enterValueIntoSearchBox(F_150_SEARCH_TEXT);
        pages.getTopPanelPage().clickSearchButton();
        int totalNumberBeforeFilter = pages.getSearchResultsPage().parseSearchResultToExtractTotalNumber();
        System.out.println("The total number of results returned is "+totalNumberBeforeFilter +" The search text is "+F_150_SEARCH_TEXT);
        pages.getFiltersPage().clickOnIAgreeCookieButton();
        pages.getFiltersPage().clickOnYearFilter();
        pages.getFiltersPage().setMinimumYearField(MINIMUM_YEAR);
        int totalNumberAfterFilter = pages.getSearchResultsPage().parseSearchResultToExtractTotalNumber();
        System.out.println("After filter we received "+totalNumberAfterFilter+" results");
        Assert.assertTrue(totalNumberAfterFilter < totalNumberBeforeFilter);
    }

}
