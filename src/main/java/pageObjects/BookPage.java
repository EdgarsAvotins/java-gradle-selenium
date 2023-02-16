package pageObjects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.InteractionHelper.*;

public class BookPage {
    private static final String titleLabelXpath = "//*[@id='title-wrapper']//*[@id='userName-value']";
    private static final String addNewRecordButtonXpath = "//*[@id='addNewRecordButton'][text()='Add To Your Collection']";

    public static String getBookTitle() {
        WebElement titleLabel = elX(titleLabelXpath);
        return titleLabel.getText();
    }

    public static void addNewRecord() {
        WebElement addNewRecordButton = elX(addNewRecordButtonXpath);
        scrollIntoView(addNewRecordButton);
        addNewRecordButton.click();
    }
}
