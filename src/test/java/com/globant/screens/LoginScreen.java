package com.globant.screens;

import com.globant.screens.logInTabs.LogInTab;
import com.globant.screens.logInTabs.SignUpTab;
import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginScreen extends BaseScreen {

    private static final String LOGIN_SCREEN_TITLE = "new UiSelector().text(\"Login / Sign up Form\")";
    private static final String SIGNUP_TAB = "new UiSelector().description(\"button-sign-up-container\")";
    private static final String LOGIN_TAB = "new UiSelector().description(\"button-login-container\")";

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = LOGIN_SCREEN_TITLE)
    private WebElement logInTitle;

    @AndroidFindBy(uiAutomator = SIGNUP_TAB)
    private WebElement signUpTab;

    @AndroidFindBy(uiAutomator = LOGIN_TAB)
    private WebElement LogInTab;

    public SignUpTab clickOnSignUpTab(){
        signUpTab.click();
        return new SignUpTab(driver);
    }

    public LogInTab clickOnLogInTab(){
        LogInTab.click();
        return new LogInTab(driver);
    }

    public void verifyLogInIsPresent() {
        Assert.assertTrue(isElementDisplayed(logInTitle), "LogIn screen is not present");
    }
}