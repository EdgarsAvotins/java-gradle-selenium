package pageObjects.navigationPages;

import org.openqa.selenium.WebElement;

import static helpers.InteractionHelper.*;

public class ProfilePage extends NavigationPage {
    private static final String ADDED_BOOK_XPATH = "//div[@class='rt-tbody']//*[@role='row']//*[contains(@id,'see-book')]";
    private static final String REMOVE_BOOK_OK_BUTTON_XPATH = "closeSmallModal-ok";

    public static boolean isAnyBookInCollection() {
        WebElement addedBook = elX(ADDED_BOOK_XPATH);
        return addedBook.isDisplayed();
    }

    public static String getFirstBookTitle() {
        WebElement addedBook = elX(ADDED_BOOK_XPATH);
        return addedBook.getText();
    }

    public static void removeBook(String title) {
        WebElement removeBookButton = elX("//div[@class='rt-tbody']//*[@role='row'][descendant::text()='" + title + "']//*[@id='delete-record-undefined']");
        removeBookButton.click();

        WebElement removeBookOkButton = el(REMOVE_BOOK_OK_BUTTON_XPATH);
        removeBookOkButton.click();
    }

    public static void waitUntilBookNotInCollection(String title) {
        noElX("//div[@class='rt-tbody']//*[@role='row'][descendant::text()='" + title + "']");
    }
}
