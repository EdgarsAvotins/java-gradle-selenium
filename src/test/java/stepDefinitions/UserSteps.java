package stepDefinitions;

import dataObjects.User;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.navigationPages.BookStorePage;

public class UserSteps {
    public static User givenANewUserIsCreatedViaAPI() {
        User user = new User();
        user.create();
        return user;
    }

    public static void givenIHaveLoggedIn(User user) {
        HomePage.openHomepage();
        HomePage.clickBookCategory();
        BookStorePage.clickLoginButton();
        LoginPage.inputDetailsAndSubmit(user.getUsername(), user.getPassword());
    }
}