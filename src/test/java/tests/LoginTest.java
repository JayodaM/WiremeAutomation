
package tests;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ScreenshotUtil;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void login_With_Valid_Credentials() {
        try {
            extentTest.get().info("_Verify that the Initializing LoginPage object</span>");
            LoginPage loginPage = new LoginPage(driver);

            extentTest.get().info("Entering valid credentials");
            loginPage.login("jayoda", "00000000",extentTest.get()); // Intentionally wrong username

            extentTest.get().info("Verifying if dashboard is visible");
            boolean isVisible = loginPage.isDashboardVisible();

            if (isVisible) {
                extentTest.get().pass("<span style='color: green;'>Login successful and dashboard is visible</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Login failed or dashboard not visible</span>");
            }

            Assert.assertTrue(isVisible, "<span style='color: red;'>Login failed or dashboard not visible.</span>");

        } catch (Exception e) {
            String ScreenshotPath = ScreenshotUtil.captureScreenshot(driver, "LoginWithValidCredential");

            extentTest.get().fail("Test execution failed: " + e.getMessage());
            MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotPath).build();

            Assert.fail("Exception occurred: " + e.getMessage());
        }
        driver.quit();
    }

    @Test(priority = 2)
    public void login_With_Invalid_Credentials() {
        try {
            extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>Verify that the login with invalid credentials</span>");
            LoginPage loginPage = new LoginPage(driver);

            extentTest.get().info("Entering invalid credentials");
            loginPage.login("SuperAdm", "000000",extentTest.get());

            extentTest.get().info("Verifying if invalid toast message is visible");
            boolean isVisible = loginPage.isInvalidToastMsgVisible();

            if (isVisible) {
                extentTest.get().pass("<span style='color: red;'>User not registered</span><span style='color: green;'> : Message displayed</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Credential verification failed: login succeeded with invalid credentials.</span>");
            }

            Assert.assertTrue(isVisible, "Displayed invalid credential toast message!");

        } catch (Exception e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "loginWithInvalidCredentials");

            extentTest.get().fail("Test execution failed: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

            Assert.fail("Exception occurred: " + e.getMessage());
        }
        driver.quit();

    }

    @Test(priority = 3)
    public void Login_With_Empty_Fields() {
        try {
            extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>Verify that the login with empty fields</span>");
            LoginPage loginPage = new LoginPage(driver);

            extentTest.get().info("Login with empty fields");
            loginPage.login("", "",extentTest.get());

            extentTest.get().info("Verifying if the Sign In button is disabled");
            boolean isDisabled = loginPage.isSigninButtonDisabled();

            if (isDisabled) {
                extentTest.get().pass("<span style='color: green;'>Login with empty fields verification passed: Sign In button is disabled</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Login with empty fields verification failed: Sign In button is enabled</span>");
            }

            Assert.assertTrue(isDisabled, "Sign In button should be disabled when fields are empty");

        } catch (Exception e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "DisabledSignInButton");

            extentTest.get().fail("Test execution failed: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

            Assert.fail("Exception occurred: " + e.getMessage());
        }
        driver.quit();
    }

    @Test(priority = 4)
    public void login_With_SQL_Injection() {
        try {
            extentTest.get().info("<span style='font-style: italic;font-weight: bold;'>Verify that the login with SQL injection </span>");
            LoginPage loginPage = new LoginPage(driver);

            // Common SQL Injection string
//            String sqlPayload = "' OR '1'='1";
             // String sqlPayload = "' OR 1=1 --";
            loginPage.login("' OR '1'='1", "' OR '1'='1",extentTest.get());

//            extentTest.get().info("Entering SQL injection payload");
//            loginPage.login(sqlPayload, sqlPayload);

            extentTest.get().info("Verifying login failure due to SQL injection attempt");
            boolean isErrorDisplayed = loginPage.isInvalidToastMsgVisible();

            if (isErrorDisplayed) {
                extentTest.get().pass("<span style='color: green;'>SQL injection was blocked as expected</span>");
            } else {
                extentTest.get().fail("<span style='color: red;'>Potential SQL injection vulnerability — login succeeded unexpectedly</span>");
            }

            Assert.assertTrue(isErrorDisplayed, "SQL injection attempt should not allow login");

        } catch (Exception e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "SQLInjectionTest");

            extentTest.get().fail("Test execution failed: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

            Assert.fail("Exception occurred: " + e.getMessage());
        }
        driver.quit();
    }
}

