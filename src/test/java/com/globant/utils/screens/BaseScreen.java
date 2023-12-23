package com.globant.utils.screens;

import com.globant.screens.*;
import com.globant.screens.LoginScreen;
import com.google.common.collect.ImmutableList;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen{

    private static final String HOME_MENUITEM = "new UiSelector().description(\"Home\")";
    private static final String WEBVIEW_MENUITEM = "new UiSelector().description(\"Webview\")";
    private static final String LOGIN_MENUITEM = "new UiSelector().description(\"Login\")";
    private static final String FORMS_MENUITEM = "new UiSelector().description(\"Forms\")";
    private static final String SWIPE_MENUITEM = "new UiSelector().description(\"Swipe\")";
    private static final String DRAG_MENUITEM = "new UiSelector().description(\"Drag\")";

    protected AndroidDriver driver;

    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = HOME_MENUITEM)
    private WebElement homeMenuItem;

    @AndroidFindBy(uiAutomator = WEBVIEW_MENUITEM)
    private WebElement webviewMenuItem;

    @AndroidFindBy(uiAutomator = LOGIN_MENUITEM)
    private WebElement loginMenuItem;

    @AndroidFindBy(uiAutomator = FORMS_MENUITEM)
    private WebElement formsMenuitem;

    @AndroidFindBy(uiAutomator = SWIPE_MENUITEM)
    private WebElement swipeMenuItem;

    @AndroidFindBy(uiAutomator = DRAG_MENUITEM)
    private WebElement dragMenuItem;

    protected Boolean isElementDisplayed(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public HomeScreen clickOnHomeMenuItem(){
        homeMenuItem.click();
        return new HomeScreen(driver);
    }

    public WebviewScreen clickOnWebviewMenuItem(){
        webviewMenuItem.click();
        return new WebviewScreen(driver);
    }

    public LoginScreen clickOnLoginMenuItem(){
        loginMenuItem.click();
        return new LoginScreen(driver);
    }

    public FormsScreen clickOnFormsMenuItem(){
        formsMenuitem.click();
        return new FormsScreen(driver);
    }

    public SwipeScreen clickOnSwipeMenuItem(){
        swipeMenuItem.click();
        return new SwipeScreen(driver);
    }

    public DragScreen clickOnDragMenuItem(){
        dragMenuItem.click();
        return new DragScreen(driver);
    }

    protected BaseScreen openScreen(){
        return this;
    }

    public void swipe(double startXPercentage, double endXPercentage, double cenerYPercentage){
        Dimension size = driver.manage().window().getSize();
        int startX = (int)(size.width * startXPercentage);
        int endX = (int)(size.width * endXPercentage);
        int centerY = (int) (size.height * cenerYPercentage);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);

        swipe.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,centerY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(300),PointerInput.Origin.viewport(),endX,centerY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(ImmutableList.of(swipe));
    }
//    This could be use if I decide to user softAssert instead of Assert,
//    for use it in the AfterTest to get the log of the assertions
//    public void validateAssertions(){
//        softAssert.assertAll();
//    }
}