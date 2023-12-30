Mobile Automation Final Practice


In this practice, we will join all the knowledge learnt from mobile automation in order to automate some scenarios on Android devices.

For this practice first we need to install the WDIO dummy app on an Android device, you can use an emulator created using Android Studio, or use your own Android device if you have one. The APK is available for download here https://github.com/webdriverio/native-demo-app/releases (Make sure to use the .apk file). Optionally, you can also do this practice in IOS, however, please consider you would need a Mac device in order to install the required tools.

After the app is correctly installed and working, you will find here 4 scenarios to be fully automated. First of all you have to recreate each step manually in order to understand what is being tested and which steps we have to execute. 

This set of tests are oriented to the navigation of the dummy WebdriverIO application. 

Navigation on the bottom menu bar:
As a precondition, the user should be on the Home screen.
Navigate to each section tapping their respective icon on the bottom menu bar.
After tapping on the respective menu section, assertions should be made in order to check all elements on the respective sections are correctly displayed (Check visibility and properties).
Successful Sign Up:
As a precondition, the user should be at the Login section
Navigate to the Signup section.
Fill all the form data to sign up (Consider the test must be able to be executed multiple times, so a random email may be generated each time, or an action should be done after the test to delete the created account).
Check if the signup process was successfully completed.
Successful Login:
As a precondition, the user should be at the Login section and have a previously created user.
Navigate to the Login View.
Fill all the form data to log in.
Check if the login process was successfully completed.
Swipe cards on the Swipe section:
As a precondition, the user should be at the Swipe section.
Perform a right swipe on the cards and check the old card is hidden, the new card is visible, and the respective card dot is selected.
Perform a left swipe on the cards and check the old card is hidden, the new card is visible, and the respective card dot is selected.

	
Consider the test cases should be fully independent one from another, so, for example, the login test may reuse code from the signup test, but it may not rely on the signup test to be done earlier in order to properly work.

