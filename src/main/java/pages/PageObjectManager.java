package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private final WebDriver driver;
    private Home_TopPanel_Page topPanelPage;
    private SearchResults_Page searchResultsPage;

    private FiltersPage filtersPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public Home_TopPanel_Page getTopPanelPage() {
        return (topPanelPage==null)? topPanelPage= new Home_TopPanel_Page(driver) : topPanelPage;
    }

    public SearchResults_Page getSearchResultsPage() {
        return (searchResultsPage==null)? searchResultsPage= new SearchResults_Page(driver) : searchResultsPage;
    }

    public FiltersPage getFiltersPage() {
        return (filtersPage == null)? filtersPage = new FiltersPage(driver): filtersPage;
    }


}

