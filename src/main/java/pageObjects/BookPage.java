package pageObjects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.InteractionHelper.*;

public class BookPage {

    public static String getBookTitle() {
        WebElement titleLabel = elX("//*[@id='title-wrapper']//*[@id='userName-value']");
        return titleLabel.getText();
    }

    public static void addNewRecord() {
        WebElement addNewRecordButton = elX("//*[@id='addNewRecordButton'][text()='Add To Your Collection']");
        scrollIntoView(addNewRecordButton);
        addNewRecordButton.click();
    }
}
