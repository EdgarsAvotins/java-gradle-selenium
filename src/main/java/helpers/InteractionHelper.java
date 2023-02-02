package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static helpers.BrowserHelper.getDriver;

public class InteractionHelper {
    private static final int defaultTimer = 30;

    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor j = (JavascriptExecutor) getDriver();
        j.executeScript ("arguments[0].scrollIntoView({block: 'center'})", element);
    }

    public static void acceptAlert() throws InterruptedException {
        Thread.sleep(300);
        for (int i=0; i<10; i++) {
            try {
                getDriver().switchTo().alert().accept();
                return;
            } catch(NoAlertPresentException e) {
                Thread.sleep(300);
            }
        }
        throw new NoAlertPresentException();
    }

    public static WebElement elX(String xpath) {
        WebDriverWait wait = new WebDriverWait(getDriver(), defaultTimer);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public static WebElement el(String id) {
        WebDriverWait wait = new WebDriverWait(getDriver(), defaultTimer);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    public static void noElX(String xpath) {
        WebDriverWait wait = new WebDriverWait(getDriver(), defaultTimer);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }
}
