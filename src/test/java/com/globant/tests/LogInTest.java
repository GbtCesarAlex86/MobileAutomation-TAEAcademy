package com.globant.tests;

import com.globant.screens.HomeScreen;
import com.globant.screens.LoginScreen;
import com.globant.screens.logInTabs.LogInTab;
import com.globant.screens.logInTabs.SignUpTab;
import com.globant.utils.CredentialsGenerator;
import com.globant.utils.dataProviders.CredentialsProvider;
import com.globant.utils.tests.BaseTest;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class LogInTest extends BaseTest {

    private LoginScreen loginScreen;

    @BeforeClass
    public void setUpTest(ITestContext context){
        HomeScreen homeScreen = returnHomeScreen();
        homeScreen.verifyHomeScreenIsPresent();
        loginScreen = homeScreen.clickOnLoginMenuItem();
        loginScreen.verifyLogInIsPresent();
//        context.setAttribute("loginScreen", loginScreen);
    }

    @Test(dataProvider = "credentialsData", dataProviderClass = CredentialsProvider.class)
    public void signUpTest(ITestContext context, String email, String password){
//        LoginScreen loginScreen = (LoginScreen) context.getAttribute("loginScreen");
        SignUpTab signUpTab = loginScreen.clickOnSignUpTab();
        signUpTab.enterEmail(email);
        signUpTab.enterPassword(password);
        signUpTab.enterConfirmPassword(password);
        signUpTab.clickOnSignUpBtn();
        signUpTab.verifySignUpProcessIsCompleted();
        loginScreen = signUpTab.clickOnLogInTab();
    }

    @Test(dataProvider = "credentialsData", dataProviderClass = CredentialsProvider.class)
    public void logInTest(ITestContext context, String email, String password){
//        LoginScreen loginScreen = (LoginScreen) context.getAttribute("loginScreen");
        LogInTab logInTab = loginScreen.clickOnLogInTab();
        logInTab.enterEmail(email);
        logInTab.enterPassword(password);
        logInTab.clickOnLogInBtn();
        logInTab.verifyLogInProcessIsCompleted();
    }
}