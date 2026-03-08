package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public synchronized String base_getResultString(String webElementXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElementXpath)));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement searchResultElement = driver.findElement(By.xpath(webElementXpath));
        return searchResultElement.getText();
    }

    public String base_readElementsAndReturnText(WebElement element, int index){
        String linkText = element.getText();
        System.out.println(" Text from "+ index+" webElement is "+linkText);
        return element.getText();
    }
}
