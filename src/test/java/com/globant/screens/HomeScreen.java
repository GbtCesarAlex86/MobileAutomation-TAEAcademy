package com.globant.screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomeScreen extends BaseScreen {

    private static final String HOME_TEXT= "new UiSelector().text(\"Demo app for the appium-boilerplate\")";

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = HOME_TEXT)
    private WebElement homeText;

    public void verifyHomeScreenIsPresent() {
        Assert.assertTrue(isElementDisplayed(homeText), "Home screen is not present");
    }
}