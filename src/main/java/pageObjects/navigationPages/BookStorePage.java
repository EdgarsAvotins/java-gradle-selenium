package pageObjects.navigationPages;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.InteractionHelper.elX;
import static helpers.InteractionHelper.scrollIntoView;

public class BookStorePage extends NavigationPage{

    public static void clickLoginButton() {
        elX("//button[@id='login']").click();
    }

    public static void openFirstBookInList() {
        WebElement firstBookRowInList = elX("(//div[@class='rt-tbody']//*[@role='row'])[1]//*[contains(@id,'see-book')]");
        scrollIntoView(firstBookRowInList);
        firstBookRowInList.click();
    }
}
