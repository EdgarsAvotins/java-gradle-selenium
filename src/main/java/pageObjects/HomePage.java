package pageObjects;

import config.TestConfig;
import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.BrowserHelper.navigateTo;
import static helpers.InteractionHelper.elX;
import static helpers.InteractionHelper.scrollIntoView;

public class HomePage {
    private static final String domainUrl = TestConfig.getDomainUrl();
    private static final String bookCategoryButtonXpath = "//div[@class='category-cards']//div[@class='card-body']/h5[text()='Book Store Application']";

    public static void openHomepage() {
        navigateTo(domainUrl);
    }

    public static void clickBookCategory() {
        WebElement bookCategoryButton = elX(bookCategoryButtonXpath);
        scrollIntoView(bookCategoryButton);
        bookCategoryButton.click();
    }
}
