package com.globant.screens.logInTabs;

import com.globant.screens.LoginScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LogInTab extends LoginScreen {

    public LogInTab(AndroidDriver driver) {
        super(driver);
    }

    private static final String EMAIL_INPUT = "new UiSelector().description(\"input-email\")";
    private static final String PASSWORD_INPUT = "new UiSelector().description(\"input-password\")";
    private static final String LOGIN_BUTTON = "new UiSelector().text(\"LOGIN\")";
    private static final String LOGIN_CONFIRMATION = "new UiSelector().text(\"You are logged in!\")";


    @AndroidFindBy(uiAutomator = EMAIL_INPUT)
    private WebElement emailInput;

    @AndroidFindBy(uiAutomator = PASSWORD_INPUT)
    private WebElement passwordInput;

    @AndroidFindBy(uiAutomator = LOGIN_BUTTON)
    private WebElement logInBtn;

    @AndroidFindBy(uiAutomator = LOGIN_CONFIRMATION)
    private WebElement logInConfirmationText;

    public void enterEmail(String email){
        emailInput.sendKeys(email);
    }
    public void enterPassword(String psw){
        passwordInput.sendKeys(psw);
    }

    public void clickOnLogInBtn(){
        logInBtn.click();
    }

    public void verifyLogInProcessIsCompleted() {
        Assert.assertTrue(isElementDisplayed(logInConfirmationText), "LogIn process not completed");
    }
}
