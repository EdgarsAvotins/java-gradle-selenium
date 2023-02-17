package pageObjects;

import org.openqa.selenium.WebElement;

import static helpers.InteractionHelper.elX;
import static helpers.InteractionHelper.scrollIntoView;

public class BookPage {
    private static final String TITLE_LABEL_XPATH = "//*[@id='title-wrapper']//*[@id='userName-value']";
    private static final String ADD_NEW_RECORD_BUTTON_XPATH = "//*[@id='addNewRecordButton'][text()='Add To Your Collection']";

    public static String getBookTitle() {
        WebElement titleLabel = elX(TITLE_LABEL_XPATH);
        return titleLabel.getText();
    }

    public static void addNewRecord() {
        WebElement addNewRecordButton = elX(ADD_NEW_RECORD_BUTTON_XPATH);
        scrollIntoView(addNewRecordButton);
        addNewRecordButton.click();
    }
}
