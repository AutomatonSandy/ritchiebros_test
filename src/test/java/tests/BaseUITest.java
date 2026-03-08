package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.PageObjectManager;
import utility.ConfigReader;
import utility.DriverFactory;

import java.net.UnknownHostException;
import java.time.Duration;

public class BaseUITest extends  DriverFactory{
    private static final String HOME_PAGE_TITLE= "Ritchie Bros. Auctioneers: Heavy Equipment Auctions & Used Heavy Equipment For Sale";
    private static final String BASE_URL_CONFIG_TEXT="ui.base.url";
    protected PageObjectManager pages;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
        DriverFactory.initDriver(browser);
        getDriver().get((ConfigReader.get(BASE_URL_CONFIG_TEXT)));
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        pages = new PageObjectManager(getDriver());
        Assert.assertTrue(getDriver().getTitle().equals(HOME_PAGE_TITLE.trim()));
        try {
            System.out.println("Host: " +
                    java.net.InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void tearDown() {
       DriverFactory.quitDriver();
    }

    public void validateResults_SoftAssert(String expected, String actual, SoftAssert softAssert ){
        softAssert.assertTrue(actual.contains(expected), "We expected --> "+expected +" will be in  -->"+actual );
    }
}


