package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home_TopPanel_Page extends  BasePage{

//    private WebDriver driver;
//    public Home_TopPanel_Page(WebDriver driver) {
//        this.driver = driver;
//    }


    public Home_TopPanel_Page(WebDriver driver) {
        super(driver);
    }

    public void enterValueIntoSearchBox(String searchText){
        driver.findElement(By.xpath("*//input[@type='text']")).sendKeys(searchText);
    }

    public void clickSearchButton(){
        driver.findElement(By.xpath("*//button[@data-testid='search button']")).click();
    }

    public void clickFilterButton(){
        driver.findElement(By.xpath("*//button[@data-testid='search filter button']")).click();
    }


}
