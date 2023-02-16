package stepDefinitions;

import io.qameta.allure.Step;
import pageObjects.BookPage;
import pageObjects.navigationPages.BookStorePage;
import pageObjects.navigationPages.ProfilePage;

import static helpers.InteractionHelper.acceptAlert;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookCollectionSteps {
    @Step("Given I add a book to the collection")
    public static String givenIAddABookToTheCollectionAndGetBookTitle() throws InterruptedException {
        BookStorePage.openFirstBookInList();
        String bookTitle = BookPage.getBookTitle();
        BookPage.addNewRecord();
        acceptAlert();
        return bookTitle;
    }

    @Step("When I remove the book from the collection")
    public static void whenIRemoveTheBookFromTheCollection(String bookTitle) throws InterruptedException {
        BookStorePage.clickSidebarButtonForProfile();
        ProfilePage.removeBook(bookTitle);
        acceptAlert();
    }

    @Step("Then the book has been added to the collection")
    public static void thenTheBookHasBeenAddedToTheCollection(String bookTitle) {
        BookStorePage.clickSidebarButtonForProfile();
        assertTrue(ProfilePage.isAnyBookInCollection());
        assertEquals(ProfilePage.getFirstBookTitle(), bookTitle);
    }

    @Step("Then the book i no longer present in the collection")
    public static void thenTheBookIsNoLongerPresentInTheCollection(String bookTitle) {
        ProfilePage.waitUntilBookNotInCollection(bookTitle);
    }
}
