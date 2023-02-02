package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserHelper {
    private static WebDriver driver;

    public static void initializeDriver() {
        if (driver == null) {
            System.out.println("===INITIALIZING");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
            driver = new ChromeDriver();
        }
    }

    public static WebDriver getDriver() {
        initializeDriver();
        return driver;
    }

    public static void navigateTo(String url) {
        getDriver().navigate().to(url);
    }

    public static void closeDriver() {
        if (driver != null) {
            System.out.println("===QUITTING");
            driver.quit();
            driver = null;
        }
    }
}