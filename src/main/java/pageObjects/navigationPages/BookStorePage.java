package pageObjects.navigationPages;

import org.openqa.selenium.WebElement;

import static helpers.InteractionHelper.elX;
import static helpers.InteractionHelper.scrollIntoView;

public class BookStorePage extends NavigationPage{
    private static final String loginButtonXpath = "//button[@id='login']";
    private static final String bookList = "//div[@class='rt-tbody']//*[@role='row']";
    private static final String bookInList = "//*[contains(@id,'see-book')]";
    public static void clickLoginButton() {
        elX(loginButtonXpath).click();
    }

    public static void openFirstBookInList() {
        WebElement firstBookRowInList = elX("(" + bookList + ")[1]" + bookInList);
        scrollIntoView(firstBookRowInList);
        firstBookRowInList.click();
    }
}
