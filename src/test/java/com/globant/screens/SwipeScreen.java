package com.globant.screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class SwipeScreen extends BaseScreen {
    private static final String SWIPE_TITLE = "new UiSelector().text(\"Swipe horizontal\")";
    private static final String SWIPE_CARD_1 = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(0)))";
    private static final String SWIPE_CARD_2 = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(1)))";
    private static final String SWIPE_CARD_3 = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(1)))";
    private static final String SWIPE_CARD_4 = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(1)))";
    private static final String SWIPE_CARD_5 = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(1)))";
    private static final String SWIPE_CARD_6 = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(1)))";

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = SWIPE_TITLE)
    private WebElement swipeTitle;

    @AndroidFindBy(uiAutomator = SWIPE_CARD_1)
    private WebElement swipeScreenScrollViewCard1;

    @AndroidFindBy(uiAutomator = SWIPE_CARD_2)
    private WebElement swipeScreenScrollViewCard2;

    @AndroidFindBy(uiAutomator = SWIPE_CARD_3)
    private WebElement swipeScreenScrollViewCard3;

    @AndroidFindBy(uiAutomator = SWIPE_CARD_4)
    private WebElement swipeScreenScrollViewCard4;

    @AndroidFindBy(uiAutomator = SWIPE_CARD_5)
    private WebElement swipeScreenScrollViewCard5;

    @AndroidFindBy(uiAutomator = SWIPE_CARD_6)
    private WebElement swipeScreenScrollViewCard6;

    List<WebElement> elementsToSwipeRight = Arrays.asList(
            swipeScreenScrollViewCard1,
            swipeScreenScrollViewCard2,
            swipeScreenScrollViewCard3,
            swipeScreenScrollViewCard4,
            swipeScreenScrollViewCard5,
            swipeScreenScrollViewCard6
    );

    List<WebElement> elementsToSwipeLeft = Arrays.asList(
            swipeScreenScrollViewCard1,
            swipeScreenScrollViewCard2,
            swipeScreenScrollViewCard3,
            swipeScreenScrollViewCard4,
            swipeScreenScrollViewCard5,
            swipeScreenScrollViewCard6
    );

    public void swipeCards(){
        for (WebElement elementToSwipe : elementsToSwipeRight){
            isElementDisplayed(elementToSwipe);
            swipe(0.5,0.2, 0.7);
        }
        for (WebElement elementToSwipe : elementsToSwipeLeft){
            isElementDisplayed(elementToSwipe);
            swipe(0.5,0.8, 0.7);
        }
    }

    public void verifySwipeTitle() {
        Assert.assertTrue(isElementDisplayed(swipeTitle), "Swipe screen is not present");
    }
}