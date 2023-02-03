package tests;

import helpers.ApiHelper;
import helpers.BrowserHelper;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObjects.BookPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.navigationPages.BookStorePage;
import pageObjects.navigationPages.ProfilePage;

import static helpers.InteractionHelper.acceptAlert;
import static helpers.UserHelper.generateUsername;
import static helpers.UserHelper.getPassword;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestScenarioUI {
    private final HomePage homePage = new HomePage();
    private final BookStorePage bookStorePage = new BookStorePage();
    private final LoginPage loginPage = new LoginPage();
    private final BookPage bookPage = new BookPage();
    private final ProfilePage profilePage = new ProfilePage();
    private final ApiHelper api = new ApiHelper();

    @BeforeEach
    public void setup() {
        BrowserHelper.initializeDriver();
    }

    @AfterEach
    public void teardown() {
        BrowserHelper.closeDriver();
    }

    @Test
    public void addBookToCollection() throws InterruptedException {
        // Given a new user is created via API
        String username = generateUsername();
        String password = getPassword();
        Response response = api.createUser(username, password);
        assertEquals(201, response.getStatusCode());

        // And I have logged in
        homePage.openHomepage();
        homePage.clickBookCategory();
        bookStorePage.clickLoginButton();
        loginPage.inputDetailsAndSubmit(username, password);

        // When I add a book to the collection
        bookStorePage.openFirstBookInList();
        String bookTitle = bookPage.getBookTitle();
        bookPage.addNewRecord();
        acceptAlert();

        // Then the book has been added to the collection
        bookStorePage.clickSidebarButtonWithText("Profile");
        assertTrue(profilePage.isAnyBookInCollection());
        assertEquals(profilePage.getFirstBookTitle(), bookTitle);

        // Uncomment next line if you wish to leave results visible for 5 seconds
        // Thread.sleep(5000);
    }

    @Test
    public void removeBookFromCollection() throws InterruptedException {
        // Given a new user is created via API
        String username = generateUsername();
        String password = getPassword();
        Response response = api.createUser(username, password);
        assertEquals(201, response.getStatusCode());

        // And I have logged in
        homePage.openHomepage();
        homePage.clickBookCategory();
        bookStorePage.clickLoginButton();
        loginPage.inputDetailsAndSubmit(username, password);

        // And I add a book to the collection
        bookStorePage.openFirstBookInList();
        String bookTitle = bookPage.getBookTitle();
        bookPage.addNewRecord();
        acceptAlert();

        // When I remove the book from the collection
        bookStorePage.clickSidebarButtonWithText("Profile");
        profilePage.removeBook(bookTitle);
        acceptAlert();

        // Then the book is no longer present in the collection
        profilePage.waitUntilBookNotInCollection(bookTitle);

        // Uncomment next line if you wish to leave results visible for 5 seconds
        // Thread.sleep(5000);
    }
}