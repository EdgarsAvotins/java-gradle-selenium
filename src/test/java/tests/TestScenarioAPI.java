package tests;

import helpers.ApiHelper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static helpers.UserHelper.generateUsername;
import static helpers.UserHelper.getPassword;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestScenarioAPI {
    private final ApiHelper api = new ApiHelper();

    @Test
    public void addBookToCollectionViaAPI() {
        System.out.println("=====API");
        String username = generateUsername();
        String password = getPassword();

        // Given user is created and userId saved
        Response response = api.createUser(username, password);
        assertEquals(201, response.getStatusCode());
        String userId = response.jsonPath().getString("userID");

        // Given user is authenticated and token saved
        response = api.authenticateUser(username, password);
        assertEquals(200, response.getStatusCode());
        assertEquals("Success", response.jsonPath().getString("status"));
        String token = response.jsonPath().getString("token");

        // Given a book isbn has been received and saved
        response = api.getBooks(username, password);
        assertEquals(200, response.getStatusCode());
        String isbn = response.jsonPath().getString("books[0].isbn");

        // When book is added to user
        response = api.addBookToCollection(userId, isbn, token);
        assertEquals(201, response.getStatusCode());

        // Then the user has the book added to their collection
        response = api.getUserById(userId, token);
        assertEquals(200, response.getStatusCode());
        assertEquals(userId, response.jsonPath().getString("userId"));
        assertEquals(isbn, response.jsonPath().getString("books[0].isbn"));
    }
}