package com.globant.tests;

import com.globant.screens.HomeScreen;
import com.globant.screens.LoginScreen;
import com.globant.screens.logInTabs.SignUpTab;
import com.globant.utils.dataProviders.CredentialsProvider;
import com.globant.utils.tests.BaseTest;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @BeforeMethod
    public void setUpTest(ITestContext context){
        HomeScreen homeScreen = returnHomeScreen();
        homeScreen.verifyHomeScreenIsPresent();
        LoginScreen loginScreen = homeScreen.clickOnLoginMenuItem();
        loginScreen.verifyLogInIsPresent();
        context.setAttribute("loginScreen", loginScreen);
    }

    @Test(dataProvider = "credentialsData", dataProviderClass = CredentialsProvider.class)
    public void signUp(ITestContext context, String email, String password){
        LoginScreen loginScreen = (LoginScreen) context.getAttribute("loginScreen");
        SignUpTab signUpTab = loginScreen.clickOnSignUpTab();
        signUpTab.enterEmail(email);
        signUpTab.enterPassword(password);
        signUpTab.enterConfirmPassword(password);
        signUpTab.clickOnSignUpBtn();
        signUpTab.verifySignUpProcessIsCompleted();
    }
}