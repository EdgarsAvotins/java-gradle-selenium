package pageObjects.navigationPages;

import org.openqa.selenium.WebElement;

import static helpers.InteractionHelper.elX;
import static helpers.InteractionHelper.scrollIntoView;

public class BookStorePage extends NavigationPage{
    private static final String LOGIN_BUTTON_XPATH = "//button[@id='login']";
    private static final String BOOK_LIST = "//div[@class='rt-tbody']//*[@role='row']";
    private static final String BOOK_IN_LIST = "//*[contains(@id,'see-book')]";
    public static void clickLoginButton() {
        elX(LOGIN_BUTTON_XPATH).click();
    }

    public static void openFirstBookInList() {
        WebElement firstBookRowInList = elX("(" + BOOK_LIST + ")[1]" + BOOK_IN_LIST);
        scrollIntoView(firstBookRowInList);
        firstBookRowInList.click();
    }
}
