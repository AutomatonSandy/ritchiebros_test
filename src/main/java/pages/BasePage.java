package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    public Logger log = LogManager.getLogger(BasePage.class.getName());

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String base_getResultString(String webElementXpath) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElementXpath)));
        WebElement searchResultElement = driver.findElement(By.xpath(webElementXpath));
        String searchResult = searchResultElement.getText();
        return searchResult;
    }

    public String base_readElementsAndReturnText(WebElement element, int index){
        String linkText = element.getText();
        System.out.println(" Text from "+ index+" webElement is "+linkText);
        return element.getText();
    }
}
