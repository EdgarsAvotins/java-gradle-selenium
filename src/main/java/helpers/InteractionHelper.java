package helpers;

import config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.BrowserHelper.getDriver;

public class InteractionHelper {
    private static final long DEFAULT_TIMEOUT = TestConfig.getDefaultTimeout();

    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor j = (JavascriptExecutor) getDriver();
        j.executeScript ("arguments[0].scrollIntoView({block: 'center'})", element);
    }

    public static void acceptAlert() throws InterruptedException {
        boolean alertAppeared = false;
        long maxTime = DEFAULT_TIMEOUT * 1000 / 3;
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0;
        long timeBetweenLoops = 200;

        while (elapsedTime < maxTime) {
            if (isAlertVisible()) {
                alertAppeared = true;
                getDriver().switchTo().alert().accept();
            } else if (alertAppeared) {
                return;
            }
            Thread.sleep(timeBetweenLoops);
            elapsedTime = System.currentTimeMillis() - startTime;
        }
        throw new NoAlertPresentException();
    }

    public static boolean isAlertVisible() {
        try {
            getDriver().switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public static WebElement elX(String xpath) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public static WebElement el(String id) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    public static void noElX(String xpath) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }
}
