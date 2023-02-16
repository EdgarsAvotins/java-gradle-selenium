package extensions;

import helpers.BrowserHelper;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UsingBrowserExtension implements AfterEachCallback, BeforeEachCallback {
    private static final String SCREENSHOT_DIR = "screenshots";

    @Override
    public void beforeEach(ExtensionContext context) {
        BrowserHelper.initializeDriver();
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        addScreenshotAfterTest(context);
        BrowserHelper.closeDriver();
    }

    public void addScreenshotAfterTest(ExtensionContext context) throws Exception {
        WebDriver driver = BrowserHelper.getDriver();
        if (driver != null) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            saveScreenshot(screenshotFile, context.getDisplayName());
            attachScreenshotToReport(screenshotFile, context);

            String currentUrl = driver.getCurrentUrl();
            Allure.addAttachment("Current URL", currentUrl);
        }
    }

    private void saveScreenshot(File screenshot, String testName) throws IOException {
        Path screenshotDir = Files.createDirectories(Path.of(SCREENSHOT_DIR));
        File destFile = new File(screenshotDir.toFile(), testName + ".png");
        FileHandler.copy(screenshot, destFile);
    }

    private void attachScreenshotToReport(File screenshot, ExtensionContext context) throws IOException {
        byte[] screenshotBytes = Files.readAllBytes(screenshot.toPath());
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshotBytes));
    }
}

