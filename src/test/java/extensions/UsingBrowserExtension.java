package extensions;

import helpers.BrowserHelper;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class UsingBrowserExtension implements AfterEachCallback, BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        BrowserHelper.initializeDriver();
    }

    @Override
    public void afterEach(ExtensionContext context) {
        BrowserHelper.closeDriver();
    }
}

