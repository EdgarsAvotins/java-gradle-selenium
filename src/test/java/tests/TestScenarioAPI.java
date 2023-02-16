package tests;

import dataObjects.User;
import helpers.ApiHelper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestScenarioAPI {

    @Test
    public void addBookToCollectionViaAPI() {
        // Given user is created and userId saved
        User user = new User();
        Response response = user.create();
        String userId = response.jsonPath().getString("userID");

        // Given user is authenticated and token saved
        response = ApiHelper.authenticateUserAndValidate(user.getUsername(), user.getPassword());
        String token = response.jsonPath().getString("token");

        // Given a book isbn has been received and saved
        response = ApiHelper.getBooksAndValidate(user.getUsername(), user.getPassword());
        String isbn = response.jsonPath().getString("books[0].isbn");

        // When book is added to user
        ApiHelper.addBookToCollectionAndValidate(userId, isbn, token);

        // Then the user has the book added to their collection
        ApiHelper.getUserByIdAndValidate(userId, token, isbn);
    }
}