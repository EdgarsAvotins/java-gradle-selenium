package tests;

import dataObjects.User;
import extensions.UsingBrowserExtension;
import helpers.ApiHelper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pageObjects.BookPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.navigationPages.BookStorePage;
import pageObjects.navigationPages.ProfilePage;

import static helpers.InteractionHelper.acceptAlert;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestScenarioUI {
    @Test @ExtendWith(UsingBrowserExtension.class)
    public void addBookToCollection() throws InterruptedException {
        // Given a new user is created via API
        User user = new User();
        user.create();

        // And I have logged in
        HomePage.openHomepage();
        HomePage.clickBookCategory();
        BookStorePage.clickLoginButton();
        LoginPage.inputDetailsAndSubmit(user.getUsername(), user.getPassword());

        // When I add a book to the collection
        BookStorePage.openFirstBookInList();
        String bookTitle = BookPage.getBookTitle();
        BookPage.addNewRecord();
        acceptAlert();

        // Then the book has been added to the collection
        BookStorePage.clickSidebarButtonForProfile();
        assertTrue(ProfilePage.isAnyBookInCollection());
        assertEquals(ProfilePage.getFirstBookTitle(), bookTitle);
    }

    @Test @ExtendWith(UsingBrowserExtension.class)
    public void removeBookFromCollection() throws InterruptedException {
        // Given a new user is created via API
        User user = new User();
        user.create();

        // And I have logged in
        HomePage.openHomepage();
        HomePage.clickBookCategory();
        BookStorePage.clickLoginButton();
        LoginPage.inputDetailsAndSubmit(user.getUsername(), user.getPassword());

        // And I add a book to the collection
        BookStorePage.openFirstBookInList();
        String bookTitle = BookPage.getBookTitle();
        BookPage.addNewRecord();
        acceptAlert();

        // When I remove the book from the collection
        BookStorePage.clickSidebarButtonForProfile();
        ProfilePage.removeBook(bookTitle);
        acceptAlert();

        // Then the book is no longer present in the collection
        ProfilePage.waitUntilBookNotInCollection(bookTitle);
    }
}