package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResults_Page extends BasePage {


    public SearchResults_Page(WebDriver driver) {
        super(driver);
    }

    public  int parseSearchResultToExtractTotalNumber(){
        String resultsHeaderLocatorXpath="*//h2[@data-testid='non-cat-header']";
        String searchResult = base_getResultString(resultsHeaderLocatorXpath);
        int totalNumber = Integer.parseInt(searchResult.split("of")[1].split("results")[0].trim());
        System.out.println("The total number of results extracted from page is --> "+totalNumber);
        return totalNumber;
    }

    public List<WebElement> readSearchResultsLinks(){
        List<WebElement> resultsHyperlinkWebElement_List = driver.findElements(By.xpath("*//a[@data-testid ='item-card-title-link']"));
        return resultsHyperlinkWebElement_List;
    }
    





}
