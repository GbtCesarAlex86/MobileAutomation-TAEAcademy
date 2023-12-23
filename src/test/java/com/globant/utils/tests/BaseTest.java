package com.globant.utils.tests;

import com.globant.screens.HomeScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseTest {

    private static final String PROPERTIES_FILE = "src/test/resources/config.properties";
    private static final Properties properties = new Properties();
    private static AndroidDriver driver;

    @BeforeTest(alwaysRun = true)
    public void environmentSetUp(){
        loadProperties();
        UiAutomator2Options capabilities = new UiAutomator2Options();
        setUpCapabilities(capabilities);
        try{
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException exception){
            System.out.println(exception.getMessage());
        }
    }

    @AfterTest
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    private void loadProperties(){
        try {
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE);
            properties.load(fileInputStream);
        }catch (IOException e){
            throw new RuntimeException("Error loading the properties file" + PROPERTIES_FILE);
        }
    }

    private void setUpCapabilities(UiAutomator2Options capabilities){
        capabilities.setPlatformName(getCapability("platformName"));
        capabilities.setDeviceName(getCapability("deviceName"));
        capabilities.setAppPackage(getCapability("appPackage"));
        capabilities.setAppActivity(getCapability("appActivity"));
    }

    private static String getCapability(String variable){
        return properties.getProperty(variable);
    }

    public HomeScreen returnHomeScreen(){
        return new HomeScreen(driver);
    }

}