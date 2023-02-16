package dataObjects;

import helpers.ApiHelper;
import io.restassured.response.Response;

import java.time.Instant;

public class User {
    private final String username;
    private final String password;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
        this(generateUsername(), getStandardPassword());
    }

    public Response create() {
        return ApiHelper.createUserAndValidate(username, password);
    }

    private static String generateUsername() {
        long timestamp = Instant.now().toEpochMilli();
        return "test" + timestamp;
    }

    private static String getStandardPassword() {
        return "Password123!";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
