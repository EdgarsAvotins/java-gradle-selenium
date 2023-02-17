package helpers;

import config.TestConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiHelper {
    private static final String BASE = TestConfig.getDomainUrl();

    public static Response createUser(String username, String password) {
        String url = BASE + "/Account/v1/User";
        String payload = "{\"userName\":\"" + username + "\",\"password\":\"" + password + "\"}";
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post(url);
    }

    public static Response createUserAndValidate(String username, String password) {
        Response response = createUser(username, password);
        assertEquals(201, response.getStatusCode());
        return response;
    }

    public static Response authenticateUser(String username, String password) {
        String url = BASE + "/Account/v1/GenerateToken";
        String payload = "{\"userName\":\"" + username + "\",\"password\":\"" + password + "\"}";
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post(url);
    }

    public static Response authenticateUserAndValidate(String username, String password) {
        Response response = authenticateUser(username, password);
        assertEquals(200, response.getStatusCode());
        assertEquals("Success", response.jsonPath().getString("status"));
        return response;
    }

    public static Response getBooks(String username, String password) {
        String url = BASE + "/BookStore/v1/Books";
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .get(url);
    }

    public static Response getBooksAndValidate(String username, String password) {
        Response response = getBooks(username, password);
        assertEquals(200, response.getStatusCode());
        return response;
    }

    public static Response addBookToCollection(String userId, String isbn, String token) {
        String url = BASE + "/BookStore/v1/Books";
        String payload = "{\n" +
                "  \"userId\": \"" + userId + "\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \"" + isbn + "\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(payload)
                .post(url);
    }

    public static Response addBookToCollectionAndValidate(String userId, String isbn, String token) {
        Response response = addBookToCollection(userId, isbn, token);
        assertEquals(201, response.getStatusCode());
        return response;
    }

    public static Response getUserById(String userId, String token) {
        String url = BASE + "/Account/v1/User/" + userId;
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .get(url);
    }

    public static Response getUserByIdAndValidate(String userId, String token, String isbn) {
        Response response = getUserById(userId, token);
        assertEquals(200, response.getStatusCode());
        assertEquals(userId, response.jsonPath().getString("userId"));
        assertEquals(isbn, response.jsonPath().getString("books[0].isbn"));
        return response;
    }
}
