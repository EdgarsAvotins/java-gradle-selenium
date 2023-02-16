package stepDefinitions;

import pageObjects.BookPage;
import pageObjects.navigationPages.BookStorePage;
import pageObjects.navigationPages.ProfilePage;

import static helpers.InteractionHelper.acceptAlert;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookCollectionSteps {
    public static String givenIAddABookToTheCollectionAndGetBookTitle() throws InterruptedException {
        BookStorePage.openFirstBookInList();
        String bookTitle = BookPage.getBookTitle();
        BookPage.addNewRecord();
        acceptAlert();
        return bookTitle;
    }

    public static void whenIRemoveTheBookFromTheCollection(String bookTitle) throws InterruptedException {
        BookStorePage.clickSidebarButtonForProfile();
        ProfilePage.removeBook(bookTitle);
        acceptAlert();
    }

    public static void thenTheBookHasBeenAddedToTheCollection(String bookTitle) {
        BookStorePage.clickSidebarButtonForProfile();
        assertTrue(ProfilePage.isAnyBookInCollection());
        assertEquals(ProfilePage.getFirstBookTitle(), bookTitle);
    }

    public static void thenTheBookIsNoLongerPresentInTheCollection(String bookTitle) {
        ProfilePage.waitUntilBookNotInCollection(bookTitle);
    }
}
