package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FiltersPage extends BasePage {


    public FiltersPage(WebDriver driver) {
        super(driver);
    }



    public void clickOnIAgreeCookieButton(){
        driver.findElement(By.xpath("//button[@id='truste-consent-button']")).click();
    }


    public  void clickOnYearFilter(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("*//div[text()='Year']"))).perform();
        driver.findElement(By.xpath("*//div[text()='Year']")).click();
    }

    public void setMinimumYearField(String minimumYearFieldValue){
        WebElement element =  driver.findElement(By.xpath("*//input[@id='manufactureYearRange_min']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        String currentText = element.getAttribute("value");
        for (int i = 0; i < currentText.length(); i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
        element.sendKeys(minimumYearFieldValue);
        element.sendKeys(Keys.RETURN);

    }
}
