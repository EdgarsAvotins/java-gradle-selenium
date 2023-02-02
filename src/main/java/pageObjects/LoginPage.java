package pageObjects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.InteractionHelper.el;

public class LoginPage {
    public void inputDetailsAndSubmit(String username, String password) {
        setUserName(username);
        setPassword(password);
        submitLoginForm();
    }

    public void setUserName(String username) {
        el("userName").sendKeys(username);
    }

    public void setPassword(String password) {
        el("password").sendKeys(password);
    }

    public void submitLoginForm() {
        el("login").click();
    }

}
