package pageObjects.navigationPages;

import org.openqa.selenium.WebElement;

import static helpers.InteractionHelper.*;

public class ProfilePage extends NavigationPage {
    private static final String addedBookXpath = "//div[@class='rt-tbody']//*[@role='row']//*[contains(@id,'see-book')]";
    private static final String removeBookOkButtonXpath = "closeSmallModal-ok";

    public static boolean isAnyBookInCollection() {
        WebElement addedBook = elX(addedBookXpath);
        return addedBook.isDisplayed();
    }

    public static String getFirstBookTitle() {
        WebElement addedBook = elX(addedBookXpath);
        return addedBook.getText();
    }

    public static void removeBook(String title) {
        WebElement removeBookButton = elX("//div[@class='rt-tbody']//*[@role='row'][descendant::text()='" + title + "']//*[@id='delete-record-undefined']");
        removeBookButton.click();

        WebElement removeBookOkButton = el(removeBookOkButtonXpath);
        removeBookOkButton.click();
    }

    public static void waitUntilBookNotInCollection(String title) {
        noElX("//div[@class='rt-tbody']//*[@role='row'][descendant::text()='" + title + "']");
    }
}
