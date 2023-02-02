package helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiHelper {
    private final String base = "https://demoqa.com";

    public Response createUser(String username, String password) {
        String url = base + "/Account/v1/User";
        String payload = "{\"userName\":\"" + username + "\",\"password\":\"" + password + "\"}";
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post(url);
    }

    public Response authenticateUser(String username, String password) {
        String url = base + "/Account/v1/GenerateToken";
        String payload = "{\"userName\":\"" + username + "\",\"password\":\"" + password + "\"}";
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post(url);
    }

    public Response getBooks(String username, String password) {
        String url = base + "/BookStore/v1/Books";
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .get(url);
    }

    public Response addBookToCollection(String userId, String isbn, String token) {
        String url = base + "/BookStore/v1/Books";
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

    public Response getUserById(String userId, String token) {
        String url = base + "/Account/v1/User/" + userId;
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .get(url);
    }
}
