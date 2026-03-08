package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResults_Page extends BasePage {


    public SearchResults_Page(WebDriver driver) {
        super(driver);
    }

    public synchronized  int parseSearchResultToExtractTotalNumber(){
        String resultsHeaderLocatorXpath="*//h2[@data-testid='non-cat-header']";
        String searchResult = base_getResultString(resultsHeaderLocatorXpath);
        return Integer.parseInt(searchResult.split("of")[1].split("results")[0].trim());
    }

    public List<WebElement> readSearchResultsLinks(){
        return driver.findElements(By.xpath("*//a[@data-testid ='item-card-title-link']"));
    }
    





}
