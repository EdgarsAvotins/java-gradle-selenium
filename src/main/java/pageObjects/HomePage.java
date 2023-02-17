package pageObjects;

import config.TestConfig;
import org.openqa.selenium.WebElement;

import static helpers.BrowserHelper.navigateTo;
import static helpers.InteractionHelper.elX;
import static helpers.InteractionHelper.scrollIntoView;

public class HomePage {
    private static final String DOMAIN_URL = TestConfig.getDomainUrl();
    private static final String BOOK_CATEGORY_BUTTON_XPATH = "//div[@class='category-cards']//div[@class='card-body']/h5[text()='Book Store Application']";

    public static void openHomepage() {
        navigateTo(DOMAIN_URL);
    }

    public static void clickBookCategory() {
        WebElement bookCategoryButton = elX(BOOK_CATEGORY_BUTTON_XPATH);
        scrollIntoView(bookCategoryButton);
        bookCategoryButton.click();
    }
}
