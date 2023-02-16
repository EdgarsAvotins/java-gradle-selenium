package tests;

import dataObjects.User;
import extensions.UsingBrowserExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static stepDefinitions.UserSteps.*;
import static stepDefinitions.BookCollectionSteps.*;


public class TestScenarioUI {
    @Test @ExtendWith(UsingBrowserExtension.class)
    public void addBookToCollection() throws InterruptedException {
        User user = givenANewUserIsCreatedViaAPI();
        givenIHaveLoggedIn(user);
        String bookTitle = givenIAddABookToTheCollectionAndGetBookTitle();
        thenTheBookHasBeenAddedToTheCollection(bookTitle);
    }

    @Test @ExtendWith(UsingBrowserExtension.class)
    public void removeBookFromCollection() throws InterruptedException {
        User user = givenANewUserIsCreatedViaAPI();
        givenIHaveLoggedIn(user);
        String bookTitle = givenIAddABookToTheCollectionAndGetBookTitle();
        whenIRemoveTheBookFromTheCollection(bookTitle);
        thenTheBookIsNoLongerPresentInTheCollection(bookTitle);
    }
}