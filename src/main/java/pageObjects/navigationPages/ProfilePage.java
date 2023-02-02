package pageObjects.navigationPages;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.InteractionHelper.*;

public class ProfilePage extends NavigationPage {

    public boolean isAnyBookInCollection() {
        WebElement addedBook = elX("//div[@class='rt-tbody']//*[@role='row']//*[contains(@id,'see-book')]");
        return addedBook.isDisplayed();
    }

    public String getFirstBookTitle() {
        WebElement addedBook = elX("//div[@class='rt-tbody']//*[@role='row']//*[contains(@id,'see-book')]");
        return addedBook.getText();
    }

    public void removeBook(String title) {
        WebElement removeBookButton = elX("//div[@class='rt-tbody']//*[@role='row'][descendant::text()='" + title + "']//*[@id='delete-record-undefined']");
        removeBookButton.click();

        WebElement removeBookOkButton = el("closeSmallModal-ok");
        removeBookOkButton.click();
    }

    public void waitUntilBookNotInCollection(String title) {
        noElX("//div[@class='rt-tbody']//*[@role='row']//*[contains(@id,'see-book')]");
    }
}
