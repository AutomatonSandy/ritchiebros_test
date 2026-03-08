package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver instance;
    private static final String REMOTE_DRIVER = "remote";
    private static final String UI_BROWSER_CONFIG="ui.browser";
    private static final String GRID_URL_STRING="grid.url";
    private static final String WD_HUB_URL="http://localhost:4444/wd/hub";
    private static final String CHROME_BROWSER ="chrome";
    private static final String EDGE_BROWSER="edge";

    public static void initDriver(String browser) {
       if(driver.get()== null) {
           if (!ConfigReader.get(UI_BROWSER_CONFIG).equals(REMOTE_DRIVER)) {
               initializeLocalBrowsers(browser);
           } else {
               try {
                   initializeRemoteBrowsers(browser);
               } catch (MalformedURLException e) {
                   throw new RuntimeException(e);
               }
           }
       }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    private static void initializeRemoteBrowsers(String browser) throws MalformedURLException {
        String gridUrl = System.getProperty(GRID_URL_STRING,WD_HUB_URL);
        if (browser.equals(CHROME_BROWSER)) {
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.setCapability("se:recordVideo", true); // Enable recording
            options.setCapability("se:screenResolution", "1920x1080"); // Optional: set size
//            driver = new RemoteWebDriver(new URL(gridUrl), options);
            instance = new RemoteWebDriver(new URL(gridUrl), options);
            driver.set(instance);
        }

    }

    private static void initializeLocalBrowsers(String browser){
        if (browser.equalsIgnoreCase(CHROME_BROWSER)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            instance = new ChromeDriver(options);
            driver.set(instance);
        } else if (browser.equalsIgnoreCase(EDGE_BROWSER)) {
            WebDriverManager.edgedriver().setup();
            instance = new EdgeDriver();
            driver.set(instance);
        }
    }
}
