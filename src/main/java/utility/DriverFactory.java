package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver driver;
    private static final String REMOTE_DRIVER = "remote";
    private static final String UI_BROWSER_CONFIG="ui.browser";
    private static final String GRID_URL_STRING="grid.url";
    private static final String WD_HUB_URL="http://localhost:4444/wd/hub";
    private static final String CHROME_BROWSER ="chrome";
    private static final String EDGE_BROWSER="edge";

    public static WebDriver initDriver(String browser) {

        if(!ConfigReader.get(UI_BROWSER_CONFIG).equals(REMOTE_DRIVER)){
            initializeLocalBrowsers(browser);
        }else{
            try {
                initializeRemoteBrowsers(browser);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
    }

    private static void initializeRemoteBrowsers(String browser) throws MalformedURLException {
        String gridUrl = System.getProperty(GRID_URL_STRING,WD_HUB_URL);
        if (browser.equals(CHROME_BROWSER)) {
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(new URL(gridUrl), options);
        }

    }

    private static void initializeLocalBrowsers(String browser){
        if (browser.equalsIgnoreCase(CHROME_BROWSER)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase(EDGE_BROWSER)) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }
}
