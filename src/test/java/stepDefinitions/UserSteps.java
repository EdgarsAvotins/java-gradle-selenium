package stepDefinitions;

import dataObjects.User;
import io.qameta.allure.Step;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.navigationPages.BookStorePage;

public class UserSteps {
    @Step("Given a new user is created via API")
    public static User givenANewUserIsCreatedViaAPI() {
        User user = new User();
        user.create();
        return user;
    }

    @Step("Given I have logged in")
    public static void givenIHaveLoggedIn(User user) {
        HomePage.openHomepage();
        HomePage.clickBookCategory();
        BookStorePage.clickLoginButton();
        LoginPage.inputDetailsAndSubmit(user.getUsername(), user.getPassword());
    }
}