package com.globant.screens.logInTabs;

import com.globant.screens.LoginScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SignUpTab extends LoginScreen {

    public SignUpTab(AndroidDriver driver) {
        super(driver);
    }

    private static final String EMAIL_INPUT = "new UiSelector().description(\"input-email\")";
    private static final String PASSWORD_INPUT = "new UiSelector().description(\"input-password\")";
    private static final String CONFIRM_PASSWORD_INPUT = "new UiSelector().description(\"input-repeat-password\")";
    private static final String SIGNUP_BUTTON = "new UiSelector().text(\"SIGN UP\")";
    private static final String SIGNUP_CONFIRMATION = "new UiSelector().text(\"You successfully signed up!\")";
    private static final String OK_BUTTON = "new UiSelector().text(\"OK\")";
    private static final String LOGIN_TAB = "new UiSelector().description(\"button-login-container\")";

    @AndroidFindBy(uiAutomator = EMAIL_INPUT)
    private WebElement emailInput;

    @AndroidFindBy(uiAutomator = PASSWORD_INPUT)
    private WebElement passwordInput;

    @AndroidFindBy(uiAutomator = CONFIRM_PASSWORD_INPUT)
    private WebElement confirmPasswordInput;

    @AndroidFindBy(uiAutomator = SIGNUP_BUTTON)
    private WebElement signUpBtn;

    @AndroidFindBy(uiAutomator = SIGNUP_CONFIRMATION)
    private WebElement signUpConfirmationText;

    @AndroidFindBy(uiAutomator = LOGIN_TAB)
    private WebElement logInTab;

    @AndroidFindBy(uiAutomator = OK_BUTTON)
    WebElement okBtn;

    public void enterEmail(String email){
        emailInput.sendKeys(email);
    }

    public void enterPassword(String psw){
        passwordInput.sendKeys(psw);
    }

    public void enterConfirmPassword(String psw){
        confirmPasswordInput.sendKeys(psw);
    }

    public void clickOnSignUpBtn(){
        signUpBtn.click();
    }

    public void verifySignUpProcessIsCompleted() {
        Assert.assertTrue(isElementDisplayed(signUpConfirmationText), "SignUp process not completed");
        okBtn.click();
    }
}
