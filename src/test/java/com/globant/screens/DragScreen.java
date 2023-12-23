package com.globant.screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DragScreen extends BaseScreen {
    private static final String DRAG_TITLE = "new UiSelector().text(\"Drag and Drop\")";

    public DragScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = DRAG_TITLE)
    private WebElement dragTitle;

    public void verifyDragTitle() {
        Assert.assertTrue(isElementDisplayed(dragTitle), "Drag screen is not present");
    }
}