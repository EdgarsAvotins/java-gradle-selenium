package pageObjects.navigationPages;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.InteractionHelper.*;

public class ProfilePage extends NavigationPage {

    public static boolean isAnyBookInCollection() {
        WebElement addedBook = elX("//div[@class='rt-tbody']//*[@role='row']//*[contains(@id,'see-book')]");
        return addedBook.isDisplayed();
    }

    public static String getFirstBookTitle() {
        WebElement addedBook = elX("//div[@class='rt-tbody']//*[@role='row']//*[contains(@id,'see-book')]");
        return addedBook.getText();
    }

    public static void removeBook(String title) {
        WebElement removeBookButton = elX("//div[@class='rt-tbody']//*[@role='row'][descendant::text()='" + title + "']//*[@id='delete-record-undefined']");
        removeBookButton.click();

        WebElement removeBookOkButton = el("closeSmallModal-ok");
        removeBookOkButton.click();
    }

    public static void waitUntilBookNotInCollection(String title) {
        noElX("//div[@class='rt-tbody']//*[@role='row']//*[contains(@id,'see-book')]");
    }
}
