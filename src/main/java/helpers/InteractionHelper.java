package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InteractionHelper {
    private static final WebDriver driver = BrowserHelper.getDriver();
    private static final int defaultTimer = 30;

    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript ("arguments[0].scrollIntoView({block: 'center'})", element);
    }

    public static void acceptAlert() throws InterruptedException {
        boolean clickedOnce = false;
        for (int i=0; i<10; i++) {
            try {
                driver.switchTo().alert().accept();
                clickedOnce = true;
            } catch(NoAlertPresentException e) {
                if (clickedOnce) {
                    return;
                }
                Thread.sleep(300);
            }
        }
        throw new NoAlertPresentException();
    }

    public static WebElement elX(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, defaultTimer);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public static WebElement el(String id) {
        WebDriverWait wait = new WebDriverWait(driver, defaultTimer);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    public static void noElX(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, defaultTimer);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }
}
