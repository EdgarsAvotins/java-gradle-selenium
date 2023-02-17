package pageObjects;

import static helpers.InteractionHelper.el;

public class LoginPage {
    private static final String USERNAME_FIELD_ID = "userName";
    private static final String PASSWORD_FIELD_ID = "password";
    private static final String LOGIN_BUTTON_ID = "login";

    public static void inputDetailsAndSubmit(String username, String password) {
        setUserName(username);
        setPassword(password);
        submitLoginForm();
    }

    public static void setUserName(String username) {
        el(USERNAME_FIELD_ID).sendKeys(username);
    }

    public static void setPassword(String password) {
        el(PASSWORD_FIELD_ID).sendKeys(password);
    }

    public static void submitLoginForm() {
        el(LOGIN_BUTTON_ID).click();
    }

}
