package tests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ChevyRelatedTests extends BaseUITest{


    public static String CHEVY_COLODRADO_SEARCH_TEXT = "Chevrolet Colodrado";

    @Test()
    public void input_ChevyColodrado_AndVerifyCount() {
        pages.getTopPanelPage().enterValueIntoSearchBox(CHEVY_COLODRADO_SEARCH_TEXT);
        pages.getTopPanelPage().clickSearchButton();
        int searchResult = pages.getSearchResultsPage().parseSearchResultToExtractTotalNumber();
        if(searchResult == 0 ){
            System.out.println("Please verify your search string it resulted in 0 results, search string "+ CHEVY_COLODRADO_SEARCH_TEXT);
        }else{
            System.out.println("We got "+searchResult+" results using search string "+ CHEVY_COLODRADO_SEARCH_TEXT);
        }
        Assert.assertTrue(pages.getSearchResultsPage().readSearchResultsLinks().size()==0, " There are no results for search text "+ CHEVY_COLODRADO_SEARCH_TEXT);
    }
}
