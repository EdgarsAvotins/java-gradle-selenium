package helpers;

import java.time.Instant;

public class UserHelper {
    public static String generateUsername() {
        long timestamp = Instant.now().toEpochMilli();
        return "test" + timestamp;
    }

    public static String getPassword() {
        return "Password123!";
    }
}
