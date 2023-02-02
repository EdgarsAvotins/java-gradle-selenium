package pageObjects.navigationPages;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.InteractionHelper.elX;
import static helpers.InteractionHelper.scrollIntoView;

public class NavigationPage {

    public void clickSidebarButtonWithText(String buttonText) {
        WebElement porfileSidebarButton = elX("//div[@class='accordion']//li[descendant::*[text()='" + buttonText + "']]");
        scrollIntoView(porfileSidebarButton);
        porfileSidebarButton.click();
    }
}
