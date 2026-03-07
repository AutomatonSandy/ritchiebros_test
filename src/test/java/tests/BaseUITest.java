package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.ConfigReader;
import utility.DriverFactory;

import java.net.UnknownHostException;

public class BaseUITest {

    protected static WebDriver driver;
    private static final String HOME_PAGE_TITLE= "Ritchie Bros. Auctioneers: Heavy Equipment Auctions & Used Heavy Equipment For Sale";
    private static final String BASE_URL_CONFIG_TEXT="ui.base.url";

    @Parameters("browser")
    @BeforeTest(alwaysRun = true)
    public void setup(String browser){
        driver = DriverFactory.initDriver(browser);
        driver.get(ConfigReader.get(BASE_URL_CONFIG_TEXT));
        Assert.assertTrue(driver.getTitle().equals(HOME_PAGE_TITLE.trim()));
        try {
            System.out.println("Host: " +
                    java.net.InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest (alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}


