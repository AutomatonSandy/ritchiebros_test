package tests;

import org.testng.annotations.Test;
import pages.Home_TopPanel;

public class Ford150_Test extends  BaseUITest {

    Home_TopPanel topPanel;
    public static String FORD_150_SEARCH_TEXT = "Ford F-150";
    @Test
    public void input_Ford150_AndVerifyCount(){
        topPanel =new Home_TopPanel(driver);
        topPanel.enterValueIntoSearchBox(FORD_150_SEARCH_TEXT);
        topPanel.clickSearchButton();
    }

}
