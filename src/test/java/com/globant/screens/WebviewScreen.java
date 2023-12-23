package com.globant.screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebviewScreen extends BaseScreen {

    private static final String WEBVIEW_TEXT = "new UiSelector().text(\"WebdriverIO\")";

    public WebviewScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = WEBVIEW_TEXT)
    private WebElement webviewText;

    public void verifyWebviewIsPresent(){
        Assert.assertTrue(isElementDisplayed(webviewText), "Webview screen is not present");
    }
}