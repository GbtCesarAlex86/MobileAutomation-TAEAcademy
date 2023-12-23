package com.globant.tests;

import com.globant.screens.*;
import com.globant.screens.LoginScreen;
import com.globant.utils.tests.BaseTest;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuBarNavigationTest extends BaseTest {

    @BeforeMethod
    public void setUpTest(ITestContext context) {
        HomeScreen homeScreen = returnHomeScreen();
        homeScreen.verifyHomeScreenIsPresent();
        context.setAttribute("homeScreen", homeScreen);
    }

    @Test
    public void navigateInMenuBar(ITestContext context) {
        HomeScreen homeScreen = (HomeScreen) context.getAttribute("homeScreen");
        WebviewScreen webviewScreen = homeScreen.clickOnWebviewMenuItem();
        webviewScreen.verifyWebviewIsPresent();

        LoginScreen loginScreen = webviewScreen.clickOnLoginMenuItem();
        loginScreen.verifyLogInIsPresent();

        FormsScreen formsScreen = loginScreen.clickOnFormsMenuItem();
        formsScreen.verifyFormsTitle();

        SwipeScreen swipeScreen = formsScreen.clickOnSwipeMenuItem();
        swipeScreen.verifySwipeTitle();

        DragScreen dragScreen = swipeScreen.clickOnDragMenuItem();
        dragScreen.verifyDragTitle();
    }
}