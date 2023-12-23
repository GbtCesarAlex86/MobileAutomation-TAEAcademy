package com.globant.tests;

import com.globant.screens.HomeScreen;
import com.globant.screens.SwipeScreen;
import com.globant.utils.tests.BaseTest;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwipeCardsTest extends BaseTest {

    @BeforeMethod
    public void setUpTest(ITestContext context){
        HomeScreen homeScreen = returnHomeScreen();
        homeScreen.verifyHomeScreenIsPresent();
        SwipeScreen swipeScreen = homeScreen.clickOnSwipeMenuItem();
        swipeScreen.verifySwipeTitle();
        context.setAttribute("swipeScreen", swipeScreen);
    }

    @Test
    public void SwipeCards(ITestContext context){
        SwipeScreen swipeScreen = (SwipeScreen) context.getAttribute("swipeScreen");
        swipeScreen.swipeCards();
    }
}
