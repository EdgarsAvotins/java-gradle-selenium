package pageObjects.navigationPages;

import org.openqa.selenium.WebElement;

import static helpers.InteractionHelper.elX;
import static helpers.InteractionHelper.scrollIntoView;

public class NavigationPage {
    public static void clickSidebarButtonWithText(String buttonText) {
        WebElement profileSidebarButton = elX("//div[@class='accordion']//li[descendant::*[text()='" + buttonText + "']]");
        scrollIntoView(profileSidebarButton);
        profileSidebarButton.click();
    }

    public static void clickSidebarButtonForProfile() {
        clickSidebarButtonWithText("Profile");
    }
}
