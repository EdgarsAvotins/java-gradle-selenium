package pageObjects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.InteractionHelper.el;

public class LoginPage {
    private static final String usernameFieldId = "userName";
    private static final String passwordFieldId = "password";
    private static final String loginButtonId = "login";

    public static void inputDetailsAndSubmit(String username, String password) {
        setUserName(username);
        setPassword(password);
        submitLoginForm();
    }

    public static void setUserName(String username) {
        el(usernameFieldId).sendKeys(username);
    }

    public static void setPassword(String password) {
        el(passwordFieldId).sendKeys(password);
    }

    public static void submitLoginForm() {
        el(loginButtonId).click();
    }

}
