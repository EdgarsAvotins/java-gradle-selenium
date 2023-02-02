package pageObjects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.BrowserHelper.navigateTo;
import static helpers.InteractionHelper.elX;
import static helpers.InteractionHelper.scrollIntoView;

public class HomePage {

    public void openHomepage() {
        navigateTo("https://demoqa.com/");
    }

    public void clickBookCategory() {
        WebElement bookCategory = elX("//div[@class='category-cards']//div[@class='card-body']/h5[text()='Book Store Application']");
        scrollIntoView(bookCategory);
        bookCategory.click();
    }
}
