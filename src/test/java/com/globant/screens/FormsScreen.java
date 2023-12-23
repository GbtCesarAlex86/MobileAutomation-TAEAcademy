package com.globant.screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FormsScreen extends BaseScreen {
    private static final String FORMS_TITLE = "new UiSelector().text(\"Form components\")";

    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = FORMS_TITLE)
    private WebElement formsTitle;

    public void verifyFormsTitle() {
        Assert.assertTrue(isElementDisplayed(formsTitle), "Forms screen is not present");
    }
}
