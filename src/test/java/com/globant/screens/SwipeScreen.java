package com.globant.screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SwipeScreen extends BaseScreen {
    private static final String SWIPE_TITLE = "new UiSelector().text(\"Swipe horizontal\")";



    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = SWIPE_TITLE)
    private WebElement swipeTitle;

//    @AndroidFindBy(uiAutomator = )
//    private WebElement selectedCard;


    public void swipeCardToLeft(){

    }

    public void swipeCardToRight(){

    }

    public void verifySwipeTitle() {
        Assert.assertTrue(isElementDisplayed(swipeTitle), "Swipe screen is not present");
    }
}